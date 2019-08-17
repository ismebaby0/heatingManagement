package com.neusoft.ht.SystemSafety.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.neusoft.ht.login.model.AdminUserValue;

import lombok.Data;

/*
 *   用户详细信息 model 
 *   作者: 马佳国
 */
@Data
@Alias("UserInfo")
public class UserInfo {
 private  String uuserid=null;
 
 private String sex=null;
 
 private int age;
 
 private byte[] photo=null;
 
 private String photoFileName=null;
 
 private String photoContentType;
 
 private String tel;
 
 private String mobile;
 
 private List<Function> functions=null;
 
 private AdminUserValue admin=null;
 
}
