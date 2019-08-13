package com.neusoft.ht.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HouseFeePayRecord;
import com.neusoft.ht.fee.service.IHouseFeePayRecordService;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月13日 上午10:25:46
 */
@RequestMapping("/HouseFeePayRecord")
@RestController
public class HouseFeePayRecordControal {
	@Autowired
	IHouseFeePayRecordService hfpr_service;

	@RequestMapping("/getByNo")
	public HouseFeePayRecord selectByNo(int recordNo) throws Exception {
		return hfpr_service.selectByNo(recordNo);
	}

	@RequestMapping("/getAll")
	public List<HouseFeePayRecord> selectAllHtHouse() throws Exception {
		return hfpr_service.selectAllHtHouse();
	}

	@RequestMapping("/addHouseFeePayRecord")
	public void addHouseFeePayRecord(HouseFeePayRecord record) throws Exception {
		hfpr_service.addHouseFeePayRecord(record);
	}

	@RequestMapping("/deleteHouseFeePayRecord")
	public void deleteHouseFeePayRecord(int recordNo) throws Exception {
		hfpr_service.deleteHouseFeePayRecord(recordNo);
	}

	@RequestMapping("/updateHouseFeePayRecord")
	public void updateHouseFeePayRecord(HouseFeePayRecord record) throws Exception {
		hfpr_service.updateHouseFeePayRecord(record);
	}

}
