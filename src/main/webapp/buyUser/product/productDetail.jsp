<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${not empty requestScope.products }">
		<br>제품 번호 : ${products.id}
		<br>소속 쇼핑몰 : ${products.sellerMall_id}
		<br>제품 이름 : ${products.name}
		<br>제품 가격 : ${products.price}
		<br>제품 종류 : ${products.kind}
		<br>제품 일자 : ${products.date}
		<br>제품 구매수 : ${products.buycount}
		<br>제품 사진경로 : ${products.img}
		<form>
			<input>
		</form>
		<br><img width="50px" alt="안나옴" src="images/${products.img}">
		<button onclick="location.href='#'">${products.name}상품 바로구매</button>
		<button onclick="location.href='shoppingCartProductAdd.shop?product_id=${products.id}&order_count=1'">${products.name}상품 장바구니</button>
</c:if>

</body>
</html>