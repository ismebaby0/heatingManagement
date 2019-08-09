/**
 * 
 */
package com.neusoft.ht.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HouseType;
import com.neusoft.ht.fee.service.IHouseTypeService;

/**
 *@Filefile	:HouseTypeController.java
 *@author 	:Administrator
 *@Date		:2019年8月9日
 *
 *
 */
@RequestMapping("/HouseType")
@RestController
public class HouseTypeController {
	@Autowired
	IHouseTypeService service = null;
	
	@RequestMapping("/getall")
	public List<HouseType> getAll() throws Exception{
		return service.selectAllHouseType();
	}
	
	@RequestMapping("/getbyno")
	public HouseType getByNo(int typeNo) throws Exception {
		return service.selectByNo(typeNo);
	}
	
	@RequestMapping("/deletebyno")
	public void deleteByNo(int typeNo) throws Exception {
		service.deleteHouseType(typeNo);
	}
	
	@RequestMapping("/update")
	public void updateHouseType(HouseType ht) throws Exception {
		service.updateHouseType(ht);
	}

	@RequestMapping("/add")
	public void addHouseType(HouseType ht) throws Exception {
		service.addHouseType(ht);
	}
}
