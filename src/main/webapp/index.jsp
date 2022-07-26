<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container{
	margin: 50px auto;
	width: 1200px;
	}
	h1{
	text-align: center;
	}
	input{
	width: 300px;
	height: 50px;
	box-sizing: border-box;
	margin: 5px 0px;
	font-size: 16px;
	outline: none;
	border-radius: 5px;
	border: 1px solid gray;
	}
	button{
	width: 300px;
	height: 50px;
	box-sizing: border-box;
	margin: 5px 0px;
	font-size: 20px;
	background-color: rgb(52,152,219);
	border: none;
	color: white;
	outline: none;
	border-radius: 5px;
	}
	form{
	width: 300px;
	display: flex;
	margin: 0 auto;
	flex-direction: column;
	box-sizing: border-box;
	}
</style>
</head>
<body>
<!-- 로그인 페이지 -->	
<!-- 회원가입 페이지로 이동 링크 -->	
<!-- 로그인 login.do 호출 LoginController를 생성해서 처리 -->	
<!-- 로그인이 되어 있으면 main.do로 이동 -->
<c:if test="${sessionScope.dto != null }">
	<c:redirect url="main.do"/>
</c:if>
	<div class="container">
		<h2>로그인</h2>
		<form action="login.do" method="post">
			<input type="text" name="id" placeholder="아이디입력">
			<input type="password" name="passwd" placeholder="암호 입력">
			<button>로그인</button><a href="member_register.jsp">회원가입</a>
		</form>
	</div>
</body>
</html>