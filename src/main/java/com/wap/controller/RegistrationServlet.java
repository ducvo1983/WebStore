package com.wap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wap.model.Account;
import com.wap.repository.AccountStore;

@WebServlet("/signup")
public class RegistrationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.getRequestDispatcher("/jsp/signUp.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		String phoneNo = req.getParameter("phoneNo");
		if (AccountStore.getAccount(userName) == null) {
			Account acc = new Account(AccountStore.getId(), userName, password, firstName, lastName, email, phoneNo, 1);
			AccountStore.addAccount(userName, acc);
			HttpSession s = req.getSession();
			s.setAttribute("username", acc);
			req.setAttribute("error_signup_msg", "");
			req.getRequestDispatcher("/checkout").forward(req, resp);
		} else {
			req.setAttribute("error_signup_msg", "The user name " + userName + " is already taken. Please choose another one!" );
			doGet(req, resp);
		}
	}
}
