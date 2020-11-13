<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

String db_number = (String) request.getAttribute("db_number");
String db_name = (String) request.getAttribute("db_name");
String master_flg = (String) request.getAttribute("master_flg");
String filename = (String) request.getAttribute("filename");
%>

<h1>更新後、SkillBLに投げられるデータ</h1>

<p><%=db_number %></p>
<p><%=db_name %></p>
<p><%=master_flg %></p>
<p><%=filename %></p>


</body>
</html>