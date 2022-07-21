<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>사원정보</h3>
	<table>
		<thead>
			<tr>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="emp" items="${empList}">
			<tr>
				<td>${emp.employee_id}</td>
				<td>${emp.first_name}</td>
				<td>${emp.last_name}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>