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
	
	<div>
		<ul class="pagination justify-content-center">
			<c:if test="${paging.prev==true}">
				<li class="page-item"><a class="page-link" href="getBoardList.do?page=${paging.startPage-1 }">이전</a></li>
			</c:if>
			<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
				<c:choose>
					<c:when test="${i==criteria.page }">	<!-- 현재 페이지 -->
						<li class="page-item active">
							<a class="page-link" href="getBoardList.do?page=${i }">${i }</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
							<a class="page-link" href="getBoardList.do?page=${i }">${i }</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.next==true}">
				<li class="page-item"><a class="page-link" href="getBoardList.do?page=${paging.endPage+1 }">다음</a></li>
			</c:if>
		</ul>
	</div>

<%@ include file="common/footer.jsp" %>