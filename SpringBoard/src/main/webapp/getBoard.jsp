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
			<tr>
				<td style="color:gray; width: 5%">${board.id }</td>
				<td class="font-weight-bold">${board.title }</td>
				<td style="width:20%"><span style="color:graytext;">조회</span></td>
			</tr>
		</thead>
		<tr><td colspan="2">${board.writer }</td><td>${board.created_time }</td></tr>
		<tbody>
			<tr><td colspan="3">${board.content }</td></tr>
		</tbody>
	</table>

	<table class="table">
		<tr><td>댓글</td></tr>
		<c:if test="${!empty comments }">
			<c:forEach items="${comments }" var="comment" varStatus="status">
				<tr>
					<td>${comment.writer }</td><td width="55%">${comment.content }</td><td style="font-size: small;">${comment.created_time }</td>
					
					
					<td>
						<div class="row">
							<button class="btn btn-link btn-sm" onclick="recomment(${status.index})">대댓글</button>
							<c:if test="${username==comment.writer }">
							<button class="btn btn-success btn-sm" onclick="revise(${status.index})">수정</button>
							
							<form action="deleteComment.do">
								<input type="hidden" name="board_id" value="${board.id }">
								<input type="hidden" name="id" value="${comment.id }">
								<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName }"/>
								<button class="btn btn-danger btn-sm" type="submit">삭제</button>
							</form>
						</c:if>
						</div>
					</td>
					
					<tr id="recommentForm${status.index }" hidden="true">
						<td colspan="4">
							<form action="insertComment.do" method="post" >
								<input type="hidden" name="board_id" value="${board.id }">
								<input type="hidden" name="group_id" value="${comment.group_id }">
								<input type="hidden" name="writer" value="${username }">
								<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName }"/>
								<div class="row justify-content-center">
									<textarea name="content" style="width:80%" placeholder="내용을 입력하세요"></textarea>
									<input style="margin-left: 5px" type="submit" class="btn btn-info" value="완료">
								</div>
							</form>
						</td>
					</tr>
					
					<tr id="reviseForm${status.index }" hidden="true">
						<td colspan="4">
							<form action="updateComment.do" method="post">
								<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName }"/>
								<input type="hidden" name="board_id" value="${board.id }">
								<input type="hidden" name="id" value="${comment.id }">
								<div class="row justify-content-center">
									<textarea  style="width:80%" name="content">${comment.content }</textarea>
									<input type="submit" class="btn btn-info" value="완료">
								</div>
							</form>
						</td>
					</tr>
			</c:forEach>
		</c:if>
		<tr>	<!-- 새 댓글 -->
			<td colspan="4">
					<form action="insertComment.do" method="post">
						<input type="hidden" name="board_id" value="${board.id }">
						<input type="hidden" name="writer" value="${username }">
						<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName }"/>
						<div class="row  justify-content-center">
							<textarea style="width:80%" name="content" placeholder="내용을 입력하세요"></textarea>
							<input style="margin-left: 5px" type="submit" class="btn btn-info" value="댓글 달기">
						</div>	
					</form>
				
			</td>
		</tr>
	</table>
</div>

<script>
	function recomment(index) {
		if($('#recommentForm'+index).prop('hidden')){
			$('#recommentForm'+index).prop('hidden', false);
		}else{
			$('#recommentForm'+index).prop('hidden', true);
		}
	}
	
	function revise(index) {
		if($('#reviseForm'+index).prop('hidden')){
			$('#reviseForm'+index).prop('hidden', false);
		}else{
			$('#reviseForm'+index).prop('hidden', true);
		}
	}
</script>
<%@ include file="common/footer.jsp" %>