package com.neusoft.ht.fee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.fee.mapper.IHouseFeePayRecordMapper;
import com.neusoft.ht.fee.model.HouseFeePayRecord;
import com.neusoft.ht.fee.service.IHouseFeePayRecordService;
/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月13日 
 */
@Service
public class HouseFeePayRecordServiceImpl implements IHouseFeePayRecordService {
	@Autowired
	IHouseFeePayRecordMapper hfpr_Mapper;
	
	@Override
	public HouseFeePayRecord selectByNo(int recordNo) throws Exception {
		return hfpr_Mapper.selectByPrimaryKey(recordNo);
	}

	@Override
	public List<HouseFeePayRecord> selectAllHtHouse() throws Exception {
		return hfpr_Mapper.selectByAll();
	}

	@Override
	public void addHouseFeePayRecord(HouseFeePayRecord record) throws Exception {
		hfpr_Mapper.insert(record);
	}

	@Override
	public void deleteHouseFeePayRecord(int recordNo) throws Exception {
		hfpr_Mapper.deleteByPrimaryKey(recordNo);
	}

	@Override
	public void updateHouseFeePayRecord(HouseFeePayRecord record) throws Exception {
		hfpr_Mapper.updateByPrimaryKey(record);
	}

}
