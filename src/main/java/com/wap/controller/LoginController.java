package com.wap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wap.model.Account;
import com.wap.repository.AccountStore;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		HttpSession s = req.getSession();
		if (s.getAttribute("origin_url") == null) {
			String referer = req.getHeader("Referer");
			int pos = referer.indexOf("webstore");
			String real_uri = referer.substring(pos);
			if (real_uri.equals("webstore") ||
					real_uri.equals("webstore/")) {
				real_uri = "/products";
			} else {
				real_uri = real_uri.substring(7);
			}
			s.setAttribute("origin_url", real_uri);
			//System.out.println("1: " + real_uri);
		}
		
		req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		String userName = req.getParameter("username");
		System.out.println(req.getRequestURI());
		Account u = AccountStore.getAccount(userName);
		if (u != null && u.getPassword().equals(req.getParameter("password"))) {
			s.setAttribute("username", u);
			Cookie cookie = null;
			String rememberMe = req.getParameter("rememberMeChk");
			if ("on".equals(rememberMe)) { 
				cookie = new Cookie("username", u.getUserName());
				cookie.setMaxAge(3600*24*30); //in seconds
				resp.addCookie(cookie);
			} else {
				cookie = new Cookie("username", null);
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
			req.setAttribute("error_login_msg", "");
			if (u.getUserId() != 0) {
				String previous_page = (String)s.getAttribute("origin_url");
				previous_page = previous_page == null ? "/products" : previous_page;
				s.setAttribute("origin_url", null);
				resp.sendRedirect(getServletContext().getContextPath() + previous_page);
				//req.getRequestDispatcher(previous_page).forward(req, resp);
				//req.getRequestDispatcher("/products").forward(req, resp);
				//req.getRequestDispatcher((String)req.getAttribute("javax.servlet.forward.request_uri")).forward(req, resp);
			} else {
				resp.sendRedirect(getServletContext().getContextPath() + "/products_admin");
			}
		} else {
			req.setAttribute("error_login_msg", "Invalid user name / password!");
			req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
		}
	}
}
