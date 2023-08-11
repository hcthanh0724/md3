<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Customer List" %>
</h1>
<br/>

<%
    response.setContentType("text/html");
    PrintWriter responseWriter = response.getWriter();
class Customer {
    String name;
    String date;
    String address;
    String img;
    public Customer(String name, String date, String address, String img) {
        this.name = name;
        this.date = date;
        this.address = address;
        this.img = img;
    }
}
    List <Customer> customers = new ArrayList();
    customers.add(new Customer("Maria Ozawa", "8/1/1986", "Japan", "https://tn.vjav.com/contents/models/386/r240x400_1.jpg"));
    customers.add(new Customer("Mia Khalifa", "10/2/1993", "USA", "https://www.dailystar.co.uk/news/weird-news/mia-khalifa-says-everyone-spider-29631953"));
    customers.add(new Customer("Ruri Tachibana", "15/3/1995", "Japan", "https://tn.vjav.com/contents/models/7230/r240x400_1.jpg"));
    customers.add(new Customer("Julia Boin", "15/10/1997", "Japan", "https://i.pinimg.com/originals/3f/ec/2e/3fec2e753cd3c2ee75ed3bc8e1002f3e.jpg"));
%>

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Date of Birth</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td><c:out value="${customer.name}" /></td>
            <td><c:out value="${customer.date}" /></td>
            <td><c:out value="${customer.address}" /></td>
            <td><img src="${customer.img}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>