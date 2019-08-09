/**
 * 
 */
package com.neusoft.ht.fee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.fee.mapper.HouseTypeMapper;
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
	private HouseTypeMapper mapper= null;
	@Override
	public List<HouseType> selectAllHouseType() {
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

}
