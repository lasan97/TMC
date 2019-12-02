package com.kh.tmc.member.model.vo;

import java.io.Serializable;

public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1992717493972199609L;

	private String userId;
	private String userPwd;
	private String userName;
	private String userPhone;
	private String userAddress;

	public Member() {
	}

	public Member(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public Member(String userId, String userPwd, String userName, String userPhone, String userAddress) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userPhone="
				+ userPhone + ", userAddress=" + userAddress + "]";
	}

}
