package com.neusoft.ht.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.mapper.IHtHeatingPriceMapper;
import com.neusoft.ht.fee.model.HtHeatingPriceModel;
import com.neusoft.ht.fee.service.IHeatingPriceService;

/**
 * 
 * @Description: 
 * @author 林康荣  
 * @date 2019年8月11日
 */
@RequestMapping("/heatingPrice")
@RestController
public class HtHeatingPriceControal {
	@Autowired
	private IHeatingPriceService hp_service = null;
	
	@RequestMapping("/selectByOne")
	public HtHeatingPriceModel selectByHeatingYear(String heatingYear) throws Exception {
		return hp_service.selectByHeatingYear(heatingYear);
	}

	@RequestMapping("/selectAll")
	public List<HtHeatingPriceModel> selectAllHeatingPrice() throws Exception {
		return hp_service.selectAllHeatingPrice();
	}

	@RequestMapping("/addOne")
	public void addHeatingPrice(HtHeatingPriceModel record) throws Exception {
		 hp_service.addHeatingPrice(record);
	}

	@RequestMapping("/deleteOne")
	public void deleteHeatingPrice(String heatingYear) throws Exception {
		hp_service.deleteHeatingPrice(heatingYear);
	}

	@RequestMapping("/updateOne")
	public void updateHeatingPrice(HtHeatingPriceModel record) throws Exception {
		hp_service.updateHeatingPrice(record);
	}
}
