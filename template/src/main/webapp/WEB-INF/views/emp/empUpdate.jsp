<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 날짜 형식 변경해주는 태그 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empUpdate.jsp</title>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<h4>사원수정</h4>
<!-- /mvc/empUpdate로 경로해줘도 됨 -->
<form action="${path}/empUpdate" method="post">
	employeeId :<input name="employeeId" value="${emp.employeeId}" readonly="readonly"><br>
	firstName : <input name="firstName" value="${emp.firstName}"><br> 
	lastName : <input name="lastName" value="${emp.lastName}"><br>
	email : <input name="email" value="${emp.email}"><br>
	<!-- Date로 적어놔도 String으로 들어가기 떄문에 vo에서 @DateTiemFormat지정해준다. -->
	hireDate : <input type="date" name="hireDate"
				 value='<fmt:formatDate value="${emp.hireDate}" pattern="yyyy-MM-dd"/>'><br> 
	JobId : <input name="JobId" value="${emp.jobId}"><br>
	<button>등록</button>
	<button type="button" id="btnDelete">삭제</button>
</form>

<script>
	btnDelete.addEventListener("click", function(){
		location.href="${path}/empDelete?employeeId=${emp.employeeId}";
	});
</script>
</body>
</html>