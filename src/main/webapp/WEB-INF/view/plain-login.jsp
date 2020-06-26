
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custom Login Page</title>
</head>
<body>

    <h3>My Custom Login Page</h3>
    <c:if test="${param.error != null}" var="a">
        <i>Sorry, you entered invalid username/password</i>
    
    </c:if>
    
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
         <p>
            User name 
            <input type="text" name="username" />
         </p>
          <p>
             Password 
            <input type="password" name="password" />
         </p>
         
         <input type="submit" value="Login"/>
         
    
    </form:form>

</body>
</html>