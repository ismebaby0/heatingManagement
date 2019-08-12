package com.neusoft.ht.fee.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月12日 
 */
@Data
public class HtHouseModel implements Serializable {
	//	公建序号
	private int houseNo;
	//	小区编号
	private Neighbourhood neighbourhood;
	//	供热编码
	private String heatingCode;
	//	公建名称
	private String name;
	//	公建编号
	private String houseCode;
	//	楼号
	private String building;
	//	建筑面积
	private BigDecimal area;
	//	地址
	private String address;
	//	邮编
	private String postcode;
	//	联系人姓名
	private String contactName;
	//	电话
	private String tel;
	//	手机
	private String mobile;
	//	Mail
	private String mail;
	//	QQ
	private String qq;
	//	供热状态
	private String heatingStatus;
	//	实际供热面积
	private BigDecimal heatingArea;
	
	@Override
	public String toString() {
		return "HtHouseModel [houseNo=" + houseNo + ", neighbourhood=" + neighbourhood + ", heatingCode=" + heatingCode
				+ ", name=" + name + ", houseCode=" + houseCode + ", building=" + building + ", area=" + area
				+ ", address=" + address + ", postcode=" + postcode + ", contactName=" + contactName + ", tel=" + tel
				+ ", mobile=" + mobile + ", mail=" + mail + ", qq=" + qq + ", heatingStatus=" + heatingStatus
				+ ", heatingArea=" + heatingArea + "]";
	}

}
