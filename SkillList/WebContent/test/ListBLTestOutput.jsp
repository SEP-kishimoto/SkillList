<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListBLテスト出力実行</title>
</head>
<body>
<!-- Link "/test/ListBLTestOutput.jsp" -->
<%
request.setCharacterEncoding("UTF-8");
String db_number = "";
String db_name = "";
String master_flg = "";
String filename = "";
String debugmsg = (String) request.getAttribute("debugmsg");

if (debugmsg == "管理者じゃけぇ") {
	ResultSet rs = (ResultSet) request.getAttribute("ResultSet");//ListBLからrs受け取り
	while (rs.next()) {
		db_number = (String) rs.getString("db_number");
		db_name = (String) rs.getString("db_name");
		master_flg = (String) rs.getString("master_flg");
		filename = (String) rs.getString("filename");
%>
<p>db_number&nbsp;：&nbsp;<%=db_number %></p>
<p>db_name&nbsp;：&nbsp;<%=db_name %></p>
<p>master_flg&nbsp;：&nbsp;<%=master_flg %></p>
<p>filename&nbsp;：&nbsp;<%=filename %></p>
<p>--------------------</p>
<%
	}
} else  {
	db_number = (String) request.getAttribute("db_number");
	db_name = (String) request.getAttribute("db_name");
	master_flg = (String) request.getAttribute("master_flg");
	filename = (String) request.getAttribute("filename");
%>
<p>db_number&nbsp;：&nbsp;<%=db_number %></p>
<p>db_name&nbsp;：&nbsp;<%=db_name %></p>
<p>master_flg&nbsp;：&nbsp;<%=master_flg %></p>
<p>filename&nbsp;：&nbsp;<%=filename %></p>
<%} %>
<p style="font-color: red; font-weight: bold"><%=debugmsg %></p>
</body>
</html>