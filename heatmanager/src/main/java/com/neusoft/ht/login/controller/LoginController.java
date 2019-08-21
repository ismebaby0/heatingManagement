package com.neusoft.ht.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.ht.login.Service.IUserBusiness;

@RequestMapping("/login")
@Controller
public class LoginController {

	@Autowired
	private IUserBusiness user=null;
	@RequestMapping("/validate")
	public String validate(String id,String password,HttpServletRequest request) throws Exception{
		boolean result=user.validate(id, password);
		if (result) {
			System.out.println("开始跳转");
			request.getSession().setAttribute("loginName", id);
			return "redirect:/index.html";
		}
		else {
			System.out.println("开始跳转");
		  
			return "redirect:/login.html";
		}
	}
	
	@RequestMapping("/getname")
	@ResponseBody
	public String getName(HttpServletRequest request)throws Exception{
		return (String) request.getSession().getAttribute("loginName");

	}
}
