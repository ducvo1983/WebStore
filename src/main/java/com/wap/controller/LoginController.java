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
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		String userName = req.getParameter("username");
		
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
				req.getRequestDispatcher("/checkout").forward(req, resp);
			} else {
				resp.sendRedirect(getServletContext().getContextPath() + "/products_admin");
			}
		} else {
			req.setAttribute("error_login_msg", "Invalid user name / password!");
			req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
		}
	}
}
