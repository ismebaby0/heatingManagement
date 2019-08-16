package com.neusoft.ht.fee.model;


/**
 * 
 * @Description
 * @author:刘培嘉
 * @date:2019年812日 下午15:17:27
 */
import java.util.Date;

import lombok.Data;
/**
 * 
 * @Description
 * @author:刘培嘉
 * @date:2019年8月12日 下午15:17:29
 */

@Data
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
	public HomeFee(Integer feeNo, Integer homeNo, Date heatingYear, String heatArea, float agreeFee, float actualFee,
			float debtFee, String feeStatus, Integer heatingdays, String feeDesc) {
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
	public HomeFee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HomeFee [feeNo=" + feeNo + ", homeNo=" + homeNo + ", heatingYear=" + heatingYear + ", heatArea="
				+ heatArea + ", agreeFee=" + agreeFee + ", actualFee=" + actualFee + ", debtFee=" + debtFee
				+ ", feeStatus=" + feeStatus + ", heatingdays=" + heatingdays + ", feeDesc=" + feeDesc + "]";
	}
	
	
}
