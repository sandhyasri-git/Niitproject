package com.frontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.online.onlinebooksbackend.dao.SupplierDAO;
import com.niit.online.onlinebooksbackend.model.Supplier;
import com.niit.online.onlinebooksbackend.model.User;

@Controller
public class suppliercontroller {

 
	@Autowired
	User user;
	
	@Autowired
	private JavaMailSender mailSender;
	
    @Autowired
	Supplier supplier;

	@Autowired
	SupplierDAO supplierDAO;

	@ModelAttribute
	public Supplier returnObject2() {
		return new Supplier();

	}

	@RequestMapping("/addSupplier")
	public ModelAndView ShowAddSupplier(Model model) {
		ModelAndView mv = new ModelAndView("addSupplier");

		model.addAttribute("supplierList", supplierDAO.list());
		System.out.println("added supplier details  in controller");

		return mv;
	}
	/*action of addsupplier*/
	@RequestMapping(value = "/addSup", method = RequestMethod.POST)
	public String addSupp(@ModelAttribute("supplier") Supplier su , HttpServletRequest request) {
		if (su.getId() == 0) {
			// new supplier, add it

			supplierDAO.saveOrUpdate(su);
			System.out.println("adding of new supplier in controller");
		} else {
			// existing supplier, call update

			supplierDAO.update(su);
			System.out.println("addsup update method of supplier in controller");
		}
		
		HttpSession session=request.getSession(false);
		String email1=(String)session.getAttribute("email");
		
		String usernaam=(String)session.getAttribute("loggedInUser");
		
		String recipientAddress=email1;
		String subject="User Registration";
		String message="User Registered successfully\n"+
		"The Details ..r.."+"\n User Name:"+usernaam+"\n Phone no:"+user.getPhno();
		
		//prints on console
		System.out.println("Too:"+recipientAddress);
		System.out.println("Subject:"+subject);
		System.out.println("Message:"+message);
		
		//creats a simple e-mail obj.
		SimpleMailMessage email=new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		
		//sends the e-mail
		mailSender.send(email);			

		return "redirect:/addSupplier";

	}
                  

	/* delete supplier... */
	@RequestMapping(value = "/deletesupplier{id}")
	public ModelAndView deletesupplier(@PathVariable("id") String id) throws Exception 
	{
		System.out.println("deleting supplier");
		int i=Integer.parseInt(id);
		supplier = supplierDAO.get(i);
		ModelAndView mv =new ModelAndView("addSupplier");
		supplierDAO.delete(supplier);
		mv.addObject("addSupplier",0);
		System.out.println("delete Id:" + id);
		return mv;
	}

	@RequestMapping(value = "/editsupplier{id}")
	public ModelAndView UpdatesuppPage(@PathVariable("id") String id, Model model) throws Exception {
		int i = Integer.parseInt(id);
		model.addAttribute("supplier", supplierDAO.get(i));
		model.addAttribute("SupplierList", supplierDAO.list());
		System.out.println("edit supplier in controller");
		ModelAndView mv = new ModelAndView("addSupplier");
		return mv;

	}
}