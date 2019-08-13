package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.ht.fee.model.HouseType;

/*
 *	 户型表
 */
@Mapper
public interface IHouseTypeMapper {
	//添加户型表
	public void addHouseType(HouseType ht) throws Exception;
	//删除户型表
	public void deleteHouseType(int ht) throws Exception;
	//修改户型表
	public void updateHouseType(HouseType ht) throws Exception;
	//查询全部户型表
	public List<HouseType>selectAllHouseType() throws Exception;
	//根据查询
	public HouseType selectByNo(int typeNo) throws Exception;
	//查询户型表的个数
	public int getCountByAll() throws Exception;
	//分页查询
	public List<HouseType> selectAllWithPage(@Param("start") int star,@Param("end") int end) throws Exception;
}
