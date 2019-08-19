package com.neusoft.ht.complain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.complain.model.PublicHouseComplainModel;
import com.neusoft.ht.complain.service.IPublicHouseComplainModelService;
import com.neusoft.ht.message.ResultMessage;

/*
 * 公建投诉信息控制类
 *   作者: 方俊坤
 */
@RestController
@RequestMapping("/housecomplain")
public class PublicHouseComplainModelController {
	@Autowired
	IPublicHouseComplainModelService PublicHouseComplainModelService = null;

	// 必须参数:no 参数类型:数字
	@RequestMapping("/get")
	public ResultMessage<PublicHouseComplainModel> getPublicHouseComplainModel(Integer no) throws Exception {
		ResultMessage<PublicHouseComplainModel> result = new ResultMessage<PublicHouseComplainModel>();
		result.setModel(PublicHouseComplainModelService.getByNo(no));
		result.setStatus("OK");
		return result;
	}

	@RequestMapping("/list")
	public ResultMessage<PublicHouseComplainModel>  getAllPublicHouseComplainModel() throws Exception {
		ResultMessage<PublicHouseComplainModel> result = new ResultMessage<PublicHouseComplainModel>();
		result.setList(PublicHouseComplainModelService.getByAll());
		result.setStatus("OK");
		return result;
	}
	//取得分页列表
	@RequestMapping("list/page")
	public ResultMessage<PublicHouseComplainModel> getListWithPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page)throws Exception{
		ResultMessage<PublicHouseComplainModel> result=new ResultMessage<PublicHouseComplainModel>("OK","取得投诉类型分页成功");
		result.setCount(PublicHouseComplainModelService.getTotalCount());
		result.setPageCount(PublicHouseComplainModelService.getPageCount(rows));
		result.setList(PublicHouseComplainModelService.getListAllWithPages(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
		
	}

	// 必须参数:no 参数类型:数字
	@RequestMapping("/delete")
	public ResultMessage<PublicHouseComplainModel> delete(Integer no) throws Exception {
		PublicHouseComplainModelService.delete(no);
		ResultMessage<PublicHouseComplainModel> result = new ResultMessage<>("OK", "删除成功");
		return result;
	}

	/**/
	@RequestMapping("/add")
	public ResultMessage<PublicHouseComplainModel> add(PublicHouseComplainModel record) throws Exception {
		PublicHouseComplainModelService.insert(record);
		ResultMessage<PublicHouseComplainModel> result = new ResultMessage<>("OK", "添加成功");
		return result;
	}

	/**/
	@RequestMapping("/modify")
	public ResultMessage<PublicHouseComplainModel> modify(PublicHouseComplainModel record) throws Exception {
		PublicHouseComplainModelService.updateByNo(record);
		ResultMessage<PublicHouseComplainModel> result = new ResultMessage<>("OK", "修改成功");
		return result;
	}

}
