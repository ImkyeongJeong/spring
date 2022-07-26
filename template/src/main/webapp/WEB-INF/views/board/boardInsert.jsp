<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardInsert.jsp</title>
</head>
<body>
<h4>게시글 등록</h4>
<div>
	<form action="boardInsert" method="post">
		제 목 : <input name="title"><br>
		작성자: <input name="writer"><br> 
		내 용 : <textarea name="content"></textarea><br>
		<button>등록</button>
	</form>
	<a href="boardList"><button>목록으로</button></a>
</div>
</body>
</html>