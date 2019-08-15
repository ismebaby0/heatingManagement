package com.neusoft.ht.fee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.fee.mapper.IHomeMapper;
import com.neusoft.ht.fee.model.HomeModel;
import com.neusoft.ht.fee.model.HouseFeePayRecord;
import com.neusoft.ht.fee.model.Neighbourhood;
import com.neusoft.ht.fee.service.IHomeService;
import com.neusoft.ht.message.ResultMessage;

@Service
public class HomeServiceImpl implements IHomeService{

	@Autowired
	private IHomeMapper mapper = null;
	@Override
	public List<HomeModel> selectAll() throws Exception {
		List<HomeModel> list = mapper.selectByAll();
		return list;
	}
	@Override
	public void add(HomeModel home) throws Exception {
		mapper.insert(home);
		
	}
	@Override
	public void delete(int homeNo) throws Exception {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(homeNo);
	}
	@Override
	public void update(HomeModel home) throws Exception {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKey(home);
	}
	@Override
	public HomeModel selectByNo(int homeNo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(homeNo);
	}

}
