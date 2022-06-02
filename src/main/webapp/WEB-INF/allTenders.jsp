<jsp:useBean id="sortBy" scope="request" type="boots.controller.HomeController"/>
<%@ page contentType="text/html;charset=UTF-8" language="en" %>
<!DOCTYPE html>
<html>
<head>
    <title>ProjectTrade</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script>
        jQuery(document).ready(function(){
            $("a[href*='sortBy=${sortBy}']").parent().addClass("orderBy");
        })
    </script>
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
            /*text-shadow: 3px 2px red;*/
        }
        .imageAndText {position: relative;}
        .imageAndText .col {position: absolute; z-index: 1; top: 0; left: 0;}
    </style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="imageAndText">
    <img src="${contextPath}/resources/img/wall.jpg" class="align-center img-responsive" alt="bdrewf" width="2492"
         height="230">
    <div class="col">
        <div class="col-sm-12 title">
            <p>ProjectTrade</p>
            <p>Tendering system</p>
        </div>
    </div>
</div>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${contextPath}/">ProjectTrade</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${contextPath}/cabinet"><span class="glyphicon glyphicon-home"></span> Personal Area</a></li>
            <li><a href="${contextPath}/registration"><span class="glyphicon glyphicon-user"></span>Sign up</a></li>
            <c:choose>
                <jsp:useBean id="principal" scope="request" type="boots.controller.HomeController"/>
                <c:when test="${principal==null}">
                    <li><a href="${contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Sign in</a></li>
                </c:when>
            </c:choose>
        </ul>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <p><a href="${contextPath}/rules">Tender Rules</a></p>
        </div>
        <div class="col-sm-8 text-left">
            <jsp:useBean id="tenders" scope="request" type="java.util.List"/>
            <c:forEach items="${tenders}" var="tender">
                <tr>
                    <div class="panel panel-default">

                        <div class="panel-heading">
                            <div class="container-fluid">
                                <div class="col-sm-11">
                                    <a href="${contextPath}/tendDetails?tenderId=${tender.id}"><strong>${tender.title}</strong></a>
                                </div>
                            </div>
                        </div>

                        <div class="panel-body">
                            <ul>
                                <li>Customer: <strong>${tender.user.name}</strong></li>
                                <li>Normative cost: <strong>${tender.price} BYN</strong></li>
                                <li>Start date: <strong>${tender.date}</strong>
                                </li>
                            </ul>
                        </div>

                    </div>
                </tr>
            </c:forEach>
        </div>
        <div class="col-sm-2 sidenav">
            <p><a href="${contextPath}/tenders?sortBy=date&orderBy=ascending"><span class="glyphicon glyphicon-arrow-down"></span>Date</a></p>
            <p><a href="${contextPath}/tenders?sortBy=price&orderBy=ascending"><span class="glyphicon glyphicon-arrow-down"></span>Price</a></p>
            <p><a href="${contextPath}/tenders?sortBy=date&orderBy=descending"><span class="glyphicon glyphicon-arrow-up"></span>Date</a></p>
            <p><a href="${contextPath}/tenders?sortBy=price&orderBy=descending"><span class="glyphicon glyphicon-arrow-up"></span>Price</a></p>
        </div>
    </div>
</div>

<footer class="container-fluid text-center">
    <p>©ProjectTrade, 2018</p>
</footer>
</body>
</html>