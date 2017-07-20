package com.wap.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wap.model.Account;
import com.wap.model.BillingAddress;
import com.wap.model.Order;
import com.wap.model.PaymentCart;
import com.wap.model.ShippingAddress;
import com.wap.model.ShoppingCart;
import com.wap.repository.BillingAddressStore;
import com.wap.repository.OrderStore;
import com.wap.repository.PaymentCartStore;
import com.wap.repository.ShippingAddressStore;

public class OrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("ORDER".equals(req.getParameter("command"))) {
			String sFullName = req.getParameter("sfullname");
			String sStreet = req.getParameter("sstreet");
			String sCity = req.getParameter("scity");
			String sState = req.getParameter("sState");
			String sCountry = req.getParameter("scountry");
			
			ShippingAddress shpAddress = new ShippingAddress(ShippingAddressStore.genId(), sFullName, sStreet, sCity, sState, sCountry, "");
			ShippingAddressStore.updateShippingAddress(shpAddress.getId(), shpAddress);
			String bFullName = req.getParameter("bfullname");
			String bStreet = req.getParameter("bstreet");
			String bCity = req.getParameter("bcity");
			String bState = req.getParameter("bState");
			String bCountry = req.getParameter("bcountry");
			BillingAddress billAddress = new BillingAddress(BillingAddressStore.genId(), bFullName, bStreet, bCity, bState, bCountry, "");
			BillingAddressStore.updateBillingAddress(billAddress.getId(), billAddress);
			String nameOnCard = req.getParameter("nameoncard");
			String cardNumber = req.getParameter("cardNumber");
			
			HttpSession s = req.getSession();
			Account acc = (Account) s.getAttribute("username");
			PaymentCart pCart = new PaymentCart(PaymentCartStore.genId(), "Master", nameOnCard, cardNumber, 0, 0, 0, acc);
			PaymentCartStore.updatePaymentCart(pCart.getId(), pCart);
			ShoppingCart cart = (ShoppingCart) s.getAttribute("cart");
			
			if (cart != null) {
				Order order = new Order(OrderStore.genId(), LocalDate.now(), cart.getTotalAmount(), pCart, shpAddress, billAddress, cart.getItems());
				OrderStore.updateOrder(OrderStore.genId(), order);
				cart.finalizeCart();
				s.setAttribute("cart", null);
				resp.sendRedirect("/jsp/thankyou.jsp");
			}
		}
	}
}
