package com.neusoft.ht.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.Neighbourhood;
import com.neusoft.ht.fee.service.INeighbourhoodService;
import com.neusoft.ht.message.ResultMessage;


/**
 *@Filefile	:HouseTypeController.java
 *@author 	:劳泽昌
 *@Date		:2019年8月9日
 *
 *
 */

@RestController
@RequestMapping("/Neighbourhood")
public class NeighbourhoodController {
	
	@Autowired
	private INeighbourhoodService service= null;
	
	@RequestMapping("/add")
	public ResultMessage<Neighbourhood> add(Neighbourhood nbh) throws Exception {
		service.add(nbh);
		return new ResultMessage<>("ok", "添加成功");
	}
	@RequestMapping("/delete")
	public ResultMessage<Neighbourhood> delete(int hoodNo)	throws Exception{
		service.delete(hoodNo);
		return new ResultMessage<>("ok", "删除成功");
	}
	@RequestMapping("/modify")
	public ResultMessage<Neighbourhood> update(Neighbourhood nbh) throws Exception{
		service.update(nbh);
		return new ResultMessage<>("ok", "更新成功");
	}
	@RequestMapping("getbyno")
	public ResultMessage<Neighbourhood> selectByNo(int hoodNo) throws Exception {
		ResultMessage<Neighbourhood> message = new ResultMessage<>("ok", "查询成功");
		message.setModel(service.selectByNo(hoodNo));
		return message;
	}
	
	@RequestMapping("/list")
	public ResultMessage<Neighbourhood> selectByAll() throws Exception{
		ResultMessage<Neighbourhood> message = new ResultMessage<>("ok", "查询成功");
		message.setList(service.selectByAll());
		return message;
	}
	
	@RequestMapping("getall")
	public ResultMessage<Neighbourhood> getAllWithPage(@RequestParam(required = false,defaultValue ="3") int row,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<Neighbourhood> message = new ResultMessage<>("ok", "查询成功");
		message.setList(service.selectAllWithPage(row, page));
		message.setPage(page);
		message.setRows(row);
		return message;
	}
}
