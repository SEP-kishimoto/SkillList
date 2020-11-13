<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"
    session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="POST" action="/SkillList/DeleteBL">
<input type="text" name="db_number" value="9999"><br>
<input type="text" name="db_name" value="試験"><br>
<input type="text" name="filename" value="SkillSheet_9999_試験男.xlsx"><br>

<%
session.setAttribute("master_flg", "1");
%>
<input type="submit" value="テスト実行">
</form>
</body>
</html>