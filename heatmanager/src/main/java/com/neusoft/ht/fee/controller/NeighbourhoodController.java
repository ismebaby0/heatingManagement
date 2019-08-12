package com.neusoft.ht.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.Neighbourhood;
import com.neusoft.ht.fee.service.INeighbourhoodService;


/**
 *@Filefile	:HouseTypeController.java
 *@author 	:劳泽昌
 *@Date		:2019年8月9日
 *
 *
 */

@RestController
@RequestMapping("/Neighbood")
public class NeighbourhoodController {
	
	@Autowired
	private INeighbourhoodService service= null;
	
	@RequestMapping("/add")
	public void add(Neighbourhood nbh) throws Exception {
		service.add(nbh);
	}
	@RequestMapping("/delete")
	public void delete(int nbh)	throws Exception{
		service.delete(nbh);
	}
	@RequestMapping("/update")
	public void update(Neighbourhood nbh) throws Exception{
		service.update(nbh);
	}
	@RequestMapping("selectByNo")
	public Neighbourhood selectByNo(int hoodNo) throws Exception {
		return service.selectByNo(hoodNo);
	}
	
	@RequestMapping("/list")
	public List<Neighbourhood> selectByAll() throws Exception{
		return service.selectByAll();
	}
}
