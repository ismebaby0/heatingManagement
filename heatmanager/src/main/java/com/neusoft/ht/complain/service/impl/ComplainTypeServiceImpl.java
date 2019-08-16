package com.neusoft.ht.complain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.ht.complain.mapper.IComplainTypeMapper;
import com.neusoft.ht.complain.model.ComplainType;
import com.neusoft.ht.complain.service.IComplainTypeService;

/*
 * 投诉类型业务实现类
 *   作者: 方俊坤
 */
@Service
@Transactional(rollbackFor = { Exception.class, Error.class })
public class ComplainTypeServiceImpl implements IComplainTypeService {
	@Autowired
	private IComplainTypeMapper complainType = null;

	@Override
	public void delete(Integer typeNo) throws Exception {
		complainType.deleteByPrimaryKey(typeNo);
	}

	@Override
	public void insert(ComplainType record) throws Exception {
		complainType.insert(record);
	}

	@Override
	public void insertSelective(ComplainType record) throws Exception {
		complainType.insertSelective(record);
	}

	@Transactional(readOnly = true)
	@Override
	public ComplainType getByNo(Integer typeNo) throws Exception {
		return complainType.selectByPrimaryKey(typeNo);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ComplainType> getByAll() throws Exception {
		return complainType.selectByAll();
	}

	@Override
	public void updateByNoSelective(ComplainType record) throws Exception {
		complainType.updateByPrimaryKeySelective(record);
	}

	@Override
	public void updateByNo(ComplainType record) throws Exception {
		complainType.updateByPrimaryKey(record);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ComplainType> getListAllWithPages(int rows, int pages) throws Exception {
		return complainType.selectListAllWithPages(rows * (pages - 1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getTotalCount() throws Exception {
		return complainType.selectTotalCount();
	}
	
	@Override
	@Transactional(readOnly = true)
	public int getPageCount(int rows) throws Exception {
		int pageCount=0;
		int count=complainType.selectTotalCount();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=(count/rows)+1;
		}
		return pageCount;
	}


}
