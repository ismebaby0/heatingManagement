package com.neusoft.ht.fee.service;

import java.util.List;


import com.neusoft.ht.fee.model.HomeModel;
import com.neusoft.ht.fee.model.Neighbourhood;

public interface IHomeService {
	public void add(HomeModel home) throws Exception;
	public void delete(int homeNo) throws Exception;
	public void update(HomeModel home) throws Exception;
	public HomeModel selectByNo(int homeNo) throws Exception;
	
	//关联查询一条数据
	public HomeModel getOneWithRelation(int homeNo) throws Exception;
	
	//全部个数
	public int getCountAll() throws Exception;
	
	//计算查询页数
	public int getCountPage(int rows) throws Exception;
	
	//分页查询
	public List<HomeModel> selectAllWithPage(int row,int page) throws Exception;
	
	
}
