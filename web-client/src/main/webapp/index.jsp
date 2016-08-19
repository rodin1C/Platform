<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/poker.css" type="text/css">
  <script src="${pageContext.request.contextPath}/resource/js/jquery/jquery-1.12.4.js"></script>
  <script src="${pageContext.request.contextPath}/resource/js/bootstrap/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resource/js/angular/angular.min.js"></script>
  <script src="${pageContext.request.contextPath}/resource/js/angular/angular-resource.min.js"></script>
  <script src="${pageContext.request.contextPath}/resource/js/angular/angular-route.min.js"></script>

</head>

<body>
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Project name</a>
      </div>
      <div id="navbar" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#about">About</a></li>
          <li><a href="#contact">Contact</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </nav>

  <div class="container">

    <div class="starter-template">
      <h1>Bootstrap starter template</h1>
      <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
      <p><input type="button" value="Connect to Websocket..." onclick="onClick()"></p>
    </div>

  </div>

<script type="text/javascript">


</script>


</body>
</html>
