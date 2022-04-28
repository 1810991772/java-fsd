<%--
  Created by IntelliJ IDEA.
  User: Nilay
  Date: 14-04-2022
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>input form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student" method="post">

    <form:input path="firstName"/><br/>
    <form:input path="lastName"/><br/>
    <form:select path="country" >
        <form:option value="India" label="India"/>
        <form:option value="France" label="France"/>
        <form:option value="Brazil" label="Brazil"/>
    </form:select><br/>
    <input type="submit" value="create student">

</form:form>
</body>
</html>
