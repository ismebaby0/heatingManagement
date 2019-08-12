package com.neusoft.ht.complain.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.complain.model.HomeComplainModel;
import com.neusoft.ht.complain.service.IHomeComplainModelService;

/*
 * 居民投诉信息控制类
 *   作者: 方俊坤
 */
@RestController
@RequestMapping("/homecomplain")
public class HomeComplainModelController {
	@Autowired
	IHomeComplainModelService HomeComplainModelService = null;

	// 必须参数:no 参数类型:数字
	@RequestMapping("/get")
	public HomeComplainModel getHomeComplainModel(Integer no) throws Exception {
		return HomeComplainModelService.getByNo(no);
	}
	@RequestMapping("/list")
	public List<HomeComplainModel> getAllHomeComplainModel() throws Exception {
		return HomeComplainModelService.getByAll();
	}

	// 必须参数:no 参数类型:数字
	@RequestMapping("/delete")
	public void delete(Integer no) throws Exception {
		HomeComplainModelService.delete(no);
	}

	/**/
	@RequestMapping("/add")
	public void add(HomeComplainModel record) throws Exception {
		HomeComplainModelService.insert(record);
	}

	/**/
	@RequestMapping("/modify")
	public void modify(HomeComplainModel record) throws Exception {
		HomeComplainModelService.updateByNo(record);
	}

}
