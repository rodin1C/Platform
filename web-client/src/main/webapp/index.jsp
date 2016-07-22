<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

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
  <script src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resource/js/jquery/jquery.atmosphere.js"></script>

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

  $(function() {

    if (!window.console) {
      console = {log: function() {}};
    }

    var asyncHttpStatistics = {
      transportType: 'N/A',
      responseState: 'N/A',
      numberOfTotalMessages: 0,
      numberOfTweets: 0,
      numberOfErrors: 0
    };

    function refresh() {

      console.log("Refreshing data tables...");

      $('#transportType').html(asyncHttpStatistics.transportType);
      $('#responseState').html(asyncHttpStatistics.responseState);
      $('#numberOfCallbackInvocations').html(asyncHttpStatistics.numberOfTotalMessages);
      $('#numberOfTweets').html(asyncHttpStatistics.numberOfTweets);
      $('#numberOfErrors').html(asyncHttpStatistics.numberOfErrors);

    }

    function onMessage(response) {
      asyncHttpStatistics.numberOfTotalMessages++;
      refresh();
      var message = response.responseBody;
      var result;

      try {
        result =  $.parseJSON(message);
      } catch (e) {
        asyncHttpStatistics.numberOfErrors++;
        console.log("An error ocurred while parsing the JSON Data: " + message.data + "; Error: " + e);
        return;
      }

      //asyncHttpStatistics.numberOfCallbackInvocations++;
      //asyncHttpStatistics.transportType = response.transport;
      //asyncHttpStatistics.responseState = response.responseState;

      //$.atmosphere.log('info', ["response.state: " + response.state]);
      //$.atmosphere.log('info', ["response.transport: " + response.transport]);

      var resultType = result['@class'];
      console.log('Object type returned: ' + resultType);

      if (resultType == "org.springframework.mvc.samples.atmosphere.model.TwitterMessage") {
        handleTwitterMessage(new TwitterMessage(result));
      } else if (resultType == "org.springframework.mvc.samples.atmosphere.model.TwitterMessages") {
        console.log('raw-----' + result);
        handleTwitterMessages(new TwitterMessages(result.twitterMessages));
      } else if (resultType == "org.springframework.mvc.samples.atmosphere.model.StatusMessage") {
        handleStatusMessage(new StatusMessage(result));
      } else {
        throw "resultType " + resultType + " is not handled.";
      }

      refresh();
    }

    function handleTwitterMessage(data) {

      console.log("Handling Twitter Message...");

      var visible = $('#placeHolder').is(':visible');

      if (result.length > 0 && visible) {
        $("#placeHolder").fadeOut();
      }

      //asyncHttpStatistics.numberOfTweets = asyncHttpStatistics.numberOfTweets + result.length;

      /*
       $( "#template" ).tmpl( result ).hide().prependTo( "#twitterMessages").fadeIn(); */
    }

    function handleTwitterMessages(data) {

      console.log("Handling Twitter Messages...");
      var x = data.toJSON();
      console.log(x);

      var visible = $('#placeHolder').is(':visible');

      if (data.length > 0 && visible) {
        $("#placeHolder").fadeOut();
      }

      asyncHttpStatistics.numberOfTweets = asyncHttpStatistics.numberOfTweets + data.length;

      var context = {
        tweets : data.toJSON()
      };

    }

    function handleStatusMessage(data) {
      console.log("Handling Status Message...");
      $('#status').html(data.get('message'));
    }



    var socket = $.atmosphere;
    var subSocket;
    var transport = 'websocket';
    var websocketUrl = "localhost:24333";

    var request = {
      url: websocketUrl,
      contentType : "application/json",
      logLevel : 'debug',
      //shared : 'true',
      transport : transport ,
      fallbackTransport: 'long-polling',
      //reconnectInterval: 10000,
      //callback: callback,
      onMessage: onMessage,
      onOpen: function(response) {
        console.log('Atmosphere onOpen: Atmosphere connected using ' + response.transport);
        transport = response.transport;
        asyncHttpStatistics.transportType = response.transport;
        refresh();
      },
      onReconnect: function (request, response) {
        console.log("Atmosphere onReconnect: Reconnecting");
      },
      onClose: function(response) {
        console.log('Atmosphere onClose executed');
      },

      onError: function(response) {
        console.log('Atmosphere onError: Sorry, but there is some problem with your '
                + 'socket or the server is down');
      }
    };

    subSocket = socket.subscribe(request);

    $('#message-button').click(function() {
      subSocket.push('Hello');
    });

    function onClick() {
      console.log("Open Websocket connection...");
      subSocket.push('Hello');
    }

  });
</script>


</body>
</html>
