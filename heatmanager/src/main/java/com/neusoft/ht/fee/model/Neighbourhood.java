package com.neusoft.ht.fee.model;

public class Neighbourhood {
	private int hoodNo = 0;
	private String hoodName = null;
	private String address = null;
	
	
	public Neighbourhood() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Neighbourhood(int hoodNo, String hoodName, String address) {
		super();
		this.hoodNo = hoodNo;
		this.hoodName = hoodName;
		this.address = address;
	}
	

	public int getHoodNo() {
		return hoodNo;
	}


	public void setHoodNo(int hoodNo) {
		this.hoodNo = hoodNo;
	}


	public String getHoodName() {
		return hoodName;
	}


	public void setHoodName(String hoodName) {
		this.hoodName = hoodName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Neighbourhood [hoodNo=" + hoodNo + ", hoodName=" + hoodName + ", address=" + address + "]";
	}
	
	
}
