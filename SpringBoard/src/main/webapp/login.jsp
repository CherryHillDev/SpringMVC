<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="common/header.jsp" %>

<div class="container my-5">
	<div class="row justify-content-center">
		<div class="col-md-8">
			<div class="card">
				<div class="card-header">Login</div>
				<div class="card-body">
					<form action="login" method="post">
						<div class="form-group row">
							<label for="username" class="col-md-4 col-form-label text-md-right">아이디</label>
							<div class="col-md-6">
								<input class="form-control" type="text" id="username" name="username" required autofocus/>
							</div>
						</div>
						
						<div class="form-group row">
							<label for="password" class="col-md-4 col-form-label text-md-right">비밀번호</label>
							<div class="col-md-6">
								<input class="form-control" type="password" id="password" name="password" required/>
							</div>
						</div>
						<div class="col-md-6 offset-md-5">
							<button class="btn btn-primary" type="submit">로그인</button>
						</div>
						
						<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName }"/>
					</form>				
				</div>
			</div>
		</div>
	</div>
</div>


<%@ include file="common/footer.jsp" %>
