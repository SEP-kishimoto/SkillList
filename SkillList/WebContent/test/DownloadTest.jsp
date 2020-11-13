<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Downloadテスト実行</title>
</head>
<body>
<form method="POST" action="/SkillList/DownloadBL">

<input type="text" name="filename" value="SkillSheet_9999_試験男.xlsx"><br>


<input type="submit" value="テスト実行">
</form>
</body>
</html>