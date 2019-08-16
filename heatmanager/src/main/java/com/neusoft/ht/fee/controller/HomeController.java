package com.neusoft.ht.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/getAllHome")
	public ResultMessage<HomeModel> getAll() throws Exception{
		List<HomeModel> list = service.selectAll();
		ResultMessage<HomeModel> result = new ResultMessage<>();
		result.setList(list);
		return result;
	}
	
	@RequestMapping("/add")
	public void add(HomeModel home) throws Exception {
		service.add(home);
	}
	@RequestMapping("/delete")
	public void delete(int homeNo)	throws Exception{
		service.delete(homeNo);
	}
	@RequestMapping("/update")
	public void update(HomeModel home) throws Exception{
		service.update(home);
	}
	@RequestMapping("selectByNo")
	public HomeModel selectByNo(int homeNo) throws Exception {
		return service.selectByNo(homeNo);
	}
	

}
