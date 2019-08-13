package com.neusoft.ht.fee.service;

import java.util.List;

import com.neusoft.ht.fee.model.HouseFeeReturnRecord;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月13日 
 */
public interface IHouseFeeReturnRecordService {
	//查询一条
	public HouseFeeReturnRecord selectByNo(int recordNo) throws Exception;
	//查询所有
	public List<HouseFeeReturnRecord> selectAll() throws Exception;
	//增加一条
	public void addHouseFeeReturnRecord(HouseFeeReturnRecord record) throws Exception;
	//删除一条
	public void deleteHouseFeeReturnRecord(int recordNo) throws Exception;
	//修改一条
	public void updateHouseFeeReturnRecord(HouseFeeReturnRecord record) throws Exception;
}
