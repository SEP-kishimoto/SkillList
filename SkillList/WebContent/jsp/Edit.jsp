<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"
    session="true" %>

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
<%!
@SuppressWarnings("unchecked")
%>

<!-- DB変数 -->
<%
String db_number = "";
String db_name = "";
String master_flg = "";
String filename = "";
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
db_number = request.getParameter("db_number");
db_name = request.getParameter("db_name");
master_flg = request.getParameter("master_flg");
filename = request.getParameter("filename");
%>

<!-- Profile変数の設定 -->
<%
kana = request.getParameter("kana");
name = request.getParameter("name");
address = request.getParameter("address");
birthday = request.getParameter("birthday");
age = request.getParameter("age");
gender = request.getParameter("gender");
background = request.getParameter("background");
backgroundNumber = request.getParameter("backgroundNumber");
nearestStation = request.getParameter("nearestStation");
stationName = request.getParameter("stationName");
%>

<!-- Skill Info変数の設定 -->
<%
os = request.getParameter("os");
skill = request.getParameter("skill");
tool = request.getParameter("tool");
db = request.getParameter("db");
qualification = request.getParameter("qualification");
%>

<!-- Background Noteの設定 リスト構造 および二重構造 -->
<%
noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");
beginning = (ArrayList<String>) session.getAttribute("beginning");
end = (ArrayList<String>) session.getAttribute("end");
task = (ArrayList<String>) session.getAttribute("task");

requirement = (ArrayList<List<String>>) session.getAttribute("requirement");
basic = (ArrayList<List<String>>) session.getAttribute("basic");
details = (ArrayList<List<String>>) session.getAttribute("details");
pg = (ArrayList<List<String>>) session.getAttribute("pg");
single = (ArrayList<List<String>>) session.getAttribute("single");
join = (ArrayList<List<String>>) session.getAttribute("join");
customer = (ArrayList<List<String>>) session.getAttribute("customer");
environment = (ArrayList<List<String>>) session.getAttribute("environment");

peopleNumber = (ArrayList<String>) session.getAttribute("peopleNumber");
development = (ArrayList<String>) session.getAttribute("development");
%>

<h1>スキルシート管理システム：編集</h1>
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
<%for (int i = 0; i < noteNumber.size(); i++) { %>
<table>
	<tr>
		<td>No.</td>
		<td><%=noteNumber.get(i) %></td>
	</tr>
	<tr>
		<td>開始</td>
		<td><input type="text" name="beginning<%=i %>" value="<%=beginning.get(i) %>"></td>
	</tr>
	<tr>
		<td>終了</td>
		<td><input type="text" name="end<%=i %>" value="<%=end.get(i) %>"></td>
	</tr>
	<tr>
		<td>業務内容</td>
		<td><input type="text" name="task<%=i %>" value="<%=task.get(i) %>"></td>
	</tr>

	<tr>
		<td>要件定義</td>
		<td><input type="text" name="requirement<%=i %>" value="<%=requirement.get(i).get(0) %>"></td>
		<td>基本設計</td>
		<td><input type="text" name="basic<%=i %>" value="<%=basic.get(i).get(1) %>"></td>
	</tr>
	<tr>
		<td>詳細設計</td>
		<td><input type="text" name="details<%=i %>" value="<%=details.get(i).get(2) %>"></td>
		<td>PG製造</td>
		<td><input type="text" name="pg<%=i %>" value="<%=pg.get(i).get(3) %>"></td>
	</tr>
	<tr>
		<td>単体試験</td>
		<td><input type="text" name="single<%=i %>" value="<%=single.get(i).get(4) %>"></td>
		<td>結合試験</td>
		<td><input type="text" name="join<%=i %>" value="<%=join.get(i).get(5) %>"></td>
	</tr>
	<tr>
		<td>客先試験</td>
		<td><input type="text" name="customer<%=i %>" value="<%=customer.get(i).get(6) %>"></td>
		<td>環境設定</td>
		<td><input type="text" name="environment<%=i %>" value="<%=environment.get(i).get(7) %>"></td>
	</tr>

	<tr>
		<td>人数</td>
		<td><input type="text" name="peopleNumber<%=i %>" value="<%=peopleNumber.get(i) %>"></td>
	</tr>
	<tr>
		<td>開発環境</td>
		<td><input type="text" name="development<%=i %>" value="<%=development.get(i) %>"></td>
	</tr>
</table>
<%} %>
<input type="button" onclick="" value="項目追加">

<%
session.setAttribute("noteNumber", noteNumber);
%>
<!-- DB input -->
<input type="hidden" name="db_number" value="<%=db_number %>">
<input type="hidden" name="db_name" value="<%=db_name %>">
<input type="hidden" name="master_flg" value="<%=master_flg %>">
<input type="hidden" name="filename" value="<%=filename %>">

<input type="submit" value="確認" class="button">
<input type="button" onclick="history.back()" value="戻る">
</form>



</body>
</html>