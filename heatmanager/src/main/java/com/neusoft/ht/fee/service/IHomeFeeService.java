package com.neusoft.ht.fee.service;

import java.util.List;

import com.neusoft.ht.fee.model.HomeFee;

public interface IHomeFeeService {
	public void add(HomeFee homeFee) throws Exception;
	public void delete(Integer feeNo) throws Exception;
	public void update(HomeFee homeFee) throws Exception;
	public HomeFee selectByNo(int feeNo) throws Exception;


}
