<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/SkillList/css/Popup.css">
</head>
<body>
	<div style="display: inline-flex">
		<form>
			<input class="edit_btn" type="submit" value="編集"
				formaction="./jsp/Edit.jsp">
		</form>
		<form id="delete_form" method="post" action="/SkillList/DeleteBL">
			<input type="button" id="deleteBtn" value='ユーザーを削除' onclick="DeletePopUp()">
			<div id="deleteModal" class="modal">
				<div class="modal-content">
					<div class="modal-body">
						<span class="delete_span" style="text-align: center;">下記の技術者の
							<br>・ユーザーアカウント<br>・スキルシート<br>を削除します。よろしいですか？
						</span>

						<p class="delete_p">Ｐタグ</p>

						<input type="hidden" name="db_number" value=""> <input
							type="hidden" name="filename" value=""><input
							form="delete_form" type="submit" value="OK"> <input
							type="button" id="deleteCloseBtn" value="キャンセル">
					</div>
				</div>
			</div>
		</form>
		<form id="download_form" method="post" action="/SkillList/DownloadBL">
		<%String filename="SkillSheet_0000_セル番号まとめ.xlsx";%>
			<input type="button" id="downloadBtn" value='ダウンロード' onclick="DownloadPopUp()">
			<div id="downloadModal" class="modal">
				<div class="modal-content">
					<div class="modal-body">
						<span class="download_span" style="text-align: center;">下記の技術者のスキルシートをダウンロードします。
							<br>よろしいですか？
						</span>

						<p class="download_p">Ｐタグ</p>

						<input type="hidden" name="db_number" value="">
							<input type="hidden" name="filename" value="<%=filename%>">
							<input
							form="download_form" type="submit" value="OK"> <input
							type="button" id="DownloadCloseBtn" value="キャンセル">
					</div>
				</div>
			</div>
		</form>
		<form id="logout_form" method="post" action="/SkillList/LoginBL">

			<input type="button" id="logoutBtn" value='ダウンロード' onclick="LogputPopUp()">
			<div id="logoutModal" class="modal">
				<div class="modal-content">
					<div class="modal-body">
						<span class="logout_span" style="text-align: center;">ログアウトします。
							<br>よろしいですか？
						</span>
							<input
							form="logout_form" type="submit" value="OK"> <input
							type="button" id="LogoutCloseBtn" value="キャンセル">
					</div>
				</div>
			</div>
		</form>
	</div>


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