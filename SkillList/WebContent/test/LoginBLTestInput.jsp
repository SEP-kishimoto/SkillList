<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginBLテスト入力実行</title>
</head>
<body>
<form method="GET" action="/SkillList/LoginBL"><br>
<input type="text" name="id" placeholder="IDを入力"><br>
<input type="text" name="password" placeholder="パスワードを入力"><br>
<!-- flgにloginが入力されている場合、flgが何もない場合 -->
<input type="text" name="flg" value="login" ><br>
<input type="submit" value="テスト実行">
</form>

</body>
</html>