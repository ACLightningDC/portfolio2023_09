<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<scipt>
	//이전 버튼
	function
</scipt>
<body>
<c:if test="${not empty requestScope.sellermalls }">
 <div class="album py-5 bg-body-tertiary">
    <div class="container">
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
	<c:forEach var="sellermall" items="${requestScope.sellermalls}">
<<<<<<< HEAD
		<br>판매자 번호 ${sellermall.seller_id}
		<br>홈쇼핑 이름 ${sellermall.name}
		<br>생성 날짜 ${sellermall.create_date}
		<br>쇼핑몰 등급 ${sellermall.grade}
		<button onclick="location.href='Mallpage.shop'">${product.name}쇼핑몰 보기</button>
		
	<div class="card col-12 col-sm-4" >
	  <div class="card-body">
	    <h5 class="card-title">홈쇼핑 이름 ${sellermall.name}</h5>
	    <p class="card-text">
			<br>판매자 번호 ${sellermall.seller_id}
			<br>홈쇼핑 이름 ${sellermall.name}
			<br>생성 날짜 ${sellermall.create_date}
			<br>쇼핑몰 등급 ${sellermall.grade}
	    </p>
			<button onclick="location.href='Mallpage.shop'">${product.name}쇼핑몰 보기</button>
	  </div>
	</div>
	</c:forEach>
</div>
</c:if>
<c:for>
      

      
        <div class="col">
          <div class="card shadow-sm">
            <div class="card-body">
            <h5 class="card-title">${sellermall.name}</h5>
              <p class="card-text">
			<br>판매자 번호 ${sellermall.seller_id}
			<br>생성 날짜 ${sellermall.create_date}
			<br>쇼핑몰 등급 ${sellermall.grade}              </p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='Mallpage.Mall?id=${sellermall.seller_id}'">${product.name}쇼핑몰 보기</button>
                </div>
                <small class="text-body-secondary"></small>
              </div>
            </div>
          </div>
        </div>
        
	</c:forEach>
      </div>
    </div>
  </div>
</c:if>

<!-- 페이지네이션 -->
<nav id="" aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <c:if test="${pageInfo.page <= 1}">
        [이전]&nbsp;
    </c:if>
    <c:choose>
        <c:when test="${pageInfo.page > 1}">
            <a href="productPage.shop?page=${pageInfo.page - 1}">[이전]</a>&nbsp;
        </c:when>
    </c:choose>

    <c:forEach var="page" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
        <c:choose>
            <c:when test="${pageInfo.page == page}">
                [<c:out value="${page}"/>]
            </c:when>
            <c:otherwise>
                <a href="productPage.shop?page=${page}">[<c:out value="${page}"/>]</a>&nbsp;
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:if test="${pageInfo.page >= pageInfo.maxPage}">
        [다음]
    </c:if>
    <c:choose>
        <c:when test="${pageInfo.page < pageInfo.maxPage}">
            <a href="productPage.shop?page=${pageInfo.page + 1}">[다음]</a>
        </c:when>
    </c:choose>
    
  </ul>
</nav>
</body>
</html>