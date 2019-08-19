package com.neusoft.ht.complain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.ht.complain.model.PublicHouseComplainModel;

/**
 * 公建投诉信息Mapper
 *  作者: 方俊坤
 */
@Mapper
public interface IPublicHouseComplainModelMapper {
	int deleteByPrimaryKey(Integer complainNo);

	int insert(PublicHouseComplainModel record);

	int insertSelective(PublicHouseComplainModel record);

	PublicHouseComplainModel selectByPrimaryKey(Integer complainNo);

	List<PublicHouseComplainModel> selectByAll();

    List<PublicHouseComplainModel> selectListAllWithPages(@Param("start") int start,@Param("rows") int rows) throws Exception;
    
    //取得所有数据的个数
    int selectTotalCount() throws Exception;
    
	int updateByPrimaryKeySelective(PublicHouseComplainModel record);

	int updateByPrimaryKey(PublicHouseComplainModel record);
}