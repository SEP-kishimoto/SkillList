<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.io.*,java.util.*,java.text.*"
	session="true"%>

<%@page import="java.util.ArrayList "%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/SkillList/css/Add.css">
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
	<div class="table">
	</div>
	<form action="/SkillList/AddCommit" method="post">
	<input type="hidden" name="noteNumber" value=<%=noteNumber%>>

<h2>DB登録画面のデータ</h2><br>
社員番号:<input type="text" name="db_number"  value=""><br>
フリガナ:<input type="text" name="kana"  value=""><br>
氏名:<input type="text" name="db_name"  value=""><br>
パスワード:<input type="text" name="password"  value=""><br>
<br>








<h2>Profile</h2><br>
現住所:<input type="text" name="address"  value=""><br>
生年月日:<input type="text" name="birthday"  value=""><br>
性別:<input type="text" name="gender"  value=""><br>
最終学歴(学校名):<input type="text" name="background"  value=""><br>
最終学歴(卒業した年):<input type="text" name="backgroundNumber"  value=""><br>
最寄り駅(路線名):<input type="text" name="nearestStation"  value=""><br>
最寄り駅(駅名):<input type="text" name="stationName"  value=""><br>
<h2>Skill Info</h2><br>
OS:<input type="text" name="os"  value=""><br>
スキル:<input type="text" name="skill"  value=""><br>
ツール:<input type="text" name="tool"  value=""><br>
データベース:<input type="text" name="db"  value=""><br>
資格:<input type="text" name="qualification"  value=""><br><br>


<h2>Background Note</h2>

<%for (int i = 0; i < noteNumber.size(); i++) { %>
<br><br>
番号:<%=noteNumber.get(i) %><br>
開始:<input style="height: 24px" type="text" name="beginning<%=i %>" value="<%=beginning.get(i) %>"><br>
終了:<input style="height: 24px" type="text" name="end<%=i %>" value="<%=end.get(i) %>"><br>
業務内容:<textarea class="textRow" name="task<%=i %>"><%=task.get(i) %></textarea><br>
フェーズ<br>
要件定義:<select class="inputWidth" name="requirement<%=i %>">
			<option value="<%=requirement.get(i) %>"><%=requirement.get(i) %></option>
			<%if (requirement.get(i) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select><br>

基本設計:<select class="inputWidth" name="basic<%=i %>">
			<option value="<%=basic.get(i) %>"><%=basic.get(i) %></option>
			<%if (basic.get(i) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select><br>

詳細設計:<select class="inputWidth" name="details<%=i %>">
			<option value="<%=details.get(i) %>"><%=details.get(i) %></option>
			<%if (details.get(i) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select><br>

PG製造:<select class="inputWidth" name="pg<%=i %>">
			<option value="<%=pg.get(i) %>"><%=pg.get(i) %></option>
			<%if (pg.get(i) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select><br>

単体試験:<select class="inputWidth" name="single<%=i %>">
			<option value="<%=single.get(i) %>"><%=single.get(i) %></option>
			<%if (single.get(i) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select><br>

結合試験:<select class="inputWidth" name="join<%=i %>">
			<option value="<%=join.get(i) %>"><%=join.get(i) %></option>
			<%if (join.get(i) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select><br>

客先試験:<select class="inputWidth" name="customer<%=i %>">
			<option value="<%=customer.get(i) %>"><%=customer.get(i) %></option>
			<%if (customer.get(i) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select><br>

環境設定:<select class="inputWidth" name="environment<%=i %>">
			<option value="<%=environment.get(i) %>"><%=environment.get(i) %></option>
			<%if (environment.get(i) == "") {%>
			<option value="◎">◎</option>
			<%} else { %>
			<option value=""></option>
			<%} %>
		</select><br>

人数:<input class="inputWidth" type="text" name="peopleNumber<%=i %>" value="<%=peopleNumber.get(i) %>"><br>
開発環境:<textarea class="textRow" name="development<%=i %>"><%=development.get(i) %></textarea>

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


	</div>
</form>

</body>
</html>