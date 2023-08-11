<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Currency Converter</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>
<br/>
<form action="/convert" method="post">
  <label>Rate: </label>
  <br>
  <input type="text" name="rate" placeholder="RATE" >
  <br>
  <label>USD: </label>
  <br>
  <input type="text" name="usd" placeholder=USD >
  <br>
  <input type="submit" id="submit" value="converter">
</form>
</body>
</html>