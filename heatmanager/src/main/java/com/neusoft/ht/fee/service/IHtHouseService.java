package com.neusoft.ht.fee.service;

import java.util.List;

import com.neusoft.ht.fee.model.HtHouseModel;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月12日
 */
public interface IHtHouseService {
	//查询一条
	public HtHouseModel selectByNo(int houseNo) throws Exception;
	//查询所有
	public List<HtHouseModel> selectAllHtHouse() throws Exception;
	//增加一条
	public void addHtHouse(HtHouseModel record) throws Exception;
	//删除一条
	public void deleteHouseModel(int houseNo) throws Exception;
	//修改一条
	public void updateHouseModel(HtHouseModel record) throws Exception;
}
