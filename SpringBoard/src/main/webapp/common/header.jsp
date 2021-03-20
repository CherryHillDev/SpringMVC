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
<body class="bg-secondary">
	<nav class="navbar bg-dark">
	<a class="navbar-brand" href="getBoardList.do"><img src="resources/images/ch2.PNG" height="50" width="50" alt="main"></a>
	<!-- 로그인 -->
	<sec:authorize access="isAnonymous()">
		<a href="loginPage.do" class="btn btn-info">로그인 페이지</a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		${username }님 로그인
		<form action="logout" method="post">
			<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName }"/>
			<button class="btn" type="submit">로그아웃</button>
		</form>
	</sec:authorize>
	
	<!-- 검색 -->
		<form class="form-inline my-2">	
			<div class="row">
				<select class="form-control mr-1">
					<option>제목</option><option>내용</option>
				</select>
				<input class="form-control mr-1" type="text" placeholder="검색"/>
				<a class="btn" type="submit"><i class="fas fa-search"></i></a>
			</div>
		</form>
	</nav>
