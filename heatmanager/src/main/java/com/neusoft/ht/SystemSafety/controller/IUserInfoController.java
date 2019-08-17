package com.neusoft.ht.SystemSafety.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.SystemSafety.mapper.IuseInfoMapper;
import com.neusoft.ht.SystemSafety.model.UserInfo;
import com.neusoft.ht.SystemSafety.service.IUserInfoService;
import com.neusoft.ht.message.ResultMessage;

@RestController
@RequestMapping("/userinfo")
public class IUserInfoController {
@Autowired
private IUserInfoService userinfo=null;
@RequestMapping("/list")
public List<UserInfo> getListWithFunction() throws Exception{
	
	return userinfo.getListWithFunction();
}

@RequestMapping("/add")
public void addList() throws Exception{
	
}

@RequestMapping("/functionList")
public UserInfo functionList(String id) throws Exception{
	
	return userinfo.getListWithFunctionByid(id);
}
}
