
package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.ht.fee.model.HomeFeeModel;
import com.neusoft.ht.fee.model.HomeModel;
import com.neusoft.ht.fee.model.Neighbourhood;

/**
 *@Filefile	:HomeFeeMapper.java
 *@author 	:Administrator
 *@Date		:2019年8月21日
 *
 *
 */

@Mapper
public interface IHomeFeeMapper {

		// 增加
		public void insert(HomeFeeModel homeFee) throws Exception;
		// 删除
		public void deleteByPrimaryKey(int feeNo)  throws Exception;
		// 修改
		public void updateByPrimaryKey(HomeFeeModel homeFee)  throws Exception;
		// 不关联查一条记录
		public HomeFeeModel getByPrimaryKey(int feeNo)  throws Exception;
		//关联查询一条数据
		public HomeFeeModel getOneWithRelation(int feeNo) throws Exception;
		//查看所有记录
		public List<HomeFeeModel> selectByAll() throws Exception;
		
		//查询表数据的个数
		public int getCountByAll() throws Exception;
		//不关联分页查询
		public List<HomeFeeModel> selectAllWithPage(@Param("start") int star,@Param("end") int end) throws Exception;
		//关联分页查询
		public List<HomeFeeModel> getAllWithRelation (@Param("start") int star,@Param("end") int end) throws Exception;
}	
