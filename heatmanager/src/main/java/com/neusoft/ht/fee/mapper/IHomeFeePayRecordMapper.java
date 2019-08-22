package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.ht.fee.model.HomeFeePayRecord;

/**
 * 住宅供热缴费记录Mapper
 * 作者: 方俊坤
 */

@Mapper
public interface IHomeFeePayRecordMapper {

	// 增加
	public void insert(HomeFeePayRecord homeFeePayRecord) throws Exception;

	// 删除
	public void deleteByPrimaryKey(int payRecord) throws Exception;

	// 修改
	public void updateByPrimaryKey(HomeFeePayRecord homeFeePayRecord) throws Exception;

	// 不关联查一条记录
	public HomeFeePayRecord selectByPrimaryKey(int payRecord) throws Exception;

	// 关联查询一条数据
//	public HomeFeePayRecord selectOneWithRelation(int payRecord) throws Exception;

	// 查看关联所有记录
	public List<HomeFeePayRecord> selectByAll() throws Exception;

	// 查询表数据的个数
	public int selectTotalCount() throws Exception;

	// 不关联分页查询
	public List<HomeFeePayRecord> selectAllWithPages(@Param("start") int star, @Param("rows") int rows) throws Exception;

	// 关联分页查询
	public List<HomeFeePayRecord> selectAllWithRelation(@Param("start") int star, @Param("rows") int rows) throws Exception;

}
