package com.rakuten.model;

public class User {
	private String email;
	private String userID;
	private String passWord;
	private String sei;
	private String mei;
	private String seiKata;
	private String meiKata;
	
	public User() {
	}

	public User(String email, String userID, String passWord, String sei, String mei, String seiKata, String meiKata) {
//	,Timestamp createDate
		this.email = email;
		this.userID = userID;
		this.passWord = passWord;
		this.sei = sei;
		this.mei = mei;
		this.seiKata = seiKata;
		this.meiKata = meiKata;
//		this.createDate = createDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getSei() {
		return sei;
	}

	public void setSei(String sei) {
		this.sei = sei;
	}

	public String getMei() {
		return mei;
	}

	public void setMei(String mei) {
		this.mei = mei;
	}

	public String getSeiKata() {
		return seiKata;
	}

	public void setSeiKata(String seiKata) {
		this.seiKata = seiKata;
	}

	public String getMeiKata() {
		return meiKata;
	}

	public void setMeiKata(String meiKata) {
		this.meiKata = meiKata;
	}

}
