package com.frontend.Handler;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.online.onlinebooksbackend.model.User;



@Component
public class RegistrationHandler {

	public User initFlow(){
		System.out.println("In Handler");
		return new User();
	}
public String validateDetails(User user,MessageContext messageContext){
		String status = "success";
		if(user.getUsername().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"username").defaultText("Name cannot be Empty").build());
			status = "failure";
			System.out.println("name pass");
		}
		if(user.getPassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"password").defaultText("Password cannot be Empty").build());
			status = "failure";
			System.out.println("password pass");
		}
		if(user.getConfirmpassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"confirmpassword").defaultText("Confirmed Password cannot be Empty").build());
			status = "failure";
			System.out.println("cpassword pass");
		}
		if(!user.getConfirmpassword().equals(user.getPassword())){
			messageContext.addMessage(new MessageBuilder().error().source(
					"confirmpassword").defaultText("Passwords do not match").build());
			status = "failure";
			System.out.println("check password pass");
		}
		
			if(user.getEmailid().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"email").defaultText("Email cannot be Empty").build());
			status = "failure";
			System.out.println("emailid pass");
		}
		if(user.getPhno().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"phno").defaultText("Mobile No. cannot be Empty").build());
			status = "failure";
			System.out.println("mob pass");
		}
		/*if(user.getAddress().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"address").defaultText("Address cannot be Empty").build());
			status = "failure";
			System.out.println("address pass");
		}*/
		return status;
	}
}

		

