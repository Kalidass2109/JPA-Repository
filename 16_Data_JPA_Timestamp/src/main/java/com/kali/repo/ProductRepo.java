package com.kali.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kali.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
