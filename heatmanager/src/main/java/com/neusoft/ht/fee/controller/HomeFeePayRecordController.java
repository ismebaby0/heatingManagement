package com.neusoft.ht.fee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HomeFeePayRecord;
import com.neusoft.ht.fee.service.IHomeFeePayRecordService;
import com.neusoft.ht.message.ResultMessage;
/**
 * 住宅供热缴费记录 controller
 * 作者: 方俊坤
 */
@RequestMapping("/homefeerecord")
@RestController
public class HomeFeePayRecordController {
	@Autowired
	private IHomeFeePayRecordService service;
	
	@RequestMapping("/add")
	public ResultMessage<HomeFeePayRecord> add(HomeFeePayRecord payRecord) throws Exception {
		service.addRecord(payRecord);
		return new ResultMessage<HomeFeePayRecord>("ok","添加成功");
	}

	@RequestMapping("/delete")
	public ResultMessage<HomeFeePayRecord> delete(int no)	throws Exception{
		service.deleteByPrimaryKey(no);
		return new ResultMessage<HomeFeePayRecord>("ok","删除成功");
	}
	@RequestMapping("/modify")
	public ResultMessage<HomeFeePayRecord> update(HomeFeePayRecord home) throws Exception{
		service.updateRecord(home);
		return new ResultMessage<HomeFeePayRecord>("ok","修改成功");
	}
	@RequestMapping("/get")
	public ResultMessage<HomeFeePayRecord> selectByNo(int no) throws Exception {
		ResultMessage<HomeFeePayRecord> result = new ResultMessage<HomeFeePayRecord>("ok","查询成功");
		result.setModel(service.getByPrimaryKey(no));
		return result;
	}

	@RequestMapping("/list")
	public ResultMessage<HomeFeePayRecord>  getAllHomeFeePayRecord() throws Exception {
		ResultMessage<HomeFeePayRecord> result = new ResultMessage<HomeFeePayRecord>("ok", "查询成功");
		result.setList(service.getByAll());
		result.setStatus("ok");
		return result;
	}
	//分页
	@RequestMapping("list/page")
	public ResultMessage<HomeFeePayRecord> getAllWithPage(@RequestParam(required = false,defaultValue ="3") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<HomeFeePayRecord> message = new ResultMessage<>("ok", "查询成功");
		message.setList(service.getAllWithPages(rows, page));
		message.setPage(page);
		message.setRows(rows);
//		System.out.println(rows);
		message.setCount(service.getCountAll());
		message.setPageCount(service.getCountPage(rows));
		return message;
	}
}
