<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en" >
  <head>
<link rel="stylesheet"href = "${pageContext.request.contextPath}/resource/css/bootstrap.css">
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.bundle.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.115.4">
    <title>로그인</title>

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }


	
    </style>

    
    <!-- Custom styles for this template -->
    <link href="sign-in.css" rel="stylesheet">
  </head>


  <jsp:include page="/mainpage/header.jsp" />

  
  <body class="d-flex flex-column min-vh-100 bg-body-tertiary" >
	
	<%
    session.setAttribute("age", 29); //슬픔
%>
세션 스코프의 age 속성값 : ${sessionScope.age}

<div class="d-flex align-items-center py-4 pt-5">

<main class="form-signin w-100 m-auto">

  <form action="login.shop" method="post">
    <h1 class="h3 mb-3 fw-normal">로그인 ${sessionScope.users_id.loginCheck}</h1>

    <div class="form-floating">
      <input type="text" name = "userid" value ="" class="form-control" id="floatingInput" placeholder="">
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input type="password" name ="password" class="form-control" id="floatingPassword" placeholder="Password">
      <label for="floatingPassword">비밀번호</label>
    </div>

    <div class="form-check text-start my-3">
      <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
      <label class="form-check-label" for="flexCheckDefault">
        아이디 기억하기
      </label>
    </div>
    <button class="btn btn-primary w-100 py-2" type="submit">로그인</button>
    <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2023</p>
  </form>
</main>
</div>
<footer class="mt-auto">
<%@include file="/mainpage/footer.jsp" %>
</footer>

  

    </body>
</html>
