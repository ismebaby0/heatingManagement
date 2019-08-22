package com.neusoft.ht.fee.model;
/**
 * 
 * @Description
 * @author:刘培嘉
 * @date:2019年8月12日 下午15:17:28
 */
import java.util.Date;

import lombok.Data;

@Data
public class HomeFeePayRecord {
	private Integer recordNo;
	private HomeFeeModel homeFeeNo;
	private PaymentType paymentTypeNo;
	private Date payDate;
	private Float payAmount;
	private String payPerson;
	private String invoiceCode;
	private String payDesc;
	private String recordStatus;
	
}
