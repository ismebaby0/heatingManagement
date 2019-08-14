package com.neusoft.ht.fee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.fee.mapper.IHouseFeeReturnRecordMapper;
import com.neusoft.ht.fee.model.HouseFeeReturnRecord;
import com.neusoft.ht.fee.service.IHouseFeeReturnRecordService;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月13日 下午2:36:00
 */
@Service
public class HouseFeeReturnRecordServiceImpl implements IHouseFeeReturnRecordService {

	@Autowired
	IHouseFeeReturnRecordMapper hfrr_mapper;

	@Override
	public HouseFeeReturnRecord selectByNo(int recordNo) throws Exception {
		return hfrr_mapper.selectByPrimaryKey(recordNo);
	}

	@Override
	public List<HouseFeeReturnRecord> selectAll() throws Exception {
		return hfrr_mapper.selectByAll();
	}

	@Override
	public void addHouseFeeReturnRecord(HouseFeeReturnRecord record) throws Exception {
		hfrr_mapper.insert(record);
	}

	@Override
	public void deleteHouseFeeReturnRecord(int recordNo) throws Exception {
		hfrr_mapper.deleteByPrimaryKey(recordNo);
	}

	@Override
	public void updateHouseFeeReturnRecord(HouseFeeReturnRecord record) throws Exception {
		hfrr_mapper.updateByPrimaryKey(record);
	}

}
