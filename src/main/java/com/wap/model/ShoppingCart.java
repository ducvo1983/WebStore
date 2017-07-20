package com.wap.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.jsp.PageContext;

public class ShoppingCart {
	
	private static Map<Integer, CartItem> itemsMap = null;
	private int numberOfItems = 0;
	
	public ShoppingCart() {
		itemsMap = new ConcurrentHashMap<Integer, CartItem>();
	}

	// Adds items to the shopping cart
	public synchronized void add(int productID, Product p, int qty, boolean increment) {
		
		if(itemsMap.containsKey(productID)){
			updateQuantity(productID, qty, increment);
		}else{
	     CartItem newItem = new CartItem(p,qty);
		 itemsMap.put(productID, newItem);
		}
	}

	// Update items in the shopping cart
	public synchronized void updateQuantity(int productID, int quantity, boolean increment){
		System.out.println("-------Update Called----------"+quantity);
			CartItem scItem = (CartItem) itemsMap.get(productID);
			if (!increment) {
				scItem.setQuantity(quantity);
			} else {
				scItem.incrQuantity(quantity);
			}
		
	}

	// Remove items from the shopping cart
	public synchronized void remove(Integer productID) {
		if (itemsMap.containsKey(productID)) {
			CartItem scItem = itemsMap.get(productID);
			if (scItem.getQuantity() <= 1) {
				itemsMap.remove(productID);
			}
			numberOfItems--;
		}
	}

	// Clear all items in the shopping cart
	public synchronized void clear() {
		itemsMap.clear();
		numberOfItems = 0;
	}

	// Get All the Items in the Shopping Cart
	public synchronized List<CartItem> getItems() {
		List<CartItem> listOfItems = new ArrayList<CartItem>();
		listOfItems.addAll(this.itemsMap.values());
		return listOfItems;
	}

	// Get Number of Items in the Shopping Cart
	public synchronized int getNumberOfItems() {
		numberOfItems = 0;
		Iterator<CartItem> scItemIterator = getItems().iterator();

		while (scItemIterator.hasNext()) {
			CartItem items = scItemIterator.next();
			numberOfItems += items.getQuantity();
		}

		return numberOfItems;
	}

	// Get the Total Value of the Shopping Cart
	public synchronized double getTotalAmount() {

		double amount = 0.0;
		Iterator<CartItem> anotherSCItemIterator = getItems()
				.iterator();
		while (anotherSCItemIterator.hasNext()) {
			CartItem anotherSCItem = anotherSCItemIterator.next();
			Product product = anotherSCItem.getProduct();
			amount += (anotherSCItem.getQuantity() * product.getPrice());
		}

		return amount;
	}

	public synchronized CartItem getCartItem(int key) {
		return itemsMap.get(key);
	}
	// Checks whether a particular product
	// is already present in the cart
	public static boolean checkProductInCart(PageContext pageContext) {
		int productID = (int) pageContext.findAttribute("productID");
		if (itemsMap == null)
			itemsMap = new ConcurrentHashMap<Integer, CartItem>();
		if (itemsMap.containsKey(productID)) {
			
			return true;
		}
		return false;
	}
	
	public void finalizeCart() {
		Iterator<CartItem> scItemIterator = getItems().iterator();

		while (scItemIterator.hasNext()) {
			CartItem item = scItemIterator.next();
			Product p = item.getProduct();
			int pQuantity = p.getQuantity();
			p.setQuantity(pQuantity - item.getQuantity());
		}
	}
}
