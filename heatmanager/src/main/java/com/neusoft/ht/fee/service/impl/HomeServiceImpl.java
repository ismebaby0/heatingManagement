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
	public HomeModel getOneWithRelation(int homeNo) throws Exception {
		return mapper.getOneWithRelation(homeNo);
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
	@Override
	public int getCountAll() throws Exception {
		return mapper.getCountByAll();
	}


	@Override
	public int getCountPage(int rows) throws Exception {
		int pageCount = 0 ;
		int count = this.getCountAll();
		if(count%rows == 0) {
			pageCount = count/rows;
		}else {
			pageCount = count/rows+1;
		}
		return pageCount;
	}


	@Override
	public List<HomeModel> selectAllWithPage(int row, int page) throws Exception {
		List<HomeModel> list = mapper.selectAllWithPage(row*(page-1), page*row);
		return list;
	}

}
