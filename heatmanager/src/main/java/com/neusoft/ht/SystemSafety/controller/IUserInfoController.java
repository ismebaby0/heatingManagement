package com.neusoft.ht.SystemSafety.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.SystemSafety.mapper.IuseInfoMapper;
import com.neusoft.ht.SystemSafety.model.UserInfo;
import com.neusoft.ht.SystemSafety.service.IUserInfoService;

@RestController
@RequestMapping("/userinfo")
public class IUserInfoController {
@Autowired
private IUserInfoService userinfo=null;
@RequestMapping("/list")
public List<UserInfo> getListWithFunction() throws Exception{
	
	return userinfo.getListWithFunction();
}
}
