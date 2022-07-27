<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookInsert.jsp</title>
</head>
<body>
<h4>도서등록</h4>

<form action="bookInsert" method="post">
	<div>도서번호<input name="bookNo"></div>	
	<div>도서명<input name="bookName"></div>
	<div>도서표지<input name="bookConverimg"></div>
	<div>출판일자<input name="bookDate"></div>
	<div>금액<input name="bookPrice"></div>
	<div>출판사<input name="bookPublisher"></div>
	<div>도서소개<textarea name="bookInfo"></textarea>
	<button>등록</button>
</form>
</body>
</html>