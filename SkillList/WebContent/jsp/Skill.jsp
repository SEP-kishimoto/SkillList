<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<!-- Background Note変数 -->
<%
List<String> noteNumber = new ArrayList<String>();
List<String> beginning = new ArrayList<String>();
List<String> end = new ArrayList<String>();
String task = "";

String requirement = "";
String basic = "";
String details = "";
String pg = "";
String single = "";
String join = "";
String customer = "";
String environment = "";
String peopleNumber = "";
String development = "";

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

<!-- Background Noteの設定 -->
<%
noteNumber = (ArrayList<String>) request.getAttribute("noteNumber");
beginning = (ArrayList<String>) request.getAttribute("beginning");
end = (ArrayList<String>) request.getAttribute("end");
task = (String) request.getAttribute("task");

requirement = (String) request.getAttribute("requirement");
basic = (String) request.getAttribute("basic");
details = (String) request.getAttribute("details");
pg = (String) request.getAttribute("pg");
single = (String) request.getAttribute("single");
join = (String) request.getAttribute("join");
customer = (String) request.getAttribute("customer");
environment = (String) request.getAttribute("environment");
peopleNumber = (String) request.getAttribute("peopleNumber");
development = (String) request.getAttribute("development");
%>

<h1>スキルシート管理システム：スキルシート編集</h1>

<h2>■Profile</h2>
<form method="post" action="/SkillList/EditBL">
<table>
	<tr>
		<td>フリガナ＊</td>
		<td><%=kana%></td>
	</tr>
	<tr>
		<td>氏名＊</td>
		<td><%=name%></td>
	</tr>
	<tr>
		<td>現住所＊</td>
		<td><%=address%></td>
	</tr>
	<tr>
		<td>生年月＊</td>
		<td><%=birthday%></td>
	</tr>
	<tr>
		<td>年齢＊</td>
		<td><%=age%></td>
	</tr>
	<tr>
		<td>性別＊</td>
		<td><%=gender%></td>
	</tr>
	<tr>
		<td>最終学歴＊</td>
		<td><%=background%></td>
		<td><%=backgroundNumber%></td>
	</tr>
	<tr>
		<td>最寄り駅＊</td>
		<td><%=nearestStation%></td>
		<td><%=stationName%></td>
	</tr>
</table>

<h2>■Skill Info</h2>
<table>
	<tr>
		<td>OS</td>
		<td><%=os%></td>
	</tr>
	<tr>
		<td>スキル</td>
		<td><%=skill%></td>
	</tr>
	<tr>
		<td>ツール</td>
		<td><%=tool%></td>
	</tr>
	<tr>
		<td>データベース</td>
		<td><%=db%></td>
	</tr>
	<tr>
		<td>資格</td>
		<td><%=qualification%></td>
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
		<td><%=beginning.get(i) %></td>
	</tr>
	<tr>
		<td>終了</td>
		<td><%=end.get(i) %></td>
	</tr>
	<tr>
		<td>業務内容</td>
		<td><%=task%></td>
	</tr>
	<tr>
		<td>要件定義</td>
		<td><%=requirement %></td>
		<td>基本設計</td>
		<td><%=basic %></td>
	</tr>
	<tr>
		<td>詳細設計</td>
		<td><%=details %></td>
		<td>PG製造</td>
		<td><%=pg %></td>
	</tr>
	<tr>
		<td>単体試験</td>
		<td><%=single %></td>
		<td>結合試験</td>
		<td><%=join %></td>
	</tr>
	<tr>
		<td>客先試験</td>
		<td><%=customer %></td>
		<td>環境設定</td>
		<td><%=environment %></td>
	</tr>
	<tr>
		<td>人数</td>
		<td><%=peopleNumber %></td>
	</tr>
	<tr>
		<td>開発環境</td>
		<td><%=development %></td>
	</tr>

</table>
<%} %>


<!-- DB input -->
<input type="hidden" name="db_number" value="<%=db_number %>">
<input type="hidden" name="db_name" value="<%=db_name %>">

<!-- Pfrofile input -->
<input type="hidden" name="kana" value="<%=kana %>">
<input type="hidden" name="name" value="<%=name%>">
<input type="hidden" name="address" value="<%=address%>">
<input type="hidden" name="birthday" value="<%=birthday%>">
<input type="hidden" name="age" value="<%=age%>">
<input type="hidden" name="gender" value="<%=gender%>">
<input type="hidden" name="background" value="<%=background%>">
<input type="hidden" name="backgroundNumber" value="<%=backgroundNumber%>">
<input type="hidden" name="nearestStation" value="<%=nearestStation%>">
<input type="hidden" name="stationName" value="<%=stationName%>">

<!-- SkillInfo input -->
<input type="hidden" name="os" value="<%=os%>">
<input type="hidden" name="skill" value="<%=skill%>">
<input type="hidden" name="tool" value="<%=tool%>">
<input type="hidden" name="db" value="<%=db%>">
<input type="hidden" name="qualification" value="<%=qualification%>">

<table>
	<tr>
		<td><input type="submit" value="編集" formaction="./EditBL"></td>
		<td><input type="submit" value="削除" formaction="./jsp/Delete.jsp"></td>
		<td><input type="submit" value="ダウンロード" formaction="./DownloadBL.jsp"></td>
		<td><input type="submit" value="ログアウト" formaction="./Logout.jsp"></td>
		<%if(request.getParameter("master_flg") == "1") {%>
		<td><input type="submit" value="戻る" formaction="./jsp/List.jsp"></td>
		<%} %>
	</tr>
</table>
</form>
</body>
</html>