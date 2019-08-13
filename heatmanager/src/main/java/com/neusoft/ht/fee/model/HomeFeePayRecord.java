package com.neusoft.ht.fee.model;
/**
 * 
 * @Description
 * @author:刘培嘉
 * @date:2019年8月12日 下午15:17:28
 */
import java.util.Date;

public class HomeFeePayRecord {
	private Integer recordNo;
	private Integer homeFeeNo;
	private Integer paymentTypeNo;
	private Date payDate;
	private Float payAmount;
	private String payPerson;
	private String invoiceCode;
	private String payDesc;
	private String recordStatus;
	public Integer getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(Integer recordNo) {
		this.recordNo = recordNo;
	}
	public Integer getHomeFeeNo() {
		return homeFeeNo;
	}
	public void setHomeFeeNo(Integer homeFeeNo) {
		this.homeFeeNo = homeFeeNo;
	}
	public Integer getPaymentTypeNo() {
		return paymentTypeNo;
	}
	public void setPaymentTypeNo(Integer paymentTypeNo) {
		this.paymentTypeNo = paymentTypeNo;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Float getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Float payAmount) {
		this.payAmount = payAmount;
	}
	public String getPayPerson() {
		return payPerson;
	}
	public void setPayPerson(String payPerson) {
		this.payPerson = payPerson;
	}
	public String getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	public String getPayDesc() {
		return payDesc;
	}
	public void setPayDesc(String payDesc) {
		this.payDesc = payDesc;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

}