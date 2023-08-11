
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <style>
    label {
      color: lightskyblue;
    }
    input{
      background-color: white;
    }
  </style>
</head>
<body style="background-color: black">
<form action="/createAccount">
  <label for="username">Enter username</label>
  <br>
  <input type="text" name="username" id="username" placeholder="username">
  <br>
  <br>
  <label for="password">Enter password</label>
  <br>
  <input type="text" name="password" id="password" placeholder="password">
  <br>
  <input type="password" placeholder="Enter Password again" name="password" required>
  <button type="submit">Submit</button>
</form>
</body>
</html>
