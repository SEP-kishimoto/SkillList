<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"
    session="true" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>DB登録テスト</title>

</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String db_number = (String) request.getAttribute("db_number");
String db_name = (String) request.getAttribute("db_name");
String password = (String) request.getAttribute("password");
String kana = (String) request.getAttribute("kana");

String  err_message = (String) request.getAttribute("err_message");


%>

<% if (err_message != null) { %>
エラーメッセージ受け取り<br><br>
err_message<br><br><%=err_message %><br><br>


<% } else { %>
転送データ<br><br>
db_number:<%=db_number %><br><br>
kana:<%=kana %><br><br>
db_name:<%=db_name %><br><br>
password:<%=password %><br><br>

<%} %>

</body>
</html>