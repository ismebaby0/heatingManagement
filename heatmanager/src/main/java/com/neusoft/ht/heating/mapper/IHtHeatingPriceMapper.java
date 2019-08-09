package com.neusoft.ht.heating.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.ht.complain.model.ComplainType;
import com.neusoft.ht.heating.model.HtHeatingPriceModel;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月9日 上午11:21:27
 */
@Mapper
public interface IHtHeatingPriceMapper {
	public void deleteByPrimaryKey(String heatingYear);

	public void insert(HtHeatingPriceModel record);

	public void insertSelective(HtHeatingPriceModel record);

	public HtHeatingPriceModel selectByPrimaryKey(String heatingYear);

	public List<HtHeatingPriceModel> selectByAll();

	public void updateByPrimaryKeySelective(HtHeatingPriceModel record);

	public void updateByPrimaryKey(HtHeatingPriceModel record);
}
