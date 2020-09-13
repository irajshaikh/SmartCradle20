package com.viit.smartcradle.entity;

public class Profile {

	private String mobNo = "";
	private String babyName = "";

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String newMobNo) {
		this.mobNo = newMobNo;
	}

	public String getBabyName() {
		return babyName;
	}

	public void setBabyName(String newBabyName) {
		this.babyName = newBabyName;
	}

	public Profile(String newMobNo, String babyName) {
		this.mobNo = newMobNo;
		this.babyName = babyName;
	}
}
