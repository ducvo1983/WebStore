package com.wap.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wap.model.Order;

public class OrderStore {
		volatile static Map<Integer,Order> database = new ConcurrentHashMap<>();

		public Map<Integer, Order> getDatabase() {
			return database;
		}
		
		public static List<Order> getAllOrders(){
		  
			
			return new ArrayList<Order>(database.values());
		}
		

		public static Order getOrder(String id) {
		     
			return database.get(Integer.parseInt(id));
	   }
		
		
		public static Order deleteOrder(String id) {
			return database.remove(Integer.parseInt(id));
		}
		
		public static int genId() {
			return database.size() + 1;
		}
		public static void updateOrder(int id, Order p) {
			database.put(id, p);
		}
	}

