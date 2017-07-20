package com.wap.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wap.model.BillingAddress;

public class BillingAddressStore {
	volatile static Map<Integer,BillingAddress> database = new ConcurrentHashMap<>();
	public static int genId() {
		return database.size() + 1;
	}
	
	public static void updateBillingAddress(int id, BillingAddress p) {
		database.put(id, p);
	}
}
