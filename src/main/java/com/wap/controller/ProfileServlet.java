package com.wap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wap.model.Account;
import com.wap.model.Order;
import com.wap.repository.AccountStore;
import com.wap.repository.OrderStore;


public class ProfileServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TODO: I have to receive userId as parameter so that I can get all orders related to that user. 
		//Note that each order contains many cart items, and each cartItem contains one product. 
		
		HttpSession s = req.getSession();
		Account account = (Account) s.getAttribute("username");
		//int userId = Integer.parseInt(req.getParameter("userId"));
		List<Order> orders = OrderStore.getOrders(account.getUserId());
		//TODO: I have to get the user information
		//when the user click profile, the client should send userName parameter. 
		//String userName = req.getParameter("userName");
		//Account account = AccountStore.getAccount(userName);
		req.setAttribute("currentUser", account);
		req.setAttribute("orders", orders);
		s.setAttribute("currentUser", account);
		s.setAttribute("orders", orders);
		req.getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
