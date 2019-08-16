package com.neusoft.ht.fee.model;

import java.math.BigDecimal;


import lombok.Data;

@Data
public class HouseFeeModel {
	/**
	 * 
	 * @Description
	 * @author:劳泽昌
	 * @date:2019年8月12日 
	 */
	
	private int feeNo;
	private HtHouseModel htHouse;
	private HtHeatingPriceModel heatingPrice;
	private BigDecimal heatArea;
	private BigDecimal agreeFee;
	private BigDecimal actualFee;
	private BigDecimal debtFee;
	private String feeDesc;
	private String feeStatus;
	private String heatingDays;
	
	public HouseFeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HouseFeeModel(int feeNo, HtHouseModel htHouse, HtHeatingPriceModel heatingPrice, BigDecimal heatArea,
			BigDecimal agreeFee, BigDecimal actualFee, BigDecimal debtFee, String feeDesc, String feeStatus,
			String heatingDays) {
		super();
		this.feeNo = feeNo;
		this.htHouse = htHouse;
		this.heatingPrice = heatingPrice;
		this.heatArea = heatArea;
		this.agreeFee = agreeFee;
		this.actualFee = actualFee;
		this.debtFee = debtFee;
		this.feeDesc = feeDesc;
		this.feeStatus = feeStatus;
		this.heatingDays = heatingDays;
	}

	@Override
	public String toString() {
		return "HouseFeeModel [feeNo=" + feeNo + ", htHouse=" + htHouse + ", heatingPrice=" + heatingPrice
				+ ", heatArea=" + heatArea + ", agreeFee=" + agreeFee + ", actualFee=" + actualFee + ", debtFee="
				+ debtFee + ", feeDesc=" + feeDesc + ", feeStatus=" + feeStatus + ", heatingDays=" + heatingDays + "]";
	}
	
	
	
}
