package com.neusoft.ht.SystemSafety.mapper;

import java.util.List;

import org.springframework.boot.autoconfigure.cache.CacheProperties.Infinispan;

import com.neusoft.ht.SystemSafety.model.Function;

/*
 *   用户功能模块信息 mapper
 *   作者: 马佳国
 */
public interface IFunctionMapper {

	public void create(Function func) throws Exception;
	
	public void update(Function func) throws Exception;
	
	public void delete(int funno) throws Exception;
	
	public List<Function>  selectListWithAll() throws Exception;
}