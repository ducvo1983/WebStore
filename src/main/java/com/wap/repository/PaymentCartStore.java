package com.wap.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wap.model.PaymentCart;

public class PaymentCartStore {
	volatile static Map<Integer,PaymentCart> database = new ConcurrentHashMap<>();
	public static int genId() {
		return database.size() + 1;
	}
	
	public static void updatePaymentCart(int id, PaymentCart p) {
		database.put(id, p);
	}
}
