<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginBLテスト出力実行</title>
</head>
<body>
<!-- Link "/test/LoginTestOutput.jsp" -->

<!-- 文字コード宣言 -->
<%
request.setCharacterEncoding("UTF-8");
%>

<%
String id = "";
String password = "";
String errmsg = (String) request.getAttribute("errmsg");

String db_number = (String) request.getAttribute("db_number");
String db_name = (String) request.getAttribute("db_name");
String master_flg = (String) request.getAttribute("master_flg");
String filename = (String) request.getAttribute("filename");
if (db_number == null) {
	id = (String) request.getAttribute("id");
	password = (String) request.getAttribute("password");
} else {
	id = request.getParameter("id");
	password = request.getParameter("password");
}



%>

<%if (errmsg != null) { %>
<p>ID&nbsp;：&nbsp;<%=id %></p>
<p>パスワード&nbsp;：&nbsp;<%=password %></p>

<p>エラーメッセージ&nbsp;：&nbsp;<%=errmsg %></p>
<%} else { %>
<p>ID&nbsp;：&nbsp;<%=id %></p>
<p>パスワード&nbsp;：&nbsp;<%=password %></p>

<p>db_number&nbsp;：&nbsp;<%=db_number %></p>
<p>db_name&nbsp;：&nbsp;<%=db_name %></p>
<p>master_flg&nbsp;：&nbsp;<%=master_flg %></p>
<p>filename&nbsp;：&nbsp;<%=filename %></p>

<%} %>

<input type="button" value="戻る" onclick="history.back()">

</body>
</html>