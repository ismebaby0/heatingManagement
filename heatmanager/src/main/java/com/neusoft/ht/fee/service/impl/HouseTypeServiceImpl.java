/**
 * 
 */
package com.neusoft.ht.fee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.fee.mapper.IHouseTypeMapper;
import com.neusoft.ht.fee.model.HouseType;
import com.neusoft.ht.fee.service.IHouseTypeService;

/**
 *@Filefile	:HouseTypeServiceImpl.java
 *@author 	:Administrator
 *@Date		:2019年8月9日
 *
 *
 */

@Service
public class HouseTypeServiceImpl implements IHouseTypeService{
	@Autowired
	private IHouseTypeMapper mapper= null;
	@Override
	public List<HouseType> selectAllHouseType() throws Exception {
		return mapper.selectAllHouseType();
	}
	@Override
	public void addHouseType(HouseType ht) throws Exception {
		mapper.addHouseType(ht);
		
	}
	@Override
	public void deleteHouseType(int typeNo) throws Exception {
		mapper.deleteHouseType(typeNo);
	}
	@Override
	public void updateHouseType(HouseType ht) throws Exception {
		mapper.updateHouseType(ht);
	}
	@Override
	public HouseType selectByNo(int typeNo) throws Exception {
		return mapper.selectByNo(typeNo);
	}
	
	//分页查寻
	@Override
	public List<HouseType> selectAllWithPage(int row,int page) throws Exception {
		return mapper.selectAllWithPage(row*(page-1),page*row);
	}
	
	//
	@Override
	public int getCountPage(int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountAll();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}
	
	//查询全部户型个数
	@Override
	public int getCountAll() throws Exception {
		return mapper.getCountByAll();
	}

}
