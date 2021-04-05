<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar bg-secondary">
		<a class="navbar-brand" href="/springboard/"><span style="color: silver;"><i class="fas fa-home fa-2x"></i></span></a>
		<!-- 로그인 -->
		<sec:authorize access="isAnonymous()">
			<a href="loginPage.do" class="btn btn-dark">로그인</a>
			<a href="insertUserForm.do" class="btn btn-dark">계정 생성</a>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<h6 style="color: white;">${username }님 로그인</h6>
			<form action="logout" method="post">
				<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName }"/>
				<button class="btn btn-dark" type="submit">로그아웃</button>
			</form>
		</sec:authorize>
	</nav>

