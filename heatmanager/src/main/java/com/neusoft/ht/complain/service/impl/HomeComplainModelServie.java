package com.neusoft.ht.complain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.ht.complain.mapper.IHomeComplainModelMapper;
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
	private IHomeComplainModelMapper hcmm;
	@Override
	public void delete(Integer complainNo) throws Exception {
		hcmm.deleteByPrimaryKey(complainNo);
	}

	@Override
	public void insert(HomeComplainModel record) throws Exception {
		hcmm.insert(record);
	}

	@Override
	public void insertSelective(HomeComplainModel record) throws Exception {
		hcmm.insertSelective(record);
	}

	@Transactional(readOnly = true)
	@Override
	public HomeComplainModel getByNo(Integer complainNo) throws Exception {
		return hcmm.selectByPrimaryKey(complainNo);
	}

	@Transactional(readOnly = true)
	@Override
	public List<HomeComplainModel> getByAll() throws Exception {
		return hcmm.selectByAll();
	}

	@Override
	public void updateByNoSelective(HomeComplainModel record) throws Exception {
		hcmm.updateByPrimaryKey(record);
	}

	@Override
	public void updateByNo(HomeComplainModel record) throws Exception {
		hcmm.updateByPrimaryKeySelective(record);
	}

}
