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
			<th>표지</th>
			<th>출판일자</th>
			<th>금액</th>
			<th>출판사</th>
			<th>도서소개</th>
		</tr>
	</thaed>
	<tbody>
		<c:forEach items="${list}" var="book">
			<tr>
				<td>${book.bookNo}</td>
				<td>${book.bookName}</td> 
				<td><img src="/images/${book.bookConverimg}"></td>
				<td><fmt:formatDate value="${book.bookDate}" pattern="yyyy/MM/dd"/> </td>
				<td><fmt:formatNumber value="${book.bookPrice}" pattern="####,####"/></td>
				<td>${book.bookPublisher}</td>
				<td>${book.bookInfo}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>