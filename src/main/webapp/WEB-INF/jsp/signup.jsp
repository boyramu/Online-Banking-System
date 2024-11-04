<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account creation</title>
<link rel="stylesheet" href="static/css/signupcss.css">
</head>
<body>
    <h1><u>Welcome to Btech Bank of India (BBI)</u></h1>
    <div id="image1">
        <img src="static/images/customerlogin.png" alt="Description of your image">
    </div>
    <div id="set">
        <div id="form">
            <form action="add" method="post">
                <h3>Fill up the details to create an account</h3>
                <label>Fullname</label>
                <input type="text" name="fullname" required><br><br>
                 <label>Gender</label>
 <input type="radio" value="male" name="gender" required><label>male</label> 
<input type="radio" value="female" name="gender" required> <label for="">female</label>
<input type="radio" value="others" name="gender" required> <label for="">others</label><br><br> 
 <label>DOB</label>
<input type="text" name="dob" required><br><br>
<label>Email</label>
<input type="email" name="email" required><br><br>
<label>adhar Number</label>
<input type="text" name="adharnumber" required><br><br>
<label>Phone Number</label>
<input type="text" name="phonenumber" required><br><br>
<label>Address</label>
<input type="text" name="address" required><br><br>
<label>Username</label>
<input type="text" name="username" required><br><br>
<label>Password</label>
<input type="password" name="password" required><br><br>
<button type="submit">
    <span class="transition"></span>
    <span class="gradient"></span>
    <span class="label">Create</span>
  </button>
            </form>
        </div>
    </div>
</body>
</html>
                
        </div>
    </div>
</body>
</html>
