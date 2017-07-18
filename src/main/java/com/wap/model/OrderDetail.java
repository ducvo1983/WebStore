package com.wap.model;

public class OrderDetail {
	
	private int id;
	private Order order;
	private PaymentCart cart;
	private ShippingAddress shpAdress;
	
	
	/**
	 * @param id
	 * @param order
	 * @param cart
	 * @param shpAdress
	 */
	public OrderDetail(int id, Order order, PaymentCart cart, ShippingAddress shpAdress) {
		super();
		this.id = id;
		this.order = order;
		this.cart = cart;
		this.shpAdress = shpAdress;
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
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	/**
	 * @return the cart
	 */
	public PaymentCart getCart() {
		return cart;
	}
	/**
	 * @param cart the cart to set
	 */
	public void setCart(PaymentCart cart) {
		this.cart = cart;
	}
	/**
	 * @return the shpAdress
	 */
	public ShippingAddress getShpAdress() {
		return shpAdress;
	}
	/**
	 * @param shpAdress the shpAdress to set
	 */
	public void setShpAdress(ShippingAddress shpAdress) {
		this.shpAdress = shpAdress;
	}
	
	

}
