<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
	
 </head>
    <body>
    
    	<jsp:include page="../common/TopMenu.jsp" />
    	<div class="container skytech-container">
    		<jsp:include page="../common/ErrorPanel.jsp" />
    	</div>
		
		<p>This is admin page !</p>
           
        <jsp:include page="../common/Footer.jsp" />
           
    </body>
</html>