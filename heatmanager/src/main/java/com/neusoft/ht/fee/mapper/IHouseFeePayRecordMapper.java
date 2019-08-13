package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.ht.fee.model.HouseFeePayRecord;
import com.neusoft.ht.fee.model.HtHeatingPriceModel;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月13日 上午9:31:38
 */
@Mapper
public interface IHouseFeePayRecordMapper {
	// 增加
	public void insert(HouseFeePayRecord record);

	// 删除
	public void deleteByPrimaryKey(int recordNo);

	// 修改
	public void updateByPrimaryKey(HouseFeePayRecord record);

	// 查看一条记录
	public HouseFeePayRecord selectByPrimaryKey(int recordNo);

	// 查看所有记录
	public List<HouseFeePayRecord> selectByAll();

}
