<%@ include file="/WEB-INF/views/includes/taglibs.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html ng-app="pokerApp">
<head>
    <title>Welcome to Poker game</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/poker.css" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/angular/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/angular/angular-resource.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/angular/angular-route.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/app/main.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/app/services.js"></script>


</head>

<body ng-controller="PokerCtrl">
<nav class="navbar navbar-default ">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand img">
                <img src="${pageContext.request.contextPath}/resources/images/poker.png">
            </a>

        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>

            <!--/.nav-collapse -->
            <!-- LOGIN -->
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail3">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail3" placeholder="Email">
                </div>
                <div class="form-group">
                    <label class="sr-only" for="exampleInputPassword3">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
                <button type="submit" class="btn btn-default">Sign in</button>
            </form>
        </div>
    </div>
</nav>

<div class="container">

    <div class="starter-template">
        <%--<h1>Bootstrap starter template</h1>--%>

        <%--<p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a--%>
        <%--mostly barebones HTML document.</p>--%>

        <%--<p><input type="button" value="Connect to Websocket..." onclick="onClick()"></p>--%>
    </div>

</div>

<script type="text/javascript">


</script>


</body>
</html>
