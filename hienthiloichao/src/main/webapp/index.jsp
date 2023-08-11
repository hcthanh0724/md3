<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <style>
    .login{
      height: 180px;
      width: 230px;
      padding: 10px;
      border: 1px #CCC solid;
    }
    .login input{
      padding: 5px;
      margin: 5px;
    }
  </style>
</head>
<body>
<form action="/login" method="post">
  <div class="login">
    <h2>Login</h2>
    <input type="text" name="username" size="30" placeholder="username">
    <input type="text" name="password" size="30" placeholder="password">
    <input type="submit" value="sign in">
</div>
</form>



</body>
</html>