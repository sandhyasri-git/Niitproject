package com.niit.online.onlinebooksbackend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.online.onlinebooksbackend.model.Category;
import com.niit.online.onlinebooksbackend.model.Product;
import com.niit.online.onlinebooksbackend.model.Supplier;


@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional 
	public boolean saveOrUpdate(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//@Transactional
	public boolean delete(Supplier supplier) {
		try {
			Session s = sessionFactory.getCurrentSession();
	    	Transaction t = s.beginTransaction();
			//sessionFactory.getCurrentSession().delete(supplier);
	    	s.delete(supplier);
	    	t.commit();
		return true;
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;
	}
	}

	@Transactional 
	public List<Supplier> list() {
		/*String hql = "from Supplier";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Supplier> all=query.list();
		System.out.println("supplier list in impl");
		tx.commit();
		return all;*/
		List<Supplier> all=sessionFactory.getCurrentSession().createCriteria(Supplier.class).list();
		return all;
		
	}
	
	
	/*@Transactional
		public Supplier get(int id) {*/
			/*Session s = sessionFactory.getCurrentSession();
	    	Transaction tx = s.beginTransaction();
	    	
			String hql = "from Supplier where id=" +id ;
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings({ "unchecked", "deprecation" }) 
			List<Supplier> list = query.list();
			if(list == null)
				return null;
			else
			{
				//tx.commit();
				
				return list.get(0);
			}*/
			
		
		/*String hql = "from Supplier where id=" + id;
	        // hibernate query
	        Session s = sessionFactory.getCurrentSession();
			//Transaction t = s.beginTransaction();
	        Query query = s.createQuery(hql);
	        //Query query = sessionFactory.getCurrentSession().createQuery(hql);
	        List<Supplier>list = query.list();
			 //t.commit();
			if (list == null) {
				return null;
				} else 
				{
	           System.out.println("geeeet supplier in impl");
	           return list.get(0);
	           }
	}*/
		
		
		
		
	
	@Transactional
	public boolean update(Supplier supplier) {
		/*try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(supplier);
			System.out.println("update supplier in impl");
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}*/
		/*sessionFactory.getCurrentSession().update(supplier);
		return true;}*/
		
		try{
			  sessionFactory.getCurrentSession().update(supplier);
			  return true;
			  }
		catch(Exception e){ 
		e.printStackTrace(); 
		return false; 
		} 
		
	}
	
	@Transactional
	public Supplier getByName(String name) {
		String hql = "from Supplier where name" + "'" + name + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list = (List<Supplier>) query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
}
	@Transactional
	public Supplier get(int id) {
		{
			// TODO Auto-generated method stub
	        String hql = "from Supplier where id= " + " ' " + id + " ' ";  //category is d domain object name not table name
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List <Supplier> list = query.list();
			return null;
		}
	}
	
	}
	
	
