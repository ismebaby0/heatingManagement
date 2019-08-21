/**
 * 
 */
package com.neusoft.ht.fee.service;

import java.util.List;

import com.neusoft.ht.fee.model.HomeFeeModel;
import com.neusoft.ht.fee.model.HomeModel;

/**
 *@Filefile	:IHomeFeeService.java
 *@author 	:Administrator
 *@Date		:2019年8月21日
 *
 *
 */
public interface IHomeFeeService {
	public void add(HomeFeeModel homeFee) throws Exception;
	public void delete(int feeNo) throws Exception;
	public void update(HomeFeeModel homeFee) throws Exception;
	
	//不关联查询一条
	public HomeFeeModel getByPrimaryKey(int homeNo) throws Exception;
	//关联查询一条数据
	public HomeFeeModel getOneWithRelation(int homeNo) throws Exception;
	
	//全部个数
	public int getCountAll() throws Exception;
	
	//计算查询页数
	public int getCountPage(int rows) throws Exception;
	
	//不关联分页查询
	public List<HomeFeeModel> selectAllWithPage(int row,int page) throws Exception;
	
	//关联分页
	public List<HomeFeeModel> getAllWithRelationWithPage(int row,int page) throws Exception;
}
