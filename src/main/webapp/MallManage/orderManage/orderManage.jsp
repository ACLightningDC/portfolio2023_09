<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/javascript/shoppingCart.js" type="text/javascript"></script>
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

function check_post(del_id){
	 
	 url="orderCheck.Seller?delivery_id="+del_id;
	 var popupWidth = 500;
	 var popupHeight = 1000;
	 
	 var popupX = (window.screen.width/ 2)-(popupWidth / 2);
	 var popupY = (window.screen.height/ 2)-(popupHeight / 2);
	 open(url,"배송확인",'width='+popupWidth+',height='+popupHeight+',left='+popupX+',top='+popupY);
	 
	 }
</script>
</head>
<body>

<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">Open modal for @getbootstrap</button>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">New message</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Recipient:</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="mb-3">
            <label for="message-text" class="col-form-label">Message:</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
        </form>
        <div>
        <table class="table table-striped table-bordered">
				<tr>
					<th>주문번호</th><th>유저 아이디</th><th>제품 이름</th><th>주문 개수</th><th>가격</th>
				</tr>
					
					<c:if test="${not empty requestScope.ShoppingCartList }">
						<c:forEach var="order" items="${requestScope.ShoppingCartList}">
						<tr id="deliveryTr">
							<td>${order.id} </td><td>${order.users_id}</td><td>${order.name}</td><td>${order.order_count}</td><td> ${order.price}</td>
							
						</tr>	
	
						</c:forEach>
					</c:if>
				</table>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div>
    </div>
  </div>
</div>

<form method="post" action="" name="CartForm">
	전체 체크<input type="checkbox" name="allCheck" onclick="CheckAll(this.form)">
	<br>

<div class="container-fluid">
  <h1 class="h3 mb-2 text-gray-800">배송 하기</h1>
  <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
      For more information about DataTables, please visit the <a target="_blank"
          href="https://datatables.net">official DataTables documentation</a>.</p>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
                           <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
        </div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered">
				<tr>
					<th>배송 체크</th><th>주문번호</th><th>유저 식별번호</th><th>배송 식별번호</th><th>제품 이름</th><th>제품 종류</th><th>주문 개수</th><th>가격</th><th>주문 상태</th><th>시간</th><th>제품 링크</th>
				</tr>
					<c:if test="${not empty requestScope.ShoppingCartList }">
						<c:forEach var="order" items="${requestScope.ShoppingCartList}">
						<tr><td>
						<c:if test="${order.result=='P'}">
						<input id="productCheck" type="checkbox" name="remove" value="${order.id}">
						</c:if>
						<c:if test="${order.result=='D'}">
						<button class="btn btn-primary btn-sm" type="button" onclick="check_post(${order.delivery_id})">배송 확인</button>
						</c:if>
						</td>
							<td>${order.id} </td><td>${order.users_id}</td><td>${order.delivery_id}</td>
							<td>${order.name}</td><td>${order.kind}</td><td>${order.order_count}</td><td> ${order.price}</td><td>${order.result}${order.result == "P" ?"결제함": order.result == "D"?"배송중":order.result == "N"?"장바구니 담김":"배송완료"}</td>
							<td>${order.date}</td>
							<td><button class="btn btn-primary btn-sm" type="button" onclick="location.href='shoppingCartProductDetail.shop?product_id=${order.product_id}'">상품 상세보기</button></td>
						</tr>	
	
						</c:forEach>
					</c:if>
				</table>
			</div>
		</div>
	</div>
</div>


<input type="submit" value ="체크한 결제 상품 승인 취소" formaction="CartRemove.shop" > 
<input type="submit" value ="체크한 장바구니 제품 배송하기" formaction="orderManageDelivery.Seller" onclick="checkform();return false;" > 
</form>



</body>
</html>