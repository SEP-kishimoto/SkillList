<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"
    session="true" %>

<%@page import="java.util.ArrayList "%>
<!DOCTYPE html>
<html>
<head>
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
<h1>スキルシート管理システム:スキルシート登録</h1>
<br>
<h2>■Profile</h2>
<form action="../SkillList/AddCommit" method="post">
<div class="table">
<table>
	<tr><th>フリガナ* : </th><td><%=kana%></td></tr>
	<tr><th>氏名* : </th><td><%=db_name%></td></tr>
	<tr><th>現住所* : </th><td><%=address%></td></tr>
	<tr><th>生年月日* : </th><td><%=birthday%></td></tr>
	<tr><th>年齢 : </th><td><%=age%></td></tr>	<!-- javascriptを使って自動表示 -->
	<tr><th>性別* : </th><td><%=gender%></td></tr>
	<tr><th>最終学歴* : </th><td><%=background%></td><td><%=backgroundNumber%>年</td></tr>
	<tr><th>最寄り駅* : </th><td><%=stationName%></td><td><%=nearestStation%></td></tr>


</table>

<br><br>
<h2>■Skill Info</h2>
<table>
	<tr><th>OS : </th><td><%=os%></td></tr>
	<tr><th>スキル : </th><td><%=skill%></td></tr>
	<tr><th>ツール : </th><td><%=tool%></td></tr>
	<tr><th>データベース : </th><td><%=db%></td></tr>
	<tr><th>資格 : </th><td><%=qualification%></td></tr>

</table>

<br><br>
<h2>■BackGround Note</h2>
<%for (int i = 0; i < noteNumber.size(); i++) { %>
<input type="hidden" name="beginning<%=i %>" value="<%=beginning.get(i) %>">
<input type="hidden" name="end<%=i %>" value="<%=end.get(i) %>">
<input type="hidden" name="task<%=i %>" value="<%=task.get(i) %>">
<!-- フェーズ -->
<input type="hidden" name="requirement<%=i %>" value="<%=requirement.get(i)%>">
<input type="hidden" name="basic<%=i %>" value="<%=basic.get(i) %>">
<input type="hidden" name="details<%=i %>" value="<%=details.get(i) %>">
<input type="hidden" name="pg<%=i %>" value="<%=pg.get(i) %>">
<input type="hidden" name="single<%=i %>" value="<%=single.get(i) %>">
<input type="hidden" name="join<%=i %>" value="<%=join.get(i) %>">
<input type="hidden" name="customer<%=i %>" value="<%=customer.get(i) %>">
<input type="hidden" name="environment<%=i %>" value="<%=environment.get(i) %>">
<!-- フェーズここまで -->
<input type="hidden" name="peopleNumber<%=i %>" value="<%=peopleNumber.get(i) %>">
<input type="hidden" name="development<%=i %>" value="<%=development.get(i) %>">
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
		<td><%=task.get(i) %></td>
	</tr>
	<!-- 本来二重構造 -->
	<tr>
		<td>要件定義</td>
		<td><%=requirement.get(i)%></td>
		<td>基本設計</td>
		<td><%=basic.get(i) %></td>
	</tr>
	<tr>
		<td>詳細設計</td>
		<td><%=details.get(i) %></td>
		<td>PG製造</td>
		<td><%=pg.get(i) %></td>
	</tr>
	<tr>
		<td>単体試験</td>
		<td><%=single.get(i) %></td>
		<td>結合試験</td>
		<td><%=join.get(i) %></td>
	</tr>
	<tr>
		<td>客先試験</td>
		<td><%=customer.get(i) %></td>
		<td>環境設定</td>
		<td><%=environment.get(i) %></td>
	</tr>
	<!-- ここまで本来二重構造 -->
	<tr>
		<td>人数</td>
		<td><%=peopleNumber.get(i) %></td>
	</tr>
	<tr>
		<td>開発環境</td>
		<td><%=development.get(i) %></td>
	</tr>
</table>
<%} %>
</div>
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
<button type="submit" class="btn">確認</button>
</form>

<form action="/SkillList/jsp/Add.jsp" method="post">
<input type="button" value="戻る" onclick="history.back()"><!-- ヒストリーバック使用 -->
</form>
</body>

</body>
</html>