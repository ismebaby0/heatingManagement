package com.neusoft.ht.login.dao;


import com.neusoft.ht.login.model.AdminUserValue;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface IUserDao {
  public void create(AdminUserValue user) throws Exception;
  public void update(@Param("upassword") String pass,@Param("uname") String name,@Param("uuserid") String id) throws Exception;
  public void delete(String uuserid) throws Exception;
  public List<AdminUserValue> selectWithAll() throws Exception;
  public AdminUserValue selectById(String uuserid) throws Exception;
}
