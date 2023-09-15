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
function checkform()
{
  if($('[name=remove]:checked').length == 0) {
    alert('항목을 체크하여 주십시오');
    $('[name=remove]:eq(0)').focus();
    return false;
  }else{
	  docuemnt.CartForm.submit();
  }
}

function check()
{
  var effect_reason_yn = false;
 
 
  var effect_reason = document.getElementsByName('effect_reason[]');
  for (var i=0; i<effect_reason.length; i++)
  {
      if (effect_reason[i].checked == true)
        {
effect_reason_yn = true;
break;
        }
      }

      if (effect_reason_yn == false)
      {
        alert('항목을 체크하여 주십시오');
        effect_reason[0].focus();
        return false;
      }
}
</script>
</head>
<body>
<form method="post" action="" name="CartForm">
	전체 체크<input type="checkbox" name="allCheck" onclick="CheckAll(this.form)">
	<br>
	<c:set var="totalmoney" value="0"></c:set>

<c:if test="${not empty requestScope.ShoppingCartList }">
	<c:forEach var="order" items="${requestScope.ShoppingCartList}">
	<hr>
	<input id="productCheck" type="checkbox" name="remove" value="${order.id}">	
	
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
		
	<hr>
	
	</c:forEach>
</c:if>

<input type="submit" value ="체크한 결제 상품 승인 취소" formaction="CartRemove.shop" > 
<input type="submit" value ="체크한 장바구니 제품 배송하기" formaction="orderManageDelivery.Seller" onclick="checkform();return false;" > 
</form>
</body>
</html>