<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スキルシート管理システム</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String kana = request.getParameter("kana");
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String birthday = request.getParameter("birthday");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String background = request.getParameter("background");
	String backgroundNumber = request.getParameter("backgroundNumber");
	String nearestStation = request.getParameter("nearestStation");
	String stationName = request.getParameter("stationName");






%>
<h3>スキルシート管理システム:スキルシート登録</h3>
<br>
<h4>■Profile</h4>
<form action="../SkillList/AddCommit" method="post">
<div class="table">
<table>
	<tr><th>フリガナ* : </th><td><%=kana%></td></tr>
	<tr><th>氏名* : </th><td><%=name%></td></tr>
	<tr><th>現住所* : </th><td><%=address%></td></tr>
	<tr><th>生年月日* : </th><td><%=birthday%></td></tr>
	<tr><th>年齢 : </th><td><%=age%></td></tr>	<!-- javascriptを使って自動表示 -->
	<tr><th>性別* : </th><td><%=gender%></td></tr>
	<tr><th>最終学歴* : </th><td><%=background%></td><td><%=backgroundNumber%>年</td></tr>
	<tr><th>最寄り駅* : </th><td><%=stationName%></td><td><%=nearestStation%></td></tr>

</table>
</div>
<input type="hidden" name="kana" value=<%=kana%>>
<input type="hidden" name="name" value=<%=name%>>
<input type="hidden" name="address" value=<%=address%>>
<input type="hidden" name="birthday" value=<%=birthday%>>
<input type="hidden" name="age" value=<%=age%>>
<input type="hidden" name="gender" value=<%=gender%>>
<input type="hidden" name="background" value=<%=background%>>
<input type="hidden" name="backgroundNumber" value=<%=backgroundNumber%>>
<input type="hidden" name="nearestStation" value=<%=nearestStation%>>
<input type="hidden" name="station" value=<%=stationName%>>
<button type="submit" class="btn">確認</button>
</form>

<form action="../SkillList/Add.jsp" method="post">
<button type="submit" class="btn">戻る</button>
</form>
</body>

</body>
</html>