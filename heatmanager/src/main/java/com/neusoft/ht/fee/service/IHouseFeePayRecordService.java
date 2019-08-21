package com.neusoft.ht.fee.service;

import java.util.List;

import com.neusoft.ht.fee.model.HouseFeePayRecord;
import com.neusoft.ht.fee.model.HouseType;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月13日 上午10:09:51
 */
public interface IHouseFeePayRecordService {
	
	//查询一条
	public HouseFeePayRecord selectByNo(int recordNo) throws Exception;
	//查询所有
	public List<HouseFeePayRecord> selectAllHtHouse() throws Exception;
	//增加一条
	public void addHouseFeePayRecord(HouseFeePayRecord record) throws Exception;
	//删除一条
	public void deleteHouseFeePayRecord(int recordNo) throws Exception;
	//修改一条
	public void updateHouseFeePayRecord(HouseFeePayRecord record) throws Exception;
	
	
	//全部付费个数
	public int getCountAll() throws Exception;
	
	//查询页数
	public int getCountPage(int rows) throws Exception;
	
	//分页查询
	public List<HouseFeePayRecord> selectAllWithPage(int row,int page) throws Exception;
}
