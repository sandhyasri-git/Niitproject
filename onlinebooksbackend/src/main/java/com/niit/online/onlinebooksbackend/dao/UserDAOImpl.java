package com.niit.online.onlinebooksbackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.online.onlinebooksbackend.model.User;

@Repository(value = "userDAO")
//@EnableTransactionManagement

public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	public boolean isValidate(String loginName, String passwd) {
		// TODO Auto-generated method stub
		
	
		 if(loginName.equals("pa")&&passwd.equals("pa"))
		{
			//b=true;
		 return true;
		}
		else
		{
		   return false;
		}
	}
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional//ACID either update evrgthg or not 
	public boolean saveOrUpdate(User user) {
		/*try {
		Session s=sessionFactory.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(user);
		t.commit();//either comit or rollback transaction incomplete
		return true;*/

			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} 
		/*catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}*/
    
	@Transactional
	public User getByName(String uname) {
    System.out.println("Inside get method");
		
		/*Session s=  sessionFactory.getCurrentSession();
		Transaction tx=s.beginTransaction();*/
		String str="From User where username=" + "'" + uname + "'";
		
		Query query=sessionFactory.getCurrentSession().createQuery(str);
		List<User>ulist=query.list();
		
		if((ulist!=null) && ulist.isEmpty())
		{
			System.out.println("fetch frm user");
			//tx.commit();
		}

		return ulist.get(0);
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	
}