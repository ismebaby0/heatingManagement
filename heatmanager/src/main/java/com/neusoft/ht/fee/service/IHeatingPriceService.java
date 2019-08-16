package com.neusoft.ht.fee.service;

import java.util.List;

import com.neusoft.ht.fee.model.HtHeatingPriceModel;
/** 
 *
 * @Description: 
 * @author 林康荣  
 * @date 2019年8月11日
 */
public interface IHeatingPriceService {
	//查询一条
	public HtHeatingPriceModel selectByHeatingYear(String heatingYear) throws Exception;
	//查询所有
	public List<HtHeatingPriceModel> selectAllHeatingPrice() throws Exception;
	//增加一条
	public void addHeatingPrice(HtHeatingPriceModel record) throws Exception;
	//删除一条
	public void deleteHeatingPrice(String heatingYear) throws Exception;
	//修改一条
	public void updateHeatingPrice(HtHeatingPriceModel record) throws Exception;

	//全部个数
	public int getCountAll() throws Exception;
	
	//查询页数
	public int getCountPage(int rows) throws Exception;
	
	//分页查询
	public List<HtHeatingPriceModel> selectAllWithPage(int row,int page) throws Exception;
}
