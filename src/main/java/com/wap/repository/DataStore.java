package com.wap.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wap.model.Product;

public class DataStore {
	
	static Map<Integer,Product> database = new ConcurrentHashMap<>();
	
	static {
		database.put(1, new Product("#1","men shoe",25,"shoem1"));
		database.put(1, new Product("#2","men shoe",30,"shoem2"));
		database.put(1, new Product("#3","men shoe",35,"shoem3"));
		database.put(1, new Product("#4","men shoe",40,"shoem4"));
		database.put(1, new Product("#5","women shoe",25,"shoef1"));
		database.put(1, new Product("#6","women shoe",25,"shoef2"));
		database.put(1, new Product("#7","women shoe",35,"shoef3"));
		database.put(1, new Product("#8","women shoe",40,"shoef4"));
		database.put(2, new Product("#9","men shirt",30,"mshirt1"));
		database.put(2, new Product("#10","men shirt",30,"mshirt2"));
		database.put(2, new Product("#11","men shirt",30,"mshirt3"));
		database.put(2, new Product("#12","men shirt",30,"mshirt4"));
		database.put(2, new Product("#13","girl shirt",30,"gshirt1"));
		database.put(2, new Product("#14","girl shirt",30,"gshirt2"));
		database.put(2, new Product("#15","girl shirt",30,"gshirt3"));
		database.put(2, new Product("#16","girl shirt",30,"gshirt4"));
	}

	public Map<Integer, Product> getDatabase() {
		return database;
	}
	
	public static List<Product> getAllProducts(){
	  
		
		return new ArrayList<Product>(database.values());
	}
	
	
	
	
	

}
