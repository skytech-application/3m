<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
          <a class="navbar-brand" href="<%= request.getContextPath() %>/index"><spring:message code="application.name" /></a>
        </div>
        <div class="navbar-collapse collapse">
        
        <ul class="nav navbar-nav">
	        
	        <sec:authorize url="/admin/index">
	        	<li <%= request.getServletPath().equals("/WEB-INF/views/admin/index.jsp") ? "class=\"active\"" : "" %>><a href="<%= request.getContextPath() %>/admin/index"><spring:message code="menu.administration" /></a></li>
	        </sec:authorize>
        </ul>
          
        <sec:authorize access="!isAuthenticated()">
        <form class="navbar-form navbar-right">
         
            <a href="<%= request.getContextPath() %>/login" type="submit" class="btn btn-info">
            <spring:message code="page.login.form.placeholder.connect" /> <span class="glyphicon glyphicon-arrow-right"></span></a>
            </form>
        	</sec:authorize>
        	
          
          <sec:authorize access="isAuthenticated()">
	        <form class="navbar-form navbar-right">
	        	<button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-user"></span>
	        	 <sec:authentication property="principal.username" /></button>
	            <a class="btn btn-info" href="<c:url value="/j_spring_security_logout" />"><span class="glyphicon glyphicon-arrow-left"></span> <spring:message code="page.login.form.placeholder.disconnect" /> </a>
	          </form>
        	</sec:authorize>
        </div><!--/.navbar-collapse -->
      </div>
    </div>
    
