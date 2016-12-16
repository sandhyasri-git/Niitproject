package com.niit.online.onlinebooksbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.online.onlinebooksbackend.dao.UserDAO;
import com.niit.online.onlinebooksbackend.model.User;

public class UserTest {

	
static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        context = new AnnotationConfigApplicationContext();
        context.scan("com.niit");
        context.refresh();
        
        UserDAO userDAO=(UserDAO)context.getBean("userDAO");
        User user=(User)context.getBean("user");
        System.out.println("User create");
/*        user.setId(1);*/
        user.setUsername("pavani");//checking weather values or saving or not in db
        user.setPassword("123");
        user.setConfirmpassword("1234");
        user.setEmailid("pavani@gmail.com");
        user.setPhno("8142863318");
        user.setEnabled("true");
        userDAO.saveOrUpdate(user);
        }

}
