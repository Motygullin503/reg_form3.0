<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: UseR7
  Date: 14.10.2016
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administration</title>
</head>
<body>
    <c:forEach var="user" items="${list}">
        ${user.getEmail()}   ${user.getPassword()}<br>
    </c:forEach>

        </body>
</html>
