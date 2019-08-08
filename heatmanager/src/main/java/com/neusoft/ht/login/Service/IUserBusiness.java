package com.neusoft.ht.login.Service;

import java.util.List;

import com.neusoft.ht.login.model.AdminUserValue;

public interface IUserBusiness {
 public void create(AdminUserValue user) throws Exception;
 
 public void modify(String id,String pass,String name) throws Exception;
 
 public void delete(String id) throws Exception;
 
 public List<AdminUserValue> getListByAll() throws Exception;
 
 public AdminUserValue getById(String id) throws Exception;
 
}
