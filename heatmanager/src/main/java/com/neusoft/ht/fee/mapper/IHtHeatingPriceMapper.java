package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.ht.complain.model.ComplainType;
import com.neusoft.ht.fee.model.HouseType;
import com.neusoft.ht.fee.model.HtHeatingPriceModel;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月9日 上午11:21:27
 */
@Mapper
public interface IHtHeatingPriceMapper {
	// 增加
	public void insert(HtHeatingPriceModel record);

	// 删除
	public void deleteByPrimaryKey(String heatingYear);

	// 修改
	public void updateByPrimaryKey(HtHeatingPriceModel record);

	// 查看一条记录
	public HtHeatingPriceModel selectByPrimaryKey(String heatingYear);

	// 查看所有记录
	public List<HtHeatingPriceModel> selectByAll();

	//查询户型表的个数
	public int getCountByAll() throws Exception;
	//分页查询
	public List<HtHeatingPriceModel> selectAllWithPage(@Param("start") int star,@Param("end") int end) throws Exception;
}
