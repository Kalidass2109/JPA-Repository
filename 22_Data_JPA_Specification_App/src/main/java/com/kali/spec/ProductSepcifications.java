package com.kali.spec;

import org.springframework.data.jpa.domain.Specification;

import com.kali.entity.Product;


public class ProductSepcifications {
	
	public static Specification<Product> nameLike(String name){
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%"+name+"%");
	}
	
	public static Specification<Product> priceLessThan(double price){
		return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("price"), price);
	}
	
	public static Specification<Product> priceGreaterThan(double price){
		return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("price"), price);
	}

}
