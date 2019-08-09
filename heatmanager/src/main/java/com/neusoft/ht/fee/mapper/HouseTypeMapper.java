package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.ht.fee.model.HouseType;

/*
 *	 户型表
 */
@Mapper
public interface HouseTypeMapper {
	//添加户型表
	public void addHouseType(HouseType ht) ;
	//删除户型表
	public void deleteHouseType(int ht);
	//修改户型表
	public void updateHouseType(HouseType ht);
	//查询全部户型表
	public List<HouseType>selectAllHouseType();
	//根据查询
	public HouseType selectByNo(int typeNo);
}
