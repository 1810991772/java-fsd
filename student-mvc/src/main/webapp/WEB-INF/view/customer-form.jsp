<%--
  Created by IntelliJ IDEA.
  User: Nilay
  Date: 18-04-2022
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>customer form</title>
    <style>
        .error {
            color: red;
        }

    </style>
</head>
<body>
<i>Fill out the form. Asterisk (*) means required.</i>
<br><br>
<form:form action="processForm" method="post" modelAttribute="customer">
    First Name(*):<form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br/><br/>
    Last Name(*):<form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <input type="submit" value="add customer">

</form:form>
</body>
</html>
