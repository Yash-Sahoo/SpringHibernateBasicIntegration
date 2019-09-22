package com.ssi.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssi.entities.Product;

@Repository
public class ProductDAO implements ProductDAOSpecification {

	@Autowired
	SessionFactory sessionFactory;
	
	public void saveProduct(Product product) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(product);
		tr.commit();
		session.close();
	}

	public void deleteProduct(Product product) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(product);
		tr.commit();
		session.close();
	}

	public Product searchProduct(Product product,int pcode) {
		Session session=sessionFactory.openSession();
		Product p=session.get(Product.class, pcode);
		session.close();
		return p;
	}

	public List<Product> viewAllProduct() {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> products=criteria.list();
		session.close();
		return products;
	}
}
