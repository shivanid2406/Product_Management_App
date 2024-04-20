package com.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.product.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByUsername(String userName);
}
