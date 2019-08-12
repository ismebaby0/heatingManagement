package com.neusoft.ht.login.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.login.Service.IUserBusiness;
import com.neusoft.ht.login.dao.IUserDao;
import com.neusoft.ht.login.model.AdminUserValue;
/*
 *   用户登陆 业务层
 *   作者: 马佳国
 */
@Service("UserBusiness")
public class IUserBusinessImpl implements IUserBusiness {

	@Autowired
	private IUserDao userDao=null;
	@Override
	public void create(AdminUserValue user) throws Exception {
		// TODO Auto-generated method stub
		userDao.create(user);

	}



	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		userDao.delete(id);

	}

	@Override
	public List<AdminUserValue> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return userDao.selectWithAll();
	}





	@Override
	public void modify(String id, String pass, String name) throws Exception {
		 userDao.update(id, pass, name);
		
	}



	@Override
	public AdminUserValue getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.selectById(id);
	}








}
