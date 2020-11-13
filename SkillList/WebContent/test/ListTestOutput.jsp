<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listテスト出力実行</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String db_number = request.getParameter("db_number");
String db_name = request.getParameter("db_name");
String master_flg = request.getParameter("master_flg");
String filename = request.getParameter("filename");
%>

<p>db_number&nbsp;：&nbsp;<%=db_number %></p>
<p>db_name&nbsp;：&nbsp;<%=db_name %></p>
<p>master_flg&nbsp;：&nbsp;<%=master_flg %></p>
<p>filename&nbsp;：&nbsp;<%=filename %></p>
</body>
</html>