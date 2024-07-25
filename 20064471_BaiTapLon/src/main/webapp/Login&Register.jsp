<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!---Coding By CoderGirl | www.codinglabweb.com--->
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login & Registration Form | CoderGirl</title>
  <!---Custom CSS File--->
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <div class="container">
    <input type="checkbox" id="check">
    <div  class="login form">
      <header>Login</header>
      <form action="login" method="post">
  <input type="text" name="user" placeholder="Enter your email">
  <input type="password" name="pass" placeholder="Enter your password">
  <div style="background-color: #ffffff; border: 1px solid #ffffff; color: #721c24; padding: 10px; margin-bottom: 4px; border-radius: 5px;">
    <p>${mess}</p>
</div>
  
  <input type="submit" class="button" value="Login">
</form>
      
      <div class="signup">
        <span class="signup">Don't have an account?
         <label for="check">Signup</label>
        </span>
      </div>
    </div>
    
    
    
    
    
    
    <div class="registration form">
      <header>Signup</header>
      <form action="signup" method="post">
        <input type="text" name="user" placeholder="Enter your email">
        <input type="password" name="pass" placeholder="Create a password">
        <input type="password" name="repass" placeholder="Confirm your password">
        <input type="submit" class="button" value="Signup">
      </form>
      <div class="signup">
        <span class="signup">Already have an account?
         <label for="check">Login</label>
        </span>
      </div>
    </div>
  </div>
</body>
</html>