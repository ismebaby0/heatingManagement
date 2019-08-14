package com.neusoft.ht.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HouseType;
import com.neusoft.ht.fee.model.HtHouseModel;
import com.neusoft.ht.fee.service.IHtHouseService;
import com.neusoft.ht.message.ResultMessage;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月12日
 */
@RequestMapping("/house")
@RestController
public class HtHouseControal {
	@Autowired
	private IHtHouseService houseService = null;

	@RequestMapping("/getAll")
	public ResultMessage<HtHouseModel> selectAllHtHouse() throws Exception {
		ResultMessage<HtHouseModel> result = new ResultMessage<>();
		result.setList(houseService.selectAllHtHouse());
		return result;
	}
	
	@RequestMapping("/getByNo")
	public ResultMessage<HtHouseModel> selectByNo(int houseNo) throws Exception {
		ResultMessage<HtHouseModel> result = new ResultMessage<>();
		result.setModel(houseService.selectByNo(houseNo));
		return result;
	}

	@RequestMapping("/deletebyno")
	public ResultMessage<HtHouseModel> deleteHouseModel(int houseNo) throws Exception {
		houseService.deleteHouseModel(houseNo);
		return new ResultMessage<>("ok","删除成功");
	}

	@RequestMapping("/updateHouse")
	public ResultMessage<HtHouseModel> updateHouseModel(HtHouseModel record) throws Exception {
		if(record.getName().trim().length() > 0) {
			houseService.updateHouseModel(record);
			return new ResultMessage<>("ok","修改成功");
		}else {
			return new ResultMessage<>("fail", "失败");
		}
	}
	
	@RequestMapping("/addHouse")
	public ResultMessage<HtHouseModel> addHtHouse(HtHouseModel record) throws Exception {
		System.out.println(record);
		if(record.getName().trim().length() > 0) {
			houseService.addHtHouse(record);
			return new ResultMessage<>("ok","添加成功");
		}else {
			return new ResultMessage<>("fail", "失败");
		}

	}

	@RequestMapping("/getAll/page")
	public ResultMessage<HtHouseModel> getAllWithPage(@RequestParam(required = false,defaultValue ="3") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<HtHouseModel> result = new ResultMessage<>("ok","添加成功");
		result.setList(houseService.selectAllWithPage(rows, page));
		result.setCount(houseService.getCountAll());
		result.setPage(page);
		result.setRows(rows);
		result.setPageCount(houseService.getCountPage(rows));
		return result;
	}


}
