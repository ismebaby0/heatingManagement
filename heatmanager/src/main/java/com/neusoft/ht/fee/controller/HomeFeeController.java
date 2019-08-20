package com.neusoft.ht.fee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HomeFee;
import com.neusoft.ht.fee.service.IHomeFeeService;
import com.neusoft.ht.message.ResultMessage;


@RestController
@RequestMapping("/homeFee")
public class HomeFeeController {
	@Autowired
	IHomeFeeService service ;
	@RequestMapping("/add")
	public ResultMessage<HomeFee> add(HomeFee homeFee) throws Exception {
		service.add(homeFee);
		return new ResultMessage<HomeFee>("ok","添加成功");
	}
	@RequestMapping("/delete")
	public ResultMessage<HomeFee> delete(int homeNo)	throws Exception{
		service.delete(homeNo);
		return new ResultMessage<HomeFee>("ok","删除成功");
	}
	@RequestMapping("/modify")
	public ResultMessage<HomeFee> update(HomeFee home) throws Exception{
		service.update(home);
		return new ResultMessage<HomeFee>("ok","修改成功");
	}
	@RequestMapping("getbyno")
	public ResultMessage<HomeFee> selectByNo(int homeNo) throws Exception {
		ResultMessage<HomeFee> result = new ResultMessage<HomeFee>("ok","查询成功");
		result.setModel(service.selectByNo(homeNo));
		return result;
	}

}
