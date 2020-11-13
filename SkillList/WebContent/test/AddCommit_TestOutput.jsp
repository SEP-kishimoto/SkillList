<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"
    session="true" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>AddCommitテスト</title>

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

<h2>画面遷移しました。</h2>

</body>
</html>