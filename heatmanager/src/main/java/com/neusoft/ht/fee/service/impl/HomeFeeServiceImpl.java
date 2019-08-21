
package com.neusoft.ht.fee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.fee.mapper.IHomeFeeMapper;
import com.neusoft.ht.fee.model.HomeFeeModel;
import com.neusoft.ht.fee.service.IHomeFeeService;

/**
 *@Filefile	:HomeFeeServiceImpl.java
 *@author 	:Administrator
 *@Date		:2019年8月21日
 *
 *
 */
@Service
public class HomeFeeServiceImpl implements IHomeFeeService{
	
	@Autowired
	IHomeFeeMapper mapper = null;
	
	@Override
	public void add(HomeFeeModel homeFee) throws Exception {
		mapper.insert(homeFee);
		
	}

	@Override
	public void delete(int feeNo) throws Exception {
		mapper.deleteByPrimaryKey(feeNo);
		
	}

	@Override
	public void update(HomeFeeModel homeFee) throws Exception {
		System.out.println("修改");
		mapper.updateByPrimaryKey(homeFee);
	}

	


	@Override
	public int getCountAll() throws Exception {
		return mapper.getCountByAll();
	}

	@Override
	public int getCountPage(int rows) throws Exception {
		int count = this.getCountAll();
		int pageCount = 0;
		if(count%rows==0) {
			pageCount = count/rows;
		}else {
			pageCount = count/rows + 1 ;
		}
		return pageCount;
	}

	@Override
	public List<HomeFeeModel> selectAllWithPage(int row, int page) throws Exception {
		List<HomeFeeModel> list = mapper.selectAllWithPage(row*(page-1), page*row);
		return list;
	}

	@Override
	public List<HomeFeeModel> getAllWithRelationWithPage(int row, int page) throws Exception {
		List<HomeFeeModel> list = mapper.getAllWithRelation(row*(page-1), page*row);
		return list;
	}

	@Override
	public HomeFeeModel getByPrimaryKey(int feeNo) throws Exception {
		return mapper.getByPrimaryKey(feeNo);
	}

	@Override
	public HomeFeeModel getOneWithRelation(int feeNo) throws Exception {
		return mapper.getOneWithRelation(feeNo);
	}
}
