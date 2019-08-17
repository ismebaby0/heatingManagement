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
@Alias("Function")
public class Function {
 private int funNo;
 
 private String funName;
 
 private String funUrl;
 
 private int levelNo;
 
 private List<UserInfo> userInfos=null;
 
 private AdminUserValue admin=null;
}
