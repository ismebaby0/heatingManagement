package com.neusoft.ht.fee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.fee.mapper.IHouseFeeMapper;
import com.neusoft.ht.fee.model.HouseFeeModel;
import com.neusoft.ht.fee.service.IHouseFeeService;

@Service
public class HouseFeeServiceImpl implements IHouseFeeService {

	@Autowired
	private IHouseFeeMapper mapper = null;

	@Override
	public HouseFeeModel selectByNo(int feeNo) throws Exception {
		return mapper.selectByPrimaryKey(feeNo);
	}

	@Override
	public List<HouseFeeModel> selectAll() throws Exception {
		return mapper.selectByAll();
	}

	@Override
	public void add(HouseFeeModel record) throws Exception {
		mapper.insert(record);
	}

	@Override
	public void delete(int feeNo) throws Exception {
		mapper.deleteByPrimaryKey(feeNo);
	}

	@Override
	public void update(HouseFeeModel record) throws Exception {
		mapper.updateByPrimaryKey(record);
	}

	// 查询全部户型个数
	@Override
	public int getCountAll() throws Exception {
		return mapper.getCountByAll();
	}

	@Override
	public int getCountPage(int rows) throws Exception {
		int pageCount = 0;
		int count = this.getCountAll();
		if (count % rows == 0) {
			pageCount = count / rows;
		} else {
			pageCount = count / rows + 1;
		}
		return pageCount;
	}

	// 分页查寻
	@Override
	public List<HouseFeeModel> selectAllWithPage(int row, int page) throws Exception {
		return mapper.selectAllWithPage(row * (page - 1), page * row);
	}

}
