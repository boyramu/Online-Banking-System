<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<link rel="stylesheet" href="static/css/signupcss.css">
</head>
<body>
    <h1><u>Welcome to Btech Bank of India (BBI)</u><p><%=request.getAttribute("result") %></p></h1>
<div id="image1">
<img src="static/images/customerlogin.png" alt="Description of your image">
</div>
<div id="set">
<div id="form">
<form action="login" method="post">
<h3>Enter the details to login</h3>
<label>Username</label>
<input type="text" name="username" required><br><br>
<label>Password</label>
<input type="password" name="password" required><br><br>
<button type="submit">
    <span class="transition"></span>
    <span class="gradient"></span>
    <span class="label">Login</span>
  </button>
</form>
</div>
</div>
</body>
</html>