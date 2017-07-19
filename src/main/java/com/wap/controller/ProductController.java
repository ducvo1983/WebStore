package com.wap.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wap.model.Product;
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
			//req.setAttribute("product", ProductStore.getProduct(id));
			//req.getRequestDispatcher("/jsp/updateProduct.jsp").forward(req, resp);
			product = ProductStore.getProduct(id);
		} else if ("DELETE".equals(command)){
			product = ProductStore.deleteProduct(id);
			//resp.sendRedirect(getServletContext().getContextPath() + "/products_admin");
		}else if("PRODUCTDETAIL".equals(command)){
			//product = ProductStore.getProduct(id);
			req.setAttribute("product", ProductStore.getProduct(id));
			req.getRequestDispatcher("/jsp/productdetail.jsp").forward(req, resp);
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
		if ("DISPLAY".equals(command)) {
			id = req.getParameter("id");
			Product product = ProductStore.getProduct(id);
			PrintWriter out = resp.getWriter();
			try{
				out.print(mapper.writeValueAsString(product));
			}catch (JsonGenerationException e) {
				e.printStackTrace();
			}
		} else if ("UPDATE".equals(command)) {
			id = req.getParameter("id");
			Product p = ProductStore.getProduct(id);
			if (p != null) {
				String name = req.getParameter("name");
				double price = Double.parseDouble(req.getParameter("price"));
				String image = req.getParameter("image");
				String fullDescription = req.getParameter("fullDescription");
				String shortDescription = req.getParameter("shortDescription");
				int quantity = Integer.parseInt(req.getParameter("quantity"));
				p.setName(name);
				p.setPrice(price);
				p.setImage(image);
				p.setQuantity(quantity);
				p.setShortDescription(shortDescription);
				p.setFullDescription(fullDescription);
				PrintWriter out = resp.getWriter();
				try{
					out.print(mapper.writeValueAsString(p));
				}catch (JsonGenerationException e) {
					e.printStackTrace();
				}
			}
			//resp.sendRedirect(getServletContext().getContextPath() + "/products_admin");
		} else if ("ADD".equals(command)) {
			Product p = new Product();
			String name = req.getParameter("name");
			double price = Double.parseDouble(req.getParameter("price"));
			String image = req.getParameter("image");
			String fullDescription = req.getParameter("fullDescription");
			String shortDescription = req.getParameter("shortDescription");
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			p.setId(String.valueOf(ProductStore.genId()));
			p.setName(name);
			p.setPrice(price);
			p.setImage(image);
			p.setQuantity(quantity);
			p.setShortDescription(shortDescription);
			p.setFullDescription(fullDescription);
			ProductStore.updateProduct(p.getId(), p);
			PrintWriter out = resp.getWriter();
			try{
				out.print(mapper.writeValueAsString(p));
			}catch (JsonGenerationException e) {
				e.printStackTrace();
			}
		}
	}
}
