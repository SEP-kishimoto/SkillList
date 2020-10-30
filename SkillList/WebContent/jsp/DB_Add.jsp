<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList "%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/SkillList/css/DB_Add.css">
<meta charset="UTF-8">
<title>スキルシート管理システム</title>
<script type="text/javascript">



</script>
</head>
<body>
<div class="title">
<h1>スキルシート管理システム:DB登録</h1>
</div>
<form action="/SkillList/DB_AddCheckBL" method="post">
<div class="table">
<%
String db_number = "";
String kana = "";
String db_name = "";
String password = "";

String return_flg = (String) request.getAttribute("db_number");
if (return_flg != null) {
	db_number = (String) request.getAttribute("db_number");
	kana = (String) request.getAttribute("kana");
	db_name = (String) request.getAttribute("db_name");
	password = (String) request.getAttribute("password");
}

String err_message = (String) request.getAttribute("err_message");
request.getSession().setAttribute("master_flg", 1);
if (err_message != null) {%>
	<p style="color: red"><%=err_message %></p>
<% }
String master_flg = "1";

%>

<table>
	<tr><th>社員番号* : </th><td><input type="text" name="db_number" class="inputLine" value=<%=db_number %>></td></tr>
	<tr><th>フリガナ* : </th><td><input type="text" class="inputLine" name="kana" value=<%=kana %>></td></tr>
	<tr><th>氏名* : </th><td><input type="text" class="inputLine" name="db_name" value=<%=db_name %>></td></tr>
	<tr><th>パスワード* : </th><td><input type="password" name="password" class="inputLine" value=<%=password %>></td></tr>


</table>

</div>
<br><br>
<div class="buttonTable">
<button type="submit" class="skillButton">確認</button>
<button type="submit" class="skillButton" name="master_flg2" value="1" formaction="/SkillList/ListBL">戻る</button>
</div>
</form>


</body>
</html>