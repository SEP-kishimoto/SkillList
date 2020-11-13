<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"
    session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スキルシート管理システム</title>
<script type="text/javascript">



</script>
</head>
<body>
<div class="title">
</div>
<form action="/SkillList/DB_AddCheckBL" method="post">
<div class="table">
<%
String db_number = "";
String kana = "";
String db_name = "";
String password = "";
request.setCharacterEncoding("utf-8");
String return_flg = (String) request.getSession().getAttribute("return_flg");

if(return_flg == null) {
	return_flg = request.getParameter("return_flg");
}
if (return_flg != null) {
	db_number = (String) request.getParameter("db_number");
	kana = request.getParameter("kana");
	db_name = request.getParameter("db_name");
	password =request.getParameter("password");
}

String err_message = (String) request.getAttribute("err_message");
request.getSession().setAttribute("master_flg", 1);
if (err_message != null) {%>
	<p style="color: red"><%=err_message %></p>
<% }
String master_flg = "1";

%>


社員番号:<input type="text" name="db_number"  value=""><br>
フリガナ:<input type="text" name="kana"  value=""><br>
氏名:<input type="text" name="db_name"  value=""><br>
パスワード:<input type="text" name="password"  value=""><br>

</div>
<br><br>

<div class="buttonTable" >
<button type="submit" class="skillButton" >確認</button>
</div>

</form>


</body>
</html>