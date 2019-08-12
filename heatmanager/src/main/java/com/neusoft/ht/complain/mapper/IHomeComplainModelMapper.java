package com.neusoft.ht.complain.mapper;

import com.neusoft.ht.complain.model.HomeComplainModel;

public interface IHomeComplainModelMapper {
    int deleteByPrimaryKey(Integer complainNo);

    int insert(HomeComplainModel record);

    int insertSelective(HomeComplainModel record);

    HomeComplainModel selectByPrimaryKey(Integer complainNo);

    int updateByPrimaryKeySelective(HomeComplainModel record);

    int updateByPrimaryKey(HomeComplainModel record);
}