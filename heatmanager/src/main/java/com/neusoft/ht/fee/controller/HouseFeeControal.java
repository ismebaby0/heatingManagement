package com.neusoft.ht.fee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HouseFeeModel;
import com.neusoft.ht.fee.service.IHouseFeeService;
import com.neusoft.ht.message.ResultMessage;

@RequestMapping("/houseFee")
@RestController
public class HouseFeeControal {

	@Autowired
	private IHouseFeeService service = null;

	@RequestMapping("/getByOne")
	public ResultMessage<HouseFeeModel> selectByHeatingYear(int feeNo) throws Exception {
		ResultMessage<HouseFeeModel> result = new ResultMessage<>();
		result.setModel(service.selectByNo(feeNo));
		return result;
	}

	@RequestMapping("/getAll")
	public ResultMessage<HouseFeeModel> selectAllHeatingPrice() throws Exception {
		ResultMessage<HouseFeeModel> result = new ResultMessage<>();
		result.setList(service.selectAll());
		return result;
	}

	@RequestMapping("/add")
	public ResultMessage<HouseFeeModel> addHeatingPrice(HouseFeeModel record) throws Exception {
		System.out.println(record);
		if (record.getFeeNo() > 0) {
			return new ResultMessage<>("ok", "添加修改成功");
		} else {
			return new ResultMessage<>("fail", "失败");
		}
	}

	@RequestMapping("/delete")
	public ResultMessage<HouseFeeModel> deleteHeatingPrice(int feeNo) throws Exception {
		service.delete(feeNo);
		return new ResultMessage<>("ok", "删除成功");
	}

	@RequestMapping("/update")
	public ResultMessage<HouseFeeModel> updateHeatingPrice(HouseFeeModel record) throws Exception {
		if (record.getFeeNo() > 0) {
			service.update(record);
			return new ResultMessage<>("ok", "修改成功");
		} else {
			return new ResultMessage<>("fail", "失败");
		}
	}

	@RequestMapping("/getall/page")
	public ResultMessage<HouseFeeModel> getAllWithPage(@RequestParam(required = false, defaultValue = "3") int rows, @RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		ResultMessage<HouseFeeModel> result = new ResultMessage<>("ok", "添加成功");
		result.setList(service.selectAllWithPage(rows, page));
		result.setCount(service.getCountAll());
		result.setPage(page);
		result.setRows(rows);
		result.setPageCount(service.getCountPage(rows));
		return result;
	}
}
