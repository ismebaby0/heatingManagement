package com.neusoft.ht.login.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("User")
public class AdminUserValue {

	private String uuserid=null;
	private String upassword =null;
	private String uname =null;
	
}
