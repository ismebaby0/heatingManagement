package com.neusoft.ht.fee.service;

import java.util.List;

import com.neusoft.ht.fee.model.PaymentType;

public interface IPaymentTypeService {
	public void add(PaymentType pay) throws Exception;
	public void delete(int typeNo) throws Exception;
	public void update(PaymentType pay) throws Exception;
	public PaymentType selectByNo(int typeNo) throws Exception;
	public List<PaymentType> selectByAll() throws Exception;
	
	//全部小区个数
	public int getCountAll() throws Exception;
	
	//计算查询页数
	public int getCountPage(int rows) throws Exception;
	
	//分页查询
	public List<PaymentType> selectAllWithPage(int row,int page) throws Exception;
}
