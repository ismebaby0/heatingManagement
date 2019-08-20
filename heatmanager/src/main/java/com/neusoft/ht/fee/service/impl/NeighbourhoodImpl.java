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


	@Override
	public int getCountAll() throws Exception {
		return mapper.getCountByAll();
	}


	@Override
	public int getCountPage(int rows) throws Exception {
		int pageCount = 0 ;
		int count = this.getCountAll();
		if(count%rows == 0) {
			pageCount = count/rows;
		}else {
			pageCount = count/rows+1;
		}
		return pageCount;
	}


	@Override
	public List<Neighbourhood> selectAllWithPage(int row, int page) throws Exception {
		List<Neighbourhood> list = mapper.selectAllWithPage(row*(page-1), page*row);
		return list;
	}

}
