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

	<table class="table">
		<tr><td>댓글</td></tr>
		<c:if test="${!empty comments }">
			<c:forEach items="${comments }" var="comment">
				<tr>
					<td>${comment.writer }</td><td>${comment.content }</td><td>${comment.created_time }</td>
					<td>
						<form action="insertComment.do" method="post">
							<input type="hidden" name="board_id" value="${board.id }">
							<input type="hidden" name="group_id" value="${comment.group_id }">
							<input type="hidden" name="writer" value="${username }">
							<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName }"/>
							<textarea rows="" cols="" name="content" placeholder="내용을 입력하세요"></textarea>
							<input type="submit" class="btn btn-info" value="대댓글 달기">
						</form>
					</td>
					<c:if test="${username==comment.writer }">
						<td>
							<button>수정</button>
							<form action="updateComment.do" method="post">
								<input type="hidden" name="board_id" value="${board.id }">
								<input type="hidden" name="id" value="${comment.id }">
								<textarea rows="" cols="" name="content">${comment.content }</textarea>
								<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName }"/>
								<input type="submit" class="btn btn-info" value="수정 완료">
							</form>
							<form action="deleteComment.do">
								<input type="hidden" name="board_id" value="${board.id }">
								<input type="hidden" name="id" value="${comment.id }">
								<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName }"/>
								<input type="submit" class="btn btn-danger" value="삭제">
							</form>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>
		<tr><td>
			<form action="insertComment.do" method="post">
				<input type="hidden" name="board_id" value="${board.id }">
				<input type="hidden" name="writer" value="${username }">
				<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName }"/>
				<textarea rows="" cols="" name="content" placeholder="내용을 입력하세요"></textarea>
				<input type="submit" class="btn btn-info" value="댓글 달기">
			</form>
		</td></tr>
	</table>
</div>

<%@ include file="common/footer.jsp" %>