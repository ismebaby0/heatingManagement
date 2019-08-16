package com.neusoft.ht.SystemSafety.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.SystemSafety.mapper.IFunctionMapper;
import com.neusoft.ht.SystemSafety.model.Function;
import com.neusoft.ht.SystemSafety.service.IFunctionService;

@Service("function")
public class FunctionService implements IFunctionService{
    
	@Autowired
	private IFunctionMapper fun=null;
	@Override
	public void create(Function func) throws Exception {
		// TODO Auto-generated method stub
		
		fun.create(func);
	}

	@Override
	public void modify(Function func) throws Exception {
		// TODO Auto-generated method stub
		fun.update(func);
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		fun.delete(id);
	}

	@Override
	public List<Function> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return fun.selectListWithAll();
	}

	@Override
	public Function getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Function> getListAllWithPages(String funName,int levelNo,int rows, int pages) throws Exception {
		// TODO Auto-generated method stub
		return fun.selectListWithPages(funName, levelNo, rows*(pages-1), rows);
	}

	@Override
	public int getTotalCount() throws Exception {
		// TODO Auto-generated method stub
		return fun.getTotalCount();
	}

	@Override
	public int getPageCount(int rows) throws Exception {
		// TODO Auto-generated method stub
		int pageCount=0;
		int count=fun.getTotalCount();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=(count/rows)+1;
		}
		return pageCount;
	}

}
