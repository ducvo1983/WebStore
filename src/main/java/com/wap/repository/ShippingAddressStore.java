package com.wap.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wap.model.ShippingAddress;

public class ShippingAddressStore {
	volatile static Map<Integer,ShippingAddress> database = new ConcurrentHashMap<>();
	public static int genId() {
		return database.size() + 1;
	}
	
	public static void updateShippingAddress(int id, ShippingAddress p) {
		database.put(id, p);
	}
}
