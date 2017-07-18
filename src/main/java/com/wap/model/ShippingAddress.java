package com.wap.model;

public class ShippingAddress {
	
	private int id;
	private String addrName;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	/**
	 * @param id
	 * @param addrName
	 * @param street1
	 * @param street2
	 * @param city
	 * @param state
	 * @param country
	 * @param zipcode
	 */
	public ShippingAddress(int id, String addrName, String street1, String street2, String city, String state,
			String country, String zipcode) {
		super();
		this.id = id;
		this.addrName = addrName;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
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
	 * @return the addrName
	 */
	public String getAddrName() {
		return addrName;
	}
	/**
	 * @param addrName the addrName to set
	 */
	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}
	/**
	 * @return the street1
	 */
	public String getStreet1() {
		return street1;
	}
	/**
	 * @param street1 the street1 to set
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	/**
	 * @return the street2
	 */
	public String getStreet2() {
		return street2;
	}
	/**
	 * @param street2 the street2 to set
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
	
	

}
