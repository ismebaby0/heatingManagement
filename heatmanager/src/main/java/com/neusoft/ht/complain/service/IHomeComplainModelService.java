package com.neusoft.ht.complain.service;

import java.util.List;

import com.neusoft.ht.complain.model.HomeComplainModel;

/*
 * 居民投诉信息业务接口
 *  作者: 方俊坤
 */
public interface IHomeComplainModelService {

	void delete(Integer complainNo) throws Exception;

	void insert(HomeComplainModel record) throws Exception;

	void insertSelective(HomeComplainModel record) throws Exception;

	HomeComplainModel getByNo(Integer complainNo) throws Exception;

	List<HomeComplainModel> getByAll() throws Exception;

	void updateByNoSelective(HomeComplainModel record) throws Exception;

	void updateByNo(HomeComplainModel record) throws Exception;

}
