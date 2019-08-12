package com.neusoft.ht.fee.model;

import lombok.Data;

@Data
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
	

	


	@Override
	public String toString() {
		return "Neighbourhood [hoodNo=" + hoodNo + ", hoodName=" + hoodName + ", address=" + address + "]";
	}
	
	
}
