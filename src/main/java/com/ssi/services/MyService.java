package com.ssi.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssi.DAO.ProductDAOSpecification;
import com.ssi.entities.Product;

@Service
public class MyService implements MyServiceSpecification{

	@Autowired
	ProductDAOSpecification dao;
	
	public void addProduct(Product product) {
		dao.saveProduct(product);
	}

	public void removeProduct(Product product) {
		dao.deleteProduct(product);
	}

	public Product getProduct(Product product, int pcode) {
		product=dao.searchProduct(product, pcode);
		return product;
	}

	public List<Product> showAllProduct() {
		List<Product> products=dao.viewAllProduct();
		return products;
	}
	
}
