/**
 * 
 */
package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.ht.fee.model.HomeFeeModel;
import com.neusoft.ht.fee.model.PaymentType;

/**
 *@Filefile	:IHomeFeePayRecordMapper.java
 *@author 	:Administrator
 *@Date		:2019年8月22日
 *
 *
 */
public interface IHomeFeePayRecordMapper {
			// 增加
			public void insert(PaymentType pay) throws Exception;
			// 删除
			public void deleteByPrimaryKey(int typeNo)  throws Exception;
			// 修改
			public void updateByPrimaryKey(PaymentType pay)  throws Exception;
			// 查看一条记录
			public PaymentType selectByPrimaryKey(int typeNo)  throws Exception;
			//查看所有记录
			public List<PaymentType> selectByAll() throws Exception;
			
			//查询小区表数据的个数
			public int getCountByAll() throws Exception;
			//分页查询
			public List<PaymentType> selectAllWithPage(@Param("start") int star,@Param("end") int end) throws Exception; 

}
