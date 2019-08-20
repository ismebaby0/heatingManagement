package com.neusoft.ht.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.ht.login.Service.IUserBusiness;

@RequestMapping("/login")
@Controller
public class LoginController {

	@Autowired
	private IUserBusiness user=null;
	@RequestMapping("/validate")
	public String validate(String id,String password) throws Exception{
		boolean result=user.validate(id, password);
		if (result) {
			System.out.println("开始跳转");
			return "redirect:/index.html";
		}
		else {
			System.out.println("开始跳转");
			return "redirect:/login.html";
		}
	}
}
