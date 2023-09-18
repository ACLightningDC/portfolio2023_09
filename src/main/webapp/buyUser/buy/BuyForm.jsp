<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script> 
	<!-- iamport.payment.js --> 
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script src="${pageContext.request.contextPath}/resource/javascript/BuyForm.js"></script>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제하기</title>
</head>
<body>
			        <form method="post" action="ShoppingresultUpdate.Seller" id="buyIdResult" name="infoPayForm">
		<div class="container">
		<div class="row mt-5">
		      <div class="col-8 mx-auto">
		      <h5>${sessionScope.userinfo.name}님의 주문 입니다.</h5>
		        <h4 class="d-flex justify-content-between align-items-center mb-3">
		        	
		          <span class="text-primary">구매한 물건 종류</span>
		          <span class="badge bg-primary rounded-pill" id="select_count">${buyCount}</span>
		        </h4>
		        <ul class="list-group mb-3 ">
			        <c:if test="${not empty requestScope.buyList}">
						<c:forEach var="buy" items="${requestScope.buyList}" varStatus="status">
							<li class="list-group-item d-flex justify-content-between lh-sm">
						            	<img width="100px" alt="안나옴" src="${pageContext.request.contextPath}/images/${buy.img}">
						            	
							           <h6 class="my-0">${buy.name}</h6> 
							              <small class="text-body-secondary">종류: ${buy.kind}</small>
							              <small class="text-body-secondary"><br>가격 : ${buy.price}</small>
							              <small class="text-body-secondary"><br>주문 개수 : ${buy.order_count}</span></small>
					          </li>
					          <li class="list-group-item d-flex lh-sm text-break">
						          		<button class="btn btn-primary btn-sm" type="button" onclick="location.href='shoppingCartProductDetail.shop?product_id=${buy.product_id}'">상품 상세보기</button>
					          </li>
					          		<input type="hidden" name="order_id" value="${buy.id}">
						</c:forEach>
					</c:if>
		          <li class="list-group-item d-flex">
		            <span >총가격  &nbsp; </span>
		            <strong id="sum_price">${requestScope.sumPrice}</strong> &#8361
		          </li>
		        </ul>
		        
		        		<input type="hidden" name="result" value="P">
		
					<h4>주소</h4>
					<%--  
					<c:if test="${not empty sessionScope.userinfo.address_id}">
						기본주소 아이디 ${sessionScope.userinfo.address_id}
					</c:if>
					 --%>
					<div>
						우편번호 : <span id="postcode">${address.postcode}</span>
						<br>주소 : <span id="address1">${address.address1}</span>						
						<br>상세주소 :<span id="address2">${address.address2}</span>			
					</div>
					<input type="hidden" name="address_id" value="${sessionScope.userinfo.address_id}">		
					<button class="btn btn-primary " type="button" onclick="select_address()">다른 배송지 선택</button>
				</form>
			
			<form id="payForm" name="payForm">
			<hr>
				<input type="hidden" name="email"  value="${sessionScope.userinfo.email}">
				<input type="hidden" name="user_name"  value="${sessionScope.userinfo.name}">
				<input type="hidden" name="tel"  value="${sessionScope.userinfo.phone}">
				<input type="text" name="order_id" value="${requestScope.buyList[0].id}">
				<br>
				${requestScope.buyList[0].name} ${not empty requestScope.buyList[1]? "외 물건 구매":"구매"}
				<input type="hidden" name="pay_name" value="${requestScope.buyList[0].name}">
				<input type="hidden" name="amount" value="${requestScope.sumPrice }">
				
			</form>
			<hr>
			<div>
				<h2>총 결제 금액 ${requestScope.sumPrice} &#8361</h2>
			</div>
			<hr>
				<button class="btn btn-primary btn-lg col-12" id="Payment" type="button">결제</button>
		</div>
	</div>	
		
	
	<c:if test="${not empty requestScope.buyList }">
	<c:forEach var="buy" items="${requestScope.buyList}">
		<br>주문번호 : ${buy.id} 
		<br>유저 아이디 : ${buy.users_id}
		<br>제품 아이디 : ${buy.product_id}
		<br>주문 개수 : ${buy.order_count}
		<br>배송 상태 : ${buy.delivery_id}
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



</body>
</html>