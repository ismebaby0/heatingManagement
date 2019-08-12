package com.neusoft.ht.complain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.ht.complain.model.HomeComplainModel;

/**
 * 居民投诉信息Mapper 作者: 方俊坤
 */
@Mapper
public interface IHomeComplainModelMapper {
	int deleteByPrimaryKey(Integer complainNo);

	int insert(HomeComplainModel record);

	int insertSelective(HomeComplainModel record);

	HomeComplainModel selectByPrimaryKey(Integer complainNo);

	List<HomeComplainModel> selectByAll();

	int updateByPrimaryKeySelective(HomeComplainModel record);

	int updateByPrimaryKey(HomeComplainModel record);
}