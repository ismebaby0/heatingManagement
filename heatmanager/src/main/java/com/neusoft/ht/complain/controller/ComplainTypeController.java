package com.neusoft.ht.complain.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.complain.model.ComplainType;
import com.neusoft.ht.complain.service.IComplainTypeService;

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
	public ComplainType getComplainType(Integer no) throws Exception {
		return complainTypeService.getByNo(no);
	}
	@RequestMapping("/list")
	public List<ComplainType> getAllComplainType() throws Exception {
		return complainTypeService.getByAll();
	}

	// 必须参数:no 参数类型:数字
	@RequestMapping("/delete")
	public void delete(Integer no) throws Exception {
		complainTypeService.delete(no);
	}

	/*
	 * 参数:typeNo 参数类型:数字 参数:typeName 参数类型:字符串
	 */
	@RequestMapping("/add")
	public void add(ComplainType record) throws Exception {
		if (record.getTypeName().trim().length() > 0) {
			complainTypeService.insert(record);
		}
	}

	/*
	 * 必须参数:typeNo 参数类型:数字 参数:typeName 参数类型:字符串
	 */
	@RequestMapping("/modify")
	public void modify(ComplainType record) throws Exception {
		if (record.getTypeName().trim().length() > 0) {
			complainTypeService.updateByNo(record);
		}
	}

}
