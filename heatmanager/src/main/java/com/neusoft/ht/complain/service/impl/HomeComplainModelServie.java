package com.neusoft.ht.complain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.ht.complain.mapper.IHomeComplainModelMapper;
import com.neusoft.ht.complain.model.ComplainType;
import com.neusoft.ht.complain.model.HomeComplainModel;
import com.neusoft.ht.complain.service.IHomeComplainModelService;

/**
 * 居民投诉信息业务接口实现
 *  作者: 方俊坤
 */
@Service
@Transactional(rollbackFor = { Exception.class, Error.class })
public class HomeComplainModelServie implements IHomeComplainModelService {

	@Autowired
	private IHomeComplainModelMapper homeComplainModelMapper;
	@Override
	public void delete(Integer complainNo) throws Exception {
		homeComplainModelMapper.deleteByPrimaryKey(complainNo);
	}

	@Override
	public void insert(HomeComplainModel record) throws Exception {
		homeComplainModelMapper.insert(record);
	}

	@Override
	public void insertSelective(HomeComplainModel record) throws Exception {
		homeComplainModelMapper.insertSelective(record);
	}

	@Transactional(readOnly = true)
	@Override
	public HomeComplainModel getByNo(Integer complainNo) throws Exception {
		return homeComplainModelMapper.selectByPrimaryKey(complainNo);
	}

	@Transactional(readOnly = true)
	@Override
	public List<HomeComplainModel> getByAll() throws Exception {
		return homeComplainModelMapper.selectByAll();
	}

	@Override
	public void updateByNoSelective(HomeComplainModel record) throws Exception {
		homeComplainModelMapper.updateByPrimaryKey(record);
	}

	@Override
	public void updateByNo(HomeComplainModel record) throws Exception {
		homeComplainModelMapper.updateByPrimaryKeySelective(record);
	}


	@Transactional(readOnly = true)
	@Override
	public List<HomeComplainModel> getListAllWithPages(int rows, int pages) throws Exception {
		return homeComplainModelMapper.selectListAllWithPages(rows * (pages - 1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getTotalCount() throws Exception {
		return homeComplainModelMapper.selectTotalCount();
	}
	
	@Override
	@Transactional(readOnly = true)
	public int getPageCount(int rows) throws Exception {
		int pageCount=0;
		int count=homeComplainModelMapper.selectTotalCount();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=(count/rows)+1;
		}
		return pageCount;
	}
}
