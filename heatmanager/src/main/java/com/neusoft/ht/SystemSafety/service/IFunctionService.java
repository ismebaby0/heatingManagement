package com.neusoft.ht.SystemSafety.service;

import java.util.List;

import com.neusoft.ht.SystemSafety.model.Function;


public interface IFunctionService {
	public void create(Function func) throws Exception;
	 
	 public void modify(Function func) throws Exception;
	 
	 public void delete(int id) throws Exception;
	 
	 public List<Function> getListByAll() throws Exception;
	 
	 public Function getById(int id) throws Exception;
	 
	 //取得列表带分页
	 public List<Function> getListAllWithPages(String funName,int levelNo,int rows,int pages)throws Exception;
	 //取得数据个数
	 public int getTotalCount() throws Exception;
	 //取得页数
	 public int getPageCount(int rows) throws Exception;
}
