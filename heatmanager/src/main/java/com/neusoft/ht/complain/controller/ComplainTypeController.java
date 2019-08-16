package com.neusoft.ht.complain.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.complain.model.ComplainType;
import com.neusoft.ht.complain.service.IComplainTypeService;
import com.neusoft.ht.login.model.AdminUserValue;
import com.neusoft.ht.message.ResultMessage;

/*
 * 投诉类型控制类
 *   作者: 方俊坤
 */
@RestController
@RequestMapping("/complaintype")
public class ComplainTypeController {
	@Autowired
	IComplainTypeService complainTypeService = null;

	// 必须参数:no 参数类型:数字
	@RequestMapping("/get")
	public ResultMessage<ComplainType> getComplainType(Integer no) throws Exception {
		ResultMessage<ComplainType> result = new ResultMessage<>();
		result.setModel(complainTypeService.getByNo(no));
		result.setStatus("OK");
		return result;
	}

	@RequestMapping("/list")
	public ResultMessage<ComplainType> getAllComplainType() throws Exception {
		ResultMessage<ComplainType> result = new ResultMessage<>();
		result.setList(complainTypeService.getByAll());
		result.setStatus("OK");
		return result;
	}
	//取得分页列表
	@RequestMapping("list/page")
	public ResultMessage<ComplainType> getListWithPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page)throws Exception{
		ResultMessage<ComplainType> result=new ResultMessage<ComplainType>("OK","取得投诉类型分页成功");
		result.setCount(complainTypeService.getTotalCount());
		result.setPageCount(complainTypeService.getPageCount(rows));
		result.setList(complainTypeService.getListAllWithPages(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
		
	}

	// 必须参数:no 参数类型:数字
	@RequestMapping("/delete")
	public ResultMessage<ComplainType> delete(Integer no) throws Exception {
		complainTypeService.delete(no);
		ResultMessage<ComplainType> result = new ResultMessage<>("OK", "删除成功");
		return result;
	}

	/*
	 * 参数:typeNo 参数类型:数字 参数:typeName 参数类型:字符串
	 */
	@RequestMapping("/add")
	public ResultMessage<ComplainType> add(ComplainType record) throws Exception {
		ResultMessage<ComplainType> result = new ResultMessage<>();
		if (record.getTypeName().trim().length() > 0) {
			complainTypeService.insert(record);
			result.setStatus("OK");
		} else {
			result.setStatus("failed");
			result.setMessage("getTypeName().trim().length() < 0");
		}
		return result;

	}

	/*
	 * 必须参数:typeNo 参数类型:数字 参数:typeName 参数类型:字符串
	 */
	@RequestMapping("/modify")
	public ResultMessage<ComplainType> modify(ComplainType record) throws Exception {
		ResultMessage<ComplainType> result = new ResultMessage<>();
		if (record.getTypeName().trim().length() > 0) {
			complainTypeService.updateByNo(record);
			result.setStatus("OK");
		} else {
			result.setStatus("failed");
			result.setMessage("getTypeName().trim().length() < 0");
		}
		return result;
	}

}
