package com.neusoft.ht.fee.mapper;
/**
 * 
 * @Description
 * @author:刘培嘉
 * @date:2019年8月14日 下午15:17:20
 */
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


import com.neusoft.ht.fee.model.Home;
import com.neusoft.ht.fee.model.HouseType;


@Mapper
public interface HomeMapper {
	
//
	@Select("SELECT * FROM ht_home")
	@Results({
		@Result(property = "homeNo",  column = "HOMENO"),
		@Result(property = "heatingCode", column = "HeatingCode"),
		//@Result(property = "houseTypeNo",  column = "HOUSETYPENO",javaType = com.neusoft.ht.fee.model.HouseType.class),
		@Result(property = "hoodNo", column = "HOODNO"),

		@Result(property = "homeName", column = "HomeName"),
		@Result(property = "buildingCode",  column = "BuildingCODE"),
		@Result(property = "departmentCode", column = "DepartmentCode"),
		@Result(property = "floorCode",  column = "FloorCode"),
		@Result(property = "houseCode", column = "HouseCode"),
		@Result(property = "homeArea",  column = "HomeArea"),
		@Result(property = "direction", column = "Direction"),
		@Result(property = "tel",  column = "Tel"),
		@Result(property = "mobile", column = "Mobile"),
		
		@Result(property = "mail",  column = "Mail"),
		@Result(property = "qq", column = "QQ"),
		@Result(property = "heatingStatus",  column = "HeatingStatus"),
		@Result(property = "heatingArea", column = "HeatingArea")
})
	public List<Home> selectAll();
	
	@Insert("INSERT INTO HT_HOME("
			+ "homeNo,heatingCode,hoodNo,homeName,buildingCode,"
			+ "departmentCode,floorCode,houseCode,homeArea,direction,tel,mobile,mail,qq,heatingStatus,heatingArea"
			+ ") VALUES(#{homeNo}, #{heatingCode},#{hoodNo}, #{homeName}, #{buildingCode},#{departmentCode}, #{floorCode}, #{houseCode},"
			+ "#{homeArea}, #{direction}, #{tel},#{mobile}, #{mail}, #{qq},#{heatingStatus}, #{heatingArea})")
	public void insert(Home home);


}
