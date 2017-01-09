package com.niit.online.onlinebooksbackend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.online.onlinebooksbackend.model.Product;
import com.niit.online.onlinebooksbackend.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(Supplier supplier) {
		 try {
            Session s = sessionFactory.getCurrentSession();
			//Transaction t = s.beginTransaction();
			s.saveOrUpdate(supplier);
			s.persist(supplier);
			System.out.println("adding supplier  impl");

			//t.commit();

			// sessionFactory.getCurrentSession().save(supplier);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Supplier supplier) {
		try {
			Session s = sessionFactory.getCurrentSession();
			//Transaction t = s.beginTransaction();

			 sessionFactory.getCurrentSession().delete(supplier);
			s.delete(supplier);
			System.out.println("deleete suppllier...in impl");

			//t.commit();

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public List<Supplier> list() {
		 /* String hql = "from Supplier";
		  Session s = sessionFactory.getCurrentSession(); 
		 // Transaction tx = s.beginTransaction(); 
	      org.hibernate.Query query = s.createQuery(hql);
		  //List<Supplier> all=query.list();
		  System.out.println("supplier list in impl"); 
		  //tx.commit(); 
		  //return all; 
*/		  List<Supplier> all=sessionFactory.getCurrentSession().createCriteria(Supplier.class).list(); 
		  System.out.println("supplier list in impl....."); 
		  return all;
	}
		 

		/*String hql = "from Supplier";
		Session s = sessionFactory.getCurrentSession();
		// Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Supplier> all = query.list();
		System.out.println("supplier list in impl..");
		// tx.commit();
		return all;

	}*/

	
		
      
	
	@Transactional
	public boolean update(Supplier supplier) {
		try {
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
		
		String hql = "from Supplier where id=" + id;
        Session s = sessionFactory.getCurrentSession();
		//Transaction t = s.beginTransaction();
        Query query = s.createQuery(hql);
        // Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list = query.list();
		/*for(Supplier s1:list)
		{
			System.out.println(s1.getId()+" "+s1.getName());
		}
		System.out.println("after list");
*/		// t.commit();
		//if (list == null) {
			return list.get(0);
           //} else {
           //System.out.println("geeeet supplier in impl");
            //return null;
			//}
	}
	}


