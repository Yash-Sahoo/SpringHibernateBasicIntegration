package com.ssi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.entities.Product;
import com.ssi.services.MyServiceSpecification;

@Controller
public class MyController{

	
	@Autowired
	MyServiceSpecification myService;
	
	@Autowired
	Product product;
	
	@RequestMapping("home")
	public String goToHome() {
		return "index.jsp";
	}
	
	@RequestMapping("productentry")
	public String showEntryProduct() {
		return "dataentry.jsp";
	}
	
	@RequestMapping("saveproduct")
	public String savingProduct(@RequestParam("pcode") int pcode, @RequestParam("pname") String pname, @RequestParam("price") int price) {
		product.setPcode(pcode);
		product.setPname(pname);
		product.setPrice(price);
		myService.addProduct(product);
		return "successfullyAdded.jsp";
	}
	
	@RequestMapping("deleteProductByID")
	public ModelAndView deleteProduct(@ModelAttribute("product") Product product) {
		myService.removeProduct(product);
		ModelAndView mv=new ModelAndView("successfullyDeleted.jsp");
		return mv;
	}
	
	@RequestMapping("deleteproduct")
	public String showDeletePage() {
		return "deletepage.jsp";
	}
	
	@RequestMapping("getproduct")
	public String showOneProduct() {
		return "productByCode.jsp";
	}
	
	@RequestMapping("getProductById")
	public ModelAndView byIDSearchProduct(@ModelAttribute("product") Product product) {
		ModelAndView mv=new ModelAndView("productByIDResult.jsp");
		product=myService.getProduct(product, product.getPcode());
		mv.addObject("product",product);
		return mv;
	}
	
	@RequestMapping("viewallproduct")
	public ModelAndView showAll() {
		ModelAndView mv=new ModelAndView("viewAllProduct.jsp");
		List<Product> products=myService.showAllProduct();
		mv.addObject("list",products);
		return mv;
	}
	
}
