package com.neusoft.ht.fee.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @Description
 * @author:刘培嘉
 * @date:2019年8月12日 下午15:17:23
 */

@Data
public class PaymentType  implements Serializable{
	private int typeNo;
	private String typeName;
	@Override
	public String toString() {
		return "PaymentType [typeNo=" + typeNo + ", typeName=" + typeName + "]";
	}
	

}
