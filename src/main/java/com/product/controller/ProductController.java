package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.dao.ProductRepository;
import com.product.dao.UserRepository;
import com.product.entity.Products;

@Controller
public class ProductController {

	@Autowired
	ProductRepository repo;

	@Autowired
	UserRepository userRepo;

	@GetMapping("/products")
	public String getProducts(Model model) {
		List<Products> products = repo.findAll();
		model.addAttribute("products", products);
		return "list-products";
	}

	@GetMapping("/addProduct")
	public String addProducts(Model model) {

		Products theProduct = new Products();
		model.addAttribute("products", theProduct);
		return "product_form";
	}

	// @ModelAttribute("products") -- form data passed using data binding
	@PostMapping("/save")
	public String saveProducts(@ModelAttribute("products") Products theProducts) {

		repo.save(theProducts);
		return "redirect:/products";
	}

	@GetMapping("/updateProduct")
	public String updateProducts(@RequestParam("id") int id, Model model) {

		Optional<Products> theProducts = repo.findById(id);
		model.addAttribute("products", theProducts);
		return "product-form";

	}

	@GetMapping("/deleteProduct")
	public String deleteProducts(@RequestParam("id") int id) {

		repo.deleteById(id);
		return "redirect:/products";
	}

	@GetMapping(value="/login")
	public String loginPage() {

		return "login-form";
	}

	@GetMapping("/authenticateTheUser")
	public String viewIndexpage(Model model,Authentication authentication) {
		
		List<Products> products = repo.findAll();
		model.addAttribute("products",products);
		for(GrantedAuthority auth: authentication.getAuthorities()) {
			if(auth.getAuthority().equals("Role_Admin")) {
				return "list-products";
			}
		}
		return "homepage";
	}

}
