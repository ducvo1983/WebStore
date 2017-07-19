package com.wap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.repository.ProductStore;

public class ProductListAdminController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("products", ProductStore.getAllProducts());
		req.getRequestDispatcher("/jsp/productListForAdmin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("products", ProductStore.getAllProducts());
		req.getRequestDispatcher("/jsp/productListForAdmin.jsp").forward(req, resp);
	}
}
