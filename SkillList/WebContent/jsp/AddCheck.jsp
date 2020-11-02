<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"
    session="true" %>

<%@page import="java.util.ArrayList "%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/SkillList/css/Add_Check.css">
<meta charset="UTF-8">
<title>スキルシート管理システム</title>
</head>
<body>
<%

	request.setCharacterEncoding("utf-8");

	//DB登録情報
	String db_number = (String) request.getAttribute("db_number");
	String db_name = (String) request.getAttribute("db_name");	// Profileの氏名も同じものを使用
	String password = (String) request.getAttribute("password");

	// Profile
	String kana = (String) request.getAttribute("kana");
	String address = (String) request.getAttribute("address");
	String birthday = (String) request.getAttribute("birthday");
	String age = (String) request.getAttribute("age");
	String gender = (String) request.getAttribute("gender");
	String background = (String) request.getAttribute("background");
	String backgroundNumber = (String) request.getAttribute("backgroundNumber");
	String nearestStation = (String) request.getAttribute("nearestStation");
	String stationName = (String) request.getAttribute("stationName");

	// Skill Info
	String os = (String) request.getAttribute("os");
	String skill = String.valueOf(request.getAttribute("skill"));;
	String tool = String.valueOf(request.getAttribute("tool"));
	String db = (String) request.getAttribute("db");
	String qualification = (String) request.getAttribute("qualification");


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
List<String> requirement = new ArrayList<>();
List<String>basic = new ArrayList<>();
List<String> details = new ArrayList<>();
List<String> pg = new ArrayList<>();
List<String> single = new ArrayList<>();
List<String> join = new ArrayList<>();
List<String> customer = new ArrayList<>();
List<String> environment = new ArrayList<>();
%>

<!-- Background Note変数 リスト構造 -->
<%
List<String> peopleNumber = new ArrayList<String>();
List<String> development = new ArrayList<String>();

%>
<%!
@SuppressWarnings("unchecked")	// 警告解除
%>
<!-- Background Noteの設定 リスト構造 本来は二重構造 -->
<%
noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");
beginning = (ArrayList<String>) session.getAttribute("beginning");
end = (ArrayList<String>) session.getAttribute("end");
task = (ArrayList<String>) session.getAttribute("task");

requirement = (ArrayList<String>) session.getAttribute("requirement");
basic = (ArrayList<String>) session.getAttribute("basic");
details = (ArrayList<String>) session.getAttribute("details");
pg = (ArrayList<String>) session.getAttribute("pg");
single = (ArrayList<String>) session.getAttribute("single");
join = (ArrayList<String>) session.getAttribute("join");
customer = (ArrayList<String>) session.getAttribute("customer");
environment = (ArrayList<String>) session.getAttribute("environment");

peopleNumber = (ArrayList<String>) session.getAttribute("peopleNumber");
development = (ArrayList<String>) session.getAttribute("development");
%>
<div class="table">
<h2>スキルシート管理システム:スキルシート登録</h2>
<br>
<h2>&#9632;Profile</h2>
</div>
<form action="../SkillList/AddCommit" method="post">
<table>
	<tr>
		<td class="tableText" style="min-width: 90px">フリガナ*</td>
		<td style="width: auto">&nbsp;：&nbsp;<%=kana%></td>
	</tr>
	<tr>
		<td class="tableText">氏名*</td>
		<td style="width: auto">&nbsp;：&nbsp;<%=db_name%></td>
	</tr>
	<tr>
		<td class="tableText">現住所*</td>
		<td style="width: auto">&nbsp;：&nbsp;<%=address%></td>
	</tr>
	<tr>
		<td class="tableText">生年月日*</td>
		<td style="width: auto">&nbsp;：&nbsp;<%=birthday%>&nbsp;生</td>
	</tr>
	<tr>
		<td class="tableText">年齢*</td>
		<td style="width: auto">&nbsp;：&nbsp;<%=age%>&nbsp;歳</td>
	</tr>
	<tr>
		<td class="tableText">性別*</td>
		<td style="width: auto">&nbsp;：&nbsp;<%=gender%></td>
	</tr>
</table>
<table>
	<tr>
		<td class="tableText">最終学歴*</td>
		<td>&nbsp;：&nbsp;<%=background%></td>
		<td>&nbsp;：&nbsp;<%=backgroundNumber%>&nbsp;年</td>
	</tr>
	<tr>
		<td class="tableText">最寄り駅*</td>
		<td>&nbsp;：&nbsp;<%=nearestStation%>&nbsp;線</td>
		<td>&nbsp;：&nbsp;<%=stationName%>&nbsp;駅</td>
	</tr>
</table>

