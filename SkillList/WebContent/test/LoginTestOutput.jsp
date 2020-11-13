<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loginテスト出力実行</title>
</head>
<body>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");
%>
<p>ID&nbsp;：&nbsp;<%=id %></p>
<p>パスワード&nbsp;：&nbsp;<%=password %></p>

</body>
</html>