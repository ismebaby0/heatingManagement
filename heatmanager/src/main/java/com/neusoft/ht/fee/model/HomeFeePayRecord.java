package com.neusoft.ht.fee.model;
import java.io.Serializable;
/**
 * 
 * @Description
 * @author:刘培嘉
 * @date:2019年8月12日 下午15:17:28
 */
import java.util.Date;

public class HomeFeePayRecord implements Serializable{
	private Integer recordNo;
	private HomeFeeModel homeFeeNo;
	private PaymentType paymentTypeNo;
	private Date payDate;
	private Float payAmount = 0f;
	private String payPerson;
	private String checkCode;
	private String invoiceCode;
	private String payDesc;
	private String recordStatus = "N";
	public Integer getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(Integer recordNo) {
		this.recordNo = recordNo;
	}
	public HomeFeeModel getHomeFeeNo() {
		return homeFeeNo;
	}
	public void setHomeFeeNo(HomeFeeModel homeFeeNo) {
		this.homeFeeNo = homeFeeNo;
	}
	public PaymentType getPaymentTypeNo() {
		return paymentTypeNo;
	}
	public void setPaymentTypeNo(PaymentType paymentTypeNo) {
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
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

}
