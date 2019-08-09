package com.neusoft.ht.heating.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月9日 上午11:17:20
 */
public class HtHeatingPriceModel implements Serializable {
	// 供热年份
	private String heatingYear;
	// 居民价格  
	private BigDecimal homePrice;
	// 公建价格
	private BigDecimal publicHousePrice;
	// 供热天数
	private int heatingdays;
	// 备注
	private String heatingMemo;
	// 价格文件
	private byte[] priceFile;
	// 文件名
	private String priceFileName;
	// 文件类型
	
	private String priceFileContentType;
	public HtHeatingPriceModel() {
		super();
	}
	public String getHeatingYear() {
		return heatingYear;
	}
	public void setHeatingYear(String heatingYear) {
		this.heatingYear = heatingYear;
	}
	public BigDecimal getHomePrice() {
		return homePrice;
	}
	public void setHomePrice(BigDecimal homePrice) {
		this.homePrice = homePrice;
	}
	public BigDecimal getPublicHousePrice() {
		return publicHousePrice;
	}
	public void setPublicHousePrice(BigDecimal publicHousePrice) {
		this.publicHousePrice = publicHousePrice;
	}
	public int getHeatingdays() {
		return heatingdays;
	}
	public void setHeatingdays(int heatingdays) {
		this.heatingdays = heatingdays;
	}
	public String getHeatingMemo() {
		return heatingMemo;
	}
	public void setHeatingMemo(String heatingMemo) {
		this.heatingMemo = heatingMemo;
	}
	public byte[] getPriceFile() {
		return priceFile;
	}
	public void setPriceFile(byte[] priceFile) {
		this.priceFile = priceFile;
	}
	public String getPriceFileName() {
		return priceFileName;
	}
	public void setPriceFileName(String priceFileName) {
		this.priceFileName = priceFileName;
	}
	public String getPriceFileContentType() {
		return priceFileContentType;
	}
	public void setPriceFileContentType(String priceFileContentType) {
		this.priceFileContentType = priceFileContentType;
	}
	@Override
	public String toString() {
		return "HtHeatingPrice [heatingYear=" + heatingYear + ", homePrice=" + homePrice + ", publicHousePrice="
				+ publicHousePrice + ", heatingdays=" + heatingdays + ", heatingMemo=" + heatingMemo + ", priceFile="
				+ Arrays.toString(priceFile) + ", priceFileName=" + priceFileName + ", priceFileContentType="
				+ priceFileContentType + "]";
	}
	
}
