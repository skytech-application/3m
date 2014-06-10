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
		<form class="form-signin" role="form" name='loginForm' action="<c:url value='j_spring_security_check' />"
        method='POST'>
			<h2 class="form-signin-heading">Please sign in</h2>
			<input name='j_username' placeholder="<spring:message code="placeholder.login.form.username" />" class="form-control" type="text" required>
			<input name='j_password' placeholder="<spring:message code="placeholder.login.form.password" />" class="form-control" type="password" required>
			<jsp:include page="common/ErrorPanel.jsp" />
			<button name="submit" type="submit" class="btn btn-lg btn-primary btn-block">
            <spring:message code="placeholder.login.form.connect" /> <span class="glyphicon glyphicon-arrow-right"></span></button>
		</form>

	</div>
	<!-- /container -->

</body>
</html>