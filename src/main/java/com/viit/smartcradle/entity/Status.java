package com.viit.smartcradle.entity;

public enum Status {
	SUCCESS("Success"), FAILURE("Failure");

	private String strVal;

	public String getVal() {
		return this.strVal;
	}

	private Status(String str) {
		this.strVal = str;
	}
}