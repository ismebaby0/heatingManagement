package com.neusoft.ht.fee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HtHeatingPriceModel;
import com.neusoft.ht.fee.service.IHeatingPriceService;
import com.neusoft.ht.message.ResultMessage;

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
	
	@RequestMapping("/getByNo")
	public ResultMessage<HtHeatingPriceModel> selectByHeatingYear(String heatingYear) throws Exception {
		ResultMessage<HtHeatingPriceModel> result = new ResultMessage<>("ok","查询成功");
		result.setModel(hp_service.selectByHeatingYear(heatingYear));
		return result;
	}

	@RequestMapping("/getAll")
	public ResultMessage<HtHeatingPriceModel> selectAllHeatingPrice() throws Exception {
		ResultMessage<HtHeatingPriceModel> result = new ResultMessage<>();
		result.setList(hp_service.selectAllHeatingPrice());
		return result;
	}

	@RequestMapping("/add")
	public ResultMessage<HtHeatingPriceModel> addHeatingPrice(HtHeatingPriceModel record) throws Exception {
		System.out.println(record);
		if(record.getHeatingYear().trim().length() > 0) {
			hp_service.addHeatingPrice(record);
			return new ResultMessage<>("ok","添加修改成功");
		}else {
			return new ResultMessage<>("fail", "失败");
		}
	}

	@RequestMapping("/delete")
	public ResultMessage<HtHeatingPriceModel> deleteHeatingPrice(String heatingYear) throws Exception {
		hp_service.deleteHeatingPrice(heatingYear);
		return new ResultMessage<>("ok","删除成功");
	}

	@RequestMapping("/modify")
	public ResultMessage<HtHeatingPriceModel> updateHeatingPrice(HtHeatingPriceModel record) throws Exception {
		if(record.getHeatingYear().trim().length() > 0) {
			hp_service.updateHeatingPrice(record);
			return new ResultMessage<>("ok","修改成功");
		}else {
			return new ResultMessage<>("fail", "失败");
		}
	}
	
	@RequestMapping("/getall/page")
	public ResultMessage<HtHeatingPriceModel> getAllWithPage(@RequestParam(required = false,defaultValue ="3") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<HtHeatingPriceModel> result = new ResultMessage<>("ok","添加成功");
		result.setList(hp_service.selectAllWithPage(rows, page));
		result.setCount(hp_service.getCountAll());
		result.setPage(page);
		result.setRows(rows);
		result.setPageCount(hp_service.getCountPage(rows));
		return result;
	}
}
