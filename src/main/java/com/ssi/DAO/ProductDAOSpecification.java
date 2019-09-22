package com.ssi.DAO;

import java.util.List;

import com.ssi.entities.Product;

public interface ProductDAOSpecification {
	void saveProduct(Product product);
	void deleteProduct(Product product);
	Product searchProduct(Product product,int pcode);
	List<Product> viewAllProduct();
}
