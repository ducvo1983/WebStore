package com.wap.model;

public class Account {
	
	private int		userId;
	private String	username;
	private String	password;
	private String	email;
	private String	phoneNumber;
	private int		active;
	
	/**
	 * @param userId
	 * @param userName
	 * @param password
	 * @param email
	 * @param phoneNumber
	 * @param active
	 */
	public Account(int userId, String userName, String password, String email, String phoneNumber, int active) {
		super();
		this.userId = userId;
		this.username = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.active = active;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return username;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.username = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}

	

}
