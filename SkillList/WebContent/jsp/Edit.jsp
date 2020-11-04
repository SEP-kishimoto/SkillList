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
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>スキルシート編集</title>
<link rel="stylesheet" type="text/css" href="/SkillList/css/Edit.css">
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

<!-- errmsg -->
<%
String errmsg = (String) request.getAttribute("errmsg");
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
if (errmsg != null) {
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
} else {
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
}
%>

<h1>スキルシート管理システム：編集</h1>
<% if (errmsg != null) {%>
<p style="color: red"><%=errmsg %></p>
<%} %>
<h2>&#9632;Profile</h2>
<form method="post" action="/SkillList/EditCheckBL">
<table class="phaseTable">
	<tr>
		<td class="tableText" style="min-width: 90px">フリガナ*</td>
		<td style="width: 600px">&nbsp;：&nbsp;<input class="inputLine" type="text" name="kana" value="<%=kana%>"></td>
	</tr>
	<tr>
		<td class="tableText">氏名*</td>
		<td>&nbsp;：&nbsp;<input class="inputLine" type="text" name="name" value="<%=name%>"></td>
	</tr>
	<tr>
		<td class="tableText">現住所*</td>
		<td>&nbsp;：&nbsp;<input class="inputLine" style="width: 80%" type="text" name="address" value="<%=address%>"></td>
	</tr>
	<tr>
		<td class="tableText">生年月日*</td>
		<td>&nbsp;：&nbsp;<input class="inputLine" type="text" name="birthday" value="<%=birthday%>">&nbsp;<label>生</label></td>
	</tr>
	<tr>
		<td class="tableText">性別*</td>
		<td>&nbsp;：&nbsp;<input class="inputLine" style="width: 40px" type="text" name="gender" value="<%=gender%>"></td>
	</tr>
</table>
<table class="phaseTable">
	<tr>
		<td class="tableText" style="min-width: 90px">最終学歴*</td>
		<td style="width: 150px">&nbsp;：&nbsp;<input  style="width: 50%; height: 24px" type="text" name="background" placeholder="学校名" value="<%=background%>"></td>
		<td style="width: 150px">&nbsp;：&nbsp;<input style="width: 50%; height: 24px" type="text" name="backgroundNumber" placeholder="卒業した年" value="<%=backgroundNumber%>">&nbsp;<label>年</label></td>
	</tr>
	<tr>
		<td class="tableText">最寄り駅*</td>
		<td style="width: 150px">&nbsp;：&nbsp;<input style="width: 50%; height: 24px" type="text" name="nearestStation" placeholder="路線名" value="<%=nearestStation%>">&nbsp;<label>線</label></td>
		<td style="width: 150px">&nbsp;：&nbsp;<input style="width: 50%; height: 24px" type="text" name="stationName" placeholder="駅名" value="<%=stationName%>">&nbsp;<label>駅</label></td>
	</tr>
</table>

<h2>&#9632;Skill Info</h2>
<table class="phaseTable">
	<tr>
		<td class="tableText" style="width: 100px; min-width: 100px; height: 24px">OS</td>
		<td style="width: 600px">&nbsp;：&nbsp;<input class="inputLine" type="text" name="os" value="<%=os%>"></td>
	</tr>
	<tr>
		<td class="tableText">スキル</td>
		<td>&nbsp;：&nbsp;<input class="inputLine" type="text" name="skill" value="<%=skill%>"></td>
	</tr>
	<tr>
		<td class="tableText">ツール</td>
		<td>&nbsp;：&nbsp;<input class="inputLine" type="text" name="tool" value="<%=tool%>"></td>
	</tr>
	<tr>
		<td class="tableText">データベース</td>
		<td>&nbsp;：&nbsp;<input class="inputLine" type="text" name="db" value="<%=db%>"></td>
	</tr>
	<tr>
		<td class="tableText">資格</td>
		<td>&nbsp;：&nbsp;<input class="inputLine" type="text" name="qualification" value="<%=qualification%>"></td>
	</tr>

