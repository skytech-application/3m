<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/3m-server/index"><spring:message code="application.name" /></a>
        </div>
        <div class="navbar-collapse collapse">
        
        <ul class="nav navbar-nav">
	        
	        <sec:authorize url="/admin/index">
	        	<li><a href="/3m-server/admin/index">Administration</a></li>
	        </sec:authorize>
	        
        </ul>
          
        <sec:authorize access="!isAuthenticated()">
	        <form class="navbar-form navbar-right" role="form" name='loginForm' action="<c:url value='j_spring_security_check' />"
        method='POST'>
            <div class="form-group left-inner-addon">
            	<span class="glyphicon glyphicon-user"></span>
              	<input name='j_username' placeholder="<spring:message code="login.form.username" />" class="form-control" type="text" required>
            </div>
            <div class="form-group left-inner-addon">
            	<span class="glyphicon glyphicon-lock"></span>
              	<input name='j_password' placeholder="<spring:message code="login.form.password" />" class="form-control" type="password" required>
            </div>
            <button name="submit" type="submit" class="btn btn-info">
            <spring:message code="login.form.connect" /> <span class="glyphicon glyphicon-arrow-right"></span></button>
          </form>
        	</sec:authorize>
        	
          
          <sec:authorize access="isAuthenticated()">
	        <form class="navbar-form navbar-right">
	            <a class="btn btn-info" href="<c:url value="/j_spring_security_logout" />"><span class="glyphicon glyphicon-arrow-left"></span> <spring:message code="login.form.disconnect" /> </a>
	          </form>
        	</sec:authorize>
        </div><!--/.navbar-collapse -->
      </div>
    </div>