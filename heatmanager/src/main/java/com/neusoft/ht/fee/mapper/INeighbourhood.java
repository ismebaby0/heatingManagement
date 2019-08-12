/**
 * 
 */
package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.ht.fee.model.HtHeatingPriceModel;
import com.neusoft.ht.fee.model.Neighbourhood;

/**
 *@Filefile	:INeighbourhood.java
 *@author 	:劳泽昌
 *@Date		:2019年8月12日
 *
 *
 */

@Mapper
public interface INeighbourhood {
	// 增加
	public void insert(Neighbourhood neighbourgood) throws Exception;
	// 删除
	public void deleteByPrimaryKey(int hoodNo)  throws Exception;
	// 修改
	public void updateByPrimaryKey(Neighbourhood neighbourgood)  throws Exception;
	// 查看一条记录
	public HtHeatingPriceModel selectByPrimaryKey(int hoodNo)  throws Exception;
	//查看所有记录
	public List<HtHeatingPriceModel> selectByAll() throws Exception;
}
