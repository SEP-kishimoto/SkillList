<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>技術者一覧画面</title>
<link rel="stylesheet" type="text/css" href="/SkillList/css/List.css">
</head>
<body>
	<h1>スキルシート管理システム：技術者一覧</h1>
	<!-- 新規登録 -->
	<form>
		<div class="head_div">
			<div class="in_div">
				<!-- テスト用のリンク先を指定して遷移を確認する -->
				<!-- ./test/LinkCheck.jsp ./jsp/DB_Add.jsp-->
				<input class="new_input" formaction="./jsp/DB_Add.jsp" type="submit"
					name="send" value="新規登録">
			</div>
		</div>
	</form>
	<!-- 技術者一覧 -->
	<table class="listTable">
		<tr class="column">
			<th><div class="column_number">社員No.</div></th>
			<th><div class="column_name">名前</div></th>
		</tr>
		<%
			ResultSet rs = (ResultSet) request.getAttribute("ResultSet");//ListBLからrs受け取り
			while (rs.next()) {
				String db_number = (String) rs.getString("db_number");
				String db_name = (String) rs.getString("db_name");
				String master_flg = (String) rs.getString("master_flg");
				String filename = (String) rs.getString("filename");
		%>
		<!-- テスト用のリンク先を指定してログアウト等を確認する -->
		<!-- ./test/ListTestOutput.jsp /SkillList/SkillBL-->
		<form method="POST" action="/SkillList/SkillBL">
		<tr class="data">
			<td><%=db_number%></td>
			<td><input class="db_name" type="submit" value="<%=db_name%>">
				<input type="hidden" name="db_number" value="<%=db_number%>">
				<input type="hidden" name="db_name" value="<%=db_name%>"> <input
				type="hidden" name="master_flg" value="<%=master_flg%>"> <input
				type="hidden" name="filename" value="<%=filename%>"></td>
		</tr>
		</form>

		<%
			}
		%>
	</table>

	<form>
		<div class="head_div">
			<div class="in_div">
				<input class="logout_input" type="button" id="logoutBtn"
					value='ログアウト' onclick="LogoutPopUp()">
				<div id="logoutModal" class="modal">
					<div class="modal-content">
						<div class="modal-body">
							<span class="logout_span" style="text-align: center;">ログアウトします。
								<br>よろしいですか？
							</span>
							<p></p>
							<!-- テスト用のリンク先を指定して遷移を確認する -->
							<!-- ./test/LinkCheck.jsp -->
							<input type="submit" value="OK" formaction="/SkillList/LoginBL">
							<input type="button" id="logoutCloseBtn" value="キャンセル">
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
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