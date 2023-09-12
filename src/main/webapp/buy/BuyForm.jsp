<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:if test="${not empty requestScope.buyList }">
	<c:forEach var="buy" items="${requestScope.buyList}">
		<br>주문번호 : ${buy.id} 
		<br>유저 아이디 : ${order.users_id}
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
	</c:forEach>
</c:if>
	<form method="post">
		<button type="button" id="check_module">카카오 페이로 결제하기</button>
	</form>
	
	<script>
	$("#check_module").click(function () {
		var IMP = window.IMP;
		IMP.init('가맹점식별코드'); 
		IMP.request_pay({
			pg: 'kakao',
			pay_method: 'card',
			merchant_uid: 'merchant_' + new Date().getTime(),
			name: '주문명 : 아메리카노',
			amount: 2000,
			buyer_name: '이름',
			buyer_postcode: '123-456',
			}, function (rsp) {
				console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				msg += '결제 금액 : ' + rsp.paid_amount;
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
			alert(msg);
		});
	});
</script>

</body>
</html>