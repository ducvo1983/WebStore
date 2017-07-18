package com.wap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wap.model.Account;

@WebServlet("/signup")
public class RegistrationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.getRequestDispatcher("/signup.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		/*String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		
		Account acc = new Account(firstName, lastName, userName, password, address);
		DataStore.addAccount(acc);
		HttpSession s = req.getSession();
		s.setAttribute("username", acc);
		req.getRequestDispatcher("checkout").forward(req, resp);
		*/
	}
}
