package com.niit.online.onlinebooksbackend.dao;

import java.util.List;

import com.niit.online.onlinebooksbackend.model.User;

public interface UserDAO {
 public boolean isValidate(String loginName,String passwd);
 public boolean saveOrUpdate(User user);//details about user 
 public User getByName(String uname);
 public List<User>list();
 public boolean delete(User user );
}
