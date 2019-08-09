package com.neusoft.ht.heating.model;
/**
 * 
 * @Description
 * @author:刘培嘉
 * @date:2019年8月9日 下午15:17:20
 */
public class Home {
	
	private int homeNo;
	private String heatingCode;
	private int houseTypeNo;
	private int hoodNo;
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
	public int getHomeNo() {
		return homeNo;
	}
	public void setHomeNo(int homeNo) {
		this.homeNo = homeNo;
	}
	public String getHeatingCode() {
		return heatingCode;
	}
	public void setHeatingCode(String heatingCode) {
		this.heatingCode = heatingCode;
	}
	public int getHouseTypeNo() {
		return houseTypeNo;
	}
	public void setHouseTypeNo(int houseTypeNo) {
		this.houseTypeNo = houseTypeNo;
	}
	public int getHoodNo() {
		return hoodNo;
	}
	public void setHoodNo(int hoodNo) {
		this.hoodNo = hoodNo;
	}
	public String getHomeName() {
		return homeName;
	}
	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}
	public String getBuildingCode() {
		return buildingCode;
	}
	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getFloorCode() {
		return floorCode;
	}
	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}
	public String getHouseCode() {
		return houseCode;
	}
	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}
	public String getHomeArea() {
		return homeArea;
	}
	public void setHomeArea(String homeArea) {
		this.homeArea = homeArea;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getHeatingStatus() {
		return heatingStatus;
	}
	public void setHeatingStatus(String heatingStatus) {
		this.heatingStatus = heatingStatus;
	}
	public String getHeatingArea() {
		return heatingArea;
	}
	public void setHeatingArea(String heatingArea) {
		this.heatingArea = heatingArea;
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
