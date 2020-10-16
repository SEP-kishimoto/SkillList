<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"%>

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

<!-- DB変数 -->
<%
String db_number = "";
String db_name = "";
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

<!-- Background Note変数 リスト構造 -->
<%
List<String> noteNumber = new ArrayList<String>();
List<String> beginning = new ArrayList<String>();
List<String> end = new ArrayList<String>();
List<String> task = new ArrayList<String>();
%>

<!-- Background Note変数 フェーズ表示、List二重構造 -->
<%
ArrayList<List<String>> requirement = new ArrayList<>();
ArrayList<List<String>> basic = new ArrayList<>();
ArrayList<List<String>> details = new ArrayList<>();
ArrayList<List<String>> pg = new ArrayList<>();
ArrayList<List<String>> single = new ArrayList<>();
ArrayList<List<String>> join = new ArrayList<>();
ArrayList<List<String>> customer = new ArrayList<>();
ArrayList<List<String>> environment = new ArrayList<>();
%>

<!-- Background Note変数 リスト構造 -->
<%
List<String> peopleNumber = new ArrayList<String>();
List<String> development = new ArrayList<String>();

%>

<!-- DBからの値 -->
<%
db_number = (String) request.getAttribute("db_number");
db_name = (String) request.getAttribute("db_name");
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

<!-- Background Noteの設定 リスト構造 および二重構造 -->
<%
noteNumber = (ArrayList<String>) request.getAttribute("noteNumber");
beginning = (ArrayList<String>) request.getAttribute("beginning");
end = (ArrayList<String>) request.getAttribute("end");
task = (ArrayList<String>) request.getAttribute("task");

requirement = (ArrayList<List<String>>) request.getAttribute("requirement");
basic = (ArrayList<List<String>>) request.getAttribute("basic");
details = (ArrayList<List<String>>) request.getAttribute("details");
pg = (ArrayList<List<String>>) request.getAttribute("pg");
single = (ArrayList<List<String>>) request.getAttribute("single");
join = (ArrayList<List<String>>) request.getAttribute("join");
customer = (ArrayList<List<String>>) request.getAttribute("customer");
environment = (ArrayList<List<String>>) request.getAttribute("environment");

peopleNumber = (ArrayList<String>) request.getAttribute("peopleNumber");
development = (ArrayList<String>) request.getAttribute("development");
%>

<h1>スキルシート管理システム：スキルシート編集</h1>
<h2>■Profile</h2>
<form method="post" action="/SkillList/EditCheckBL">
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
<h2>■Background Note</h2>
<table>
	<tr>
		<td>No.</td>
		<td><input type="text" name="" value="<%= %>"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="text" name="" value="<%= %>"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="text" name="" value="<%= %>"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="text" name="" value="<%= %>"></td>
	</tr>

	<tr>
		<td></td>
		<td><input type="text" name="" value="<%= %>"></td>
		<td></td>
		<td><input type="text" name="" value="<%= %>"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="text" name="" value="<%= %>"></td>
		<td></td>
		<td><input type="text" name="" value="<%= %>"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="text" name="" value="<%= %>"></td>
		<td></td>
		<td><input type="text" name="" value="<%= %>"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="text" name="" value="<%= %>"></td>
		<td></td>
		<td><input type="text" name="" value="<%= %>"></td>
	</tr>

	<tr>
		<td></td>
		<td><input type="text" name="" value="<%= %>"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="text" name="" value="<%= %>"></td>
	</tr>




</table>




<!-- DB input -->
<input type="hidden" name="db_number" value="<%=db_number %>">
<input type="hidden" name="db_name" value="<%=db_name %>">

<input type="submit" value="確認" class="button">
</form>


</body>
</html>