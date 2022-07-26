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
	<!-- 검색 기능 -->
	<form>
		사번<input name="employeeId">
		부서<input type="checkbox" name="depts" value="10">10
			<input type="checkbox" name="depts" value="20">20
			<input type="checkbox" name="depts" value="30">30
		직무<select name="jobId">
				<option value="">선택
				<option value="IT_PROG">IT_PROG
				<option value="ST_CLERK">ST_CLERK
				<option value="ST_MAN">ST_MAN	
			</select>
		입사일자<input type="date" name="sdt">~<input type="date" name="edt">
		<button>검색</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
				<th>department_id</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="emp" items="${empList}">
			<tr>
				<td><a href="empUpdate/${emp.employeeId}">${emp.employeeId}</a></td>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.email}</td>
				<td>${emp.hireDate}</td>
				<td>${emp.jobId}</td>
				<td>${emp.salary}</td>
				<td>${emp.departmentId}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>