<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
 
    <body>
        You have successfully logged in.
        <br/>
         
        <a href="<c:url value="/admin"/>">Admin Page</a>
        <br/>
        <br/>
        <br/>
        <a href="<c:url value="/common"/>">Regular User Page</a>
         
        <br/>
        <br/>
        <br/>
        <a href="<c:url value="j_spring_security_logout" />">Logout</a>
         
    </body>
</html>