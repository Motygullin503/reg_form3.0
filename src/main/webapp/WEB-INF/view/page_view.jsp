<%--
  Created by IntelliJ IDEA.
  User: UseR7
  Date: 28.09.2016
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Material Design Bootstrap -->
    <link href="<c:url value="/css/mdb.min.css"/>" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="<c:url value="/form.css"/>">

    <meta charset="UTF-8">
    <title>Registration Form</title>
</head>
<body>

<c:if test="${not empty message}">
    <h3>${message}</h3>
</c:if>



<form action="" id="reg" name='registration' method="POST">

    <h2>Register</h2>
    <p>Enter fullname (required, at least 3 characters, 20 symbols)</p>
    <div class="md-form">
        <i class="fa fa-user fa-3x prefix"></i>
        <input type="text" name="fullname" id="fullname" class="form-control"
               <c:if test="${not empty name}">value="${name}" </c:if>>
        <label for="fullname" class="">for example: Aaron Smith</label>
    </div>
    <br/>

    <p>Enter Email (required)</p>
    <div class="md-form">
        <i class="fa fa-envelope prefix"></i>
        <input type="text" name="email" id="email" class="form-control"
               <c:if test="${not empty email}">value="${email}" </c:if>>
        <label for="email" class="">example@example.com</label>
    </div>
    <br/>
    <p>Enter password </p>
    <div class="md-form">
        <i class="fa fa-lock prefix"></i>
        <input type="password" name="password" id="password" class="form-control"
               <c:if test="${not empty password}">value="${password}" </c:if>>
        <label for="password" class="">(required, at least 3 characters) </label>
    </div>

    <br/>
    <p>Enter password again</p>
    <div class="md-form">
        <i class="fa fa-lock prefix"></i>
        <input type="password" name="password2" id="password2" class="form-control"
               <c:if test="${not empty password2}">value="${password2}" </c:if>>
        <label for="password2" class="">You're not robot, right?</label><br/>
    </div>
    <p>Choose your city</p>
    <label for="city_select"></label>
    <select name=city id=city_select>
        <option value=London>London</option>
        <option value=Alabama>Alabama</option>
        <option value=Paris>Paris</option>
        <option value=Rome>Rome</option>
        <option value=Moskva>Moscow</option>
    </select>

    <br><br>
    <p>Choose gender</p>
    <label>
        <input type="radio" name="gender" value="male" checked>
    </label>Male<br>
    <label>
        <input type="radio" name="gender" value="female">
    </label>Female<br>
    <br> About yourself (optional) <br>
    <label>
        <textarea name=about cols=20 rows=10><c:if test="${not empty about}">${about} </c:if></textarea>
    </label>
    <br>
    <p>Enter your favourite singer or band</p>
    <div class="md-form">
        <i class="fa fa-music fa-3x prefix"></i>
            <input type="text" name="fav_singer" id="fav_singer" class="form-control"
                   <c:if test="${not empty fav_singer}">value="${fav_singer}" </c:if>>
            <label for="fav_singer" class="">for example: Maroon 5</label>
    </div>
    <br/>
    <p>Choose category you interested in</p>
    <br>
    <label>
        <input type="checkbox" value=politics name="topic">
    </label>Politics
    <br>
    <label>
        <input type="checkbox" value=autonews name="topic">
    </label>Autonews
    <br>
    <label>
        <input type="checkbox" value=hardware name="topic" checked>
    </label>Technology
    <br>
    <label>
        <input type="checkbox" value=microsoft name="topic">
    </label>Microsoft news
    <br>
    <label>
        <input type="checkbox" value=space name="topic">
    </label>Space
    <br>
    <label>
        <input type="checkbox" value=medicine name="topic">
    </label>Medicine
    <br>
    <label>
        <input type="checkbox" value=mobile name="topic">
    </label>Mobile technology
    <br>
    <label>
        <input type="checkbox" value=economics name="topic">
    </label>Economics
    <br><br>
    <p>Choose kind of sport you interested in</p>
    <br>
    <label>
        <input type="checkbox" value=football name="sport" checked>Football
    </label>
    <br>
    <label>
        <input type="checkbox" value=hockey name="sport">Hockey
    </label>
    <br>
    <label>
        <input type="checkbox" value=basketball name="sport">Basketball
    </label>
    <br>
    <label>
        <input type="checkbox" value=autosport name="sport">Autosport
    </label>
    <br>
    <label>
        <input type="checkbox" value=boxing name="sport">Boxing
    </label>
    <br>
    <br>
    <p>Enter your favourite team or player</p>
    <div class="md-form">
        <i class="fa fa-soccer-ball-o fa-3x prefix"></i>
        <input type="text" name="fav_team" id="fav_team" class="form-control"
               <c:if test="${not empty fav_team}">value="${fav_team}" </c:if>>
        <label for="fav_team" class="">for example: Рубин Казань or Роберт Левандовски</label>
    </div>
    <br/>

    <label>
        <input type=checkbox checked name=sub value=yes>
    </label> Subscribe for newsletter<br>
    <br>
    <button type="submit" value="Register" name="submit" onclick="validate()" class="btn btn-primary btn-lg">Register
    </button>
</form>

<a href="<c:url value="/authentification"/>">Already have an account? Sign in</a>

<script src="webjars/jquery/1.9.1/jquery.js"></script>
<script src="webjars/jquery-validation/1.15.1/jquery.validate.js"></script>
<script src="<c:url value="/js/check.js"/>"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>

<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/tether.min.js"/>"></script>
 <!-- MDB core JavaScript -->
<script type="text/javascript" src="<c:url value="/js/mdb.min.js"/>"></script>
<script>
        $('input[type="checkbox"]').on('change', function() {
$('input[name="' + this.name + '"]').not(this).prop('checked', false);
});
</script>
</body>
</html>
