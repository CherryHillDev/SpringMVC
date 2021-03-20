<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp" %>

<form action="updateBoard.do" method="post">
	<h3>글 수정하기</h3>
	<div class="container py-5">
		<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName }"/>
		<input type="hidden" value="${board.id}" name="id">
		<input type="hidden" value="${board.writer}" name="writer">
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" value="${board.title }" id="title" name="title">
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea rows="" cols="" class="form-control" id="content" name="content">${board.content }</textarea>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-secondary">수정 완료</button>
		</div>
	</div>
</form>

<%@ include file="common/footer.jsp" %>