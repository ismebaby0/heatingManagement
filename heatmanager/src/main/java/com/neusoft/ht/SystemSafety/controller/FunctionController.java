package com.neusoft.ht.SystemSafety.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.SystemSafety.model.Function;
import com.neusoft.ht.SystemSafety.service.IFunctionService;
import com.neusoft.ht.login.model.AdminUserValue;
import com.neusoft.ht.message.ResultMessage;

@RestController
@RequestMapping("/function")
public class FunctionController {
@Autowired
private IFunctionService func=null;
@RequestMapping("/list/page")
public ResultMessage<Function> getListWithPages(@RequestParam(required = false,defaultValue ="") String funName,@RequestParam(required = false,defaultValue ="0") int levelNo,@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page)throws Exception{
	ResultMessage<Function> result=new ResultMessage<Function>("OK","取得部门列表分页模式成功");
	result.setCount(func.getTotalCount());
	result.setPageCount(func.getPageCount(rows));
	result.setList(func.getListAllWithPages(funName, levelNo, rows, page));
	result.setPage(page);
	result.setRows(rows);
	
	return result;
}
}
