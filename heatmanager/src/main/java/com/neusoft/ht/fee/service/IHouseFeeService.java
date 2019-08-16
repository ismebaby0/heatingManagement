package com.neusoft.ht.fee.service;

import java.util.List;

import com.neusoft.ht.fee.model.HouseFeeModel;

public interface IHouseFeeService {
	//查询一条
	public HouseFeeModel selectByNo(int feeNo) throws Exception;
	//查询所有
	public List<HouseFeeModel> selectAll() throws Exception;
	//增加一条
	public void add(HouseFeeModel record) throws Exception;
	//删除一条
	public void delete(int feeNo) throws Exception;
	//修改一条
	public void update(HouseFeeModel record) throws Exception;

	//全部个数
	public int getCountAll() throws Exception;
	
	//查询页数
	public int getCountPage(int rows) throws Exception;
	
	//分页查询
	public List<HouseFeeModel> selectAllWithPage(int row,int page) throws Exception;
}
