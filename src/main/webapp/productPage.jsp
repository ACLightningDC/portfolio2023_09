<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

products

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
		<br><img width="50px" alt="안나옴" src="images/${product.img}">
		<button onclick="location.href='#'">${product.name}상품 바로구매</button>
		<button onclick="location.href='shoppingCartProductAdd.shop?product_id=${product.id}'">${product.name}상품 장바구니</button>
		<button onclick="location.href='#'">${product.name}상품 상세보기</button>
	</c:forEach>
</c:if>

페이지별로 15개씩 만들기

</body>
</html>