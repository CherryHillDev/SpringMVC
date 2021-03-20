<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="common/header.jsp" %>
	
<!-- 게시글 -->
	<div class="container py-5">
		<sec:authorize access="isAuthenticated()">
			<a href="insertBoard.jsp">글쓰기</a>
		</sec:authorize>
		
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr><th>#</th><th>제목</th><th>게시자</th><th>게시일</th></tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList }" var="board">
					<tr><th>${board.id }</th>
					<th><a href="getBoard.do?id=${board.id }">${board.title }</a></th>
					<th>${board.writer }</th><th>${board.created_time }</th></tr>
				</c:forEach>
			</tbody>
				
		</table>
	</div>

<%@ include file="common/footer.jsp" %>