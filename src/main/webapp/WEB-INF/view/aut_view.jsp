<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: UseR7
  Date: 04.10.2016
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="<c:url value="/css/mdb.min.css"/>" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/form.css"/>">
    <title>Authentification page</title>
</head>
<body>
<form action="" method="POST">
    <h2>Sign In</h2>

    <p>Enter Email</p>
    <div class="md-form">

        <input type="text" name="email" id="email" class="form-control"
               <c:if test="${not empty email}">value="${email}" </c:if>>
        <label for="email" class=""></label>
    </div>
    <br/>
    <p>Enter password</p>
    <div class="md-form">
            <input type='password' id="password" name='password' class="form-control">
            <label for="password" class=""></label>
    </div>
    <br/>
    <br>
    <button type='submit' value='Sign up' class="btn btn-primary btn-lg">Sign in</button>
</form>
<c:if test="${not empty message}">
    <h3>${message}</h3><br>
</c:if>

<i class="fa fa-arrow-circle-o-left fa-2x prefix"></i> <a href="<c:url value="/registration?status=0"/>">To registration page</a>

<script src="webjars/jquery/1.9.1/jquery.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/tether.min.js"/>"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>

<!-- MDB core JavaScript -->
<script type="text/javascript" src="<c:url value="/js/mdb.min.js"/>"></script>
</body>
</html>
