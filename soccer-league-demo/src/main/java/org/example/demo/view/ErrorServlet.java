package org.example.demo.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/error.view=")
public class ErrorServlet extends HttpServlet {

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

	@SuppressWarnings("unchecked")
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		List<String> list=(List<String>)req.getAttribute("ERROR");
		out.println("please correct the bellow error(s)</br>");
		for(String s:list)
		{
			out.println("<font color='red'>"+s+"</font></br>");
		}
		
		out.println("<a href='add_league.html'>try again</a>");
	}

}
