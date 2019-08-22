package com.neusoft.ht.fee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.fee.mapper.IPaymentTypeMapper;
import com.neusoft.ht.fee.model.PaymentType;
import com.neusoft.ht.fee.service.IPaymentTypeService;

@Service
public class PaymentTypeServiceImpl implements IPaymentTypeService {
	
	@Autowired
	IPaymentTypeMapper mapper = null;
	@Override
	public void add(PaymentType pay) throws Exception {
		mapper.insert(pay);
		
	}

	@Override
	public void delete(int typeNo) throws Exception {
		mapper.deleteByPrimaryKey(typeNo);
	}

	@Override
	public void update(PaymentType pay) throws Exception {
		mapper.updateByPrimaryKey(pay);
	}

	@Override
	public PaymentType selectByNo(int typeNo) throws Exception {
		return mapper.selectByPrimaryKey(typeNo);
	}

	@Override
	public List<PaymentType> selectByAll() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectByAll();
	}

	@Override
	public int getCountAll() throws Exception {
		return mapper.getCountByAll();
	}

	@Override
	public int getCountPage(int rows) throws Exception {
		int pageCount = 0;
		int countAll = mapper.getCountByAll();
		if(countAll%rows==0) {
			pageCount = countAll/rows;
		}else {
			pageCount = countAll/rows + 1;
		}
		return pageCount;
	}

	@Override
	public List<PaymentType> selectAllWithPage(int row, int page) throws Exception {
		List<PaymentType> list = mapper.selectAllWithPage(row*(page-1), page*row);
		return list;
	}

}
