package com.neusoft.ht.SystemSafety.service;

import java.util.List;

import com.neusoft.ht.SystemSafety.model.UserInfo;


public interface IUserInfoService {

	 public void create(UserInfo iuser) throws Exception;
	 
	 public void modify(UserInfo iuser) throws Exception;
	 
	 public void delete(String id) throws Exception;
	 
	 public List<UserInfo> getListByAll() throws Exception;
	 
	 public List<UserInfo> getListWithFunction() throws Exception;
	 
	 public UserInfo getListWithId() throws Exception;
}
