
/**
 * 
 */
package com.neusoft.ht.fee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HomeFeeModel;
import com.neusoft.ht.fee.service.IHomeFeeService;
import com.neusoft.ht.message.ResultMessage;

/**
 *@Filefile	:HomeFeeController.java
 *@author 	:Administrator
 *@Date		:2019年8月21日
 *
 *
 */
@RestController
@RequestMapping("/homefee")
public class HomeFeeController {
	@Autowired
	IHomeFeeService service = null;
	
	@RequestMapping("/add")
	public ResultMessage<HomeFeeModel> add(HomeFeeModel homeFee) throws Exception{
		service.add(homeFee);
		return new ResultMessage<>("ok", "添加成功");
	}
	@RequestMapping("/delete")
	public ResultMessage<HomeFeeModel> delete(int feeNo)	throws Exception{
		service.delete(feeNo);
		return new ResultMessage<>("ok", "删除成功");
	}
	@RequestMapping("/modify")
	public ResultMessage<HomeFeeModel> update(HomeFeeModel homeFee) throws Exception{
		service.update(homeFee);
		return new ResultMessage<>("ok", "更新成功");
	}
	@RequestMapping("/getone")
	public ResultMessage<HomeFeeModel> getByPrimaryKey(int homeNo) throws Exception {
		ResultMessage<HomeFeeModel> message = new ResultMessage<>("ok", "查询成功");
		message.setModel(service.getByPrimaryKey(homeNo));
		return message;
	}
	@RequestMapping("/getone/withrelation")
	public ResultMessage<HomeFeeModel> getOneWithRelation(int feeNo) throws Exception {
		ResultMessage<HomeFeeModel> message = new ResultMessage<>("ok", "查询成功");
		System.out.println("查询成功");
		message.setModel(service.getOneWithRelation(feeNo));
		return message;
	}
	@RequestMapping("/getall/withpage")
	public ResultMessage<HomeFeeModel> getAllWithPage(@RequestParam(required = false,defaultValue ="3") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<HomeFeeModel> message = new ResultMessage<>("ok", "查询成功");
		message.setList(service.getAllWithRelationWithPage(rows, page));
		message.setPage(page);
		message.setRows(rows);
		message.setCount(service.getCountAll());
		message.setPageCount(service.getCountPage(rows));
		return message;
	}
}
