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

import com.niit.online.onlinebooksbackend.model.Category;
import com.niit.online.onlinebooksbackend.model.Supplier;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
    
	
	@Autowired
	Category category;
	
	@Autowired
	SessionFactory sessionfactory;

	public CategoryDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}
	
	@Transactional
	public boolean delete(Category category) {
		try {
			Session s = sessionfactory.getCurrentSession();
			//Transaction t = s.beginTransaction();
            sessionfactory.getCurrentSession().delete(category);
			s.delete(category);
			System.out.println("deleete category...in impl");
            //t.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
	}
	}
	
	@Transactional
	public List<Category> list() {
		/*String hql = "from Category";
		Session s = sessionfactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Category> all = query.list();
	    tx.commit();
	    System.out.println("In cat list method");
		return all;*/
		List<Category> all=sessionfactory.getCurrentSession().createCriteria(Category.class).list();
		return all;
}

	@Transactional
	public boolean saveOrUpdate(Category category) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		/*sessionfactory.getCurrentSession().saveOrUpdate(category);
		return true;*/
	}
    
	@Transactional
	public Category get(int id) {
		String hql = "from Category where Catid=" +   id;
        Session s = sessionfactory.getCurrentSession();
		//Transaction t = s.beginTransaction();
        Query query = s.createQuery(hql);
        // Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list = query.list();
		/*for(Supplier s1:list)
		{
			System.out.println(s1.getId()+" "+s1.getName());
		}
		System.out.println("after list");
		// t.commit();
		if (list == null) {
			*/return list.get(0);
        /*   } else {
           System.out.println("geeeet supplier in impl");
            return null;
			}*/

	}
	
	@Transactional
	public boolean update(Category category) {
		try {
			Session s = sessionfactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(category);
			System.out.println("update category in impl");
			tx.commit();
		 return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public Category getByName(String name) {
		String hql = "from Category where name" + "'" + name + "'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Category> list = (List<Category>) query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
