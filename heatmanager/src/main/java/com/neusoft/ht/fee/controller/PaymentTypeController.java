package com.neusoft.ht.fee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.PaymentType;
import com.neusoft.ht.fee.service.IPaymentTypeService;
import com.neusoft.ht.message.ResultMessage;

@RestController
@RequestMapping("/paymenttype")
public class PaymentTypeController {
	@Autowired
	private IPaymentTypeService service= null;
	
	@RequestMapping("/add")
	public ResultMessage<PaymentType> add(PaymentType pay) throws Exception {
		service.add(pay);
		return new ResultMessage<>("ok", "添加成功");
	}
	@RequestMapping("/delete")
	public ResultMessage<PaymentType> delete(int typeNo)	throws Exception{
		service.delete(typeNo);
		return new ResultMessage<>("ok", "删除成功");
	}
	@RequestMapping("/modify")
	public ResultMessage<PaymentType> update(PaymentType pay) throws Exception{
		service.update(pay);
		System.out.println(pay);
		return new ResultMessage<>("ok", "更新成功");
	}
	@RequestMapping("getbyno")
	public ResultMessage<PaymentType> selectByNo(int typeNo) throws Exception {
		ResultMessage<PaymentType> message = new ResultMessage<>("ok", "查询成功");
		message.setModel(service.selectByNo(typeNo));
		return message;
	}
	
	@RequestMapping("/list")
	public ResultMessage<PaymentType> selectByAll() throws Exception{
		ResultMessage<PaymentType> message = new ResultMessage<>("ok", "查询成功");
		message.setList(service.selectByAll());
		return message;
	}
	
	@RequestMapping("getall")
	public ResultMessage<PaymentType> getAllWithPage(@RequestParam(required = false,defaultValue ="3") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<PaymentType> message = new ResultMessage<>("ok", "查询成功");
		message.setList(service.selectAllWithPage(rows, page));
		message.setPage(page);
		message.setRows(rows);
		System.out.println(rows);
		message.setCount(service.getCountAll());
		message.setPageCount(service.getCountPage(rows));
		return message;
	}
}
