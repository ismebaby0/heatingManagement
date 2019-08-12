package com.neusoft.ht.fee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.fee.mapper.IHtHeatingPriceMapper;
import com.neusoft.ht.fee.model.HtHeatingPriceModel;
import com.neusoft.ht.fee.service.IHeatingPriceService;

@Service(value = "HeatingPriceService")
public class HeatingPriceServiceImpl implements IHeatingPriceService {
	@Autowired
	private IHtHeatingPriceMapper hhp_mapper;
	
	@Override
	public HtHeatingPriceModel selectByHeatingYear(String heatingYear) throws Exception {
		return hhp_mapper.selectByPrimaryKey(heatingYear);
	}

	@Override
	public List<HtHeatingPriceModel> selectAllHeatingPrice() throws Exception {
		return hhp_mapper.selectByAll();
	}

	@Override
	public void addHeatingPrice(HtHeatingPriceModel record) throws Exception {
		hhp_mapper.insert(record);
	}

	@Override
	public void deleteHeatingPrice(String heatingYear) throws Exception {
		hhp_mapper.deleteByPrimaryKey(heatingYear);
	}

	@Override
	public void updateHeatingPrice(HtHeatingPriceModel record) throws Exception {
		hhp_mapper.updateByPrimaryKey(record);
	}

}
