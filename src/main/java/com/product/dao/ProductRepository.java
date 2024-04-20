package com.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Integer>{

}
