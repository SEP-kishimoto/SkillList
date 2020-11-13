<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.io.*,java.util.*,java.text.*"
	session="true"%>

<%@page import="java.util.ArrayList "%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/SkillList/css/Add.css">
<meta charset="UTF-8">
<title>登録画面</title>
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

		System.out.println(db_number);
		System.out.println(db_name);
		System.out.println(password);
		System.out.println(kana);

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

		if (entry_flg != null) { // AddCheckBLから戻ってきたときの処理
			//Profile
			address = (String) request.getAttribute("address");
			birthday = (String) request.getAttribute("birthday");
			gender = (String) request.getAttribute("gender");
			background = (String) request.getAttribute("background");
			backgroundNumber = (String) request.getAttribute("backgroundNumber");
			nearestStation = (String) request.getAttribute("nearestStation");
			stationName = (String) request.getAttribute("stationName");

			// Skill Info
			os = (String) request.getAttribute("os");
			skill = String.valueOf(request.getAttribute("skill"));
			;
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
		List<String> basic = new ArrayList<>();
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
	<%!@SuppressWarnings("unchecked") // 警告解除%>
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
	<div class="title">
	<h1>スキルシート管理システム:スキルシート登録</h1>
	</div>
	<br>
<% if (errmsg != null) {%>
<p style="color: red"><%=errmsg %></p>
<%} %>
	<div class="table">
	</div>
	<form action="/SkillList/AddCheckBL" method="post">
		<input type="hidden" name="db_number" value=<%=db_number%>> <input
			type="hidden" name="password" value=<%=password%>> <input
			type="hidden" name="db_name" value=<%=db_name%>> <input
			type="hidden" name="kana" value=<%=kana%>> <input
			type="hidden" name="noteNumber" value=<%=noteNumber%>>
<h2>&#9632;Profile</h2>
<table class="phaseTable">
	<tr>
		<td class="tableText" style="min-width: 90px">フリガナ*</td>
		<td style="width: 600px">&nbsp;：&nbsp;<%=kana%></td>
	</tr>
	<tr>
		<td class="tableText">氏名*</td>
		<td>&nbsp;：&nbsp;<%=db_name%></td>
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
			<option value="<%=requirement.get(i) %>"><%=requirement.get(i) %></option>
			<%if (requirement.get(i) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select></td>
		<td style="width: 70px; font-weight: bold">基本設計</td>
		<td class="tableWidth">&nbsp;：&nbsp;
		<select class="inputWidth" name="basic<%=i %>">
			<option value="<%=basic.get(i) %>"><%=basic.get(i) %></option>
			<%if (basic.get(i) == "") {%>
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
			<option value="<%=details.get(i) %>"><%=details.get(i) %></option>
			<%if (details.get(i) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select></td>
		<td style="width: 70px; font-weight: bold">PG製造</td>
		<td class="tableWidth">&nbsp;：&nbsp;
		<select class="inputWidth" name="pg<%=i %>">
			<option value="<%=pg.get(i) %>"><%=pg.get(i) %></option>
			<%if (pg.get(i) == "") {%>
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
			<option value="<%=single.get(i) %>"><%=single.get(i) %></option>
			<%if (single.get(i) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select></td>
		<td style="width: 70px; font-weight: bold">結合試験</td>
		<td class="tableWidth">&nbsp;：&nbsp;
		<select class="inputWidth" name="join<%=i %>">
			<option value="<%=join.get(i) %>"><%=join.get(i) %></option>
			<%if (join.get(i) == "") {%>
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
			<option value="<%=customer.get(i) %>"><%=customer.get(i) %></option>
			<%if (customer.get(i) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select></td>
		<td style="width: 70px; font-weight: bold">環境設定</td>
		<td class="tableWidth">&nbsp;：&nbsp;
		<select class="inputWidth" name="environment<%=i %>">
			<option value="<%=environment.get(i) %>"><%=environment.get(i) %></option>
			<%if (environment.get(i) == "") {%>
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


			<br>
			<br>
			<br>
			<br>
		<div class="buttonTable">
			<button type="submit" class="editButton" name="addition_flg"
				value="0">確認</button>

				<button type="submit" class="editButton" name="addition_flg"
				value="1">項目追加</button><!-- AddCheckBLで項目追加の処理を行う-->

	<button type="submit" class="editButton" name="return_flg" value="1" formaction="/SkillList/jsp/DB_Add.jsp" >戻る</button>



	</div>
</form>

</body>
</html>