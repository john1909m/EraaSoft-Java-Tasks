package com.servlet.controller;

import java.io.IOException;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.item.service.userService;
import com.item.service.impl.userServiceImpl;
import com.servlet.model.User;

/**
 * Servlet implementation class userController
 */
@WebServlet("/userController")
public class userController extends HttpServlet {

	@Resource(name = "jdbc/users")
	private DataSource dataSource;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action =request.getParameter("action");
		if(Objects.isNull(action)) {
			action="showRegister";
		}
		switch(action) {
			case "login":
				login(request,response);
				break;
			case "register":
				register(request,response);
				break;
			case "showRegister":
				showRegister(request,response);
				break;
			case "showLogin":
				showlogin(request,response);
		}
		
		
		
		
		
		
	}

	private void showlogin(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
        try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void showRegister(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Register.html");
        try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void register(HttpServletRequest request, HttpServletResponse response) {
		String fName=request.getParameter("first_name");
		String lName=request.getParameter("last_name");
		String phone=request.getParameter("phone_number");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User user=new User(fName,lName,phone,email,password);
		userService userService=new userServiceImpl(dataSource);
		boolean isUserRegisterd=userService.register(user);
		
		if (isUserRegisterd) {
			try {
				response.sendRedirect("userController?action=showLogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
		    request.setAttribute("error", "Registration failed. Please try again.");
		    try {
				showRegister(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User user=new User(email,password);
		userService userService=new userServiceImpl(dataSource);
		User isUserLoggedin=userService.login(user);
		if(isUserLoggedin!=null) {
			try {
				HttpSession session=request.getSession();
				session.setAttribute("currentUser", user);
				response.sendRedirect("ItemController");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			request.setAttribute("error", "Registration failed. Please try again.");
		    try {
				showlogin(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
