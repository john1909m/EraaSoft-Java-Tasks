package com.servlet.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("currentUser")==null) {
			response.sendRedirect("userController?action=showLogin");
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
				
			default:
				getItems(request, response);
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void getItems(HttpServletRequest request, HttpServletResponse response){
		ItemService itemService=new ItemServiceImpl(dataSource);
		List<Item> items=itemService.getItems();
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
		getItems(request, response);
	}

	
}
