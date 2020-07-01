<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Access Denied</title>
</head>
<body>
     <h1>Access denied, You are not authorized to access this resource</h1>
     <a href="${pageContext.request.contextPath}/">Back to home</a>
     	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
		<p>
		User: <sec:authentication property="principal.username" />
		<br><br>
		Role(s): <sec:authentication property="principal.authorities" />
	</p>
	
	

</body>
</html>