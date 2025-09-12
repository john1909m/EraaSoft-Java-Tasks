package com.servlet.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
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
	public boolean emailExists(String email) {
		String sql = "SELECT * FROM USERS WHERE EMAIL = ?";
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, email);
			try {
				ResultSet rs=ps.executeQuery();
				return rs.next();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	private void register(HttpServletRequest request, HttpServletResponse response) {
		String fName=request.getParameter("first_name");
		if(fName==null || fName.isEmpty()) {
			request.setAttribute("fNameError", "First name is required");
		}
		String lName=request.getParameter("last_name");
		if(lName==null || lName.isEmpty()) {
			request.setAttribute("lNameError", "Last name is required");
		}
		String phone=request.getParameter("phone_number");
		if(phone==null || phone.isEmpty()) {
			request.setAttribute("phoneError", "Phone number is required");
		}
		String email=request.getParameter("email");
		if(email==null || email.isEmpty()) {
			request.setAttribute("emailError", "Email is required");
		}
		if(emailExists(email)) {
			request.setAttribute("emailExist", "Email is already registerd");

		}
		String password=request.getParameter("password");
		if(password==null || password.isEmpty()) {
			request.setAttribute("passwordError", "Password is required");
		}
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
			request.setAttribute("error", "Email or password is incorrect");
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
