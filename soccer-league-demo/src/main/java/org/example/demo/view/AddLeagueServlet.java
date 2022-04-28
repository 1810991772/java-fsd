package org.example.demo.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add_league.view")
public class AddLeagueServlet extends HttpServlet{

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
		PrintWriter out= resp.getWriter();
		@SuppressWarnings("unchecked")
		List<String> list=(List<String>)req.getAttribute("ERROR");
		if(list!=null)
		{
			out.println("please correct the bellow error(s)</br>");
			for(String s:list)
			{
				out.println("<font color='red'>"+s+"</font></br>");
			}
			
			out.println("<a href='add_league.html'>try again</a><br/>");
		}
		out.println("<form action='add_league.do' method='post'>");
		
		out.println("Year<input type='text' name='year'><br/>");
		out.println("Season<select name='season'><option value='UNKNOWN'>Select...</option><option value='Summer'>Summer</option></select><br/>");
		out.println("Title<input type='text' name='title'><br/><input type='submit' value='add new league'></form>");
	}
	

}