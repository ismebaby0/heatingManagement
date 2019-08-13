package com.neusoft.ht.login.Service;

import java.util.List;

import com.neusoft.ht.login.model.AdminUserValue;
/*
 *   用户登陆 业务层接口
 *   作者: 马佳国
 */
public interface IUserBusiness {
 public void create(AdminUserValue user) throws Exception;
 
 public void modify(String id,String pass,String name) throws Exception;
 
 public void delete(String id) throws Exception;
 
 public List<AdminUserValue> getListByAll() throws Exception;
 
 public AdminUserValue getById(String id) throws Exception;
 
 //取得列表带分页
 public List<AdminUserValue> getListAllWithPages(String id,String name,int rows,int pages)throws Exception;
 //取得数据个数
 public int getTotalCount() throws Exception;
 //取得页数
 public int getPageCount(int rows) throws Exception;
}
