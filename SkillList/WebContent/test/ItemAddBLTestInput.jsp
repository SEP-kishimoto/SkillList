<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"
    session="true" %>
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
<%
ArrayList<String> noteNumber = new ArrayList<String>();
for (int i = 1; i <= 5; i++) {
	noteNumber.add(Integer.toString(i));
}
%>

<form method="POST" action="/SkillList/ItemAddBL">

<!-- DB関係 -->
<p style="font-weight: bold">DB</p>
<input type="text" name="db_number" value="9999"><br>
<input type="text" name="db_name" value="試験男"><br>
<select name="master_flg">
<option value="0">0</option>
<option value="1">1</option>
</select><br>
<input type="text" name="filename" value="SkillSheet_9999_試験男.xlsx"><br>
<p>--------------------</p>
<!-- Profile関係 -->
<p style="font-weight: bold">Profile</p>
<input type="text" name="kana" value="エドガワコナン"><br>
<input type="text" name="name" value="江戸川湖南"><br>
<input type="text" name="address" value="東京都新宿区"><br>
<input type="text" name="birthday" value="2000/01/01"><br>
<input type="text" name="gender" value="男"><br>
<input type="text" name="background" value="大学卒"><br>
<input type="text" name="backgroundNumber" value="2020"><br>
<input type="text" name="nearestStation" value="総武"><br>
<input type="text" name="stationName" value="新小岩"><br>
<p>--------------------</p>
<!-- Skill Info関係 -->
<p style="font-weight: bold">Skill Info</p>
<input type="text" name="os" value="Windows10"><br>
<input type="text" name="skill" value="Java,HTML,CSS"><br>
<input type="text" name="tool" value="Eclipse,Springboot"><br>
<input type="text" name="db" value="MySQL"><br>
<input type="text" name="qualification" value="情報処理"><br>
<p>--------------------</p>
<!-- Background Note関係 -->
<p style="font-weight: bold">Background Note</p>
<%for (int i = 0; i < noteNumber.size(); i++) { %>
<p>No.<%=noteNumber.get(i) %></p><br>
<input type="text" name="beginning<%=i %>" value="2018/01/01"><br>
<input type="text" name="end<%=i %>" value="2020/01/01"><br>
<input type="text" name="task<%=i %>" value="ビジネスマナー研修,プログラム研修,Javaの基本,"><br>
<input type="text" name="requirement<%=i %>" value="◎"><br>
<input type="text" name="basic<%=i %>" value="◎"><br>
<input type="text" name="details<%=i %>" value="◎"><br>
<input type="text" name="pg<%=i %>" value="◎"><br>
<input type="text" name="single<%=i %>" value="◎"><br>
<input type="text" name="join<%=i %>" value="◎"><br>
<input type="text" name="customer<%=i %>" value="◎"><br>
<input type="text" name="environment<%=i %>" value="◎"><br>
<input type="text" name="peopleNumber<%=i %>" value="3"><br>
<input type="text" name="development<%=i %>" value="Windows10,Linux,"><br>
<p>--------------------</p>
<%} %>
<%
session.setAttribute("noteNumber", noteNumber);
%>

<input type="submit" value="テスト実行">
</form>

</body>
</html>