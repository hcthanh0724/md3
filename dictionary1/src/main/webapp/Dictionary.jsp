<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
Map<String,String> dic = new HashMap<>();
%>
<%
dic.put("hello","cdcmm af?");
dic.put("how","is your mom'clit?");
dic.put("bro","wanna smoke?");
String search = request.getParameter("word");
String result = dic.get(search);
if(result != null){

}
%>
</body>
</html>
