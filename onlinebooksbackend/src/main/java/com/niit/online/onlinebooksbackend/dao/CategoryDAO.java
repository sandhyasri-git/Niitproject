package com.niit.online.onlinebooksbackend.dao;

import java.util.List;

import com.niit.online.onlinebooksbackend.model.Category;
import com.niit.online.onlinebooksbackend.model.Supplier;



public interface CategoryDAO {
	
	
	public boolean delete(Category category);
	
    public List<Category> list();
    
	public boolean saveOrUpdate(Category category);
	
	public Category get(int id);
	
	public boolean update(Category category);
	 
	public Category getByName(String name);

}
