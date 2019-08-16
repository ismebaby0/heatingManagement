package com.neusoft.ht.fee.mapper;

import java.util.List;

import com.neusoft.ht.fee.model.HomeStopRecordModel;
import com.neusoft.ht.fee.model.HouseFeePayRecord;

public interface IHomeStopRecordMapper {
		
		// 增加
		public void insert(HomeStopRecordModel homeStopRecordModel);

		// 删除
		public void deleteByPrimaryKey(int recordNo);

		// 修改
		public void updateByPrimaryKey(HomeStopRecordModel homeStopRecordModel);

		// 查看一条记录
		public HouseFeePayRecord selectByPrimaryKey(int recordNo);

		// 查看所有记录
		public List<HouseFeePayRecord> selectByAll();
}
