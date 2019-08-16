package com.neusoft.ht.complain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.complain.model.HomeComplainModel;
import com.neusoft.ht.complain.service.IHomeComplainModelService;
import com.neusoft.ht.message.ResultMessage;

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
	public ResultMessage<HomeComplainModel> getHomeComplainModel(Integer no) throws Exception {
		ResultMessage<HomeComplainModel> result = new ResultMessage<HomeComplainModel>();
		result.setModel(HomeComplainModelService.getByNo(no));
		result.setStatus("OK");
		return result;
	}

	@RequestMapping("/list")
	public ResultMessage<HomeComplainModel>  getAllHomeComplainModel() throws Exception {
		ResultMessage<HomeComplainModel> result = new ResultMessage<HomeComplainModel>();
		result.setList(HomeComplainModelService.getByAll());
		result.setStatus("OK");
		return result;
	}
	//取得分页列表
	@RequestMapping("list/page")
	public ResultMessage<HomeComplainModel> getListWithPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page)throws Exception{
		ResultMessage<HomeComplainModel> result=new ResultMessage<HomeComplainModel>("OK","取得投诉类型分页成功");
		result.setCount(HomeComplainModelService.getTotalCount());
		result.setPageCount(HomeComplainModelService.getPageCount(rows));
		result.setList(HomeComplainModelService.getListAllWithPages(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
		
	}

	// 必须参数:no 参数类型:数字
	@RequestMapping("/delete")
	public ResultMessage<HomeComplainModel> delete(Integer no) throws Exception {
		HomeComplainModelService.delete(no);
		ResultMessage<HomeComplainModel> result = new ResultMessage<>("OK", "删除成功");
		return result;
	}

	/**/
	@RequestMapping("/add")
	public ResultMessage<HomeComplainModel> add(HomeComplainModel record) throws Exception {
		HomeComplainModelService.insert(record);
		ResultMessage<HomeComplainModel> result = new ResultMessage<>("OK", "添加成功");
		return result;
	}

	/**/
	@RequestMapping("/modify")
	public ResultMessage<HomeComplainModel> modify(HomeComplainModel record) throws Exception {
		HomeComplainModelService.updateByNo(record);
		ResultMessage<HomeComplainModel> result = new ResultMessage<>("OK", "修改成功");
		return result;
	}

}
