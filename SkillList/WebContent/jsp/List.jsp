<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>技術者一覧画面</title>
</head>
<body>
	<h1>スキルシート管理システム：技術者一覧</h1>
	<!-- 新規登録 -->
	<form>
		<input formaction="http://localhost:8080/ExcelTest/Add.jsp"
			type="submit" name="send" value="新規登録"
			style="width: 100px; height: 25px">
	</form>
	<!-- 技術者一覧 -->
	<table border="1" style="border-collapse: collapse;">
		<tr class="column">
			<th><div class="column_number">社員No.</div></th>
			<th><div class="column_name">名前</div></th>
		</tr>
		<%
			ResultSet rs = (ResultSet) request.getAttribute("ResultSet");//ListBLからrs受け取り
			while (rs.next()) {
				String db_number = (String) rs.getString("db_number");
				String db_name = (String) rs.getString("db_name");
				String filename = (String) rs.getString("filename");
		%>
		<form>
		<tr class="cell">
			<td><%=db_number%></td>
			<td><%=db_name%></td>
		</tr>
		</form>
		<%
			}
		%>
	</table>
</body>
</html>