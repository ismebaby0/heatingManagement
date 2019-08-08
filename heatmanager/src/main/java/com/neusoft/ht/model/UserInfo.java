package com.neusoft.ht.model;

import java.util.Arrays;

public class UserInfo {
	private String uuserId = null ;
	private String sex = null;
	private int age = 0;
	private byte[] phote = null ;
	private String photeFileName = null;
	private String photoContentType = null;
	private String tel = null;
	private String mobile = null;
	
	
	public UserInfo(String uuserId, String sex, int age, byte[] phote, String photeFileName, String photoContentType,
			String tel, String mobile) {
		super();
		this.uuserId = uuserId;
		this.sex = sex;
		this.age = age;
		this.phote = phote;
		this.photeFileName = photeFileName;
		this.photoContentType = photoContentType;
		this.tel = tel;
		this.mobile = mobile;
	}


	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUuserId() {
		return uuserId;
	}


	public void setUuserId(String uuserId) {
		this.uuserId = uuserId;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public byte[] getPhote() {
		return phote;
	}


	public void setPhote(byte[] phote) {
		this.phote = phote;
	}


	public String getPhoteFileName() {
		return photeFileName;
	}


	public void setPhoteFileName(String photeFileName) {
		this.photeFileName = photeFileName;
	}


	public String getPhotoContentType() {
		return photoContentType;
	}


	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
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


	@Override
	public String toString() {
		return "UserInfo [uuserId=" + uuserId + ", sex=" + sex + ", age=" + age + ", phote=" + Arrays.toString(phote)
				+ ", photeFileName=" + photeFileName + ", photoContentType=" + photoContentType + ", tel=" + tel
				+ ", mobile=" + mobile + "]";
	}
	
	
}
