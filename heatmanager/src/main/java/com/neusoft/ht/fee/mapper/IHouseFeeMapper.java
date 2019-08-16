package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.ht.fee.model.HouseFeeModel;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月16日 上午11:10:53
 */
@Mapper
public interface IHouseFeeMapper {
	// 增加
	public void insert(HouseFeeModel record);

	// 删除
	public void deleteByPrimaryKey(int recordNo);

	// 修改
	public void updateByPrimaryKey(HouseFeeModel record);

	// 查看一条记录
	public HouseFeeModel selectByPrimaryKey(int recordNo);

	// 查看所有记录
	public List<HouseFeeModel> selectByAll();
	
	//查询户型表的个数
	public int getCountByAll() throws Exception;
	//分页查询
	public List<HouseFeeModel> selectAllWithPage(@Param("start") int star,@Param("end") int end) throws Exception;

}
