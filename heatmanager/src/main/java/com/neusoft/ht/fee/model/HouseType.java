package com.neusoft.ht.fee.model;

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


	public int getTypeNo() {
		return typeNo;
	}


	public void setTypeNo(int typeNo) {
		this.typeNo = typeNo;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	
	
}
