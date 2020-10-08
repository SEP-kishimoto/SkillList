<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page
import="servlet.EditBL"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スキルシート編集</title>
</head>
<body>
<!-- 文字コード宣言 -->
<%
request.setCharacterEncoding("UTF-8");
%>

<!-- Profile変数 -->
<%
String kana = "";
String name = "";
String address = "";
String birthday = "";
String age = "";
String gender = "";
String background = "";
String backgroundNumber = "";
String nearestStation = "";
String stationName = "";
%>
<!-- Skill Info変数 -->
<%
String os = "";
String skill = "";
String tool = "";
String db = "";
String qualification = "";
%>

<!-- Profile変数の設定 -->
<%
kana = (String) request.getAttribute("kana");
name = (String) request.getAttribute("name");
address = (String) request.getAttribute("address");
birthday = (String) request.getAttribute("birthday");
age = (String) request.getAttribute("age");
gender = (String) request.getAttribute("gender");
background = (String) request.getAttribute("background");
backgroundNumber = (String) request.getAttribute("backgroundNumber");
nearestStation = (String) request.getAttribute("nearestStation");
stationName = (String) request.getAttribute("stationName");
%>

<!-- Skill Info変数の設定 -->
<%
os = (String) request.getAttribute("os");
skill = (String) request.getAttribute("skill");
tool = (String) request.getAttribute("tool");
db = (String) request.getAttribute("db");
qualification = (String) request.getAttribute("qualification");
%>

<h1>スキルシート管理システム：スキルシート編集</h1>
<h2>■Profile</h2>
<form method="post" action="/SkillList/EditBL">
<table>
	<tr>
		<td>フリガナ＊</td>
		<td><input type="text" name="kana" value="<%=kana%>"></td>
	</tr>
	<tr>
		<td>氏名＊</td>
		<td><input type="text" name="name" value="<%=name%>"></td>
	</tr>
	<tr>
		<td>現住所＊</td>
		<td><input type="text" name="address" value="<%=address%>"></td>
	</tr>
	<tr>
		<td>生年月＊</td>
		<td><input type="text" name="birthday" value="<%=birthday%>"></td>
	</tr>
	<tr>
		<td>年齢＊</td>
		<td><input type="text" name="age" value="<%=age%>"></td>
	</tr>
	<tr>
		<td>性別＊</td>
		<td><input type="text" name="gender" value="<%=gender%>"></td>
	</tr>
	<tr>
		<td>最終学歴＊</td>
		<td><input type="text" name="background" value="<%=background%>"></td>
		<td><input type="text" name="backgroundNumber" value="<%=backgroundNumber%>"></td>
	</tr>
	<tr>
		<td>最寄り駅＊</td>
		<td><input type="text" name="nearestStation" value="<%=nearestStation%>"></td>
		<td><input type="text" name="stationName" value="<%=stationName%>"></td>
	</tr>
</table>

<h2>■Skill Info</h2>
<table>
	<tr>
		<td>OS</td>
		<td><input type="text" name="os" value="<%=os%>"></td>
	</tr>
	<tr>
		<td>スキル</td>
		<td><input type="text" name="skill" value="<%=skill%>"></td>
	</tr>
	<tr>
		<td>ツール</td>
		<td><input type="text" name="tool" value="<%=tool%>"></td>
	</tr>
	<tr>
		<td>データベース</td>
		<td><input type="text" name="db" value="<%=db%>"></td>
	</tr>
	<tr>
		<td>資格</td>
		<td><input type="text" name="qualification" value="<%=qualification%>"></td>
	</tr>

</table>

<input type="submit" value="確認" class="button">
</form>

<h2>■Background Note</h2>
</body>
</html>