package com.neusoft.ht.fee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月13日 下午2:02:39
 */
@Data
public class HouseFeeReturnRecord implements Serializable {

	// 退费序号
	private Integer recordNo;
	// 公建供热费记录编号
	private HouseFeeModel houseFee;
	// 付款方式编号
	private PaymentType paymentType;
	// 退费日期
	private Date returnDate;
	// 退费金额
	private BigDecimal amount;
	// 收款人
	private String person;
	// 支票编号
	private String checkCode;
	// 退费单编号
	private String invoiceCode;
	// 退费备注
	private String recordDesc;
	// 退费状态
	private char recordStatus;

	@Override
	public String toString() {
		return "HouseFeeReturnRecord [recordNo=" + recordNo + ", houseFee=" + houseFee + ", paymentType=" + paymentType
				+ ", returnDate=" + returnDate + ", amount=" + amount + ", person=" + person + ", checkCode="
				+ checkCode + ", invoiceCode=" + invoiceCode + ", recordDesc=" + recordDesc + ", recordStatus="
				+ recordStatus + "]";
	}
}
