package com.niit.online.onlinebooksbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.online.onlinebooksbackend.model.Category;

public class CategoryTest {
	
	static AnnotationConfigApplicationContext context;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		context = new AnnotationConfigApplicationContext();
        context.scan("com.niit");
        context.refresh();
        Category category=(Category)context.getBean("category");
        System.out.println("Category create");

	}

}
