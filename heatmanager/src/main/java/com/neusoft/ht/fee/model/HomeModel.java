package com.neusoft.ht.fee.model;

import java.io.Serializable;

import lombok.Data;


@Data
public class HomeModel  implements Serializable {
	
	private int homeNo;
	private String heatingCode;
	private HouseType houseTypeNo;
	private Neighbourhood hoodNo;
	private String homeName;
	private String buildingCode;
	private String departmentCode;
	private String floorCode;
	private String houseCode;
	private String homeArea;
	private String direction;
	private String tel;
	private String mobile;
	private String mail;
	private String qq;
	private String heatingStatus ;
	private String heatingArea ;
	public HomeModel(int homeNo, String heatingCode, HouseType houseTypeNo, Neighbourhood hoodNo, String homeName,
			String buildingCode, String departmentCode, String floorCode, String houseCode, String homeArea,
			String direction, String tel, String mobile, String mail, String qq, String heatingStatus,
			String heatingArea) {
		super();
		this.homeNo = homeNo;
		this.heatingCode = heatingCode;
		this.houseTypeNo = houseTypeNo;
		this.hoodNo = hoodNo;
		this.homeName = homeName;
		this.buildingCode = buildingCode;
		this.departmentCode = departmentCode;
		this.floorCode = floorCode;
		this.houseCode = houseCode;
		this.homeArea = homeArea;
		this.direction = direction;
		this.tel = tel;
		this.mobile = mobile;
		this.mail = mail;
		this.qq = qq;
		this.heatingStatus = heatingStatus;
		this.heatingArea = heatingArea;
	}
	public HomeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Home [homeNo=" + homeNo + ", heatingCode=" + heatingCode + ", houseTypeNo=" + houseTypeNo + ", hoodNo="
				+ hoodNo + ", homeName=" + homeName + ", buildingCode=" + buildingCode + ", departmentCode="
				+ departmentCode + ", floorCode=" + floorCode + ", houseCode=" + houseCode + ", homeArea=" + homeArea
				+ ", direction=" + direction + ", tel=" + tel + ", mobile=" + mobile + ", mail=" + mail + ", qq=" + qq
				+ ", heatingStatus=" + heatingStatus + ", heatingArea=" + heatingArea + "]";
	}
	
	


}
