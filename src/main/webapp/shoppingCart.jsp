<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="javascript/shoppingCart.js" type="text/javascript">

</script>

</head>
<body>
<form method="post" action="">
	전체 체크<input type="checkbox" name="allCheck" onclick="CheckAll(this.form)">
	<br>
	<c:set var="totalmoney" value="0"></c:set>

<c:if test="${not empty requestScope.ShoppingCartList }">
	<c:forEach var="order" items="${requestScope.ShoppingCartList}">
	<hr>
	<input type="checkbox" name="remove" value="${order.id}">	
	
	제품 보기 
	<hr>
		<br>주문번호 : ${order.id} 
		<br>유저 아이디 : ${order.users_id}
		<br>제품 아이디 : ${order.product_id}
		<br>주문 개수 : ${order.order_count}
		<br>배송 상태 : ${order.delivery}
		<br>배송 상태 : ${order.date}
		<br>주문 상태 : ${order.result}
		
		<br>셀러 아이디 : ${order.sellerMall_id}
		<br>가격 : ${order.price}
		<br>이름 : ${order.name}
		<br>종류: ${order.kind}
		<br>이미지: ${order.img}
		
		<button type="button" onclick="location.href='shoppingCartProductDetail.shop?product_id=${order.product_id}'">상품 상세보기</button>
		<button type="button" onclick="productPluse('${order.order_count}','${order.id}');">상품 추가</button>
		<button type="button" onclick="productMinus('${order.order_count}','${order.id}');">상품 감소</button>
		
		<button type="button" onclick="location.href='inquiryForm.shop'">상품 문의하기</button>
		<div>
			<input id="order_id" type="hidden" name="id" value="${order.id}">
			<input id="orderCount" type="text" name="orderCount" value="">
			<button type="button" onclick="productCount()">입력 변경</button>		
		</div>
	<hr>
	
	</c:forEach>
</c:if>

<input type="submit" value ="장바구니 삭제하기" formaction="CartRemove.shop" > 
<input type="submit" value ="장바구니 제품 주문하기" formaction="CartBuy.shop" > 
</form>
</body>
</html>