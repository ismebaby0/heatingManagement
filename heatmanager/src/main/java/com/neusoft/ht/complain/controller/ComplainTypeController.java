package com.neusoft.ht.complain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.complain.model.ComplainType;
import com.neusoft.ht.complain.service.IComplainTypeService;

@RestController
@RequestMapping("/complaintype")
public class ComplainTypeController {
	@Autowired
	IComplainTypeService complainTypeService = null;

	@RequestMapping("/get")
	public ComplainType getComplainType(Integer no) throws Exception {
		return complainTypeService.getByNo(no);
	}
	
	@RequestMapping("list")
	List<ComplainType> getAllComplainType() throws Exception {
		return complainTypeService.getByAll();
	}

}
