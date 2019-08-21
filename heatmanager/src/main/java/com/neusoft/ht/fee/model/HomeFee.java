package com.neusoft.ht.fee.model;


/**
 * 
 * @Description
 * @author:刘培嘉
 * @date:2019年812日 下午15:17:27
 */
import java.util.Date;

import lombok.Data;


@Data
public class HomeFee {
	private Integer feeNo;
	private HomeModel home;
	private HtHeatingPriceModel HtHeatingPrice ;
	private Integer heatArea;
	private float agreeFee;
	private float actualFee;
	private float debtFee;
	private String feeStatus;
	private Integer heatingdays;
	private String feeDesc;

	
	
}
