package com.neusoft.ht.complain.mapper;

import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neusoft.ht.complain.model.ComplainType;
import com.neusoft.ht.complain.model.PublicHouseComplainModel;
import com.neusoft.ht.fee.mapper.IHtHouseMapper;
import com.neusoft.ht.fee.model.HtHouseModel;

/**
 * 公建投诉信息 单元测试类
 *  作者: 方俊坤
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseTest {
	@Autowired
	private IPublicHouseComplainModelMapper houseComplainModelMapper;
	@Autowired
	private IHtHouseMapper htHouse;
	@Autowired
	private IComplainTypeMapper complain;
	
	@Test
	public void inserTest() {
		PublicHouseComplainModel publicHouse=new PublicHouseComplainModel();
		HtHouseModel ht = htHouse.selectByPrimaryKey(1);
		ComplainType cType= complain.selectByPrimaryKey(3);
		publicHouse.setHouse(ht);
		publicHouse.setComplainType(cType);
		houseComplainModelMapper.insert(publicHouse);
	}
	@Test
	public void selectTest() {
		System.out.println(houseComplainModelMapper.selectByAll().stream()
				  .map(PublicHouseComplainModel::getComplainTitle)
				  .collect(Collectors.joining(", ")) );
	}
	@Test
	public void updateTest() {
		PublicHouseComplainModel hc = houseComplainModelMapper.selectByPrimaryKey(1);
		hc.setComplainTitle("8888");
		houseComplainModelMapper.updateByPrimaryKeySelective(hc);
		hc.setComplainNo(2);
		hc.setComplainTitle("168");
		houseComplainModelMapper.updateByPrimaryKeySelective(hc);
		
	}
	@Test
	public void deleteTest() {
		houseComplainModelMapper.deleteByPrimaryKey(3);
	}
	
}
