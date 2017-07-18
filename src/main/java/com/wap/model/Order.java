package com.wap.model;

import java.time.LocalDate;

public class Order {
	     
	    private int orderId;
	    private LocalDate orderDate;
	    private int orderNum;
	    private double amount;
	    
	    
	    
	    
	    
		/**
		 * @param orderId
		 * @param orderDate
		 * @param orderNum
		 * @param amount
		 */
		public Order(int orderId, LocalDate orderDate, int orderNum, double amount) {
			super();
			this.orderId = orderId;
			this.orderDate = orderDate;
			this.orderNum = orderNum;
			this.amount = amount;
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
		 * @return the orderNum
		 */
		public int getOrderNum() {
			return orderNum;
		}
		/**
		 * @param orderNum the orderNum to set
		 */
		public void setOrderNum(int orderNum) {
			this.orderNum = orderNum;
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
