<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"
    session="true" %>

<%@page import="java.util.ArrayList "%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/SkillList/css/Add_Check.css">
<meta charset="UTF-8">
<title>スキルシート管理システム</title>
</head>
<body>
<%

	request.setCharacterEncoding("utf-8");

	//DB登録情報
	String db_number = (String) request.getAttribute("db_number");
	String db_name = (String) request.getAttribute("db_name");	// Profileの氏名も同じものを使用
	String password = (String) request.getAttribute("password");

	// Profile
	String kana = (String) request.getAttribute("kana");
	String address = (String) request.getAttribute("address");
	String birthday = (String) request.getAttribute("birthday");
	String age = (String) request.getAttribute("age");
	String gender = (String) request.getAttribute("gender");
	String background = (String) request.getAttribute("background");
	String backgroundNumber = (String) request.getAttribute("backgroundNumber");
	String nearestStation = (String) request.getAttribute("nearestStation");
	String stationName = (String) request.getAttribute("stationName");

	// Skill Info
	String os = (String) request.getAttribute("os");
	String skill = String.valueOf(request.getAttribute("skill"));;
	String tool = String.valueOf(request.getAttribute("tool"));
	String db = (String) request.getAttribute("db");
	String qualification = (String) request.getAttribute("qualification");


	// エラーメッセージ
	String errmsg = (String) request.getAttribute("errmsg");


%>
<!-- Background Note変数 リスト構造 -->
<%
List<String> noteNumber = new ArrayList<String>();
List<String> beginning = new ArrayList<String>();
List<String> end = new ArrayList<String>();
List<String> task = new ArrayList<String>();
%>

<!-- Background Note変数 フェーズ表示、List二重構造 -->
<%
ArrayList<List<String>> requirement = new ArrayList<>();
ArrayList<List<String>>basic = new ArrayList<>();
ArrayList<List<String>> details = new ArrayList<>();
ArrayList<List<String>> pg = new ArrayList<>();
ArrayList<List<String>> single = new ArrayList<>();
ArrayList<List<String>> join = new ArrayList<>();
ArrayList<List<String>> customer = new ArrayList<>();
ArrayList<List<String>> environment = new ArrayList<>();
%>

<!-- Background Note変数 リスト構造 -->
<%
List<String> peopleNumber = new ArrayList<String>();
List<String> development = new ArrayList<String>();

%>
<%!
@SuppressWarnings("unchecked")	// 警告解除
%>
<!-- Background Noteの設定 リスト構造 本来は二重構造 -->
<%
noteNumber = (ArrayList<String>) request.getAttribute("noteNumber");
beginning = (ArrayList<String>) request.getAttribute("beginning");
end = (ArrayList<String>) request.getAttribute("end");
task = (ArrayList<String>) request.getAttribute("task");

requirement = (ArrayList<List<String>>) request.getAttribute("requirement");
basic = (ArrayList<List<String>>)request.getAttribute("basic");
details = (ArrayList<List<String>>) request.getAttribute("details");
pg = (ArrayList<List<String>>) request.getAttribute("pg");
single = (ArrayList<List<String>>) request.getAttribute("single");
join = (ArrayList<List<String>>) request.getAttribute("join");
customer =(ArrayList<List<String>>) request.getAttribute("customer");
environment = (ArrayList<List<String>>) request.getAttribute("environment");

peopleNumber = (ArrayList<String>) request.getAttribute("peopleNumber");
development = (ArrayList<String>) request.getAttribute("development");
%>


<%if (errmsg != null) { %>
<br>
エラーメッセージ表示<br><br>
errmsg<br><br><%=errmsg %>




<% } else { %>
<br>
転送データ<br><br>
db_number:<%=db_number %><br><br>
kana:<%=kana %><br><br>
db_name:<%=db_name %><br><br>
password:<%=password %><br><br>

<h4>Profile</h4><br><br>

address:<%=address %><br><br>
birthday:<%=birthday %><br><br>
age:<%=age %><br><br>
gender:<%=gender %><br><br>
background:<%=background %><br><br>
backgroundNumber:<%=backgroundNumber %><br><br>
nearestStation:<%=nearestStation %><br><br>
stationName:<%=stationName %><br><br>

<h4>Skill Info</h4><br><br>
os:<%=os %><br><br>
skill:<%=skill %><br><br>
tool:<%=tool %><br><br>
db:<%=db %><br><br>
qualification:<%=qualification %><br><br>
skill:<%=skill %><br><br>
<h4>Background Note</h4><br><br>
<%for (int i = 0; i < noteNumber.size(); i++) { %>
noteNumber:<%=noteNumber.get(i) %><br><br>
beginning:<%=beginning.get(i) %><br><br>
end:<%=end.get(i) %><br><br>
task:<%=task.get(i) %><br><br>
requirement:<%=requirement.get(i).get(0) %><br><br>
basic:<%=basic.get(i).get(1) %><br><br>
details:<%=details.get(i).get(2) %><br><br>
pg:<%=pg.get(i).get(3) %><br><br>
single:<%=single.get(i).get(4) %><br><br>
join:<%=join.get(i).get(5) %><br><br>
customer:<%=customer.get(i).get(6) %><br><br>
environment:<%=environment.get(i).get(7) %><br><br>
peopleNumber:<%=peopleNumber.get(i) %><br><br>
development:<%=development.get(i) %><br><br>

<%} %>

<%} %>


</body>
</html>