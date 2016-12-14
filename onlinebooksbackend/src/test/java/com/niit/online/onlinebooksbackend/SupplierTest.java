package com.niit.online.onlinebooksbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.online.onlinebooksbackend.model.Category;
import com.niit.online.onlinebooksbackend.model.Supplier;

public class SupplierTest {

	static AnnotationConfigApplicationContext context;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		context = new AnnotationConfigApplicationContext();
        context.scan("com.niit");
        context.refresh();
        Supplier supplier=(Supplier)context.getBean("supplier");
        System.out.println("Supplier create");

	}


}
