<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html lang="fr"><head>
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
          <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span> Project name</a>
        </div>
        <div class="navbar-collapse collapse">
          <form class="navbar-form navbar-right">
            <a class="btn btn-info" href="<c:url value="/j_spring_security_logout" />"><span class="glyphicon glyphicon-arrow-left"></span> Se déconnecter </a>
          </form>
          	
        </div><!--/.navbar-collapse -->
      </div>
    </div>
      		
        <br/>
         ${principal.name}
        <a href="<c:url value="/admin/index"/>">Admin Page</a>
        <br/>
         
    </body>
</html>