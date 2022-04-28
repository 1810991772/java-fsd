package org.example.demo.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.demo.db.MyConnectionFactory;
import org.example.demo.model.League;

@WebServlet(urlPatterns = "/list_leagues.view")
public class ListLeaguesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<League> leagueList = null;
	MyConnectionFactory myConnectionFactory;

    public ListLeaguesServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		leagueList = new LinkedList<League>();
		myConnectionFactory=new MyConnectionFactory();
		Connection connection;
	
		String pageTitle = "Duke’s Soccer League: List Leagues";
		
		 // Specify the content type is HTML
		 response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 // Generate the HTML response
		 out.println("<html>");
		out.println("<head>");
		out.println("<title>"+ pageTitle + "</title>");
		out.println("</head>");
		out.println("<body bgcolor='white'>");
		
		 // Generate page heading
		 out.println("<!-- Page Heading -->");
		out.println("<table border='1' cellpadding='5' cellspacing='0' width='400'>");
		out.println("<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>");
		out.println("<td><h3>" + pageTitle + "</h3></td>");
		out.println("</tr>");
		out.println("</table>");

		out.println("<p>");
		out.println("The set of soccer leagues are:");
		out.println("</p>");
		out.println("<ul>");
		try {
			connection = myConnectionFactory.getMyConnection();
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM LEAGUE ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int year=rs.getInt(2);
				String season=rs.getString(3);
				String title=rs.getString(4);
				out.println(" <li>" + year+"  "+season+ " "+ title+"</li>");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 out.println("</ul>");
		
		 out.println("</body>");
		out.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
