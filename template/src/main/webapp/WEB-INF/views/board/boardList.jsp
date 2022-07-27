<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link href="//cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" rel="stylesheet" />
<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script>
	$(function() {
		//$('#myTable').DataTable();
		$('[name="type"]').val('${cri.type}') //선택값 selected되기 위함
		
		//수정, 삭제시 메시지 출력
		var result1 = '${result1}'
		var result2 = '${param.result2}'
		
		if(result1 != ''){
			const myModal = new bootstrap.Modal('#staticBackdrop', {});	//모달 객체 생성
			const modal = document.getElementById("staticBackdrop");
			$("#msg").html(result1);
			myModal.show(modal);
		}
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
${cri}

<div class="card">
  <div class="card-header">
    Featured
    <form name="searchFrm">
		<input type="hidden" name="pageNum" value="1">
		<select name="type">
			<option value="title">제목
			<option value="content" >내용
			<option value="writer">작성자
		</select>
		<input name="keyword" value="${cri.keyword}">
		<button>검색</button>
	</form>
  </div>
  
  <div class="card-body">
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
	</div>	
	
	
	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <div id="msg"></div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Understood</button>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>