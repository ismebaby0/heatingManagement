package com.neusoft.ht.fee.model;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;

@Data
public class HomeStopRecordModel {
	private int recordNo = 0;
	private HomeFee feeNo = null;
	private BigDecimal stopArea = null;
	private Date stopDate = null;
	private String stopReason = null;
	private String stopPerson = null;
	private String stopDesc = null;
	private String stopStatus = null;
	public HomeStopRecordModel(int recordNo, HomeFee feeNo, BigDecimal stopArea, Date stopDate, String stopReason,
			String stopPerson, String stopDesc, String stopStatus) {
		super();
		this.recordNo = recordNo;
		this.feeNo = feeNo;
		this.stopArea = stopArea;
		this.stopDate = stopDate;
		this.stopReason = stopReason;
		this.stopPerson = stopPerson;
		this.stopDesc = stopDesc;
		this.stopStatus = stopStatus;
	}
	public HomeStopRecordModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HomeStopRecordModel [recordNo=" + recordNo + ", feeNo=" + feeNo + ", stopArea=" + stopArea
				+ ", stopDate=" + stopDate + ", stopReason=" + stopReason + ", stopPerson=" + stopPerson + ", stopDesc="
				+ stopDesc + ", stopStatus=" + stopStatus + "]"; 
	}
	
	

}
