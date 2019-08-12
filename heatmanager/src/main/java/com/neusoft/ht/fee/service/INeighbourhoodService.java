package com.neusoft.ht.fee.service;

import java.util.List;

import com.neusoft.ht.fee.model.Neighbourhood;

public interface INeighbourhoodService {
	public void add(Neighbourhood nbh) throws Exception;
	public void delete(int hoodNo) throws Exception;
	public void update(Neighbourhood nbh) throws Exception;
	public Neighbourhood selectByNo(int hoodNo) throws Exception;
	public List<Neighbourhood> selectByAll() throws Exception;
	
}