<h2>■Skill Info</h2>
<table>
	<tr>
		<td class="tableText" style="min-width: 90px">OS</td>
		<td>&nbsp;：&nbsp;<%=os%></td>
	</tr>
	<tr>
		<td class="tableText">スキル</td>
		<td>&nbsp;：&nbsp;<%=skill%></td>
	</tr>
	<tr>
		<td class="tableText">ツール</td>
		<td>&nbsp;：&nbsp;<%=tool%></td>
	</tr>
	<tr>
		<td class="tableText" style="width: 100px; min-width: 100px">データベース</td>
		<td>&nbsp;：&nbsp;<%=db%></td>
	</tr>
	<tr>
		<td class="tableText" style="vertical-align: top">資格</td>
		<td style="vertical-align: top">&nbsp;：&nbsp;<%=qualification%></td>
	</tr>
</table>

<h2>■Background Note</h2>
<%for (int i = 0; i < noteNumber.size(); i++) { %>
<div style="border:1px solid #000000; margin-bottom: 20px;">
<table>
	<tr>
		<td class="tableText">No.</td>
		<td>&nbsp;：&nbsp;<%=noteNumber.get(i) %></td>
	</tr>
	<tr>
		<td class="tableText">開始</td>
		<td>&nbsp;：&nbsp;<%=beginning.get(i) %></td>
	</tr>
	<tr>
		<td class="tableText">終了</td>
		<td>&nbsp;：&nbsp;<%=end.get(i) %></td>
	</tr>
	<tr>
		<td class="tableText" style="font-weight: bold; width: 90px; vertical-align: top">業務内容</td>
		<td style="height: 24px; vertical-align: top">&nbsp;：&nbsp;<%=task.get(i) %></td>
	</tr>
</table>
<p style="font-weight: bold">フェーズ</p>
<table>
	<tr>
		<td class="tableText">要件定義</td>
		<td>&nbsp;：&nbsp;<%=requirement.get(i) %></td>
		<td class="tableText">基本設計</td>
		<td>&nbsp;：&nbsp;<%=basic.get(i) %></td>
	</tr>
	<tr>
		<td class="tableText">詳細設計</td>
		<td>&nbsp;：&nbsp;<%=details.get(i) %></td>
		<td class="tableText">PG製造</td>
		<td>&nbsp;：&nbsp;<%=pg.get(i) %></td>
	</tr>
	<tr>
		<td class="tableText">単体試験</td>
		<td>&nbsp;：&nbsp;<%=single.get(i) %></td>
		<td class="tableText">結合試験</td>
		<td>&nbsp;：&nbsp;<%=join.get(i) %></td>
	</tr>
	<tr>
		<td class="tableText">客先試験</td>
		<td>&nbsp;：&nbsp;<%=customer.get(i) %></td>
		<td class="tableText">環境設定</td>
		<td>&nbsp;：&nbsp;<%=environment.get(i) %></td>
	</tr>
</table>
<p style="margin-bottom:1em;"></p>
<table>
	<tr>
		<td class="tableText">人数</td>
		<td>&nbsp;：&nbsp;<%=peopleNumber.get(i) %></td>
	</tr>
	<tr>
		<td class="tableText" style="font-weight: bold; width: 90px; vertical-align: top">開発環境</td>
		<td style="height: 24px; vertical-align: top">&nbsp;：&nbsp;<%=development.get(i) %></td>
	</tr>
</table>
<p style="margin-bottom:1em;"></p>
</div>
<%} %>
<!-- DB登録情報 -->
<input type="hidden" name="db_number" value=<%=db_number%>>
<input type="hidden" name="db_name" value=<%=db_name%>><!-- Profileの氏名も同じものを使用 -->
<input type="hidden" name="password" value=<%=password%>>
<!-- Profile -->
<input type="hidden" name="kana" value=<%=kana%>>
<input type="hidden" name="address" value=<%=address%>>
<input type="hidden" name="birthday" value=<%=birthday%>>
<input type="hidden" name="age" value=<%=age%>>
<input type="hidden" name="gender" value=<%=gender%>>
<input type="hidden" name="background" value=<%=background%>>
<input type="hidden" name="backgroundNumber" value=<%=backgroundNumber%>>
<input type="hidden" name="nearestStation" value=<%=nearestStation%>>
<input type="hidden" name="stationName" value=<%=stationName%>>
<!-- Skill Info -->
<input type="hidden" name="os" value=<%=os%>>
<input type="hidden" name="skill" value=<%=skill%>>
<input type="hidden" name="tool" value=<%=tool%>>
<input type="hidden" name="db" value=<%=db%>>
<input type="hidden" name="qualification" value=<%=qualification%>>
<div class="buttonTable">
<button type="submit" class="addCheckButton">登録</button>
<input type="button" value="戻る" class="addCheckButton" onclick="history.back()" formaction="/SkillList/jsp/Add.jsp"><!-- ヒストリーバック使用 -->
</div>
</form>


</body>

</body>
</html>