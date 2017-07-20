package com.wap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wap.model.CartItem;
import com.wap.model.ShoppingCart;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	ObjectMapper mapper = new ObjectMapper();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//req.getRequestDispatcher("/jsp/checkout.jsp").forward(req, resp);
		String action = req.getParameter("action");
		if ("CHECKQUANTITY".equals(action)) {
			HttpSession s = req.getSession();
			ShoppingCart cart = (ShoppingCart) s.getAttribute("cart");
			Map<String,Integer> quantityViolent = new TreeMap<>();
			if (cart != null) {
				for (CartItem cartItem : cart.getItems()) {
					if (!cartItem.satisfyQuantity()) {
						System.out.println("quantity: " + cartItem.getQuantity() + ", product_quantity: " + cartItem.getProduct().getQuantity());
						quantityViolent.put(cartItem.getProduct().getId(), cartItem.getProduct().getQuantity());
					}
				}
			}
			//if (quantityViolent.size() > 0) {
				PrintWriter out = resp.getWriter();
				try{
					String json = mapper.writeValueAsString(quantityViolent);
					out.print(json);
				}catch (JsonGenerationException e) {
					e.printStackTrace();
				}
			//}
		} else if ("CHECKOUT".equals(action)) {
			doPost(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//req.getRequestDispatcher("/checkout").forward(req, resp);
		req.getRequestDispatcher("/jsp/checkout.jsp").forward(req, resp);
	}
}
