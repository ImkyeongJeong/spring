<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardUpdate.jsp</title>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<h4>게시글 수정</h4>
<div>
	<form action="${path}/boardUpdate" method="post">
		글번호 : <input name="bno" value="${board.bno}" readonly><br>
		제 목 : <input name="title" value="${board.title}"><br>
		작성자: <input name="writer" value="${board.writer}"><br> 
		내 용 : <textarea name="content">${board.content}</textarea><br>
		<button>수정</button>
		<button type="button" id="btnDelete">삭제</button>
		<a href="boardList"><button>목록으로</button></a>
	</form>
</div>
<script>
	btnDelete.addEventListener("click", function(){
		location.href="${path}/boardDelete?bno=${board.bno}";
	});
</script>
</body>
</html>