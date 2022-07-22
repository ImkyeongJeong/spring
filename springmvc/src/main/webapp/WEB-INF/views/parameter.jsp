<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="req1">
	<input name="id">
	<button>스트링</button>
</form>
<hr>
<form action="req2">
	<input type="checkbox" name="ids" value="100">100
	<input type="checkbox" name="ids" value="101">101
	<input type="checkbox" name="ids" value="102">102
	<button>스트링배열</button>
</form>
<hr>
<form action="req3">
	<input name="id">
	<input type="checkbox" name="ids" value="100">100
	<input type="checkbox" name="ids" value="101">101
	<input type="checkbox" name="ids" value="102">102
	<button>맵</button>
</form>
<hr>
<form action="req4">
	<input name="id">
	<input type="checkbox" name="ids" value="100">100
	<input type="checkbox" name="ids" value="101">101
	<input type="checkbox" name="ids" value="102">102
	<button>VO</button>
	<!-- VO를 List로 생성 -->
</form>
<hr>
<form action="req5">
<div>
	<!-- VO의 필드명따라 배열을 정해줘서 name을 지정한다. -->
	<input name="list[0].id">
	<input type="checkbox" name="list[0].ids" value="100">100
	<input type="checkbox" name="list[0].ids" value="101">101
	<input type="checkbox" name="list[0].ids" value="102">102
</div>	
<div>
	<input name="list[1].id">
	<input type="checkbox" name="list[1].ids" value="100">100
	<input type="checkbox" name="list[1].ids" value="101">101
	<input type="checkbox" name="list[1].ids" value="102">102
</div>	
<div>
	<input name="list[2].id">
	<input type="checkbox" name="list[2].ids" value="100">100
	<input type="checkbox" name="list[2].ids" value="101">101
	<input type="checkbox" name="list[2].ids" value="102">102
</div>	
	<button>List&lt;VO&gt;</button>
</form>
<hr>
<!-- multipart/form-data로 지정해야 한다.type이 file인 form이 있다면 -->
<form action="req6" method="post" enctype="multipart/form-data">
	<input name="id">
	<input type="checkbox" name="ids" value="100">100
	<input type="checkbox" name="ids" value="101">101
	<input type="checkbox" name="ids" value="102">102
	<input type="file" name="pic" multiple="multiple">
	<button>첨부파일</button>
</form>

<!-- url경로에 변수 -->
<a href="req7/jeong/20">pathvariable</a>
</body>
</html>