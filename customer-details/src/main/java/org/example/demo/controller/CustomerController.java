package org.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.demo.db.MyConnectionFactory;
import org.example.demo.model.Customer;

@WebServlet(urlPatterns = "/add_customer.do")
public class CustomerController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MyConnectionFactory myConnectionFactory;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doProcess(req, resp);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doProcess(req, resp);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		
		List<String> erros=new ArrayList<String>();
		String firstn=req.getParameter("fn");
		String stream=req.getParameter("st");
		String lastn=req.getParameter("ln");
		String email=req.getParameter("email");
		
		
		if(firstn.length()<0)
		{
			erros.add("provided First Name ");
		}
                if(lastn.length()<0)
		{
			erros.add("provided last Name ");
		}
		if(stream.equals("UNKNOWN"))
		{
			erros.add("please select stream..");
		}
		 if(email.length()<0)
		{
			erros.add("provided email ");
		}
		
		
		
		if(!erros.isEmpty())
		{
			req.setAttribute("ERROR", erros);
			RequestDispatcher view=req.getRequestDispatcher("add_customer.view");
			view.forward(req, resp);
		}
		else
		{
			try {
				myConnectionFactory=new MyConnectionFactory();
				Connection connection=myConnectionFactory.getMyConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("insert into customer1(first_name,last_name,stream,email) values(?,?,?,?)");
				preparedStatement.setString(1,firstn );
				preparedStatement.setString(2, lastn);
				preparedStatement.setString(3, stream);
                preparedStatement.setString(4, email);
				preparedStatement.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
			req.setAttribute("CUSTOMER", new Customer(firstn, lastn, stream,email));
			RequestDispatcher view=req.getRequestDispatcher("success.view");
			view.forward(req, resp);
		}
		
		

	}

}
