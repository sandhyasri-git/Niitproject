package com.niit.online.onlinebooksbackend.dao;

import java.util.List;

import com.niit.online.onlinebooksbackend.model.Supplier;



public interface SupplierDAO {

    public boolean delete(Supplier supplier);
    
	public Supplier get(int id);
	
	// collection of supplier list
    public List<Supplier>list();

    boolean saveOrUpdate(Supplier supplier);
    
    public boolean update(Supplier supplier);
    
    public Supplier getByName(String name);

}



	
