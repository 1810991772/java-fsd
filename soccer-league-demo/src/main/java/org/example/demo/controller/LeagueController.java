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
import org.example.demo.model.League;

@WebServlet(urlPatterns = "/add_league.do")
public class LeagueController extends HttpServlet {

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
		String year=req.getParameter("year");
		int iYear=0;
		String season=req.getParameter("season");
		String title=req.getParameter("title");
		
		try {
			iYear=Integer.parseInt(year);
		} catch (Exception e) {
			erros.add("year field must be numeric");
			
		}
		
		if(iYear!=2022)
		{
			erros.add("provided year is not the current year.");
		}
		if(season.equals("UNKNOWN"))
		{
			erros.add("please select season..");
		}
		
		if(title.length()<10)
		{
			erros.add("invalid title.");
		}
		
		
		if(!erros.isEmpty())
		{
			req.setAttribute("ERROR", erros);
			RequestDispatcher view=req.getRequestDispatcher("add_league.jsp");
			view.forward(req, resp);
		}
		else
		{
			try {
				myConnectionFactory=new MyConnectionFactory();
				Connection connection=myConnectionFactory.getMyConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("insert into league(year,season,title) values(?,?,?)");
				preparedStatement.setInt(1, iYear);
				preparedStatement.setString(2, season);
				preparedStatement.setString(3, title);
				preparedStatement.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
			req.setAttribute("LEAGUE", new League(iYear, season, title));
			RequestDispatcher view=req.getRequestDispatcher("success.jsp");
			view.forward(req, resp);
		}
		
		

	}

}
