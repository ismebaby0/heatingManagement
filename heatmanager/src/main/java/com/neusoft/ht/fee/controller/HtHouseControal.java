package com.neusoft.ht.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HtHouseModel;
import com.neusoft.ht.fee.service.IHtHouseService;

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

	@RequestMapping("/selectByNo")
	public HtHouseModel selectByNo(int houseNo) throws Exception {
		return houseService.selectByNo(houseNo);
	}

	@RequestMapping("/selectAllHouse")
	public List<HtHouseModel> selectAllHtHouse() throws Exception {
		return houseService.selectAllHtHouse();
	}

	@RequestMapping("/addHouse")
	public void addHtHouse(HtHouseModel record) throws Exception {
		houseService.addHtHouse(record);
	}

	@RequestMapping("/deleteHouse")
	public void deleteHouseModel(int houseNo) throws Exception {
		houseService.deleteHouseModel(houseNo);
	}

	@RequestMapping("/updateHouse")
	public void updateHouseModel(HtHouseModel record) throws Exception {
		houseService.updateHouseModel(record);
	}
}
