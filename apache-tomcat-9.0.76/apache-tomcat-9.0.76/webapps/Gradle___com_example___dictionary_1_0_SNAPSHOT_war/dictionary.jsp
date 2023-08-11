<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Map<String,String> dic = new HashMap<>();
%>

<%
dic.put("fuck","địt");
dic.put("dick","con đĩ");
dic.put("pussy","con mều");
String search = request.getParameter("search");
String result = dic.get(search);
if(result != null){
    System.out.println("Word: " + search);
    System.out.println("Result: " + result);

}
else {
    System.out.println("Not found");
}
%>
</body>
</html>
