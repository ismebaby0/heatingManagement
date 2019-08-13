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
	public ResultMessage<HouseType> getAll() throws Exception{
		ResultMessage<HouseType> result = new ResultMessage<>();
		result.setList(service.selectAllHouseType());
		return result;
	}
	
	@RequestMapping("/getbyno")
	public ResultMessage<HouseType> getByNo(int typeNo) throws Exception {
		ResultMessage<HouseType> result = new ResultMessage<>();
		result.setModel(service.selectByNo(typeNo));
		return result;
	}
	
	@RequestMapping("/deletebyno")
	public ResultMessage<HouseType> deleteByNo(int typeNo) throws Exception {
		service.deleteHouseType(typeNo);
		return new ResultMessage<>("ok","删除成功");
	}
	
	@RequestMapping("/update")
	public ResultMessage<HouseType> updateHouseType(HouseType ht) throws Exception {
		if(ht.getTypeName().trim().length() > 0) {
			service.updateHouseType(ht);
			return new ResultMessage<>("ok","修改成功");
		}else {
			return new ResultMessage<>("faild", "失败");
		}
	}

	@RequestMapping("/add")
	public ResultMessage<HouseType> addHouseType(HouseType ht) throws Exception {
		System.out.println(ht);
		if(ht.getTypeName().trim().length() > 0) {
			service.addHouseType(ht);
			return new ResultMessage<>("ok","添加成功");
		}else {
			return new ResultMessage<>("faild", "失败");
		}
	}
	
	@RequestMapping("/getall/page")
	public ResultMessage<HouseType> getAllWithPage(@RequestParam(required = false,defaultValue ="3") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<HouseType> result = new ResultMessage<>("ok","添加成功");
		result.setList(service.selectAllWithPage(rows, page));
		result.setCount(service.getCountAll());
		result.setPage(page);
		result.setRows(rows);
		result.setPageCount(service.getCountPage(rows));
		return result;
	}
}
