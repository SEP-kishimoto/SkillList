<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" type="text/css" href="/SkillList/css/Login.css">
</head>
<body>
	<h1>スキルシート管理システム：ログイン</h1>
	<!-- テスト用の入力データ送信先 -->
	<!-- action="./test/LoginTestOutput.jsp" -->
	<form method="POST">
		<input type="hidden" value="login" name="flg">
		<table class="loginTable">
			<tr>
				<th class="id">ID：</th>
				<td class="text_td"><input type="text" name="id" class="text"></td>
			</tr>
			<tr>
				<th class="password">パスワード：</th>
				<td class="text_td"><input type="password" name="password"
					class="text"></td>
			</tr>
			<tr>
				<th></th>
				<td class="btn_td"><input type="submit" value="ログイン"
					class="btn"></td>
			</tr>
		</table>
	</form>
	<!-- エラー文受け取り -->
	<%
		String errmsg = (String) request.getAttribute("errmsg");
	%>
	<%
		if (errmsg != null) {
	%>
	<div class="errmsg">
		<%
			{
					out.println(errmsg);
				}
		%>
	</div>
	<%
		}
	%>
</body>
</html>