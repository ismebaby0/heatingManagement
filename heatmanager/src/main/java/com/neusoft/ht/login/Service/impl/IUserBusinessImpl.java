package com.neusoft.ht.login.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.ht.SystemSafety.mapper.IuseInfoMapper;
import com.neusoft.ht.login.Service.IUserBusiness;
import com.neusoft.ht.login.mapper.IUserMapper;
import com.neusoft.ht.login.model.AdminUserValue;
/*
 *   用户登陆 业务层
 *   作者: 马佳国
 */
@Service("UserBusiness")
@Transactional
public class IUserBusinessImpl implements IUserBusiness {

	@Autowired
	private IUserMapper userDao=null;
	@Autowired
	private IuseInfoMapper userinfo=null;
	@Override
	
	public void create(AdminUserValue user) throws Exception {
		// TODO Auto-generated method stub
		userDao.create(user);
		userDao.createUserInfo(user);

	}



	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		userDao.delete(id);
		userinfo.delete(id);

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
	@Transactional(readOnly = true)
	public AdminUserValue getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.selectById(id);
	}



	@Override
	@Transactional(readOnly = true)
	public List<AdminUserValue> getListAllWithPages(String id,String name,int rows, int pages) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getListAllWithPages(id,name,rows*(pages-1), rows);
	}



	@Override
	@Transactional(readOnly = true)
	public int getTotalCount() throws Exception {
		// TODO Auto-generated method stub
		return userDao.getTotalCount();
	}



	@Override
	@Transactional(readOnly = true)
	public int getPageCount(int rows) throws Exception {
		// TODO Auto-generated method stub
		int pageCount=0;
		int count=userDao.getTotalCount();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=(count/rows)+1;
		}
		return pageCount;
	}








}
