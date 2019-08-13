/**
 * 
 */
package com.neusoft.ht.fee.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HouseType;
import com.neusoft.ht.fee.service.IHouseTypeService;
import com.neusoft.ht.message.ResultMessage;

/**
 *@Filefile	:HouseTypeController.java
 *@author 	:劳泽昌
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
		if(ht.getTypeName().trim().length() > 0)
			service.updateHouseType(ht);
		}

	@RequestMapping("/add")
	public void addHouseType(HouseType ht) throws Exception {
		if(ht.getTypeName().trim().length() > 0) {
			service.addHouseType(ht);
		}
	}
	
	@RequestMapping("/getall/page")
	public ResultMessage<HouseType> getAllWithPage(@RequestParam(required = false,defaultValue ="3") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<HouseType> result = new ResultMessage<>();
		result.setList(service.selectAllWithPage(rows, page));
		result.setCount(service.getCountAll());
		result.setPage(page);
		result.setRows(rows);
		result.setPageCount(service.getCountPage(rows));
		return result;
	}
}
