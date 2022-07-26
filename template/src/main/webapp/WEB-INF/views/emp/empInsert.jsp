<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
</head>
<body>
<h4>사원등록</h4>
<form action="empInsert" method="post">
	employeeId :<input name="employeeId"><br>
	firstName : <input name="firstName"><br> 
	lastName : <input name="lastName"><br>
	email : <input name="email"><br>
	<!-- 데이트로 적어놔도 String으로 들어가기 떄문에 vo에서 @DateTiemFormat지정해준다. -->
	hireDate : <input type="date" name="hireDate"><br> 
	JobId : <input name="JobId"><br>
	<button>등록</button>
</form>
</body>
</html>