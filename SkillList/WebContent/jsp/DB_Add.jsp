<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"
    session="true" %>
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
<h1 style="font-size:25px;text-align: center;margin-right:100px;">スキルシート管理システム:DB登録</h1>
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
System.out.println("リターン" + return_flg);
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


<table style="margin: 0 auto;">
	<tr><th>社員番号* : </th><td><input type="text" name="db_number" class="inputLine" value=<%=db_number %>></td></tr>
	<tr><th>フリガナ* : </th><td><input type="text" class="inputLine" name="kana" value=<%=kana %>></td></tr>
	<tr><th>氏名* : </th><td><input type="text" class="inputLine" name="db_name" value=<%=db_name %>></td></tr>
	<tr><th>パスワード* : </th><td><input type="password" name="password" class="inputLine" value=<%=password %>></td></tr>


</table>

</div>
<br><br>

<div class="buttonTable" >
<button type="submit" class="skillButton" >確認</button>
<button type="submit" class="skillButton" name="master_flg2" value="1" formaction="/SkillList/ListBL">戻る</button>
</div>

</form>


</body>
</html>