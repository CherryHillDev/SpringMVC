<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="common/header.jsp" %>

<form class="form-inline mr-auto ml-1" action="login" method="post">
	<input class="form-control mr-1 col-md-2" type="text" placeholder="ID" name="username"/>
	<input class="form-control mr-1 col-md-2" type="password" placeholder="PW" name="password"/>
	<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName }"/>
	<button class="btn" type="submit">로그인</button>
</form>

<%@ include file="common/footer.jsp" %>
