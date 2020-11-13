<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.text.*"
    session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SkillBLテスト出力実行</title>
</head>
<body>
<!-- Link "./test/SkillTest.jsp" -->

<!-- 文字コード宣言 -->
<%
request.setCharacterEncoding("UTF-8");
%>
<%!
@SuppressWarnings("unchecked")
%>
<!-- DBからの値 -->
<%
String db_number = (String) request.getAttribute("db_number");
String db_name = (String) request.getAttribute("db_name");
String master_flg = (String) request.getAttribute("master_flg");
String filename = (String) request.getAttribute("filename");
%>

<!-- Profile変数の設定 -->
<%
String kana = (String) request.getAttribute("kana");
String name = (String) request.getAttribute("name");
String address = (String) request.getAttribute("address");
String birthday = (String) request.getAttribute("birthday");
String age = (String) request.getAttribute("age");
String gender = (String) request.getAttribute("gender");
String background = (String) request.getAttribute("background");
String backgroundNumber = (String) request.getAttribute("backgroundNumber");
String nearestStation = (String) request.getAttribute("nearestStation");
String stationName = (String) request.getAttribute("stationName");
%>

<!-- Skill Info変数の設定 -->
<%
String os = (String) request.getAttribute("os");
String skill = (String) request.getAttribute("skill");
String tool = (String) request.getAttribute("tool");
String db = (String) request.getAttribute("db");
String qualification = (String) request.getAttribute("qualification");
%>

<!-- Background Noteの設定 リスト構造 および二重構造 -->
<%
List<String> noteNumber = (ArrayList<String>) request.getAttribute("noteNumber");
List<String> beginning = (ArrayList<String>) request.getAttribute("beginning");
List<String> end = (ArrayList<String>) request.getAttribute("end");
List<String> task = (ArrayList<String>) request.getAttribute("task");

ArrayList<List<String>> requirement = (ArrayList<List<String>>) request.getAttribute("requirement");
ArrayList<List<String>> basic = (ArrayList<List<String>>) request.getAttribute("basic");
ArrayList<List<String>> details = (ArrayList<List<String>>) request.getAttribute("details");
ArrayList<List<String>> pg = (ArrayList<List<String>>) request.getAttribute("pg");
ArrayList<List<String>> single = (ArrayList<List<String>>) request.getAttribute("single");
ArrayList<List<String>> join = (ArrayList<List<String>>) request.getAttribute("join");
ArrayList<List<String>> customer = (ArrayList<List<String>>) request.getAttribute("customer");
ArrayList<List<String>> environment = (ArrayList<List<String>>) request.getAttribute("environment");

List<String> peopleNumber = (ArrayList<String>) request.getAttribute("peopleNumber");
List<String> development = (ArrayList<String>) request.getAttribute("development");
%>

<!-- DB -->
<p style="font-weight: bold">DB</p>
<p>db_number&nbsp;：&nbsp;<%=db_number %></p>
<p>db_name&nbsp;：&nbsp;<%=db_name %></p>
<p>master_flg&nbsp;：&nbsp;<%=master_flg %></p>
<p>filename&nbsp;：&nbsp;<%=filename %></p>
<p>--------------------</p>

<!-- Profile -->
<p style="font-weight: bold">Profile</p>
<p>フリガナ&nbsp;：&nbsp;<%=kana %></p>
<p>名前&nbsp;：&nbsp;<%=name %></p>
<p>住所&nbsp;：&nbsp;<%=address %></p>
<p>生年月日&nbsp;：&nbsp;<%=birthday %></p>
<p>年齢&nbsp;：&nbsp;<%=age %></p>
<p>性別&nbsp;：&nbsp;<%=gender %></p>
<p>最終学歴&nbsp;：&nbsp;<%=background %></p>
<p>&nbsp;：&nbsp;<%=backgroundNumber %>年</p>
<p>最寄り駅&nbsp;：&nbsp;<%=nearestStation %>線</p>
<p>&nbsp;：&nbsp;<%=stationName %>駅</p>
<p>--------------------</p>
<!-- Skill Info -->
<p style="font-weight: bold">Skill Info</p>
<p>OS&nbsp;：&nbsp;<%=os %></p>
<p>スキル&nbsp;：&nbsp;<%=skill %></p>
<p>ツール&nbsp;：&nbsp;<%=tool %></p>
<p>データベース&nbsp;：&nbsp;<%=db %></p>
<p>資格&nbsp;：&nbsp;<%=qualification %></p>
<p>--------------------</p>
<!-- Background Note -->
<p style="font-weight: bold">Background Note</p>
<%for (int i = 0; i <  noteNumber.size(); i++) { %>
<p>No.&nbsp;：&nbsp;<%=noteNumber.get(i) %></p>
<p>開始&nbsp;：&nbsp;<%=beginning.get(i) %></p>
<p>終了&nbsp;：&nbsp;<%=end.get(i) %></p>
<p>業務内容&nbsp;：&nbsp;<%=task.get(i) %></p>

<p>要件定義&nbsp;：&nbsp;<%=requirement.get(i).get(0) %></p>
<p>基本設計&nbsp;：&nbsp;<%=basic.get(i).get(1) %></p>
<p>詳細設計&nbsp;：&nbsp;<%=details.get(i).get(2) %></p>
<p>PG設計&nbsp;：&nbsp;<%=pg.get(i).get(3) %></p>
<p>単体テスト&nbsp;：&nbsp;<%=single.get(i).get(4) %></p>
<p>結合テスト&nbsp;：&nbsp;<%=join.get(i).get(5) %></p>
<p>客先試験&nbsp;：&nbsp;<%=customer.get(i).get(6) %></p>
<p>環境設定&nbsp;：&nbsp;<%=environment.get(i).get(7) %></p>

<p>人数&nbsp;：&nbsp;<%=peopleNumber.get(i) %></p>
<p>開発環境&nbsp;：&nbsp;<%=development.get(i) %></p>
<p>--------------------</p>
<%} %>

</body>
</html>