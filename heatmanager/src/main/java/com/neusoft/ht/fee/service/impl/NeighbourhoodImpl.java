package com.neusoft.ht.fee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.ht.fee.mapper.INeighbourhoodMapper;
import com.neusoft.ht.fee.model.Neighbourhood;
import com.neusoft.ht.fee.service.INeighbourhoodService;

@Service
public class NeighbourhoodImpl  implements INeighbourhoodService {
	
	@Autowired
	private INeighbourhoodMapper mapper;
	

	@Override
	public List<Neighbourhood> selectByAll() throws Exception {
		return mapper.selectByAll();
	}


	@Override
	public void add(Neighbourhood nbh) throws Exception {
		mapper.insert(nbh);
	}


	@Override
	public void delete(int hoodNo) throws Exception {

		mapper.deleteByPrimaryKey(hoodNo);
	}


	@Override
	public void update(Neighbourhood nbh) throws Exception {

			mapper.updateByPrimaryKey(nbh);
	}


	@Override
	public Neighbourhood selectByNo(int hoodNo) throws Exception {
		return mapper.selectByPrimaryKey(hoodNo);
	}

}
