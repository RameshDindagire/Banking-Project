package com.banking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.dao.UserDao;
import com.banking.pojo.User;

@WebServlet("/userurl")
public class UserController extends HttpServlet {
	String action;
	String userName, userRole, userEmail, userPassword;

	User user;
	UserDao userDao = new UserDao();

	HttpSession session;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		action = req.getParameter("action");
		session = req.getSession();

		if (action != null && action.equals("login")) {
			resp.sendRedirect("login.jsp");
		} else if (action != null && action.equals("register")) {
			resp.sendRedirect("register.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action = req.getParameter("action");

		if (action != null && action.equals("login")) {
			userEmail = req.getParameter("userEmail");
			userPassword = req.getParameter("userPassword");

			user = userDao.login(userEmail, userPassword);

			if (user != null) {
				session.setAttribute("user", user);
				session.setAttribute("msg", "Login successfull!!");
				resp.sendRedirect("index.jsp");
			} else {
				session.setAttribute("msg", "Login unsuccessfull!!!");
				resp.sendRedirect("login.jsp");
			}
		} else if (action != null && action.equals("register")) {

			userName = req.getParameter("userName");
			userEmail = req.getParameter("userEmail");
			userRole = req.getParameter("userRole");
			userPassword = req.getParameter("userPassword");
			// HERE WE GET THE DATA FROM REGISTRATION FORM

			user = new User(userName, userEmail, userPassword, userRole);
			// HERE WE CREATE OBJECT OF THAT DATA
			System.out.println(user);
			userDao.register(user);
			// HERE WE SAVE THAT OBJECT INTO DATABASE

			session.setAttribute("msg", "Your registration is successfull!!!!<br/> Please Login here");
			resp.sendRedirect("login.jsp");
		} else if (action != null && action.equals("logout")) {
			session.invalidate();
			session = req.getSession();
			session.setAttribute("msg", "Log out successfull!!");
			resp.sendRedirect("index.jsp");
		}
	}
}

