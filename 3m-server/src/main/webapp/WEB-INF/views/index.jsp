<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="http://getbootstrap.com/assets/ico/favicon.ico">

    <title>SkyTech</title>

    <!-- Bootstrap core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
	
	<link href="<%= request.getContextPath() %>/css/datepicker.css" rel="stylesheet">
	
    <!-- Custom styles for this template -->
    <link href="<%= request.getContextPath() %>/css/skytech.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	<script type='text/javascript' src='<%= request.getContextPath() %>/js/jquery-1.11.1.js'></script>
	<script type='text/javascript' src='<%= request.getContextPath() %>/js/bootstrap.min.js'></script>
	<script type='text/javascript' src='<%= request.getContextPath() %>/js/bootbox.min.js'></script>
	<script type='text/javascript' src='<%= request.getContextPath() %>/js/jquery.mixitup.min.js'></script>
	<script type='text/javascript' src='<%= request.getContextPath() %>/js/typeahead.js'></script>
	<script type='text/javascript' src='<%= request.getContextPath() %>/js/bootstrap-datepicker.fr.js'></script>

 </head>
    <body>
    
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" role="form" name='loginForm' action="<c:url value='j_spring_security_check' />"
        method='POST'>
            <div class="form-group left-inner-addon">
            	<span class="glyphicon glyphicon-user"></span>
              	<input name='j_username' placeholder="Nom d'utilisateur" class="form-control" type="text" required>
            </div>
            <div class="form-group left-inner-addon">
            	<span class="glyphicon glyphicon-lock"></span>
              	<input name='j_password' placeholder="Password" class="form-control" type="password" required>
            </div>
            <button name="submit" type="submit" class="btn btn-info">
            Se connecter <span class="glyphicon glyphicon-arrow-right"></span></button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </div>
    
 

        <%
         String errorString = (String)request.getAttribute("error");
         if(errorString != null && errorString.trim().equals("true")){
            out.println("Impossible ");
         }
   		%>
   		        <br/>
        <br/>
        <a href="<c:url value="/user/index"/>">Regular User Page</a>
            		
        <br/>
        
        
         
    </body>
</html>