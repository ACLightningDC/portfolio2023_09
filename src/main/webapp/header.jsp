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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.bundle.js"></script>
<link rel="stylesheet"href = "${pageContext.request.contextPath}/resource/css/bootstrap.css">
<style>
	.container-fluid{
	}
</style>
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-light">
        <a class="navbar-brand " href="${pageContext.request.contextPath}/homePage.shop">홈쇼핑 ${sessionScope.userinfo.id}</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0 mx-auto ">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/productPage.shop">상품별 보기</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/shopPage.shop">매장별 보기</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                카테고리
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">식자재</a></li>
                <li><a class="dropdown-item" href="#">전자재품</a></li>
                <li><a class="dropdown-item" href="#">생활용품</a></li>
                <li><hr class="dropdown-divider"></li>
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
				              
            </li>
           <li class="nav-item ">
              <a class="nav-link" >${sessionScope.Seller_id}/${sessionScope.userinfo.name}${sessionScope.userinfo.grade == 'S' ? '판매자님' : '님' } 로그인되었습니다.</a>
            </li> 
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                내정보 관리 ${sessionScope.userinfo.grade} ${sessionScope.userinfo.grade == 'S'}
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="<%=request.getContextPath()%>/myImformationForm.shop">내 정보 변경 , 확인</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shoppingCart.shop">장바구니</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/resultShopping.shop">배송조회 , 결과조회</a></li>
                <li><hr class="dropdown-divider"></li>
                <c:if test="${sessionScope.userinfo.grade == 'S'}">
					<li><a class="dropdown-item" href="${pageContext.request.contextPath}/ShoppingMallManage.shop">쇼핑몰 관리하기</a></li>
                </c:if>	
                
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/logout.shop">로그아웃</a>
            </li> 
           
          </c:when>
          <c:otherwise>
          	<li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/loginForm.shop">로그인</a>
            </li>
			<li class="nav-item ">
              <a class="nav-link" href="${pageContext.request.contextPath}/account.shop">회원가입</a>
            </li>
          
          </c:otherwise>
          </c:choose>
          	<li class="nav-item ">
              <a class="nav-link disabled"></a>
            </li>

           
          </ul>

        </div>
    </nav>
    
    
</body>
</html>