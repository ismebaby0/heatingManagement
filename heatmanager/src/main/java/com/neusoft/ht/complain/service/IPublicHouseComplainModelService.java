package com.neusoft.ht.complain.service;

import java.util.List;

import com.neusoft.ht.complain.model.ComplainType;
import com.neusoft.ht.complain.model.PublicHouseComplainModel;

/*
 * 公建投诉信息业务接口
 *  作者: 方俊坤
 */
public interface IPublicHouseComplainModelService {

	void delete(Integer complainNo) throws Exception;

	void insert(PublicHouseComplainModel record) throws Exception;

	void insertSelective(PublicHouseComplainModel record) throws Exception;

	PublicHouseComplainModel getByNo(Integer complainNo) throws Exception;

	List<PublicHouseComplainModel> getByAll() throws Exception;

	// 取得列表带分页
	List<PublicHouseComplainModel> getListAllWithPages(int rows, int pages) throws Exception;

	// 取得数据个数
	int getTotalCount() throws Exception;

	int getPageCount(int rows) throws Exception;

	void updateByNoSelective(PublicHouseComplainModel record) throws Exception;

	void updateByNo(PublicHouseComplainModel record) throws Exception;

}
