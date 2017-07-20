package com.wap.model;

import java.time.LocalDate;
import java.util.List;

public class Order {
	     
	    private int orderId;
	    private LocalDate orderDate;
	    private double amount;
		private PaymentCart cart;
		private ShippingAddress shpAdress;
		private BillingAddress billAddress;
	    private List<CartItem> items;
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
		/**
		 * @return the billAddress
		 */
		public BillingAddress getBillAddress() {
			return billAddress;
		}
		/**
		 * @param billAddress the billAddress to set
		 */
		public void setBillAddress(BillingAddress billAddress) {
			this.billAddress = billAddress;
		}
		/**
		 * @return the items
		 */
		public List<CartItem> getItems() {
			return items;
		}
		/**
		 * @param items the items to set
		 */
		public void setItems(List<CartItem> items) {
			this.items = items;
		}
		/**
		 * @param orderId
		 * @param orderDate
		 * @param amount
		 */
		public Order(int orderId, LocalDate orderDate, double amount, PaymentCart cart, ShippingAddress shpAdress, BillingAddress billAddress, List<CartItem> items) {
			super();
			this.orderId = orderId;
			this.orderDate = orderDate;
			this.amount = amount;
			this.cart = cart;
			this.shpAdress = shpAdress;
			this.billAddress = billAddress;
			this.items = items;
		}
		/**
		 * @return the orderId
		 */
		public int getOrderId() {
			return orderId;
		}
		/**
		 * @param orderId the orderId to set
		 */
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		/**
		 * @return the orderDate
		 */
		public LocalDate getOrderDate() {
			return orderDate;
		}
		/**
		 * @param orderDate the orderDate to set
		 */
		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}
		/**
		 * @return the amount
		 */
		public double getAmount() {
			return amount;
		}
		/**
		 * @param amount the amount to set
		 */
		public void setAmount(double amount) {
			this.amount = amount;
		}
	    
	    
	
	

}
