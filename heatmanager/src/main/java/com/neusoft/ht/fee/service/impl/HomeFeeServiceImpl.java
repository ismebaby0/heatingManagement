package com.neusoft.ht.fee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.fee.mapper.IHomeFeeMapper;
import com.neusoft.ht.fee.model.HomeFee;
import com.neusoft.ht.fee.service.IHomeFeeService;

@Service
public class HomeFeeServiceImpl implements IHomeFeeService {
	@Autowired
	private IHomeFeeMapper mapper = null;

	@Override
	public void add(HomeFee homeFee) throws Exception {
		// TODO Auto-generated method stub
		mapper.insertHomeFee(homeFee);
		
	}

	@Override
	public void delete(Integer feeNo) throws Exception {
		// TODO Auto-generated method stub
		mapper.deleteByFeeNo(feeNo);
	}

	@Override
	public void update(HomeFee homeFee) throws Exception {
		// TODO Auto-generated method stub
		mapper.updateByFeeNo(homeFee);
	}

	@Override
	public HomeFee selectByNo(int feeNo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectByFeeNo(feeNo);
	}


}
