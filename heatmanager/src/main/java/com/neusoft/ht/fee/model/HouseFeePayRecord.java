package com.neusoft.ht.fee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月13日 上午9:21:31
 */
@Data
public class HouseFeePayRecord implements Serializable {
	//	缴费序号(自增)
	private Integer recordNo;
	//	公建供热序号
	private HouseFeeModel houseFee;
	//	交款方式编号
	private PaymentType paymentType;
	//	缴费日期
	private Date payDate;
	//	缴费金额
	private BigDecimal payAmount;
	//	缴费人
	private String payPerson;
	//	支票编号
	private String checkCode;
	//	发票编号
	private String invoiceCode;
	//	缴费备注
	private String payDesc;
	//	记录处理状态Y已处理
	private String recordStatus;
	
	@Override
	public String toString() {
		return "HouseFeePayRecord [recordNo=" + recordNo + ", houseFee=" + houseFee + ", paymentType=" + paymentType
				+ ", payDate=" + payDate + ", payAmount=" + payAmount + ", payPerson=" + payPerson + ", checkCode="
				+ checkCode + ", invoiceCode=" + invoiceCode + ", payDesc=" + payDesc + ", recordStatus=" + recordStatus
				+ "]";
	}

}
