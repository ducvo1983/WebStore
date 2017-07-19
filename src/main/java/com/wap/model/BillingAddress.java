package com.wap.model;

public class BillingAddress extends Address{
	
	Payment payment;

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
}
