package com.neusoft.ht.fee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.fee.mapper.IHtHouseMapper;
import com.neusoft.ht.fee.model.HtHouseModel;
import com.neusoft.ht.fee.service.IHtHouseService;
/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月12日 下午2:54:36
 */
@Service
public class HtHouseServiceImpl implements IHtHouseService {
	@Autowired
	private IHtHouseMapper houseMapper;
	
	@Override
	public HtHouseModel selectByNo(int houseNo) throws Exception {
		return houseMapper.selectByPrimaryKey(houseNo);
	}

	@Override
	public List<HtHouseModel> selectAllHtHouse() throws Exception {
		return houseMapper.selectByAll();
	}

	@Override
	public void addHtHouse(HtHouseModel record) throws Exception {
		houseMapper.insert(record);
	}

	@Override
	public void deleteHouseModel(int houseNo) throws Exception {
		houseMapper.deleteByPrimaryKey(houseNo);
	}

	@Override
	public void updateHouseModel(HtHouseModel record) throws Exception {
		houseMapper.updateByPrimaryKey(record);
	}

}
