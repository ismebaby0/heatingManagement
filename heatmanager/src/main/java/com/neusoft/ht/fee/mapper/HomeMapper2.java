package com.neusoft.ht.fee.mapper;

import java.util.List;

import com.neusoft.ht.fee.model.Home;

public interface HomeMapper2 {
	List<Home> selectAll();
	void update(Home home);
	void delete(Home one);
	Home getOne(Integer homeNo);
	void insert(Home home);
}
