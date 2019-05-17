<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="/model-view-controller/login" method="post">
enter name: <input type="text" name="name">
enter password : <input type="password" name="pass">			
				 <input type="submit" value="Submit">
</form>
<p style="color: red">${error}</p>
</body>
</html>