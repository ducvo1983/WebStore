package com.wap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wap.model.CartItem;
import com.wap.model.Product;
import com.wap.model.ShoppingCart;
import com.wap.repository.ProductStore;


public class ProductController extends HttpServlet {
	ObjectMapper mapper = new ObjectMapper();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = req.getParameter("command");
		String id = req.getParameter("id");
		Product product = null;
		if ("DISPLAY".equals(command)) {
			product = ProductStore.getProduct(id);
		} else if ("DELETE".equals(command)){
			product = ProductStore.deleteProduct(id);
			//resp.sendRedirect(getServletContext().getContextPath() + "/products_admin");
		}else if("PRODUCTDETAIL".equals(command)){
			//product = ProductStore.getProduct(id);
			req.setAttribute("product", ProductStore.getProduct(id));
			ShoppingCart cart = (ShoppingCart)(req.getSession().getAttribute("cart"));
			int quantity = 0;
			if (cart != null) {
				CartItem cartItem = cart.getCartItem(Integer.parseInt(id));
				if (cartItem != null) {
					quantity = cartItem.getQuantity();
				}
			}
			req.setAttribute("cartItemQuantity", quantity);
			req.getRequestDispatcher("/jsp/productDetails.jsp").forward(req, resp);
			return;
		}
		
		PrintWriter out = resp.getWriter();
		try{
			out.print(mapper.writeValueAsString(product));
		}catch (JsonGenerationException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getParameter("command");
		String id = null;
		Product product = null;
		if ("DISPLAY".equals(command)) {
			id = req.getParameter("id");
			product = ProductStore.getProduct(id);
		} else if ("UPDATE".equals(command)) {
			String jsonSting = req.getParameter("product");
			product = mapper.readValue(jsonSting, Product.class);
			
			if (product != null) {
				ProductStore.updateProduct(product.getId(), product);
			}
			//resp.sendRedirect(getServletContext().getContextPath() + "/products_admin");
		} else if ("ADD".equals(command)) {
			String jsonSting = req.getParameter("product");
			product = mapper.readValue(jsonSting, Product.class);
			
			if (product != null) {
				product.setId(String.valueOf(ProductStore.genId()));
				ProductStore.updateProduct(product.getId(), product);
			}
		}
		
		if (product != null) {
			PrintWriter out = resp.getWriter();
			try{
				out.print(mapper.writeValueAsString(product));
			}catch (JsonGenerationException e) {
				e.printStackTrace();
			}
		}
	}
}
