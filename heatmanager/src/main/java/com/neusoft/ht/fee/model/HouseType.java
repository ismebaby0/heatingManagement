package com.neusoft.ht.fee.model;

import lombok.Data;

@Data
public class HouseType {
	private int typeNo = 0;
	private String typeName = null;
	
	
	public HouseType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public HouseType(int typeNo, String typeName) {
		super();
		this.typeNo = typeNo;
		this.typeName = typeName;
	}


	@Override
	public String toString() {
		return "HouseType [typeNo=" + typeNo + ", typeName=" + typeName + "]";
	}
	
	
	
	
}
