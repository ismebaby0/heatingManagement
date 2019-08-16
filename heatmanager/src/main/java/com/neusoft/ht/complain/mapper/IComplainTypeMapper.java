package com.neusoft.ht.complain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.ht.complain.model.ComplainType;
import com.neusoft.ht.login.model.AdminUserValue;

/* 
 * 投诉类型 ComplainTypeMapper 
 *   作者: 方俊坤
 */
@Mapper
public interface IComplainTypeMapper {
	int deleteByPrimaryKey(Integer typeNo);

	int insert(ComplainType record);

	int insertSelective(ComplainType record);

	ComplainType selectByPrimaryKey(Integer typeNo);

	List<ComplainType> selectByAll();
	
    List<ComplainType> selectListAllWithPages(@Param("start") int start,@Param("rows") int rows) throws Exception;
    
    //取得所有数据的个数
    int selectTotalCount() throws Exception;

	int updateByPrimaryKeySelective(ComplainType record);

	int updateByPrimaryKey(ComplainType record);
	
	
}