package com.wap.model;

public class PaymentCart {
	
	private int id;
	private String type;
	private String cardName;
	private String cardNumber;
	private int expiryMonth;
	private int expiryYear;
	private int cvc;
	private User holderName;
	
	
	
	
	/**
	 * @param id
	 * @param type
	 * @param cardName
	 * @param cardNumber
	 * @param expiryMonth
	 * @param expiryYear
	 * @param cvc
	 * @param holderName
	 */
	public PaymentCart(int id, String type, String cardName, String cardNumber, int expiryMonth, int expiryYear,
			int cvc, User holderName) {
		super();
		this.id = id;
		this.type = type;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.cvc = cvc;
		this.holderName = holderName;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the cardName
	 */
	public String getCardName() {
		return cardName;
	}
	/**
	 * @param cardName the cardName to set
	 */
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * @return the expiryMonth
	 */
	public int getExpiryMonth() {
		return expiryMonth;
	}
	/**
	 * @param expiryMonth the expiryMonth to set
	 */
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	/**
	 * @return the expiryYear
	 */
	public int getExpiryYear() {
		return expiryYear;
	}
	/**
	 * @param expiryYear the expiryYear to set
	 */
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
	/**
	 * @return the cvc
	 */
	public int getCvc() {
		return cvc;
	}
	/**
	 * @param cvc the cvc to set
	 */
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	/**
	 * @return the holderName
	 */
	public User getHolderName() {
		return holderName;
	}
	/**
	 * @param holderName the holderName to set
	 */
	public void setHolderName(User holderName) {
		this.holderName = holderName;
	}
	
	
	
	
}
