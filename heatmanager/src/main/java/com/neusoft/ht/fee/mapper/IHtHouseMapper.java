package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.ht.fee.model.HtHouseModel;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月12日 上午10:57:23
 */
@Mapper
public interface IHtHouseMapper {
	// 增加
	public void insert(HtHouseModel record);
	// 删除
	public void deleteByPrimaryKey(int houseNo);
	// 修改
	public void updateByPrimaryKey(HtHouseModel record);
	// 查看一条记录
	public HtHouseModel selectByPrimaryKey(int houseNo);
	//查看所有记录
	public List<HtHouseModel> selectByAll();
	
	//查询公建的个数
	public int getCountByAll() throws Exception;
	//分页查询
	public List<HtHouseModel> selectAllWithPage(@Param("start") int star,@Param("end") int end) throws Exception;
}
