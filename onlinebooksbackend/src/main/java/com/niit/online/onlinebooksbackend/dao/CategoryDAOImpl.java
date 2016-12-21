package com.niit.online.onlinebooksbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.online.onlinebooksbackend.model.Category;





@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionfactory;

	public CategoryDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}

	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
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
}
	
