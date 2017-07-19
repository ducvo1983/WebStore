package com.wap.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wap.model.Account;
import com.wap.model.Product;

public class AccountStore {
	
	volatile static Map<String,Account> database = new ConcurrentHashMap<>();
	
	static {
		database.put("admin", new Account(getId(), "admin", "Admin123", "Administrator", "", "admin@gmail.com", "661-2226-333", 1));
		database.put("saint_paul", new Account(getId(), "saint_paul", "SaintPaul123", "Saint", "Paul", "saintpaultinga@gmail.com", "661-2224-333", 1));
		database.put("mohammed", new Account(getId(), "mohammed", "Mohammed123", "Mohammed", "", "mohammed@gmail.com", "661-2224-323", 1));
		database.put("duc", new Account(getId(), "duc", "Duc123", "Duc", "Vo", "ducvo1983@gmail.com", "661-2224-223", 1));
	}

	public Map<String, Account> getDatabase() {
		return database;
	}
	
	public static List<Account> getAccounts(){
		return new ArrayList<Account>(database.values());
	}
	
	public static Account getAccount(String userName) {
		return database.get(userName);
	}
	
	public static void addAccount(String userName, Account acc) {
		database.put(userName, acc);
	}

	public static int getId() {
		return database.size();
	}
}
