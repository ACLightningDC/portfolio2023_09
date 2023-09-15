<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.0.min.js"></script>


</head>
<body>
	<c:set var="totalmoney" value="0"></c:set>
<div class="container-fluid d-grid col-8 mx-auto my-5">
	<div class="row">
		<div class="col ">
			<table class="table table-striped table-bordered">
			<tr>
				<th>주문번호</th><th>유저 아이디</th><th>제품 이름</th><th>제품 종류</th><th>주문 개수</th><th>가격</th><th>주문 상태</th><th>시간</th><th>제품 링크</th>
			</tr>
				<c:if test="${not empty requestScope.ShoppingCartList }">
					<c:forEach var="order" items="${requestScope.ShoppingCartList}">
					<tr>
						<td>${order.id} </td><td>${order.users_id}</td><td>${order.name}</td><td>${order.kind}</td><td>${order.order_count}</td><td> ${order.price}</td><td>${order.result}${order.result == "P" ?"결제함": order.result == "D"?"배송중":order.result == "N"?"장바구니 담김":"배송완료"}</td>
						<td>${order.date}</td>
						<td><button class="btn btn-primary" type="button" onclick="location.href='shoppingCartProductDetail.shop?product_id=${order.product_id}'">상품 상세보기</button></td>
					</tr>	

					</c:forEach>
				</c:if>
			<tr>
				<td>총합</td><td colspan="8">${sum }</td>
			</tr>
			
			
			</table>
		</div>
	</div>
</div>
</body>
</html>