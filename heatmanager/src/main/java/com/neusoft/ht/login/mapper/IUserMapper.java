package com.neusoft.ht.login.mapper;

import com.neusoft.ht.SystemSafety.model.UserInfo;
/*
 *   用户信息 mapper
 *   作者: 马佳国
 */
import com.neusoft.ht.login.model.AdminUserValue;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface IUserMapper {
  public void create(AdminUserValue user) throws Exception;
  public void update(@Param("upassword") String pass,@Param("uname") String name,@Param("uuserid") String id) throws Exception;
  public void delete(String uuserid) throws Exception;
  public List<AdminUserValue> selectWithAll() throws Exception;
  public AdminUserValue selectById(String uuserid) throws Exception;
  //取得所有用户的信息带分页
  public List<AdminUserValue> getListAllWithPages(@Param("uuserid") String id,@Param("uname") String name,@Param("start") int start,@Param("rows") int rows) throws Exception;
  
  //取得所有数据的个数
  public void createUserInfo(AdminUserValue user) throws Exception;
  public int getTotalCount() throws Exception;

}

