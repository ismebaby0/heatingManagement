package com.neusoft.ht.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HomeModel;
import com.neusoft.ht.fee.model.Neighbourhood;
import com.neusoft.ht.fee.service.IHomeService;
import com.neusoft.ht.message.ResultMessage;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	IHomeService service = null;
	
	
	
	@RequestMapping("/add")
	public ResultMessage<HomeModel> add(HomeModel home) throws Exception {
		service.add(home);
		return new ResultMessage<HomeModel>("ok","添加成功");
		
	}
	@RequestMapping("/delete")
	public ResultMessage<HomeModel> delete(int homeNo)	throws Exception{
		service.delete(homeNo);
		return new ResultMessage<HomeModel>("ok","删除成功");
	}
	@RequestMapping("/modify")
	public ResultMessage<HomeModel> update(HomeModel home) throws Exception{
		service.update(home);
		return new ResultMessage<HomeModel>("ok","修改成功");
	}
	@RequestMapping("getbyno")
	public ResultMessage<HomeModel> selectByNo(int homeNo) throws Exception {
		ResultMessage<HomeModel> result = new ResultMessage<HomeModel>("ok","查询成功");
		result.setModel(service.selectByNo(homeNo));
		return result;
	}
	@RequestMapping("getone/withrelation")
	public ResultMessage<HomeModel> getOneWithRelation(int homeNo) throws Exception{
		ResultMessage<HomeModel> result = new ResultMessage<>("ok", "关联查询成功");
		result.setModel(service.getOneWithRelation(homeNo));
		return result;
	}
	
	//分页
	@RequestMapping("getall")
	public ResultMessage<HomeModel> getAllWithPage(@RequestParam(required = false,defaultValue ="3") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<HomeModel> message = new ResultMessage<>("ok", "查询成功");
		message.setList(service.selectAllWithPage(rows, page));
		message.setPage(page);
		message.setRows(rows);
		System.out.println(rows);
		message.setCount(service.getCountAll());
		message.setPageCount(service.getCountPage(rows));
		return message;
	}
	

}
