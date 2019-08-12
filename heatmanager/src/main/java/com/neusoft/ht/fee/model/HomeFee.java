package com.neusoft.ht.fee.model;


/**
 * 
 * @Description
 * @author:刘培嘉
 * @date:2019年812日 下午15:17:27
 */
import java.util.Date;
/**
 * 
 * @Description
 * @author:刘培嘉
 * @date:2019年8月12日 下午15:17:29
 */
public class HomeFee {
	private Integer feeNo;
	private Integer homeNo;
	private Date heatingYear;
	private String heatArea;
	private float agreeFee;
	private float actualFee;
	private float debtFee;
	private String feeStatus;
	private Integer heatingdays;
	private String feeDesc;
	public Integer getFeeNo() {
		return feeNo;
	}
	public void setFeeNo(Integer feeNo) {
		this.feeNo = feeNo;
	}
	public Integer getHomeNo() {
		return homeNo;
	}
	public void setHomeNo(Integer homeNo) {
		this.homeNo = homeNo;
	}
	public Date getHeatingYear() {
		return heatingYear;
	}
	public void setHeatingYear(Date heatingYear) {
		this.heatingYear = heatingYear;
	}
	public String getHeatArea() {
		return heatArea;
	}
	public void setHeatArea(String heatArea) {
		this.heatArea = heatArea;
	}
	public float getAgreeFee() {
		return agreeFee;
	}
	public void setAgreeFee(float agreeFee) {
		this.agreeFee = agreeFee;
	}
	public float getActualFee() {
		return actualFee;
	}
	public void setActualFee(float actualFee) {
		this.actualFee = actualFee;
	}
	public float getDebtFee() {
		return debtFee;
	}
	public void setDebtFee(float debtFee) {
		this.debtFee = debtFee;
	}
	public String getFeeStatus() {
		return feeStatus;
	}
	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}
	public Integer getHeatingdays() {
		return heatingdays;
	}
	public void setHeatingdays(Integer heatingdays) {
		this.heatingdays = heatingdays;
	}
	public String getFeeDesc() {
		return feeDesc;
	}
	public void setFeeDesc(String feeDesc) {
		this.feeDesc = feeDesc;
	}



}
