<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スキルシート管理システム</title>
<script type="text/javascript">


</script>
</head>
<body>
<h3>スキルシート管理システム:スキルシート登録</h3>
<br>
<h4>■Profile</h4>
<form action="../AddCheckBL" method="post">
<div class="table">
<table>
	<tr><th>フリガナ* : </th><td><input type="text" name="kana" value=""></td></tr>
	<tr><th>氏名* : </th><td><input type="text" class="address-txt" name="name" value=""></td></tr>
	<tr><th>現住所* : </th><td><input type="text" name="address" value=""></td></tr>
	<tr><th>生年月日* : </th><td><input type="date" name="birthday"></td></tr>
	<tr><th>年齢 : </th><td><input type="text" name="age"></td></tr>	<!-- javascriptを使って自動表示 -->
	<tr><th>性別* : </th><td><input type="text" name="gender" ></td></tr>
	<tr><th>最終学歴* : </th><td><input type="text" name="background" value=""></td><!-- 卒業した年 --><td><input type="text" name="backgroundNumber" value="">年</td></tr>
	<tr><th>最寄り駅* : </th><!-- 路線名 --><td><input type="text" name="nearestStation" value=""></td><!-- 駅名 --><td><input type="text" name="stationName" value=""></td></tr>

</table>

<!--
<h4>■Skill Info</h4>
<table>
	<tr><th>OS : </th><td><input type="text" name="os" value=""></td></tr>
	<tr><th>スキル : </th><td><input type="text" class="" name="skill" value=""></td></tr>
	<tr><th>ツール : </th><td><input type="text" name="tool" value=""></td></tr>
	<tr><th>データベース : </th><td><input type="text" name="db" value=></td></tr>
	<tr><th>資格 : </th><td><input type="text" name="qualification" value=></td></tr>

</table>



<h4>■BackGround Note</h4>
<table>
	<tr><th>No. : </th><td><input type="text" name="number" value=""></td></tr>
	<tr><th>期間 : </th><td><input type="text" class="address-txt" name="period" value=""></td></tr>
	<tr><th>業務内容 : </th><td><input type="text" name="content" value=""></td></tr>
</table>

<p><h4>フェーズ</h4>
<table>
	<tr><th>要件定義 : </th><td><input type="text" name="youkenteigi" value=""></td><td></td><th>単体試験 : </th><td><input type="text" name="only_test" value=""></td></tr>
	<tr><th>基本設計 : </th><td><input type="text" class="kihonsekkei" name="name" value=""></td><td></td><th>総合試験 : </th><td><input type="text" name="total_test" value=""></td></tr>
	<tr><th>詳細設計 : </th><td><input type="text" name="syousaisekkei" value=""></td><td></td><th>客先試験 : </th><td><input type="text" name="client_test" value=""></td></tr>
	<tr><th>PG製造 : </th><td><input type="text" name="pgseizou" value=></td><td></td><th>環境設定 : </th><td><input type="text" name="setting" value=""></td></tr>
</table>

<table>
	<tr><th>人数 : </th><td><input type="text" name="count" value=""></td></tr>
	<tr><th>開発環境 : </th><td><input type="text" class="address-txt" name="development_environment" value=""></td></tr>
</table>
<br>

<input type="button" id="add" name="add" value="追加">
<button type="submit" class="btn" name="add" >確認</button>
 -->
<button type="submit" class="btn">確認</button>

</div></form>

<form action="../SkillList/List.jsp" method="post">
<button type="submit" class="btn">戻る</button>
</form>
</body>
</html>