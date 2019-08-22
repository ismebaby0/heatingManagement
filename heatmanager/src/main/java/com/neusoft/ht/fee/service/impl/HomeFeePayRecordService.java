package com.neusoft.ht.fee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.ht.fee.mapper.IHomeFeePayRecordMapper;
import com.neusoft.ht.fee.model.HomeFeePayRecord;
import com.neusoft.ht.fee.service.IHomeFeePayRecordService;
/**
 *  住宅供热缴费记录 业务实现
 * 作者: 方俊坤
 */
@Service
@Transactional(rollbackFor = { Exception.class, Error.class })
public class HomeFeePayRecordService implements IHomeFeePayRecordService{
	@Autowired
	IHomeFeePayRecordMapper payRecord;

	@Override
	@Transactional(readOnly = true)
	public HomeFeePayRecord getByPrimaryKey(int record) throws Exception {
		return payRecord.selectByPrimaryKey(record);
	}

	@Override
	@Transactional(readOnly = true)
	public List<HomeFeePayRecord> getByAll() throws Exception {
		return payRecord.selectByAll();
	}

	@Override
	public void addRecord(HomeFeePayRecord record) throws Exception {
		payRecord.insert(record);
	}

	@Override
	public void deleteByPrimaryKey(int no) throws Exception {
		payRecord.deleteByPrimaryKey(no);
	}

	@Override
	public void updateRecord(HomeFeePayRecord record) throws Exception {
		payRecord.updateByPrimaryKey(record);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountAll() throws Exception {
		return payRecord.selectTotalCount();
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountPage(int rows) throws Exception {
		int pageCount=0;
		int count=payRecord.selectTotalCount();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=(count/rows)+1;
		}
		return pageCount;
	}

	@Override
	@Transactional(readOnly = true)
	public List<HomeFeePayRecord> getAllWithPages(int row, int page) throws Exception {
		return payRecord.selectAllWithPages(row * (page - 1),row);
	}

	@Override
	@Transactional(readOnly = true)
	public List<HomeFeePayRecord> getAllWithRelation(int row, int page) throws Exception {
		return payRecord.selectAllWithRelation(row * (page - 1), row);
	}

}
