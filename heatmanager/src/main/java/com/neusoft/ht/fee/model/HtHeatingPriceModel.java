package com.neusoft.ht.fee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

import lombok.Data;
/**
 * 
 * @Description
 * @author:林康荣
 * @date:2019年8月9日 上午11:17:20
 */
@Data
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

	@Override
	public String toString() {
		return "HtHeatingPrice [heatingYear=" + heatingYear + ", homePrice=" + homePrice + ", publicHousePrice="
				+ publicHousePrice + ", heatingdays=" + heatingdays + ", heatingMemo=" + heatingMemo + ", priceFile="
				+ Arrays.toString(priceFile) + ", priceFileName=" + priceFileName + ", priceFileContentType="
				+ priceFileContentType + "]";
	}
	
}
