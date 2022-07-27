<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>사원목록</h3>
<table>
	<thaed>
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>대여총계</th>
			<th>대여횟수</th>
		</tr>
	</thaed>
	<tbody>
		<c:forEach items="${rentList}" var="rent">
			<tr>
				<td>${rent.rentNo}</td>
				<td>${rent.bookName}</td> 
				<td>${rent.rentPrice}</td>
				<td>${rent.rentStatus}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>