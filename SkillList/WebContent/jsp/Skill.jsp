<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"
    session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スキルシート詳細画面</title>
<link rel="stylesheet" type="text/css" href="/SkillList/css/Skill.css">
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

<h2>&#9632;Profile</h2>
<form method="post">
<table>
	<tr class="tableLayout">
		<td class="tableText" style="min-width: 90px">フリガナ*</td>
		<td style="width: auto; font-size: max(16px, 1vw)">&nbsp;：&nbsp;<%=kana%></td>
	</tr>
	<tr>
		<td class="tableText">氏名*</td>
		<td style="width: auto">&nbsp;：&nbsp;<%=name%></td>
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
		<td class="tableText" style="min-width: 90px">最終学歴*</td>
		<td style="width: auto">&nbsp;：&nbsp;<%=background%></td>
		<td style="width: auto">&nbsp;：&nbsp;<%=backgroundNumber%>&nbsp;年</td>
	</tr>
	<tr>
		<td class="tableText">最寄り駅*</td>
		<td style="width: auto">&nbsp;：&nbsp;<%=nearestStation%>&nbsp;線</td>
		<td style="width: auto">&nbsp;：&nbsp;<%=stationName%>&nbsp;駅</td>
	</tr>
</table>

<h2>&#9632;Skill Info</h2>
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
		<td class="tableText">資格</td>
		<td>&nbsp;：&nbsp;<%=qualification%></td>
	</tr>

</table>

<h2>&#9632;Background Note</h2>
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
</table>
<table>
	<tr>
		<td class="tableText" style="min-width: 90px; vertical-align: top">業務内容</td>
		<td style="height: 24px; vertical-align: top">&nbsp;：&nbsp;<%=task.get(i) %></td>
	</tr>
</table>
<p style="font-weight: bold">フェーズ</p>
<table class="phaseTable">
	<tr>
		<td class="tableText">要件定義</td>
		<td>&nbsp;：&nbsp;<%=requirement.get(i).get(0) %></td>
		<td class="tableText">基本設計</td>
		<td>&nbsp;：&nbsp;<%=basic.get(i).get(1) %></td>
	</tr>
	<tr>
		<td class="tableText">詳細設計</td>
		<td>&nbsp;：&nbsp;<%=details.get(i).get(2) %></td>
		<td class="tableText">PG製造</td>
		<td>&nbsp;：&nbsp;<%=pg.get(i).get(3) %></td>
	</tr>
	<tr>
		<td class="tableText">単体試験</td>
		<td>&nbsp;：&nbsp;<%=single.get(i).get(4) %></td>
		<td class="tableText">結合試験</td>
		<td>&nbsp;：&nbsp;<%=join.get(i).get(5) %></td>
	</tr>
	<tr>
		<td class="tableText">客先試験</td>
		<td>&nbsp;：&nbsp;<%=customer.get(i).get(6) %></td>
		<td class="tableText">環境設定</td>
		<td>&nbsp;：&nbsp;<%=environment.get(i).get(7) %></td>
	</tr>
</table>
<p style="margin-bottom:1em;"></p>
<table>
	<tr>
		<td class="tableText">人数</td>
		<td>&nbsp;：&nbsp;<%=peopleNumber.get(i) %></td>
	</tr>
	<tr>
		<td style="font-weight: bold; width: 90px; vertical-align: top">開発環境</td>
		<td style="height: 24px; vertical-align: top">&nbsp;：&nbsp;<%=development.get(i) %></td>
	</tr>
</table>
<p style="margin-bottom:1em;"></p>
</div>
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

	<div class="buttonTable">
			<!-- テスト用のリンク先 -->
			<!-- ./test/SkillTestOutput.jsp ./jsp/Edit.jsp-->
			<!-- 編集ボタン -->
			<input class="skillButton" type="submit" value="編集" formaction="./jsp/Edit.jsp">
			<!-- 削除ボタン -->
			<%String master_flg2=(String)session.getAttribute("master_flg");
			if(master_flg2.equals("1")){
			%>
			<input type="hidden" value="<%=master_flg2%>" name="master_flg2">
			<input class="skillButton" type="button" id="deleteBtn" value='ユーザーを削除' onclick="DeletePopUp()">
			<div id="deleteModal" class="modal">
				<div class="modal-content">
					<div class="modal-body">
						<span class="delete_span" style="text-align: center;">下記の技術者の
							<br>・ユーザーアカウント<br>・スキルシート<br>を削除します<br>削除を行った場合<br>データの復元はできません<br>本当に削除してもよろしいですか？
						</span>

						<p class="delete_p"><%=db_name %></p>

						<!-- テスト用のリンク先 -->
						<!-- ./test/LinkCheck.jsp /SkillList/DeleteBL-->
						<input
							type="submit" value="OK" formaction="/SkillList/DeleteBL"> <input
							type="button" id="deleteCloseBtn" value="キャンセル">
					</div>
				</div>
			</div>
			<%}%>
			<!-- ダウンロードボタン -->
			<input class="skillButton" type="button" id="downloadBtn" value='ダウンロード' onclick="DownloadPopUp()">
			<div id="downloadModal" class="modal">
				<div class="modal-content">
					<div class="modal-body">
						<span class="download_span" style="text-align: center;">下記の技術者のスキルシートをダウンロードします。
							<br>よろしいですか？
						</span>

						<p class="download_p"><%=db_name %></p>
						<!-- テスト用のリンク先 -->
						<!-- ./test/LinkCheck.jsp /SkillList/DownloadBL-->
							<input
							type="submit" value="OK" formaction="/SkillList/DownloadBL"> <input
							type="button" id="DownloadCloseBtn" value="キャンセル">
					</div>
				</div>
			</div>
			<!-- ログアウトボタン -->
			<input class="skillButton" type="button" id="logoutBtn" value='ログアウト' onclick="LogoutPopUp()">
			<div id="logoutModal" class="modal">
				<div class="modal-content">
					<div class="modal-body">
						<span class="logout_span" style="text-align: center;">ログアウトします。
							<br>よろしいですか？
						</span>
						<p></p>
						<!-- テスト用のリンク先 -->
						<!-- ./test/LinkCheck.jsp /SkillList/ListBL /SkillList/LoginBL-->
							<input
							type="submit" value="OK" formaction="/SkillList/LoginBL"> <input
							type="button" id="logoutCloseBtn" value="キャンセル">
					</div>
				</div>
			</div>
			<%
			if(master_flg2.equals("1")){
			%>
			<!-- テスト用のリンク先 -->
			<!-- ./test/LinkCheck.jsp /SkillList/ListBL-->
			<input type="hidden" value="<%=master_flg2%>" name="master_flg2">
			<input class="skillButton" type="submit" value="戻る" formaction="/SkillList/ListBL">
			<%}%>
	</div>
</form>
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