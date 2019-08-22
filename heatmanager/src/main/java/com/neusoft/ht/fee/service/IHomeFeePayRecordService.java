package com.neusoft.ht.fee.service;

import java.util.List;

import com.neusoft.ht.fee.model.HomeFeePayRecord;

public interface IHomeFeePayRecordService {
	//查询一条
	public HomeFeePayRecord getByPrimaryKey(int record) throws Exception;
	//查询所有
	public List<HomeFeePayRecord> getByAll() throws Exception;
	//增加一条
	public void addRecord(HomeFeePayRecord record) throws Exception;
	//删除一条
	public void deleteByPrimaryKey(int payRecord) throws Exception;
	//修改一条
	public void updateRecord(HomeFeePayRecord record) throws Exception;

	//全部个数
	public int getCountAll() throws Exception;
	
	//查询页数
	public int getCountPage(int rows) throws Exception;
	
	//分页查询
	public List<HomeFeePayRecord> getAllWithPages(int row,int page) throws Exception;

	//关联分页查询
	public List<HomeFeePayRecord> getAllWithRelation(int row,int page) throws Exception;
	

}
