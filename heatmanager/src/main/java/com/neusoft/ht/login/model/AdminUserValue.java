package com.neusoft.ht.login.model;

import org.apache.ibatis.type.Alias;

import com.neusoft.ht.SystemSafety.model.UserInfo;

import lombok.Data;
/*
 *   用户信息 model 
 *   作者: 马佳国
 */
@Data
@Alias("User")
public class AdminUserValue {

	private UserInfo iuser=null;
	private String upassword =null;
	private String uname =null;
	
}
