package com.neusoft.ht.fee.service;

import java.util.List;


import com.neusoft.ht.fee.model.HomeModel;

public interface IHomeService {
	public void add(HomeModel home) throws Exception;
	public void delete(int homeNo) throws Exception;
	public void update(HomeModel home) throws Exception;
	public HomeModel selectByNo(int homeNo) throws Exception;
	public List<HomeModel> selectAll() throws Exception;
	
}
