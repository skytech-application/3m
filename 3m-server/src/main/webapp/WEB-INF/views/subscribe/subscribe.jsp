<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

    <div class="col-xs-12 col-md-4">
		<div class="panel panel-primary">
			<div class="panel-heading login-panel">
	        <h3><spring:message code="page.subscribe.form.placeholder.title" /></h3>
	      </div>
      		<div class="panel-body">
			<form id="subscribeForm" class="form-signin" name='subscribeForm'
	        method='POST'>
				<input id='subscribeEmail' placeholder="<spring:message code="page.login.form.placeholder.email" />" class="form-control" type="email" required>
				<input id='subscribeUsername' placeholder="<spring:message code="page.login.form.placeholder.username" />" class="form-control" type="text" required>
				<input id='subscribePassword' placeholder="<spring:message code="page.login.form.placeholder.password" />" class="form-control" type="password" required>
				<div id="subscribeErrorPanel" class="alert alert-danger manga-network-error-panel"></div>
				<div id="subscribeInfoPanel" class="alert alert-info manga-network-info-panel">test</div>
				<button name="submit" type="submit" class="btn btn-lg btn-primary btn-block">
	            <spring:message code="page.login.form.placeholder.connect" /></button>
			</form>
			</div>
		</div>
	</div>