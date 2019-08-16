package com.neusoft.ht.SystemSafety.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.cache.CacheProperties.Infinispan;

import com.neusoft.ht.SystemSafety.model.Function;

/*
 *   用户功能模块信息 mapper
 *   作者: 马佳国
 */
@Mapper
public interface IFunctionMapper {

	public void create(Function func) throws Exception;
	
	public void update(Function func) throws Exception;
	
	public void delete(int funno) throws Exception;
	
	public List<Function>  selectListWithAll() throws Exception;
	
	//分页查询
	public List<Function> selectListWithPages(@Param("funName") String funName,@Param("levelNo") int levelNo,@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得数据数
	
	public int getTotalCount() throws Exception;
	
}
