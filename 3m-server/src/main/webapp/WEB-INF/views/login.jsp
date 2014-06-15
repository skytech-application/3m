<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon"
	href="http://getbootstrap.com/assets/ico/favicon.ico">

<title>SkyTech</title>

<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/css/signin.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/skytech.css"
	rel="stylesheet">
	
<script type='text/javascript' src='<%= request.getContextPath() %>/js/jquery-2.1.1.min.js'></script>
<script type='text/javascript' src='<%= request.getContextPath() %>/js/rest.js'></script>
<script type='text/javascript' src='<%= request.getContextPath() %>/js/model/users.js'></script>
<script type='text/javascript' src='<%= request.getContextPath() %>/js/controllers/subscribe.js'></script>

<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-4 col-md-offset-2">
				<div class="panel panel-primary">
					<div class="panel-heading login-panel">
			        <h3><spring:message code="page.login.form.placeholder.title" /></h3>
			      </div>
		      		<div class="panel-body">
					<form class="form-signin" role="form" name='loginForm' action="<c:url value='j_spring_security_check' />"
			        method='POST'>
						<input name='j_username' placeholder="<spring:message code="page.login.form.placeholder.username" />" class="form-control" type="text" required>
						<input name='j_password' placeholder="<spring:message code="page.login.form.placeholder.password" />" class="form-control" type="password" required>
						
						<button name="submit" type="submit" class="btn btn-lg btn-primary btn-block">
			            <spring:message code="page.login.form.placeholder.connect" /></button>
					</form>
					</div>
				</div>
			</div>
	
			<jsp:include page="subscribe/subscribe.jsp" />
			
		</div>
		
		
	</div>
	<!-- /container -->
	
	<jsp:include page="common/Footer.jsp" />
	
</body>
</html>