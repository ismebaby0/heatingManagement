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

	// 查询全部户型个数
	@Override
	public int getCountAll() throws Exception {
		return hfpr_Mapper.getCountByAll();
	}

	@Override
	public int getCountPage(int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountAll();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public List<HouseFeePayRecord> selectAllWithPage(int row, int page) throws Exception {
		return hfpr_Mapper.selectAllWithPage(row*(page-1),page*row);
	}

}
