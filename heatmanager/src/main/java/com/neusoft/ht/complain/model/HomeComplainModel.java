package com.neusoft.ht.complain.model;

import com.neusoft.ht.fee.model.HomeModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 居民投诉信息Model 作者: 方俊坤
 */
public class HomeComplainModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer complainNo;

	private HomeModel home;

	private ComplainType complainType;

	private String complainTitle;

	private String complainContent;

	private String requestContent;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date complainDate;

	private String contactPerson;

	private String tel;

	private String mobile;

	private String mail;

	private String qq;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date serviceStartDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date serviceEndDate;

	private String serviceContent;

	private String servicePerson;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date feedBackDate;

	private String homeComment;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date assuranceDate;

	private BigDecimal assuranceFee = new BigDecimal(0);

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date assurancePayDate;

	private String complainStatus = "未处理";

	public Integer getComplainNo() {
		return complainNo;
	}

	public void setComplainNo(Integer complainNo) {
		this.complainNo = complainNo;
	}

	public HomeModel getHome() {
		return home;
	}

	public void setHome(HomeModel home) {
		this.home = home;
	}

	public ComplainType getComplainType() {
		return complainType;
	}

	public void setComplainType(ComplainType complainType) {
		this.complainType = complainType;
	}

	public String getComplainTitle() {
		return complainTitle;
	}

	public void setComplainTitle(String complainTitle) {
		this.complainTitle = complainTitle == null ? null : complainTitle.trim();
	}

	public String getComplainContent() {
		return complainContent;
	}

	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent == null ? null : complainContent.trim();
	}

	public String getRequestContent() {
		return requestContent;
	}

	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent == null ? null : requestContent.trim();
	}

	public Date getComplainDate() {
		return complainDate;
	}

	public void setComplainDate(Date complainDate) {
		this.complainDate = complainDate;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson == null ? null : contactPerson.trim();
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail == null ? null : mail.trim();
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq == null ? null : qq.trim();
	}

	public Date getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public Date getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public String getServiceContent() {
		return serviceContent;
	}

	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent == null ? null : serviceContent.trim();
	}

	public String getServicePerson() {
		return servicePerson;
	}

	public void setServicePerson(String servicePerson) {
		this.servicePerson = servicePerson == null ? null : servicePerson.trim();
	}

	public Date getFeedBackDate() {
		return feedBackDate;
	}

	public void setFeedBackDate(Date feedBackDate) {
		this.feedBackDate = feedBackDate;
	}

	public String getHomeComment() {
		return homeComment;
	}

	public void setHomeComment(String homeComment) {
		this.homeComment = homeComment == null ? null : homeComment.trim();
	}

	public Date getAssuranceDate() {
		return assuranceDate;
	}

	public void setAssuranceDate(Date assuranceDate) {
		this.assuranceDate = assuranceDate;
	}

	public BigDecimal getAssuranceFee() {
		return assuranceFee;
	}

	public void setAssuranceFee(BigDecimal assuranceFee) {
		this.assuranceFee = assuranceFee;
	}

	public Date getAssurancePayDate() {
		return assurancePayDate;
	}

	public void setAssurancePayDate(Date assurancePayDate) {
		this.assurancePayDate = assurancePayDate;
	}

	public String getComplainStatus() {
		return complainStatus;
	}

	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus == null ? null : complainStatus.trim();
	}
}