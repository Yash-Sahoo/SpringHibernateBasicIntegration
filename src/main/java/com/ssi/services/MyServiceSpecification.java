package com.ssi.services;

import java.util.List;

import com.ssi.entities.Product;

public interface MyServiceSpecification {
	void addProduct(Product product);
	void removeProduct(Product product);
	Product getProduct(Product product,int pcode);
	List<Product> showAllProduct();
	
}
