package com.wap.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wap.model.Product;

public class ProductStore {
	
	volatile static Map<Integer,Product> database = new ConcurrentHashMap<>();
	
	static {
		database.put(genId(), new Product(String.valueOf(genId()),"men shoe",25,"shoem1","good shoes", "", 100));
		database.put(genId(), new Product(String.valueOf(genId()),"men shoe",30,"shoem2","good shoes", "", 100));
		database.put(genId(), new Product(String.valueOf(genId()),"men shoe",35,"shoem3","good shoes", "",100));
		database.put(genId(), new Product(String.valueOf(genId()),"men shoe",40,"shoem4","good shoes", "",100));
		database.put(genId(), new Product(String.valueOf(genId()),"women shoe",25,"shoef1","good shoes", "",100));
		database.put(genId(), new Product(String.valueOf(genId()),"women shoe",25,"shoef2","good shoes", "",100));
		database.put(genId(), new Product(String.valueOf(genId()),"women shoe",35,"shoef3","good shoes", "",100));
		database.put(genId(), new Product(String.valueOf(genId()),"women shoe",40,"shoef4","good shoes", "",100));
		database.put(genId(), new Product(String.valueOf(genId()),"men shirt",30,"shirt1","good shirt", "",100));
		database.put(genId(), new Product(String.valueOf(genId()),"men shirt",30,"shirt2","good shirt", "",100));
		database.put(genId(), new Product(String.valueOf(genId()),"men shirt",30,"shirt3","good shirt", "",100));
		database.put(genId(), new Product(String.valueOf(genId()),"men shirt",500,"shirt4","good shoirt", "",100));
		database.put(genId(), new Product(String.valueOf(genId()),"girl shirt",30,"gshirt1","good shirt", "",100));
		database.put(genId(), new Product(String.valueOf(genId()),"girl shirt",35,"gshirt2","good shirt", "",100));
		database.put(genId(), new Product(String.valueOf(genId()),"girl shirt",40,"gshirt3","good shirt", "",100));
		database.put(genId(), new Product(String.valueOf(genId()),"girl shirt",30,"gshirt4","good shirt", "",100));
	}

	public Map<Integer, Product> getDatabase() {
		return database;
	}
	
	public static List<Product> getAllProducts(){
	  
		
		return new ArrayList<Product>(database.values());
	}
	

	public static synchronized boolean checkProductInDB(int productId) {
	     
		return database.containsKey(productId);
   }
	
	public static synchronized Product getProductInDB(int productId) {
	     
		return database.get(productId);
   }
	
	
	public static void updateProduct(String id, Product p) {
		database.put(Integer.parseInt(id), p);
	}
	
	public static Product getProduct(String id) {
		return database.get(Integer.parseInt(id));
	}
	public static Product deleteProduct(String id) {
		return database.remove(Integer.parseInt(id));
	}
	
	public static int genId() {
		return database.size() + 1;
	}

}
