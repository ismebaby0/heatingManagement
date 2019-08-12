package com.neusoft.ht.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.login.Service.IUserBusiness;
import com.neusoft.ht.login.model.AdminUserValue;
@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
	private IUserBusiness user=null;
	@RequestMapping("/list")
	public List<AdminUserValue> getList() throws Exception{
		return user.getListByAll();
	}
}
