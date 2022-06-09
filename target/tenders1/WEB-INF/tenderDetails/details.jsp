<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Tender details</title>
    <style>
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }

        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        .title{
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-weight: bold;
        }
        .imageAndText {position: relative;}
        .imageAndText .col {position: absolute; z-index: 1; top: 0; left: 0;}

    </style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<div class="imageAndText">
    <img src="${contextPath}/resources/img/wall.jpg" class="align-center img-responsive">
    <div class="col">
        <div class="col-sm-12 title">
            <p>ProjectTrade</p>
            <p>Tender system</p>
        </div>
    </div>
</div>


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${contextPath}/">ProjectTrade</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${contextPath}/cabinet"><span class="glyphicon glyphicon-home"></span> Personal cabinet</a></li>
            <li><a href="${contextPath}/registration"><span class="glyphicon glyphicon-user"></span> Sign in</a></li>
            <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Exit</a></li>
        </ul>
    </div>
</nav>


<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <p><a href="${contextPath}/rules">Rules</a></p>
        </div>
        <div class="col-sm-8 text-left">

            <h3 class="text-center">Tender details</h3>
            <p>Project name: <strong>${tender.title}</strong></p>
            <p>Customer: <strong>${tender.user.name}</strong></p>
            <p>Price: <strong>${tender.price} UAH</strong></p>
            <p>Date: <strong>${tender.date}</strong></p>
            <p>Description: ${tender.description}</p>

            <c:if test="${tender.active==true}">
                <c:if test="${user.username!=tender.user.name}">
                    <p class="text-center "><a class="btn btn-primary" href="${contextPath}/doOffer?tenderId=${tender.id}">Оставить заявку на участие</a></p>
                </c:if>
            </c:if>
        </div>

        <div class="col-sm-2 sidenav">
            <p><a href="${contextPath}/tenders?active=all">All tenders</a></p>
        </div>
    </div>
</div>

<footer class="container-fluid text-center">
    <p>©ProjectTrade, 2022</p>
</footer>

</body>
</html>

