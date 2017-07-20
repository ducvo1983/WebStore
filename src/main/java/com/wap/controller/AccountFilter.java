package com.wap.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wap.model.Account;

@WebFilter(
filterName = "webstoreFilter",
urlPatterns = { "/checkout", "/products_admin", "/product_controller", "/order" },
servletNames = { "checkout", "products_admin", "product_controller", "order" }
)
public class AccountFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession s = req.getSession();
		if (s == null ||
			s.getAttribute("username") == null) {
			String action = req.getParameter("action");
			boolean isValid = ("PRODUCTDETAIL".equals(action)) ||
					("CHECKQUANTITY".equals(action));
			if (!isValid) {
				if ("CHECKOUT".equals(action)){
					s.setAttribute("origin_url", "/checkout?action=CHECKOUT");
				}
				resp.sendRedirect(req.getServletContext().getContextPath() + "/jsp/login.jsp");
			} else {
				chain.doFilter(req, resp);
			}
		} else {
			//TODO: Check if the user is not admin but he/she wants to navigate to admin pages
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
