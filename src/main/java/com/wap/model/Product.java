package com.wap.model;

public class Product {

	 
    private String id;
    private String name;
    private double price;
    private String image;
    private String shortDescription;
    private String fullDescription;
    private int quantity;
    
    
    public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param image
	 * @param description
	 * @param quantity
	 */
	public Product(String id, String name, double price, String image, String shortDescription, String fullDescription, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.shortDescription = shortDescription;
		this.fullDescription = fullDescription;
		this.quantity = quantity;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the shortDescription
	 */
	public String getShortDescription() {
		return shortDescription;
	}
	/**
	 * @param shortDescription the shortDescription to set
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	/**
	 * @return the fullDescription
	 */
	public String getFullDescription() {
		return fullDescription;
	}
	/**
	 * @param fullDescription the fullDescription to set
	 */
	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}
    
    
   
}
