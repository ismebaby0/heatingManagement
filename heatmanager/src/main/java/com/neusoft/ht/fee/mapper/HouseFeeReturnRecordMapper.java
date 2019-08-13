package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.ht.fee.model.HouseFeeReturnRecord;
@Mapper
public interface HouseFeeReturnRecordMapper {
	// 增加
	public void insert(HouseFeeReturnRecord record);

	// 删除
	public void deleteByPrimaryKey(int recordNo);

	// 修改
	public void updateByPrimaryKey(HouseFeeReturnRecord record);

	// 查看一条记录
	public HouseFeeReturnRecord selectByPrimaryKey(int recordNo);

	// 查看所有记录
	public List<HouseFeeReturnRecord> selectByAll();
}
