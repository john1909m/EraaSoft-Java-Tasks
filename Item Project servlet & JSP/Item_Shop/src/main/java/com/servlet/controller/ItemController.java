package com.servlet.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.item.service.ItemService;
import com.item.service.impl.ItemServiceImpl;
import com.servlet.model.Item;

//http://localhost:8080/Item_Shop/ItemController
//http://localhost:8080/Item_Shop/ItemController?action=getItems
//http://localhost:8080/Item_Shop/ItemController?action=getItem
//http://localhost:8080/Item_Shop/ItemController?action=addItem
//http://localhost:8080/Item_Shop/ItemController?action=editItem
//http://localhost:8080/Item_Shop/ItemController?action=removeItem
//http://localhost:8080/Item_Shop/ItemController?action=fiselfbhskj

@WebServlet("/ItemController")
public class ItemController extends HttpServlet {

	@Resource(name = "jdbc/item")
	private DataSource dataSource;
	
	@Resource(name = "jdbc/item_details")
	private DataSource detailDataSource;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isLoggedIn=false;
		Cookie[] cookies=request.getCookies();
		if(cookies != null) {
			for(Cookie c:cookies) {
				if ("isLoggedIn".equals(c.getName()) && "true".equals(c.getValue())) {
		            isLoggedIn = true;
		            break;
		        }
			}
		}
		HttpSession session = request.getSession(false);
		if(!isLoggedIn && (session == null || session.getAttribute("currentUser") == null)) {
		    response.sendRedirect("userController?action=showLogin");
		    return;
		}

		String action =request.getParameter("action");
		if(Objects.isNull(action)) {
			action="getItems";
		}

		switch(action) {
			case "getItems":
				getItems(request,response);
				break;
			case "getItem":
				getItem(request,response);
				break;
			case "addItem":
				addItem(request,response);
				break;
			case "editItem":
				editItem(request,response);
				break;
			case "removeItem":
				removeItem(request,response);
				break;
			case "saveDetails":
				saveDetails(request,response);
				break;
			case "showDetails":
				showDetails(request,response);
				break;
			case "editDetails":
				editDetails(request,response);
				break;
			case "removeDetails":
				removeDetails(request,response);
				break;
			default:
				getItems(request, response);
				break;
		}
	}

	private void showDetails(HttpServletRequest request, HttpServletResponse response) {
		Long id=Long.parseLong(request.getParameter("item_id"));
		Item item=new Item(id);
		ItemService itemService=new ItemServiceImpl(detailDataSource);
		Item itemDetails=itemService.showDetails(id);
		request.setAttribute("itemDetails", itemDetails);
//		request.setAttribute("itemId", id);
		System.out.println("-----> Forwarding to EditDetails.jsp with ID=" + id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EditDetails.jsp");
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

	private void editDetails(HttpServletRequest request, HttpServletResponse response) {
		Long id=Long.parseLong(request.getParameter("item_id"));
		String desc=request.getParameter("desc");
		String brand=request.getParameter("brand");
		String expirationDateStr=request.getParameter("expiration_date");
		java.sql.Date expirationDate = java.sql.Date.valueOf(expirationDateStr);
		Item item=new Item(id,desc,brand,expirationDate);
		ItemService itemService=new ItemServiceImpl(detailDataSource);
		boolean itemDetailsSaved=itemService.editDetails(item);
		getItems(request, response);
		
	}

	private void removeDetails(HttpServletRequest request, HttpServletResponse response) {
		Long id=Long.parseLong(request.getParameter("id"));
		ItemService itemService=new ItemServiceImpl(detailDataSource);
		boolean isDetailsRemoved= itemService.removeDetails(id);
		getItems(request, response);
		
	}

	private void saveDetails(HttpServletRequest request, HttpServletResponse response) {
		Long id=Long.parseLong(request.getParameter("item_id"));
		String desc=request.getParameter("desc");
		String brand=request.getParameter("brand");
		String expirationDateStr=request.getParameter("expiration_date");
		java.sql.Date expirationDate = java.sql.Date.valueOf(expirationDateStr);
		Item item=new Item(id,desc,brand,expirationDate);
		ItemService itemService=new ItemServiceImpl(detailDataSource);
		boolean itemDetailsSaved=itemService.saveDetails(item);
		getItems(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void getItems(HttpServletRequest request, HttpServletResponse response){
		ItemService itemService=new ItemServiceImpl(dataSource);
		List<Item> items=itemService.getItems();
		for (Item item : items) {
			item.setHasDetails(itemService.hasDetails(item.getId()));	
		}
		request.setAttribute("allItems",items);
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("ShowItemsAll/ShowItems.jsp");
		    dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getItem(HttpServletRequest request, HttpServletResponse response){

		  try {
		        Long id = Long.parseLong(request.getParameter("id")); 
		        ItemService itemService = new ItemServiceImpl(dataSource);
		        Item thisItem = itemService.getItem(id);

		        if (thisItem != null) {
		            List<Item> items = new ArrayList<>();
		            items.add(thisItem);
		            request.setAttribute("allItems", items);
		        } else {
		            request.setAttribute("allItems", new ArrayList<Item>());
		        }

		        RequestDispatcher dispatcher = request.getRequestDispatcher("ShowItemsAll/ShowItems.jsp");
		        dispatcher.forward(request, response);

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
			
		
	}
	private void addItem(HttpServletRequest request, HttpServletResponse response){
		String name=request.getParameter("name");
		Double price=Double.parseDouble(request.getParameter("price"));
		int totalNumber=Integer.parseInt(request.getParameter("totalNumber"));
		Item item =new Item(name,price,totalNumber);
		ItemService itemService=new ItemServiceImpl(dataSource);
		boolean isItemAdded=itemService.addItem(item);
		getItems(request, response);
		
	}
	private void editItem(HttpServletRequest request, HttpServletResponse response){
		Long id=Long.parseLong(request.getParameter("id"));
		String name=request.getParameter("name");
		Double price=Double.parseDouble(request.getParameter("price"));
		int totalNumber=Integer.parseInt(request.getParameter("totalNumber"));
		Item item =new Item(id,name,price,totalNumber);
		ItemService itemService=new ItemServiceImpl(dataSource);
		boolean isItemEdited=itemService.editItem(item);
		getItems(request,response);
	}
	private void removeItem(HttpServletRequest request, HttpServletResponse response){
		Long id=Long.parseLong(request.getParameter("id"));
		ItemService itemService=new ItemServiceImpl(dataSource);
		boolean isItemRemoved=itemService.removeItem(id);
		if(!isItemRemoved) {
			request.setAttribute("itemRemoved", id);
		}
		getItems(request, response);
	}

	
}
