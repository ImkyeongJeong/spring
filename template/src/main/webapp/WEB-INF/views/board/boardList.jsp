<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="//cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" rel="stylesheet" />
<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script>
	$(function() {
		//$('#myTable').DataTable();
	});

	function goPage(num){
		searchFrm.pageNum.value = num; //$('[name="pageNum"]').val(num)
		searchFrm.submit();
	}
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
</head>
<body>

<form name="searchFrm">
	<input type="hidden" name="pageNum" value="1">
	<select name="type">
		<option value="title">제목
		<option value="content">내용
		<option value="writer">작성자
	</select>
	<input name="keyword">
	<button>검색</button>
</form>
	<h3>게시글목록</h3>
		<a href="boardInsert"><button>글쓰기</button></a>
	<table style="text-align: center" id="myTable" class="table table-dark table-striped table-hover">
		<thead>
			<th width="50">글번호</th>
			<th width="150">제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일자</th>
		</thead>
		<tbody>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.bno}</td>
					<td><a href="board/${board.bno}">${board.title}</td>
					<td>${board.writer}</td>
					<td>${board.regDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- 페이징처리 -->
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
	  
	  <c:if test="${pageMaker.prev}">
	    <li class="page-item"><a class="page-link" href="#" onclick="goPage(${pageMaker.startPage-1})">Previous</a></li>
	  </c:if>
	  
	  <!-- startPage와 endPage를 for문 돌림 -->
	  <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">
	    <li class="page-item"><a class="page-link" href="#" onclick="goPage(${num})">${num}</a></li>
	  </c:forEach>
	  
	  <c:if test="${pageMaker.next}">
	    <li class="page-item"><a class="page-link" href="#" onclick="goPage(${pageMaker.endPage+1})">Next</a></li>
	  </c:if>
	  </ul>
	</nav>
</body>
</html>