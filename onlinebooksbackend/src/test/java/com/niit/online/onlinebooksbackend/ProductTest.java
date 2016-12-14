package com.niit.online.onlinebooksbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.online.onlinebooksbackend.dao.ProductDAO;
import com.niit.online.onlinebooksbackend.model.Product;

public class ProductTest {
	
	static AnnotationConfigApplicationContext context;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		context = new AnnotationConfigApplicationContext();
        context.scan("com.niit");
       context.refresh();
      //  @SuppressWarnings("unused")
		Product product=(Product)context.getBean("product");
        ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
        product.setProdname("abcd");
        product.setQuatity(4);
        product.setPrice(1000);
        productDAO.saverOrUpdate(product);
        System.out.println("Product create");

	}

}
