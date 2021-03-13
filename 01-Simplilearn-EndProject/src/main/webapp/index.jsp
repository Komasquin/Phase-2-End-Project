<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Sign In</h1>
	<div align="center">
		<form action="LogInServlet" method="post">
			User Name: <input type="text" name="username" />
			Password: <input type="text" name="password" />
			<input type="submit" value="LogIn">
		</form>	
		<a href="Enroll.jsp">Enroll Here</a>
	</div>
</body>
</html>