package com.neusoft.ht.fee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.fee.mapper.HomeMapper;
import com.neusoft.ht.fee.model.Home;

@Service
public class HomeService {
	
	
	@Autowired
	private HomeMapper home;
	public List<Home> findAll(){
		
		return home.selectAll();
	}
}
