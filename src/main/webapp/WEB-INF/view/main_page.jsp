<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: UseR7
  Date: 05.10.2016
  Time: 2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Material Design Bootstrap -->
    <link href="<c:url value="/css/mdb.min.css"/>" rel="stylesheet">

    <!-- Your custom styles (optional) -->
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

    <title>Your page</title>
</head>
<body>
<div class="col-md-5">
    <!--Image Card-->
    <div class="card hoverable">
        <div class="card-image">
            <div class="view overlay hm-white-slight z-depth-1">
                <img src="http://mdbootstrap.com/images/reg/reg%20(2).jpg" class="img-responsive" alt="">
                <a href="#">
                    <div class="mask waves-effect"></div>
                </a>
            </div>
        </div>
        <div class="card-content">
            <h5>Card title</h5>
            <p>
                <c:forEach var="String" items="${list}">
                ${String}<br>
            </c:forEach>
            </p>
            <p>
                <c:forEach var="String" items="${list2}">
                ${String}<br>
            </c:forEach>
            </p>

        </div>
    </div>
    <!--Image Card-->
</div>
<div class="col-md-2">
    <!--Image Card-->
    <div class="card hoverable">
        <div class="card-image">
            <div class="view overlay hm-white-slight z-depth-1">
                <img src="<c:url value="/img/Logomakr_5l0prY.png"/>" class="img-responsive" alt="">
                <a href="#">
                    <div class="mask waves-effect"></div>
                </a>
            </div>
        </div>
        <div class="card-content">
            <c:forEach var="user" items="${preferences}">
                <h2>${user}</h2><br>
            </c:forEach>
        </div>
    </div>
</div>
<div class="col-md-5">
    <!--Image Card-->
    <div class="card hoverable">
        <div class="card-image">
            <div class="view overlay hm-white-slight z-depth-1">
                <img src="http://mdbootstrap.com/images/reg/reg%20(2).jpg" class="img-responsive" alt="">
                <a href="#">
                    <div class="mask waves-effect"></div>
                </a>
            </div>
        </div>
        <div class="card-content">
            <c:if test="${not empty city}">${city}</c:if>,
            <c:if test="${not empty description}">${description}</c:if>,
            <c:if test="${not empty temperature}">${temperature}</c:if>
            <br>
            <c:if test="${not empty username}"><b>${username}</b></c:if>
            <br>
            <c:if test="${not empty fav_singer}">${fav_singer}</c:if>
            <c:if test="${not empty playcount}">${playcount}</c:if>
            <br>
            <a href="<c:url value="/authentification?status=0"/>">Log out</a>
        </div>
    </div>
    <!--Image Card-->


    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>

    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>

    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="<c:url value="/js/mdb.min.js"/>"></script>
</body>
</html>
