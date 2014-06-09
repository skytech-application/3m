<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:if test="${error != null}">
	<button type="button" class="close skytech-close" data-dismiss="alert" aria-hidden="true">&times;</button>
	<div class="alert alert-danger"><spring:message code="${error}" /></div>
</c:if>