package com.neusoft.ht.complain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.ht.complain.mapper.IPublicHouseComplainModelMapper;
import com.neusoft.ht.complain.model.PublicHouseComplainModel;
import com.neusoft.ht.complain.service.IPublicHouseComplainModelService;

/**
 * 公建投诉信息业务接口实现
 *  作者: 方俊坤
 */
@Service
@Transactional(rollbackFor = { Exception.class, Error.class })
public class PublicHouseComplainModelServiceImpl implements IPublicHouseComplainModelService {

	@Autowired
	private IPublicHouseComplainModelMapper publicHouseMapper;
	@Override
	public void delete(Integer complainNo) throws Exception {
		publicHouseMapper.deleteByPrimaryKey(complainNo);
	}

	@Override
	public void insert(PublicHouseComplainModel record) throws Exception {
		publicHouseMapper.insert(record);
	}

	@Override
	public void insertSelective(PublicHouseComplainModel record) throws Exception {
		publicHouseMapper.insertSelective(record);
	}

	@Transactional(readOnly = true)
	@Override
	public PublicHouseComplainModel getByNo(Integer complainNo) throws Exception {
		return publicHouseMapper.selectByPrimaryKey(complainNo);
	}

	@Transactional(readOnly = true)
	@Override
	public List<PublicHouseComplainModel> getByAll() throws Exception {
		return publicHouseMapper.selectByAll();
	}

	@Override
	public void updateByNoSelective(PublicHouseComplainModel record) throws Exception {
		publicHouseMapper.updateByPrimaryKey(record);
	}

	@Override
	public void updateByNo(PublicHouseComplainModel record) throws Exception {
		publicHouseMapper.updateByPrimaryKeySelective(record);
	}


	@Transactional(readOnly = true)
	@Override
	public List<PublicHouseComplainModel> getListAllWithPages(int rows, int pages) throws Exception {
		return publicHouseMapper.selectListAllWithPages(rows * (pages - 1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getTotalCount() throws Exception {
		return publicHouseMapper.selectTotalCount();
	}
	
	@Override
	@Transactional(readOnly = true)
	public int getPageCount(int rows) throws Exception {
		int pageCount=0;
		int count=publicHouseMapper.selectTotalCount();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=(count/rows)+1;
		}
		return pageCount;
	}
}
