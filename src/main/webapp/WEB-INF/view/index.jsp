<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page isELIgnored="false" %>

<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	
	<p>
	Welcome to the luv2code company home page!
	</p>
	
	<hr>
	
	<!-- display user name and role -->
	
	<p>
		User: <sec:authentication property="principal.username" />
		<br><br>
		Role(s): <sec:authentication property="principal.authorities" />
	</p>
	
	<hr>
	  <p>
	    <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a> (Only only for Manager Peeps)
	  </p>
	<hr>
	
	<hr>
	  <p>
	    <a href="${pageContext.request.contextPath}/systems">IT systems Meeting</a> (Only only for Admin Peeps)
	  </p>
	<hr>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>

</html>