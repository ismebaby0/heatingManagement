package com.neusoft.ht.SystemSafety.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.ht.SystemSafety.mapper.IuseInfoMapper;
import com.neusoft.ht.SystemSafety.model.UserInfo;
import com.neusoft.ht.SystemSafety.service.IUserInfoService;
@Service("userInfo")
@Transactional
public class UserInfoService implements IUserInfoService {
    
	@Autowired
	private IuseInfoMapper userinfo=null;
	@Override
	public void create(UserInfo iuser) throws Exception {
		// TODO Auto-generated method stub
		userinfo.create(iuser);
		
	}

	@Override
	public void modify(UserInfo iuser) throws Exception {
		// TODO Auto-generated method stub
		userinfo.update(iuser);
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		userinfo.delete(id);
		
	}

	@Override
	public List<UserInfo> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return userinfo.selectListWithAll();
	}

	@Override
	public List<UserInfo> getListWithFunction() throws Exception {
		// TODO Auto-generated method stub
		return userinfo.selectWithFunction();
	}

	@Override
	public UserInfo getListWithId(String id) throws Exception {
		// TODO Auto-generated method stub
		return userinfo.selectListById(id);
	}

	@Override
	public UserInfo getListWithFunctionByid(String id) throws Exception {
		// TODO Auto-generated method stub
		return userinfo.selectListWithFunctionById(id);
	}

	@Override
	public void createWithFunction(String id, int[] no) throws Exception {
		// TODO Auto-generated method stub
		userinfo.deleteWithFunctionById(id);
		userinfo.createWithFunctionById(id, no);
	}

	@Override
	public void modifyPhtoto(String id, byte[] photo, String contentType, String photoName) throws Exception {
		// TODO Auto-generated method stub
		userinfo.modifyPhoto(id, photo, contentType, photoName);
	}

}