</table>
<h2>&#9632;Background Note</h2>
<%for (int i = 0; i < noteNumber.size(); i++) { %>
<div style="border:1px solid #000000; margin-bottom: 20px;">
<table class="phaseTable">
	<tr>
		<td class="tableText">No.</td>
		<td style="width: 600px">&nbsp;：&nbsp;<%=noteNumber.get(i) %></td>
	</tr>
	<tr>
		<td class="tableText">開始</td>
		<td>&nbsp;：&nbsp;<input style="height: 24px" type="text" name="beginning<%=i %>" value="<%=beginning.get(i) %>"></td>
	</tr>
	<tr>
		<td class="tableText">終了</td>
		<td>&nbsp;：&nbsp;<input style="height: 24px" type="text" name="end<%=i %>" value="<%=end.get(i) %>"></td>
	</tr>
	<tr>
		<td class="tableText" style="min-width: 90px; vertical-align: top">業務内容</td>
		<td>&nbsp;：&nbsp;<textarea class="textRow" name="task<%=i %>"><%=task.get(i) %></textarea></td>
	</tr>
</table>
<p style="font-weight: bold">フェーズ</p>
<table class="phaseTable">
	<tr>
		<td style="width: 70px; font-weight: bold">要件定義</td>
		<td class="tableWidth">&nbsp;：&nbsp;
		<select class="inputWidth" name="requirement<%=i %>">
			<option value="<%=requirement.get(i).get(0) %>"><%=requirement.get(i).get(0) %></option>
			<%if (requirement.get(i).get(0) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select></td>
		<td style="width: 70px; font-weight: bold">基本設計</td>
		<td class="tableWidth">&nbsp;：&nbsp;
		<select class="inputWidth" name="basic<%=i %>">
			<option value="<%=basic.get(i).get(1) %>"><%=basic.get(i).get(1) %></option>
			<%if (basic.get(i).get(1) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select></td>
	</tr>
	<tr>
		<td style="width: 70px; font-weight: bold">詳細設計</td>
		<td class="tableWidth">&nbsp;：&nbsp;
		<select class="inputWidth" name="details<%=i %>">
			<option value="<%=details.get(i).get(2) %>"><%=details.get(i).get(2) %></option>
			<%if (details.get(i).get(2) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select></td>
		<td style="width: 70px; font-weight: bold">PG製造</td>
		<td class="tableWidth">&nbsp;：&nbsp;
		<select class="inputWidth" name="pg<%=i %>">
			<option value="<%=pg.get(i).get(3) %>"><%=pg.get(i).get(3) %></option>
			<%if (pg.get(i).get(3) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select></td>
	</tr>
	<tr>
		<td style="width:70px; font-weight: bold">単体試験</td>
		<td class="tableWidth">&nbsp;：&nbsp;
		<select class="inputWidth" name="single<%=i %>">
			<option value="<%=single.get(i).get(4) %>"><%=single.get(i).get(4) %></option>
			<%if (single.get(i).get(4) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select></td>
		<td style="width: 70px; font-weight: bold">結合試験</td>
		<td class="tableWidth">&nbsp;：&nbsp;
		<select class="inputWidth" name="join<%=i %>">
			<option value="<%=join.get(i).get(5) %>"><%=join.get(i).get(5) %></option>
			<%if (join.get(i).get(5) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select></td>
	</tr>
	<tr>
		<td style="width: 70px; font-weight: bold">客先試験</td>
		<td class="tableWidth">&nbsp;：&nbsp;
		<select class="inputWidth" name="customer<%=i %>">
			<option value="<%=customer.get(i).get(6) %>"><%=customer.get(i).get(6) %></option>
			<%if (customer.get(i).get(6) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select></td>
		<td style="width: 70px; font-weight: bold">環境設定</td>
		<td class="tableWidth">&nbsp;：&nbsp;
		<select class="inputWidth" name="environment<%=i %>">
			<option value="<%=environment.get(i).get(7) %>"><%=environment.get(i).get(7) %></option>
			<%if (environment.get(i).get(7) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select></td>
	</tr>
</table>
<p style="margin-bottom:1em;"></p>
<table class="phaseTable">
	<tr>
		<td class="tableText">人数</td>
		<td style="width: 600px">&nbsp;：&nbsp;<input class="inputWidth" type="text" name="peopleNumber<%=i %>" value="<%=peopleNumber.get(i) %>"></td>
	</tr>
	<tr>
		<td class="tableText" style="min-width: 90px; vertical-align: top">開発環境</td>
		<td>&nbsp;：&nbsp;<textarea class="textRow" name="development<%=i %>"><%=development.get(i) %></textarea></td>
	</tr>
</table>
<p style="margin-bottom:1em;"></p>
</div>
<%} %>


<%
session.setAttribute("noteNumber", noteNumber);
%>
<!-- DB input -->
<input type="hidden" name="db_number" value="<%=db_number %>">
<input type="hidden" name="db_name" value="<%=db_name %>">
<input type="hidden" name="master_flg" value="<%=master_flg %>">
<input type="hidden" name="filename" value="<%=filename %>">
<div class="buttonTable">
<input class="editButton" type="submit" value="確認">
<input class="editButton" type="submit" value="項目追加" formaction="/SkillList/ItemAddBL">
<input class="editButton" type="submit" value="戻る" formaction="/SkillList/SkillBL">
</div>
</form>



</body>
</html>