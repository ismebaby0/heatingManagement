package com.neusoft.ht.fee.service;

import java.util.List;

import com.neusoft.ht.fee.model.HouseType;
import com.neusoft.ht.fee.model.Neighbourhood;

public interface INeighbourhoodService {
	public void add(Neighbourhood nbh) throws Exception;
	public void delete(int hoodNo) throws Exception;
	public void update(Neighbourhood nbh) throws Exception;
	public Neighbourhood selectByNo(int hoodNo) throws Exception;
	public List<Neighbourhood> selectByAll() throws Exception;
	
	//全部小区个数
	public int getCountAll() throws Exception;
	
	//计算查询页数
	public int getCountPage(int rows) throws Exception;
	
	//分页查询
	public List<Neighbourhood> selectAllWithPage(int row,int page) throws Exception;
}
