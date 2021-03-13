<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">New User Add Page</h1>
	<div align="center">
		<form action="AddServlet" method="post">
			User Name: <input type="text" name="uname" />
			Password: <input type="text" name="pword" />
			<input type="submit" value="add">
		</form>	
	</div>
</body>
</html>