package org.example.demo.view;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.demo.model.Customer;

@WebServlet(urlPatterns = "/success.view")
public class SuccessPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);

	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		Customer customer=(Customer) req.getAttribute("CUSTOMER");
		
		out.println("<p> Customer Added Sucessfully..</p>");
		out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getStream()+" "+customer.getEmail()+"<br/>");
		out.println("<a href='index.html'>go to home</a>");
		
	
	}

}
