<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${pageContext.request.contextPath}/board?name=choi&title=test
	<c:url value="/board" var="boardListUrl"> <!-- / : contextPath다음을 가르킴 -->
		<c:param name="name" value="choi"></c:param>
		<c:param name="title" value="test"></c:param>
	</c:url>
<a href="${boardListUrl}">게시판</a>
<a href="<c:url value="boardList"/>">게시판</a>
</body>
</html>