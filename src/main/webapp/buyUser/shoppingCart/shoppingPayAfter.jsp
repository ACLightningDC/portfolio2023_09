<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>배송조회</title>
	<script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/resource/javascript/shoppingCart.js" type="text/javascript">
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
	<br>
	<c:set var="totalmoney" value="0"></c:set>

<div class="container-fluid ">
  <h1 class="h3 mb-2 text-gray-800 py-2">주문 목록</h1>
	<div class="card shadow mb-4">
		<div class="card-header ">
                           <h6 class="m-0 font-weight-bold text-primary">
	전체 체크<input type="checkbox" name="allCheck" onclick="CheckAll(this.form)">
                           </h6>
        </div>
        <div class="row">
<c:if test="${not empty requestScope.ShoppingCartList }">
	<c:forEach var="order" items="${requestScope.ShoppingCartList}">
		<c:if test="${order.result==C}">
		<input id="productCheck" type="checkbox" name="remove" value="${order.id}">	
		</c:if>
			<div class="card mb-4 m-3 col-md-10 mx-auto">
		<div class="row g-0">
			<div class="col-md-2">
										            	<img height="100px" alt="안나옴" src="${pageContext.request.contextPath}/images/${order.img}">
			</div>
			<div class="col-md-8">
						<div class="card-body">
						<div class="justify-content-between d-flex justify-content-between align-items-center">
						<div>
				<br>주문 개수 : ${order.order_count}
				<br>배송 상태 : ${order.delivery}
						</div>
						<div>
				<br>가격 : ${order.price}
				<br>이름 : ${order.name}
				<br>종류: ${order.kind}
						</div>
						<div>
										<br>배송 시작 시각 : ${order.date}
				<br>주문 상태 : ${order.result}
				</div>
						<div>
						<br>가격 : ${order.price}
						</div>
						</div>
				
			<div class="btn-group" role="group">
          		<button class="btn btn-primary" type="button" onclick="location.href='shoppingCartProductDetail.shop?product_id=${order.product_id}'">상품 상세보기</button>
          		<button class="btn btn-primary" type="button" onclick="location.href='inquiryForm.shop?seller_Mall_id=${order.sellerMall_id}&product_id=${order.product_id}'">상품 문의하기</button>
				<button class="btn btn-primary" type="button" onclick="location.href='shoppingCartProductDetail.shop?product_id=${order.product_id}'">배송 조회하기</button>
			</div>
				
		</div>
			</div>
		</div>
</div>
	</c:forEach>
					</c:if>
</div>
	<input class="btn btn-primary " type="submit" value ="배송완료된 제품 삭제하기" formaction="CartRemove.shop" > 
	</div>
</div>
		
</form>
</body>
</html>