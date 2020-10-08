<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td><button>編集</button></td>
		<td><button>削除</button></td>
		<td><button>ダウンロード</button></td>
		<td><button>ログアウト</button></td>
		<%if(request.getParameter("flg") == "1") {%>
		<td><button>戻る</button></td>
		<%} %>
	</tr>
</table>

</body>
</html>