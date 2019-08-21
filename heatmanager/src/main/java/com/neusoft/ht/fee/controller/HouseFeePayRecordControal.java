package com.neusoft.ht.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HouseFeePayRecord;
import com.neusoft.ht.fee.model.HouseType;
import com.neusoft.ht.fee.service.IHouseFeePayRecordService;
import com.neusoft.ht.message.ResultMessage;

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
	public ResultMessage<HouseFeePayRecord> getByNo(int recordNo) throws Exception {
		ResultMessage<HouseFeePayRecord> result = new ResultMessage<>("ok","查询成功");
		result.setModel(hfpr_service.selectByNo(recordNo));
		return result;
	}

	@RequestMapping("/getAll")
	public ResultMessage<HouseFeePayRecord> getAll() throws Exception {
		ResultMessage<HouseFeePayRecord> result = new ResultMessage<>();
		result.setList(hfpr_service.selectAllHtHouse());
		return result;
	}

	@RequestMapping("/add")
	public ResultMessage<HouseFeePayRecord> addHouseFeePayRecord(HouseFeePayRecord record) throws Exception {
			hfpr_service.addHouseFeePayRecord(record);
			return new ResultMessage<>("ok","添加成功");		
	}

	@RequestMapping("/delete")
	public ResultMessage<HouseFeePayRecord> deleteHouseFeePayRecord(int recordNo) throws Exception {
		hfpr_service.deleteHouseFeePayRecord(recordNo);
		return new ResultMessage<>("ok","删除成功");
	}

	@RequestMapping("/modify")
	public ResultMessage<HouseFeePayRecord> updateHouseFeePayRecord(HouseFeePayRecord record) throws Exception {
		if(record.getRecordNo() > 0) {
			 hfpr_service.updateHouseFeePayRecord(record);
			 ResultMessage<HouseFeePayRecord> resultMessage = new ResultMessage<>("ok","修改成功");
			 resultMessage.setModel(record);
			 return resultMessage;
		}else {
			return new ResultMessage<>("faild", "失败");
		}
		
	}

	@RequestMapping("/getall/page")
	public ResultMessage<HouseFeePayRecord> getAllWithPage(@RequestParam(required = false,defaultValue ="3") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<HouseFeePayRecord> result = new ResultMessage<>("ok","添加成功");
		result.setList(hfpr_service.selectAllWithPage(rows, page));
		result.setCount(hfpr_service.getCountAll());
		result.setPage(page);
		result.setRows(rows);
		System.out.println(rows);
		result.setPageCount(hfpr_service.getCountPage(rows));
		return result;
	}
}
