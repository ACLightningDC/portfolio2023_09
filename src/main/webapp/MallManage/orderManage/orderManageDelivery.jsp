<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.0.min.js"></script>

<script src="javascript/shoppingCart.js" type="text/javascript">

</script>
<script type="text/javascript">

</script>
</head>
<body>
<form action="orderManageDeliveryregistration.Seller" method="post">
배송 리스트 ${requestScope.buyList}
<c:if test="${not empty requestScope.buyList }">
	<c:forEach var="order" items="${requestScope.buyList}">
	
	제품 보기 
	<hr>
	         <input type="hidden" class="form-control" id="order_list_id" name="order_list_id" value="${order.id}">
	
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
		
	<hr>
	
	</c:forEach>
</c:if>


배송 운송장 배송회사 선택

            <div class="form-group">
              <label for="t_code">택배사 코드</label>
              <input type="text" class="form-control" name="delivery_company" id="delivery_company" placeholder="택배사 코드">
            </div>
            <div class="form-group">
              <label for="t_invoice">운송장 번호</label>
              <input type="text" class="form-control" name="delivery_num" id="delivery_num" placeholder="운송장 번호">
            </div>
            <button type="submit" class="btn btn-default">제품 배송등록</button>
        </form>
        

 
</form>
</body>
</html>