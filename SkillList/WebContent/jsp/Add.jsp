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
<script type="text/javascript">



</script>
</head>
<body>
<%

// DB登録情報
String db_number = (String) request.getAttribute("db_number");
String db_name = (String) request.getAttribute("db_name");
String password = (String) request.getAttribute("password");


String kana = (String) request.getAttribute("kana");
String errmsg = (String) request.getAttribute("errmsg");


//Profile
	String address = "";
	String birthday = "";
	String age = "";
	String gender = "";
	String background = "";
	String backgroundNumber = "";
	String nearestStation = "";
	String stationName = "";

	// Skill Info
	String os = "";
	String skill = "";
	String tool = "";
	String db = "";
	String qualification = "";

	String entry_flg = (String) request.getAttribute("entry_flg");

	if (entry_flg != null) {	// AddCheckBLから戻ってきたときの処理
		//Profile
		address = (String) request.getAttribute("address");
		birthday = (String) request.getAttribute("birthday");
		age = (String) request.getAttribute("age");
		gender = (String) request.getAttribute("gender");
		background = (String) request.getAttribute("background");
		backgroundNumber = (String) request.getAttribute("backgroundNumber");
		nearestStation = (String) request.getAttribute("nearestStation");
		stationName = (String) request.getAttribute("stationName");

		// Skill Info
		os = (String) request.getAttribute("os");
		skill = String.valueOf(request.getAttribute("skill"));;
		tool = String.valueOf(request.getAttribute("tool"));
		db = (String) request.getAttribute("db");
		qualification = (String) request.getAttribute("qualification");
	}

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
System.out.println(noteNumber);
%>
<h1>スキルシート管理システム:スキルシート登録</h1>
<br>
<%if (errmsg != null) {
	out.print(errmsg);
}
	%>

<h2>■Profile</h2>
<form action="/SkillList/AddCheckBL" method="post">
<input type="hidden" name="db_number" value=<%=db_number%>>
<input type="hidden" name="password" value=<%=password%>>
<input type="hidden" name="db_name" value=<%=db_name%>>
<input type="hidden" name="kana" value=<%=kana%>>
<input type="hidden" name="noteNumber" value=<%=noteNumber%>>
<div class="table">
<table>
	<tr><th>フリガナ* : </th><td><%=kana %></td></tr>
	<tr><th>氏名* : </th><td><%=db_name %></td></tr>
	<tr><th>現住所* : </th><td><input type="text" name="address" value=<%=address%>></td></tr>
	<tr><th>生年月日* : </th><td><input type="text" name="birthday" value=<%=birthday%>></td></tr>
	<tr><th>年齢 : </th><td><input type="text" name="age" value=<%=age%>></td></tr>	<!-- javascriptを使って自動表示 -->
	<tr><th>性別* : </th><td><input type="text" name="gender" value=<%=gender%>></td></tr>
	<tr><th>最終学歴* : </th><td><input type="text" name="background" value=<%=background%>></td><!-- 卒業した年 --><td><input type="text" name="backgroundNumber" value=<%=backgroundNumber%>>年</td></tr>
	<tr><th>最寄り駅* : </th><!-- 路線名 --><td><input type="text" name="nearestStation" value=<%=nearestStation%>></td><!-- 駅名 --><td><input type="text" name="stationName" value=<%=stationName%>></td></tr>

</table>


<h2>■Skill Info</h2>
<table>
	<tr><th>OS : </th><td><input type="text" name="os" value=<%=os%>></td></tr>
	<tr><th>スキル : </th><td><input type="text" class="" name="skill" value=<%=skill%>></td></tr>
	<tr><th>ツール : </th><td><input type="text" name="tool" value=<%=tool%>></td></tr>
	<tr><th>データベース : </th><td><input type="text" name="db" value=<%=db%>></td></tr>
	<tr><th>資格 : </th><td><input type="text" name="qualification" value=<%=qualification%>></td></tr>

</table>

<h2>■Background Note</h2>
<%System.out.println(beginning); %>
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
	<!-- 本来二重構造 -->
	<tr>
		<td>要件定義</td>
		<td><input type="text" name="requirement<%=i %>" value="<%=requirement.get(i)%>"></td>
		<td>基本設計</td>
		<td><input type="text" name="basic<%=i %>" value="<%=basic.get(i) %>"></td>
	</tr>
	<tr>
		<td>詳細設計</td>
		<td><input type="text" name="details<%=i %>" value="<%=details.get(i) %>"></td>
		<td>PG製造</td>
		<td><input type="text" name="pg<%=i %>" value="<%=pg.get(i) %>"></td>
	</tr>
	<tr>
		<td>単体試験</td>
		<td><input type="text" name="single<%=i %>" value="<%=single.get(i) %>"></td>
		<td>結合試験</td>
		<td><input type="text" name="join<%=i %>" value="<%=join.get(i) %>"></td>
	</tr>
	<tr>
		<td>客先試験</td>
		<td><input type="text" name="customer<%=i %>" value="<%=customer.get(i) %>"></td>
		<td>環境設定</td>
		<td><input type="text" name="environment<%=i %>" value="<%=environment.get(i) %>"></td>
	</tr>
	<!-- ここまで本来二重構造 -->
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


<button type="submit" class="btn"  name="addition_flg" value="1">項目追加</button><!-- AddCheckBLで項目追加の処理を行う-->
<button type="submit" class="btn"  name="addition_flg" value="0">確認</button>

</div></form>

<form action="/SkillList/jsp/DB_Add.jsp" method="post">
<input type="hidden" name="db_number" value=<%=db_number%>>
<input type="hidden" name="password" value=<%=password%>>
<input type="hidden" name="db_name" value=<%=db_name%>>
<input type="hidden" name="kana" value=<%=kana%>>
<button type="submit" class="btn" name="return_flg" value="1">戻る</button>
</form>
</body>
</html>