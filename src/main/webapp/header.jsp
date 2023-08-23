<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>헤드 네비게이션</title>
<!-- 부트스트랩 리소스 임포트 -->
<link rel="stylesheet"href = "${pageContext.request.contextPath}/resource/css/bootstrap.css">
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.bundle.js"></script>
<style>
	.container-fluid{
	}
</style>
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-light  ">
      <div class="container-fluid ">
        <a class="navbar-brand " href="#">홈쇼핑 ${sessionScope.userinfo.id}</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">베스트&세일</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">베스트 매장</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                카테고리
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li> 
          </ul>
          <ul class="navbar-nav mb-2 mb-lg-0 ">
          <c:if test="${!empty sessionScope.userinfo }">
           
          </c:if>
          <c:choose>
          <c:when test="${!empty sessionScope.userinfo }"> 
            <li class="nav-item">
            	<span></span>
				              ${sessionScope.userinfo.name} 로그인되었습니다.
            </li>
            
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                내정보 관리
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">내정보 보기</a></li>
                <li><a class="dropdown-item" href="#">내 정보 변경 , 확인</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="logout.shop">장바구니</a></li>	
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="logout.shop">로그아웃</a>
            </li> 
           
          </c:when>
          <c:otherwise>
          	<li class="nav-item">
              <a class="nav-link" href="loginForm.jsp">로그인</a>
            </li>
			<li class="nav-item ">
              <a class="nav-link" href="#">회원가입</a>
            </li>
          
          </c:otherwise>
          </c:choose>
          	<li class="nav-item ">
              <a class="nav-link disabled"></a>
            </li>

           
          </ul>

        </div>
      </div>
    </nav>
    
    
</body>
</html>