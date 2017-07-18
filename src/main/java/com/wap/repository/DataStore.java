package com.wap.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wap.model.Product;

public class DataStore {
	
	static Map<Integer,Product> database = new ConcurrentHashMap<>();
	
	static {
		database.put(1, new Product("#1","men shoe",25,"images/shoem2.png"));
		database.put(2, new Product("#2","men shoe",30,"images/shoem2.png"));
		database.put(3, new Product("#3","men shoe",35,"images/shoem2.png"));
		database.put(4, new Product("#4","men shoe",40,"images/shoem2.png"));
		database.put(5, new Product("#5","women shoe",25,"images/shoef2.png"));
		database.put(6, new Product("#6","women shoe",25,"images/shoef2.png"));
		database.put(7, new Product("#7","women shoe",35,"images/shoef2.png"));
		database.put(8, new Product("#8","women shoe",40,"images/shoef2.png"));
		database.put(9, new Product("#9","men shirt",30,"images/shoem2.png"));
		database.put(10, new Product("#10","men shirt",30,"images/shoem2.png"));
		database.put(11, new Product("#11","men shirt",30,"images/shoem2.png"));
		database.put(12, new Product("#12","men shirt",30,"images/shoem2.png"));
		database.put(13, new Product("#13","girl shirt",30,"images/shoef2.png"));
		database.put(14, new Product("#14","girl shirt",30,"images/shoef2.png"));
		database.put(15, new Product("#15","girl shirt",30,"images/shoef2.png"));
		database.put(16, new Product("#16","girl shirt",30,"images/shoef2.png"));
	}

	public Map<Integer, Product> getDatabase() {
		return database;
	}
	
	public static List<Product> getAllProducts(){
	  
		
		return new ArrayList<Product>(database.values());
	}
	
	
	
	
	

}
