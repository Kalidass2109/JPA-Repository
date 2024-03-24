package com.kali.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kali.entity.Product;
import com.kali.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public void saveProduct() {
		Product p=new Product();
		//p.setPid(3);
		p.setName("HDD");
		p.setPrice(9000.00);
		
		//p.setCreatedDate(LocalDate.now());
		
		productRepo.save(p);
		System.out.println("Product saved....");
	}

}
