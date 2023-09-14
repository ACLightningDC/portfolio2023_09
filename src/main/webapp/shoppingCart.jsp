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

	<div class="container">
		<div class="row mt-5">
		      <div class="col-12 mx-auto">
		        <h4 class="d-flex justify-content-between align-items-center mb-3">
		          <span class="text-primary">현재 쇼핑 카트</span>
		          <span class="badge bg-primary rounded-pill" id="select_count">0</span>
		        </h4>
		        <ul class="list-group mb-3 ">
		        	<li class="list-group-item d-flex justify-content-between">
		        	<div>
		        		<input class="form-check-input" id="allCheck_id" type="checkbox" class="form-check form-check-inline" name="allCheck" onclick="CheckAll(this.form)">
		        		 <label class="form-check-label" for="allCheck_id">
						전체 체크  						
						</label>
		        	</div>
		          	</li>
			        <c:if test="${not empty requestScope.ShoppingCartList}">
						<c:forEach var="order" items="${requestScope.ShoppingCartList}" varStatus="status">
							<li class="list-group-item d-flex justify-content-between lh-sm">
						            	<img width="300px" alt="안나옴" src="${pageContext.request.contextPath}/images/${order.img}">
						            	
							           <h6 class="my-0">${order.name}</h6> 
							              <small class="text-body-secondary"><br>가격 : ${order.price}</small>
							              <small class="text-body-secondary"><br>종류: ${order.kind}</small>
							              <small class="text-body-secondary"><br>주문 개수 : <span id="${status.index}order_count">${order.order_count}</span></small>
						            <span class="text-body-secondary">
						            <input class="form-check-input" id="productCheck" type="checkbox" name="remove" value="${order.id}" onchange="checkbox(this, ${order.price},${order.order_count} )">
						            <label class="form-check-label" for="productCheck">
									제품 선택 체크  						
									</label>
						            <br>가격 : <span id="${status.index}price">${order.price}</span></span>
					          </li>
					          <li class="list-group-item d-flex lh-sm text-break">
						          <div class="btn-group" role="group">
						          		<button class="btn btn-primary btn-sm" type="button" onclick="location.href='shoppingCartProductDetail.shop?product_id=${order.product_id}'">상품 상세보기</button>
						          		<button class="btn btn-primary btn-sm" type="button" onclick="location.href='inquiryForm.shop?seller_Mall_id=${order.sellerMall_id}&product_id=${order.product_id}'">상품 문의하기</button>
						          </div>
						          <div class="btn-group mx-5" role="group">
						          		<button class="btn btn-primary btn-sm" type="button" onclick="productPluse('${order.order_count}','${order.id}');">상품 개수 추가</button>
										<button class="btn btn-primary btn-sm" type="button" onclick="productMinus('${order.order_count}','${order.id}');">상품 개수 감소</button>
						          </div>
						          
						         <div id="CountDiv">
									<input id="${order.id}order_id" type="hidden" name="id" value="${order.id}">
									<div class="row g-3 align-items-center">
										  <div class="col-auto">
										    <label for="${order.id}orderCount" class="col-form-label">제품 개수</label>
										  </div>
										  <div class="col-auto">
											<input id="${order.id}orderCount"  class="form-control" type="text" name="orderCount" aria-describedby="orderCountHelpInline">
										  </div>
										  <div class="col-auto">
										    <span id="orderCountHelpInline" class="form-text">
										      1개 이상의 수 부탁드립니다
										    </span>
										  </div>
										  <div class="col-auto">
											<button class="btn btn-primary btn-sm" type="button" onclick="productCount(${order.id})">입력 변경</button>		
										  </div>
										</div>
								</div>
					          </li>
					          </li>
						</c:forEach>
					</c:if>
		          <li class="list-group-item d-flex">
		            <span >총가격  &nbsp; </span>
		            <strong id="sum_price">0</strong> &#8361
		          </li>
		        </ul>
		</div>
	</div>
	
	</div>
</form>


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
		<button type="button" onclick="productPluse('${order.order_count}','${order.id}');">상품 추가</button>
		<button type="button" onclick="productMinus('${order.order_count}','${order.id}');">상품 감소</button>
		
		<button type="button" onclick="location.href='inquiryForm.shop?seller_Mall_id=${order.sellerMall_id}&product_id=${order.product_id}'">상품 문의하기</button>
		
		<div>
			<input id="order_id" type="hidden" name="id" value="${order.id}">
			<input id="orderCount" type="text" name="orderCount" value="">
			<button type="button" onclick="productCount()">입력 변경</button>		
		</div>
	<hr>
	
	</c:forEach>
</c:if>

<input type="submit" value ="장바구니 삭제하기" formaction="CartRemove.shop" > 
<input type="submit" value ="체크한 장바구니 제품 주문하기" formaction="CartBuyForm.shop" onclick="checkform();return false;" > 
</form>
</body>
</html>