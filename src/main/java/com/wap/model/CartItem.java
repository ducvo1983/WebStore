package com.wap.model;

public class CartItem {
	
	private Product product;
	private int quantity;
	
	
	
	
	/**
	 * @param product
	 * @param quantity
	 */
	public CartItem(Product product, int qty) {
		super();
		this.product = product;
		this.quantity = qty;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
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
		this.quantity += quantity;
	}
	
	
	public double getTotalPrice(){
		
		return this.getQuantity() * this.getProduct().getPrice();
	}
	
	
}
