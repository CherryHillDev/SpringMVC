<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp" %>


<div class="container py-5">
	<c:if test="${username == board.writer}">
		<div class="row">		
			<a class="btn btn-info" href="getUpdateBoard.do?id=${board.id }">수정</a><a class="btn btn-danger" href="deleteBoard.do?id=${board.id }">삭제</a>
		</div>	
	</c:if>
	
	<table class="table">
		<thead>
			<tr><td>${board.id }</td><td>${board.title }</td></tr>
		</thead>
		<tr><td>${board.writer }</td><td>${board.created_time }</td></tr>
		<tbody>
			<tr><td>${board.content }</td></tr>
		</tbody>
	</table>

	<table>
		<tr><td>댓글</td></tr>
		<c:forEach items="comments" var="comment">
			<tr>
				<td>${comment.writer }</td><td>${comment.content }</td><td>${comment.created_time }</td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="common/footer.jsp" %>