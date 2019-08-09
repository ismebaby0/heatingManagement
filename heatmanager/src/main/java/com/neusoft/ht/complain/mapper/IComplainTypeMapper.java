package com.neusoft.ht.complain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.ht.complain.model.ComplainType;

/* 
 * 投诉类型 ComplainTypeMapper 
 *   作者: 方俊坤
 */
@Mapper
public interface IComplainTypeMapper {
	int deleteByPrimaryKey(Integer typeNo);

	int insert(ComplainType record);

	int insertSelective(ComplainType record);

	ComplainType selectByPrimaryKey(Integer typeNo);

	List<ComplainType> selectByAll();

	int updateByPrimaryKeySelective(ComplainType record);

	int updateByPrimaryKey(ComplainType record);
	
	
}