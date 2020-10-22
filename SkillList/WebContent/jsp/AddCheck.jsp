<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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



	// BackGround Note
	String noteNumber = (String) request.getAttribute("noteNumber");
	String beginning = (String) request.getAttribute("beginning");
	String end = (String) request.getAttribute("end");
	String task = (String) request.getAttribute("task");
	String requirement = request.getParameter("requirement");
	String basic = (String) request.getAttribute("basic");
	String details = (String) request.getAttribute("details");
	String pg = (String) request.getAttribute("pg");
	String single = (String) request.getAttribute("single");
	String join = (String) request.getAttribute("join");
	String customer = (String) request.getAttribute("customer");
	String environment = (String) request.getAttribute("environment");
	String peopleNumber = (String) request.getAttribute("peopleNumber");
	String development = (String) request.getAttribute("development");





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
<table>
	<tr><th>No. : </th><td><%=noteNumber%></td></tr>
	<tr><th>期間 : </th><td><%=beginning%></td><td>～<%=end%></td></tr>
	<tr><th>業務内容 : </th><td><%=task%></td></tr>
</table>

<p><h3>フェーズ</h3>
<table>
	<tr><th>要件定義 : </th><td><%=requirement%></td><td></td><th>単体試験 : </th><td><%=single%></td></tr>
	<tr><th>基本設計 : </th><td><%=basic%></td><td></td><th>総合試験 : </th><td><%=join%></td></tr>
	<tr><th>詳細設計 : </th><td><%=details%></td><td></td><th>客先試験 : </th><td><%=customer%></td></tr>
	<tr><th>PG製造 : </th><td><%=pg%></td><td></td><th>環境設定 : </th><td><%=environment%></td></tr>
</table>

<table>
	<tr><th>人数 : </th><td><%=peopleNumber%></td></tr>
	<tr><th>開発環境 : </th><td><%=development%></td></tr>
</table>
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
<!-- Background Note -->
<input type="hidden" name="noteNumber" value=<%=noteNumber%>>
<input type="hidden" name="beginning" value=<%=beginning%>>
<input type="hidden" name="end" value=<%=end%>>
<input type="hidden" name="task" value=<%=task%>>
<input type="hidden" name="requirement" value=<%=requirement%>>
<input type="hidden" name="basic" value=<%=basic%>>
<input type="hidden" name="details" value=<%=details%>>
<input type="hidden" name="pg" value=<%=pg%>>
<input type="hidden" name="single" value=<%=single%>>
<input type="hidden" name="join" value=<%=join%>>
<input type="hidden" name="customer" value=<%=customer%>>
<input type="hidden" name="environment" value=<%=environment%>>
<input type="hidden" name="peopleNumber" value=<%=peopleNumber%>>
<input type="hidden" name="development" value=<%=development%>>
<button type="submit" class="btn">確認</button>
</form>

<form action="/SkillList/jsp/Add.jsp" method="post">
<button type="submit" class="btn">戻る</button>
</form>
</body>

</body>
</html>