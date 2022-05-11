<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
		<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="../CSS/login.css">
	<title>JSP Page</title>
	</head>
		<body>
			<h1>Please login</h1>
			<form action=<%=request.getContextPath()+"/login"%> method="POST">
				<input type="text" name="username">
				<input type="password" name="password">
				<input type="submit" name="Login">
			</form>
		
		</body>
</html>