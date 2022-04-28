<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<String> list=(List<String>) request.getAttribute("ERROR");
if(list!=null)
{
	out.println("please correct the bellow error(s)<br/>");
	for(String s:list)
	{
		out.println("<font color='red'>"+s+"</font><br/>");
	}
}
%>

<form action="add_league.do" method="post">

<label>Year</label>
<input type="text" name="year"><br/>
<label>Season</label>
<select name="season">
<option value="UNKNOWN">Select...</option>
<option value="summer">Summer</option>
<option value="winter">winter</option>
<option value="autumn">Autumn</option>
</select><br/>
<label>Title</label>
<input type="text" name="title"><br/>
<input type="submit" value="add a new league">
</form>
</body>
</html>