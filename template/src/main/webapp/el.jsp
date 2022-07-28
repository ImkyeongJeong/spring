<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL 내장객체</h3>
<%
	request.setAttribute("name", "길동");
	session.setAttribute("name", "세션");
	application.setAttribute("name", "어플");
	request.setAttribute("list", Arrays.asList("joeng","park","kim"));
%>
<ul>
	<!-- el안에서 사용할 수 있는 내장객체 : param -->
	<li>파라미터=============</li>
	<li><%= request.getParameter("id") %></li>
	<li>${param.id}</li>
	<li>${param["id"]}</li>
	
	<!-- request,session,application 속성 읽을 때 / el은 null체크 형변환 알아서 해준다. -->
	<!-- page,request,session,application 순서로 읽어낸다. -->
	<li>속성=============</li>
	<li><%=request.getAttribute("name") %></li>
	<li>${name}</li> 							<!-- ${requestScope.name}과 동일 -->
	<li>${sessionScope.name}</li> 				<!-- session은 map구조 -->
	<li>${applicationScope.name}</li>
	
	<li>헤더=============</li>
	<li><%= request.getHeader("User-Agent") %></li>
	<li>${header["User-Agent"]}</li>
	
	<li>쿠키=============</li>
	<li>${cookie.openYn.value}</li>
	
	<li>초기화파라미터======</li>
	<li><%= application.getInitParameter("contextConfigLocation") %></li>
	<li>${initParam.contextConfigLocation}</li>
	
	<li>EL함수===========</li>
	<li>리스트 크기 ${fn:length(list)}</li>
	<li>해당 단어로 시작여부 : ${fn:startsWith(name, "길")}</li> <!-- true,false -->
	
	<li><c:out escapeXml="true" value="<u>태그</u>" />
	<li><c:out escapeXml="false" value="<u>태그</u>" />
	
</ul>
</body>
</html>