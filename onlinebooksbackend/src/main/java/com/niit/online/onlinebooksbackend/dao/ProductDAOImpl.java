package com.niit.online.onlinebooksbackend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.online.onlinebooksbackend.model.Product;

@Repository(value = "productDAO")
//@EnableTransactionManagement

public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionfactory;

	public ProductDAOImpl(SessionFactory sessionfactory) {
		// super();
		this.sessionfactory = sessionfactory;
	}
	public ProductDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean update(Product product) {
		try{
			  sessionfactory.getCurrentSession().update(product);
			  return true;
			  }
		catch(Exception e){ 
		e.printStackTrace(); 
		return false; 
		} 
		
	}


	 @Transactional
	public boolean delete(Product product) {
		try {
			/*Session s = sessionfactory.getCurrentSession();
	    	Transaction tx = s.beginTransaction();*/
			sessionfactory.getCurrentSession().delete(product);
	    	//tx.commit();
		return true;
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;
	}
	}
	
	
	@Transactional
	public Product get(int id) {
		/*Session s = sessionfactory.getCurrentSession();
    	Transaction tx = s.beginTransaction();*/
    	String hql = "from Product where productid=" +id ;
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings({ "unchecked", "deprecation" }) 
		List<Product> list = query.list();
		if(list == null)
			return null;
		else
		{
			//tx.commit();
			return list.get(0);
		}
	}
	
    @Transactional
	public List<Product> list() {
    	/*Session s = sessionfactory.getCurrentSession();
    	Transaction tx = s.beginTransaction();
*/    	
    	List<Product> list =sessionfactory.getCurrentSession().createCriteria(Product.class).list();
		return list;
	}
    
    @Transactional
	public boolean saverOrUpdate(Product product) {
		/*try {
			Session s = sessionfactory.getCurrentSession();
			Transaction t = s.beginTransaction();
			s.saveOrUpdate(product);
			t.commit();// either comit or rollback transaction incomplete
			return true;*/
			sessionfactory.getCurrentSession().saveOrUpdate(product);
			return true;
		/*} catch (Exception e) {
			e.printStackTrace();
			return false;
		}*/
	}
	
}
