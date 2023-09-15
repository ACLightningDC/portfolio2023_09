<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script> 
	<!-- iamport.payment.js --> 
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script src="${pageContext.request.contextPath}/javascript/BuyForm.js"></script>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>${sessionScope.userinfo.name}님의 주문 입니다.</h5>
	<form method="post" action="ShoppingresultUpdate.Seller" id="buyIdResult">
	
	<c:if test="${not empty requestScope.buyList }">
	<c:forEach var="buy" items="${requestScope.buyList}">
		<br>주문번호 : ${buy.id} 
		<br>유저 아이디 : ${buy.users_id}
		<br>제품 아이디 : ${buy.product_id}
		<br>주문 개수 : ${buy.order_count}
		<br>배송 상태 : ${buy.delivery}
		<br>장바구니 시각 : ${buy.date}
		<br>주문 상태 : ${buy.result}
		
		<br>아이디 : ${buy.sellerMall_id}
		<br>가격 : ${buy.price}
		<br>이름 : ${buy.name}
		<br>종류: ${buy.kind}
		<br>이미지: ${buy.img}
		
		<input type="hidden" name="order_id" value="${buy.id}">
	</c:forEach>
</c:if>
		<input type="hidden" name="result" value="P">
		
		기본 주소 사용하기 
		<c:if test="${not empty sessionScope.userinfo.address_id}">
			<input type="text" name="address_id" value="${sessionScope.userinfo.address_id}">		
		</c:if>
		
		<br><button type="button" onclick="">배송지 선택</button>
	</form>

<form id="payForm">

	<input type="text" name="email"  value="${sessionScope.userinfo.email}">
	<input type="text" name="user_name"  value="${sessionScope.userinfo.name}">
	<input type="text" name="tel"  value="${sessionScope.userinfo.phone}">
	<input type="text" name="order_id" value="${requestScope.buyList[0].id}">
	<input type="text" name="pay_name" value="${requestScope.buyList[0].name}">
	<input type="text" name="amount" value="${requestScope.sumPrice }">
	
	<button id="Payment" type="button">결제</button>

</form>
				<h2>총 결제 금액 ${requestScope.sumPrice}</h2>
	
	
	
	



</body>
</html>