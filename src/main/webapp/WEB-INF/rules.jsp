<%@ page contentType="text/html;charset=UTF-8"  %>
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
            <p><a href="${contextPath}/rules">Rules</a></p>
        </div>
        <div class="col-sm-8 text-left">

            <h2 class="text-center"> Rules of online tenders</h2>
            <ul>
                <li>Тендерные торги на сайте начинаются в день, указанный в детальной информации конкретного тендера в 01:00 по минскому времени. Заявки на участие в тендере принимаются до указанного времени.</li>
                <li>В деталях тендера указана нормативная стоимость проектно-изыскательский работ, предлагаемая участником тендера стоимость может быть ниже или выше нормативной стоимости.</li>
                <li>Для получения дополнительных сведений о проекте, Пользователь обращается к Заказчику по контактам, указанным в деталях тендера.</li>
                <li>Победителем тендера считается участник, предложивший наименьшую стоимость выполнения проектно-изыскательский работ.</li>
                <li>Результаты тендера (победитель и стоимость) будут доступны в деталях тендера и в Личном кабинете пользователя (при условии участия в тендере).</li>
                <li>После успешного проведения тендера Победитель связывается с Заказчиком (или наоборот) для заключения договора на выполнение проектно-изыскательский работ.</li>
                <li>После отправки заявки на проведение тендера, она проходит проверку Администратором.</li>
                <li>В случае если минимальную цену предложат двое или более Участников, победителем призенается участник, предложивший цену раньше.</li>
                <li>Участник вправе предложить новую цену, если предыдущая ставка сделана им же.</li>
            </ul>
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
