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

	ComplainType getByNo(Integer typeNo) throws Exception;

	List<ComplainType> getByAll() throws Exception;

	// 取得列表带分页
	List<ComplainType> getListAllWithPages(int rows, int pages) throws Exception;
	//取得数据个数
	int getTotalCount() throws Exception;

	void updateByNoSelective(ComplainType record) throws Exception;

	void updateByNo(ComplainType record) throws Exception;

	int getPageCount(int rows) throws Exception;

}
