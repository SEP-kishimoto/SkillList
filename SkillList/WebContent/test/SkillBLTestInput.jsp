<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 文字コード宣言 -->
<%
request.setCharacterEncoding("UTF-8");
%>
<form method="POST" action="/SkillList/SkillBL"><br>
<input type="text" name="db_number" value="9999"><br>
<input type="text" name="db_name" value="試験男"><br>
<select name="master_flg">
<option value="0">0</option>
<option value="1">1</option>
</select><br>
<input type="text" name="filename" value="SkillSheet_9999_試験男.xlsx"><br>
<input type="submit" value="テスト実行">
</form>
</body>
</html>