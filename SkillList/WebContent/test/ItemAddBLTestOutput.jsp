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
<!-- Link "./test/EditTest.jsp" -->
<!-- 文字コード宣言 -->
<%
request.setCharacterEncoding("UTF-8");
%>
<%!
@SuppressWarnings("unchecked")
%>


<!-- errmsg -->
<%
String errmsg = (String) request.getAttribute("errmsg");
%>

<!-- DBからの値 -->
<%
String db_number = request.getParameter("db_number");
String db_name = request.getParameter("db_name");
String master_flg = request.getParameter("master_flg");
String filename = request.getParameter("filename");
%>

<!-- Profile変数の設定 -->
<%
String kana = request.getParameter("kana");
String name = request.getParameter("name");
String address = request.getParameter("address");
String birthday = request.getParameter("birthday");
String gender = request.getParameter("gender");
String background = request.getParameter("background");
String backgroundNumber = request.getParameter("backgroundNumber");
String nearestStation = request.getParameter("nearestStation");
String stationName = request.getParameter("stationName");
%>

<!-- Skill Info変数の設定 -->
<%
String os = request.getParameter("os");
String skill = request.getParameter("skill");
String tool = request.getParameter("tool");
String db = request.getParameter("db");
String qualification = request.getParameter("qualification");
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
ArrayList<List<String>> basic = new ArrayList<>();
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
<!-- Background Noteの設定 リスト構造 および二重構造 -->
<%

noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");
beginning = (ArrayList<String>) session.getAttribute("beginning");
end = (ArrayList<String>) session.getAttribute("end");
task = (ArrayList<String>) session.getAttribute("task");

requirement = (ArrayList<List<String>>) session.getAttribute("requirement");
basic = (ArrayList<List<String>>) session.getAttribute("basic");
details = (ArrayList<List<String>>) session.getAttribute("details");
pg = (ArrayList<List<String>>) session.getAttribute("pg");
single = (ArrayList<List<String>>) session.getAttribute("single");
join = (ArrayList<List<String>>) session.getAttribute("join");
customer = (ArrayList<List<String>>) session.getAttribute("customer");
environment = (ArrayList<List<String>>) session.getAttribute("environment");

peopleNumber = (ArrayList<String>) session.getAttribute("peopleNumber");
development = (ArrayList<String>) session.getAttribute("development");

%>

<!-- DB関係 -->
<p style="font-weight: bold">DB</p>
<input type="text" name="db_number" value="<%=db_number %>"><br>
<input type="text" name="db_name" value="<%=db_name %>"><br>
<select name="master_flg">
<option value="0">0</option>
<option value="1">1</option>
</select><br>
<input type="text" name="filename" value="<%=filename %>"><br>
<p>--------------------</p>
<!-- Profile関係 -->
<p style="font-weight: bold">Profile</p>
<input type="text" name="kana" value="<%=kana %>"><br>
<input type="text" name="name" value="<%=name %>"><br>
<input type="text" name="address" value="<%=address %>"><br>
<input type="text" name="birthday" value="<%=birthday %>"><br>
<input type="text" name="gender" value="<%=gender %>"><br>
<input type="text" name="background" value="<%=background %>"><br>
<input type="text" name="backgroundNumber" value="<%=backgroundNumber %>"><br>
<input type="text" name="nearestStation" value="<%=nearestStation %>"><br>
<input type="text" name="stationName" value="<%=stationName %>"><br>
<p>--------------------</p>
<!-- Skill Info関係 -->
<p style="font-weight: bold">Skill Info</p>
<input type="text" name="os" value="<%=os %>"><br>
<input type="text" name="skill" value="<%=skill %>"><br>
<input type="text" name="tool" value="<%=tool %>"><br>
<input type="text" name="db" value="<%=db %>"><br>
<input type="text" name="qualification" value="<%=qualification %>"><br>
<p>--------------------</p>
<!-- Background Note関係 -->
<p style="font-weight: bold">Background Note</p>
<%for (int i = 0; i < noteNumber.size(); i++) { %>
<p>No.<%=noteNumber.get(i) %></p><br>
<input type="text" name="beginning" value="<%=beginning.get(i) %>"><br>
<input type="text" name="end" value="<%=end.get(i) %>"><br>
<input type="text" name="task" value="<%=task.get(i) %>"><br>
<input type="text" name="requirement" value="<%=requirement.get(i).get(0) %>"><br>
<input type="text" name="basic" value="<%=basic.get(i).get(1) %>"><br>
<input type="text" name="details" value="<%=details.get(i).get(2) %>"><br>
<input type="text" name="pg" value="<%=pg.get(i).get(3) %>"><br>
<input type="text" name="single" value="<%=single.get(i).get(4) %>"><br>
<input type="text" name="join" value="<%=join.get(i).get(5) %>"><br>
<input type="text" name="customer" value="<%=customer.get(i).get(6) %>"><br>
<input type="text" name="environment" value="<%=environment.get(i).get(7) %>"><br>
<input type="text" name="peopleNumber" value="<%=peopleNumber.get(i) %>"><br>
<input type="text" name="development" value="<%=development.get(i) %>"><br>
<p>--------------------</p>
<%} %>

</body>
</html>