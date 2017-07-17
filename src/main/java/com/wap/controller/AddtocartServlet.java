package com.wap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wap.model.Product;
import com.wap.repository.DataStore;



@WebServlet(urlPatterns={"/addtocartServlet",""})
public class AddtocartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html;charset=UTF-8");
        // PrintWriter out = response.getWriter();

        HttpSession session = req.getSession();
        List<Product> products = DataStore.getAllProducts();
        session.setAttribute("products", products);
        resp.sendRedirect("catalog.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	

}
