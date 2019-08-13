package com.neusoft.ht.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HouseFeeReturnRecord;
import com.neusoft.ht.fee.service.IHouseFeeReturnRecordService;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月13日 下午2:39:04
 */
@RequestMapping("/houseFeeReturnRecord")
@RestController
public class HouseFeeReturnRecordControal {
	@Autowired
	IHouseFeeReturnRecordService hfrr_service;

	@RequestMapping("/selectByNo")
	public HouseFeeReturnRecord selectByNo(int recordNo) throws Exception {
		return hfrr_service.selectByNo(recordNo);
	}

	@RequestMapping("/selectAll")
	public List<HouseFeeReturnRecord> selectAll() throws Exception {
		return hfrr_service.selectAll();
	}

	@RequestMapping("/addHouseFeeReturnRecord")
	public void addHouseFeeReturnRecord(HouseFeeReturnRecord record) throws Exception {
		hfrr_service.addHouseFeeReturnRecord(record);
	}

	@RequestMapping("/deleteHouseFeeReturnRecord")
	public void deleteHouseFeeReturnRecord(int recordNo) throws Exception {
		hfrr_service.deleteHouseFeeReturnRecord(recordNo);
	}

	@RequestMapping("/updateHouseFeeReturnRecord")
	public void updateHouseFeeReturnRecord(HouseFeeReturnRecord record) throws Exception {
		hfrr_service.updateHouseFeeReturnRecord(record);
	}
}
