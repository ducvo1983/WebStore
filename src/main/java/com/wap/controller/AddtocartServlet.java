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
import com.wap.model.ShoppingCart;
import com.wap.repository.ProductStore;



@WebServlet("/addServlet")
public class AddtocartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-------sizeeee----------");
		resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html;charset=UTF-8");
        // PrintWriter out = response.getWriter();
         
        HttpSession session = req.getSession();
        List<Product> products = ProductStore.getAllProducts();
        System.out.println("-------sizeeee----------"+products.size());
        session.setAttribute("products", products);
        resp.sendRedirect("catalog.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if("ADD".equals(action)){
			addToCart(request, response);
		}
		

	}
	
	public void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String productiID = request.getParameter("productID");
		String qty = request.getParameter("quantity");
		System.out.println("-------Servlet quantity----------"+qty);
		// Request the Session
		HttpSession hs = request.getSession();
		ShoppingCart cart = (ShoppingCart) hs.getAttribute("cart");

		// Checks whether cart is available
		// If not, then will create a cart object
		if (cart == null) {
			cart = new ShoppingCart();
			hs.setAttribute("cart", cart);
		}

		boolean increment = qty.charAt(0) == '+';
		int prodID = Integer.parseInt(productiID);
		int pqty = !increment ? Integer.parseInt(qty) : Integer.parseInt(qty.substring(1));
		// Check whether the product id is not null
		// If not null then add the product to the cart

		if (prodID != 0) {
			
			Product p = ProductStore.getProductInDB(prodID);

			cart.add(prodID, p, pqty, increment);
			
			hs.setAttribute("cart_size", cart.getNumberOfItems());
			System.out.println("-------Items size----------"+cart.getNumberOfItems());
			//response.sendRedirect(getServletContext().getContextPath()+"/jsp/catalog.jsp");

		} 
	}
	
	
	

}
