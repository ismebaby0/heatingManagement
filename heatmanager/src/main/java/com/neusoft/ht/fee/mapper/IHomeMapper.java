package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.ht.fee.model.HomeModel;
import com.neusoft.ht.fee.model.Neighbourhood;

@Mapper
public interface IHomeMapper {
	// 增加
	public void insert(HomeModel home) throws Exception;

	// 删除
	public void deleteByPrimaryKey(int homeNo) throws Exception;

	// 修改
	public void updateByPrimaryKey(HomeModel home) throws Exception;

	// 查看一条记录
	public HomeModel selectByPrimaryKey(int homeNo) throws Exception;

	// 查看所有记录
	public List <HomeModel> selectByAll() throws Exception;
	
	//查询小区表数据的个数
	public int getCountByAll() throws Exception;
	
	//分页查询
	public List<HomeModel> selectAllWithPage(@Param("start") int star,@Param("end") int end) throws Exception;

}
