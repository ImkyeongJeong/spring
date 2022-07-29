<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 시큐리티 관련 태그 -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body>

<h1>로그인 페이지</h1>
${param.error}
<form action="login" method="post">
	<!-- 토근 생성 -->
  <sec:csrfInput/>
  <!-- <sec:csrfInput/>와 동일 -->
  <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }"/> --%>
  <dl>
    <dt>로그인 ID</dt>
    <dd>
    	<!-- 스프링에서 사용하는 id가 username임 -->
      <input type="text" name="username">
    </dd>
    <dt>패스워드</dt>
    <dd>
      <input type="password" name="password">
    </dd>
  </dl>
  <button>로그인</button>
</form>
</body>
</html>
