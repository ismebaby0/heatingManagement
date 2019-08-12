package com.neusoft.ht.SystemSafety.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.ht.SystemSafety.model.UserInfo;

/*
 *   用户详细信息 mapper
 *   作者: 马佳国
 */

@Mapper
public interface IuseInfoMapper {
 public void create (UserInfo iuser) throws Exception;
 
 public void update(UserInfo iuser) throws Exception;
 
 public void delete(String id) throws Exception;
 
 public List<UserInfo> selectListWithAll() throws Exception;
 
 public UserInfo selectListById() throws Exception;
 
 public UserInfo selectWithFunctionById() throws Exception;
}
