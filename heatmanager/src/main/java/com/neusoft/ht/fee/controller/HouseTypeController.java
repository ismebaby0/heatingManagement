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
@RequestMapping("/getAll")
@RestController
public class HouseTypeController {
	@Autowired
	IHouseTypeService service = null;
	@RequestMapping("/all")
	public List<HouseType> getAll() throws Exception{
		return service.selectAllHouseType();
	}

}
