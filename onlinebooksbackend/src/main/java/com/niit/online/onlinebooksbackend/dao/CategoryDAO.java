package com.niit.online.onlinebooksbackend.dao;

import java.util.List;

import com.niit.online.onlinebooksbackend.model.Category;



public interface CategoryDAO {
	
	
	public boolean delete(Category category);
    public List<Category> list();
	public boolean saveOrUpdate(Category category);
	

}
