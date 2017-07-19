package com.wap.repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wap.model.Order;
import com.wap.model.Product;

public class OrderStore {
	
	
	//this is just dummy data: 
	volatile static Map<Integer,Product> database = new ConcurrentHashMap<>();
	public static List<Order> getOrders(int userId) {
		//get all orders for the user whose id is userId. 
		
		
		return null;
	}

}
