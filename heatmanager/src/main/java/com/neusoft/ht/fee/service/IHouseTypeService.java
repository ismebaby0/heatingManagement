/**
 * 
 */
package com.neusoft.ht.fee.service;

import java.util.List;

import com.neusoft.ht.fee.model.HouseType;

/**
 *@Filefile	:HouseTypeService.java
 *@author 	:Administrator
 *@Date		:2019年8月9日
 *
 *
 */
public interface IHouseTypeService {
	
	public List<HouseType> selectAllHouseType() throws Exception;
	
	public void addHouseType(HouseType ht) throws Exception;
	
	public void deleteHouseType(int ht) throws Exception;
	
	public void updateHouseType(HouseType ht) throws Exception;
	
	public HouseType selectByNo(int typeNo) throws Exception;
	
	
}
