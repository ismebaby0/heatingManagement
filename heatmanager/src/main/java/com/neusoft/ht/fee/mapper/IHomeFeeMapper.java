package com.neusoft.ht.fee.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.ht.fee.model.HomeFee;
import com.neusoft.ht.fee.model.HomeModel;


@Mapper
public interface IHomeFeeMapper {


		// 删除
		int deleteByFeeNo(int feeNo);

		// 修改
		int updateByFeeNo(HomeFee home);

		// 查看一条记录
		HomeFee selectByFeeNo(int feeNo);

		int insertHomeFee(HomeFee homeFee);
		
		

		List<HomeFee> getAll();
}
