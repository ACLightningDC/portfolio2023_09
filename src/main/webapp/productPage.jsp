<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  </head>
  <body class="p-3 m-0 border-0 bd-example">
<title>Insert title here</title>
</head>

<body>

products
${requestScope.products[0].name}
<c:if test="${not empty requestScope.products }">
	<c:forEach var="product" items="${requestScope.products}">
		<br>제품 번호 : ${product.id}
		<br>소속 쇼핑몰 : ${product.sellerMall_id}
		<br>제품 이름 : ${product.name}
		<br>제품 가격 : ${product.price}
		<br>제품 종류 : ${product.kind}
		<br>제품 일자 : ${product.date}
		<br>제품 구매수 : ${product.buycount}
		<br>제품 사진경로 : ${product.img}
		<form>
			<input>
		</form>
		<br><img width="50px" alt="안나옴" src="images/${product.img}">
		<button onclick="location.href='#'">${product.name}상품 바로구매</button>
		<button onclick="location.href='shoppingCartproductAdd.shop?product_id=${product.id}&order_count=1'">${product.name}상품 장바구니</button>
		<button onclick="location.href='shoppingCartProductDetail.shop?product_id=${product.id}'">${product.name}상품 상세보기</button>
	</c:forEach>
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