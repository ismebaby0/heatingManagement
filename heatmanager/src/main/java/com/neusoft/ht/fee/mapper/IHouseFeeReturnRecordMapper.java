package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.ht.fee.model.HouseFeeReturnRecord;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月14日 上午8:42:24
 */
@Mapper
public interface IHouseFeeReturnRecordMapper {
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
