package com.neusoft.ht.fee.model;


/**
 * 
 * @Description
 * @author:刘培嘉
 * @date:2019年812日 下午15:17:27
 */
import java.util.Date;

import com.neusoft.ht.fee.service.impl.HeatingPriceServiceImpl;

import lombok.Data;


/**
 *@Filefile	:HomeFee.java
 *@author 	:Administrator
 *@Date		:2019年8月21日
 *
 *
 */
@Data
public class HomeFeeModel {
	private int feeNo;
	private HomeModel homeNo;	//外键，表home,对应属性homeNo
	private HtHeatingPriceModel heatingYear;//外键，对应属性heatingYear
	private String heatArea;
	private float agreeFee;
	private float actualFee;
	private float debtFee;
	private String feeStatus;
	private Integer heatingdays;
	private String feeDesc;
	@Override
	public String toString() {
		return "HomeFee [feeNo=" + feeNo + ", homeNo=" + homeNo + ", heatingYear=" + heatingYear + ", heatArea="
				+ heatArea + ", agreeFee=" + agreeFee + ", actualFee=" + actualFee + ", debtFee=" + debtFee
				+ ", feeStatus=" + feeStatus + ", heatingdays=" + heatingdays + ", feeDesc=" + feeDesc + "]";
	}
	public HomeFeeModel(Integer feeNo, HomeModel homeNo, HtHeatingPriceModel heatingYear, String heatArea, float agreeFee,
			float actualFee, float debtFee, String feeStatus, Integer heatingdays, String feeDesc) {
		super();
		this.feeNo = feeNo;
		this.homeNo = homeNo;
		this.heatingYear = heatingYear;
		this.heatArea = heatArea;
		this.agreeFee = agreeFee;
		this.actualFee = actualFee;
		this.debtFee = debtFee;
		this.feeStatus = feeStatus;
		this.heatingdays = heatingdays;
		this.feeDesc = feeDesc;
	}
	public HomeFeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
