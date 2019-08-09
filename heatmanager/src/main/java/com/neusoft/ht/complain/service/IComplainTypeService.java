package com.neusoft.ht.complain.service;

import java.util.List;

import com.neusoft.ht.complain.model.ComplainType;

/*
 * 投诉类型业务接口
 *  作者: 方俊坤
 */
public interface IComplainTypeService {

	void delete(Integer typeNo) throws Exception;

	void insert(ComplainType record) throws Exception;

	void insertSelective(ComplainType record) throws Exception;

	ComplainType selectByNo(Integer typeNo) throws Exception;

	List<ComplainType> selectByAll() throws Exception;

	void updateByNoSelective(ComplainType record) throws Exception;

	void updateByNo(ComplainType record) throws Exception;

}
