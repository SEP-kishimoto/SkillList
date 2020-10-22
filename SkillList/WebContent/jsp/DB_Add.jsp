<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList "%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スキルシート管理システム</title>
<script type="text/javascript">



</script>
</head>
<body>
<h1>スキルシート管理システム:DB登録</h1>

<form action="/SkillList/DB_AddCheckBL" method="post">
<%
String err_message = (String) request.getAttribute("err_message");
request.getSession().setAttribute("master_flg", 1);
if (err_message != null) {
	out.println("<h2>" + err_message + "</h2>");
}


%>
<table>
	<tr><th>社員No* : </th><td><input type="text" name="db_number" value=""></td></tr>
	<tr><th>氏名* : </th><td><input type="text" class="address-txt" name="db_name" value=""></td></tr>
	<tr><th>パスワード* : </th><td><input type="password" name="password" value=""></td></tr>


</table>



<button type="submit" class="btn">確認</button>

</form>

<form action="/SkillList/ListBL" method="post">
<input type="hidden" name="master_flg" value="1">
<button type="submit" class="btn">戻る</button>
</form>
</body>
</html>