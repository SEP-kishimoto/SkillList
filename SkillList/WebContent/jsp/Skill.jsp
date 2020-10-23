<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"
    session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/SkillList/css/Popup.css">
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
db_number = (String) request.getAttribute("db_number");
db_name = (String) request.getAttribute("db_name");
master_flg = (String) request.getAttribute("master_flg");
filename = (String) request.getAttribute("filename");
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

<h1>スキルシート管理システム：詳細</h1>

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
		<td><%=task.get(i) %></td>
	</tr>
	<tr>
		<td>要件定義</td>
		<td><%=requirement.get(i).get(0) %></td>
		<td>基本設計</td>
		<td><%=basic.get(i).get(1) %></td>
	</tr>
	<tr>
		<td>詳細設計</td>
		<td><%=details.get(i).get(2) %></td>
		<td>PG製造</td>
		<td><%=pg.get(i).get(3) %></td>
	</tr>
	<tr>
		<td>単体試験</td>
		<td><%=single.get(i).get(4) %></td>
		<td>結合試験</td>
		<td><%=join.get(i).get(5) %></td>
	</tr>
	<tr>
		<td>客先試験</td>
		<td><%=customer.get(i).get(6) %></td>
		<td>環境設定</td>
		<td><%=environment.get(i).get(7) %></td>
	</tr>
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


<!-- DB input -->
<input type="hidden" name="db_number" value="<%=db_number %>">
<input type="hidden" name="db_name" value="<%=db_name %>">
<input type="hidden" name="master_flg" value="<%=master_flg %>">
<input type="hidden" name="filename" value="<%=filename %>">

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

<!-- BackgroundNote input -->
<%
session.setAttribute("noteNumber", noteNumber);
session.setAttribute("beginning", beginning);
session.setAttribute("end", end);
session.setAttribute("task", task);

session.setAttribute("requirement", requirement);
session.setAttribute("basic", basic);
session.setAttribute("details", details);
session.setAttribute("pg", pg);
session.setAttribute("single", single);
session.setAttribute("join", join);
session.setAttribute("customer", customer);
session.setAttribute("environment", environment);

session.setAttribute("peopleNumber", peopleNumber);
session.setAttribute("development", development);
%>

	<div style="display: inline-flex">
			<input class="edit_btn" type="submit" value="編集"
				formaction="./jsp/Edit.jsp">
			<input type="button" id="deleteBtn" value='ユーザーを削除' onclick="DeletePopUp()">
			<div id="deleteModal" class="modal">
				<div class="modal-content">
					<div class="modal-body">
						<span class="delete_span" style="text-align: center;">下記の技術者の
							<br>・ユーザーアカウント<br>・スキルシート<br>を削除します。よろしいですか？
						</span>

						<p class="delete_p">Ｐタグ</p>

						<input
							type="submit" value="OK" formaction="/SkillList/DeleteBL"> <input
							type="button" id="deleteCloseBtn" value="キャンセル">
					</div>
				</div>
			</div>
			<input type="button" id="downloadBtn" value='ダウンロード' onclick="DownloadPopUp()">
			<div id="downloadModal" class="modal">
				<div class="modal-content">
					<div class="modal-body">
						<span class="download_span" style="text-align: center;">下記の技術者のスキルシートをダウンロードします。
							<br>よろしいですか？
						</span>

						<p class="download_p">Ｐタグ</p>
        <p><label>パラメタ1:</label><input type="text" name="param1" /></p>
        <p><label>パラメタ2:</label><input type="text" name="param2" /></p>
        <p><label>パラメタ3:</label><input type="text" name="param3" /></p>
							<input
							type="submit" value="OK" formaction="/SkillList/DownloadBL"> <input
							type="button" id="DownloadCloseBtn" value="キャンセル">
					</div>
				</div>
			</div>
			<input type="button" id="logoutBtn" value='ログアウト' onclick="LogoutPopUp()">
			<div id="logoutModal" class="modal">
				<div class="modal-content">
					<div class="modal-body">
						<span class="logout_span" style="text-align: center;">ログアウトします。
							<br>よろしいですか？
						</span>
						<p></p>
							<input
							type="submit" value="OK" formaction="/SkillList/LoginBL"> <input
							type="button" id="logoutCloseBtn" value="キャンセル">
					</div>
				</div>
			</div>
	</div>
<%if(master_flg.equals("1")){%>
<input type="submit" value="戻る" formaction="/SkillList/LoginBL">
<%}%>

	<script>
		function DeletePopUp() {
			var btn = document.getElementById('deleteBtn');
			var modal = document.getElementById('deleteModal');

			btn.addEventListener('click', function() {
				modal.style.display = 'block';
			})
			var closeBtn = document.getElementById('deleteCloseBtn');

			closeBtn.addEventListener('click', function() {
				modal.style.display = 'none';
			})
		}

		function DownloadPopUp() {
			var btn = document.getElementById('downloadBtn');
			var modal = document.getElementById('downloadModal');

			btn.addEventListener('click', function() {
				modal.style.display = 'block';
			})
			var closeBtn = document.getElementById('DownloadCloseBtn');

			closeBtn.addEventListener('click', function() {
				modal.style.display = 'none';
			})
		}

		function LogoutPopUp() {
			var btn = document.getElementById('logoutBtn');
			var modal = document.getElementById('logoutModal');

			btn.addEventListener('click', function() {
				modal.style.display = 'block';
			})
			var closeBtn = document.getElementById('logoutCloseBtn');

			closeBtn.addEventListener('click', function() {
				modal.style.display = 'none';
			})
		}
	</script>
</body>
</html>