<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="common/header.jsp" %>

<!-- 검색 -->


	
<!-- 게시글 -->
	<div class="container py-5">
		<div class="d-flex justify-content-end">
			<form action="getBoardList.do" class="form-inline my-2" method="get">	
				<div class="row">
					<select class="form-control mr-1" name="condition">
						<option value="title">제목</option><option value="content">내용</option>
					</select>
					<input class="form-control" type="text" placeholder="검색" name="keyword"/>
					<button class="btn" type="submit"><i class="fas fa-search"></i></button>
					
				</div>
			</form>
		</div>
			
		<sec:authorize access="isAuthenticated()">
			<a href="insertBoard.jsp">글쓰기</a>
		</sec:authorize>
		
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr><th style="width:10%">#</th><th style="width:50%">제목</th><th style="width:20%">게시자</th><th style="width:20%">게시일</th></tr>
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
				<li class="page-item"><a class="page-link" href="getBoardList.do?page=${paging.startPage-1 }&condition=${criteria.condition}&keyword=${criteria.keyword}">이전</a></li>
			</c:if>
			<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
				<c:choose>
					<c:when test="${i==criteria.page }">	<!-- 현재 페이지 -->
						<li class="page-item active">
							<a class="page-link" href="getBoardList.do?page=${i }&condition=${criteria.condition}&keyword=${criteria.keyword}">${i }</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
							<a class="page-link" href="getBoardList.do?page=${i }&condition=${criteria.condition}&keyword=${criteria.keyword}">${i }</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.next==true}">
				<li class="page-item"><a class="page-link" href="getBoardList.do?page=${paging.endPage+1 }&condition=${criteria.condition}&keyword=${criteria.keyword}">다음</a></li>
			</c:if>
		</ul>
	</div>

<%@ include file="common/footer.jsp" %>