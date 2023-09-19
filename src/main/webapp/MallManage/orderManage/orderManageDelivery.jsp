<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/javascript/shoppingCart.js" type="text/javascript">
</script>
</head>
<body>
<form action="orderManageDeliveryregistration.Seller" method="post">
배송 리스트 ${requestScope.buyList}

<div class="container-fluid">
  <h1 class="h3 mb-2 text-gray-800">배송 하기</h1>
  <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
      For more information about DataTables, please visit the <a target="_blank"
          href="https://datatables.net">official DataTables documentation</a>.</p>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
                           <h6 class="m-0 font-weight-bold text-primary">배송할 주문</h6>
        </div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered">
				<tr>
					<th>주문번호</th><th>유저 아이디</th><th>제품 이름</th><th>제품 종류</th><th>주문 개수</th><th>가격</th><th>주문 상태</th><th>시간</th><th>제품 링크</th>
				</tr>
					<c:if test="${not empty requestScope.buyList }">
						<c:forEach var="order" items="${requestScope.buyList}">
						<input type="hidden" class="form-control" id="order_list_id" name="order_list_id" value="${order.id}">
						<tr>
							<td>${order.id} </td><td>${order.users_id}</td><td>${order.name}</td><td>${order.kind}</td><td>${order.order_count}</td><td> ${order.price}</td><td>${order.result}${order.result == "P" ?"결제함": order.result == "D"?"배송중":order.result == "N"?"장바구니 담김":"배송완료"}</td>
							<td>${order.date}</td>
							<td><button class="btn btn-primary btn-sm" type="button" onclick="location.href='shoppingCartProductDetail.shop?product_id=${order.product_id}'">상품 상세보기</button></td>
						</tr>	
	
						</c:forEach>
					</c:if>
				</table>
			</div>
		</div>
	</div>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
                           <h6 class="m-0 font-weight-bold text-primary">배송 운송장 & 배송회사 선택</h6>
        </div>
		<div class="card-body">
			            <div class="form-group">
              <label for="t_code">택배사 코드</label>
              <input type="text" class="form-control" name="delivery_company" id="delivery_company" placeholder="택배사 코드">
            </div>
            <div class="form-group">
              <label for="t_invoice">운송장 번호</label>
              <input type="text" class="form-control" name="delivery_num" id="delivery_num" placeholder="운송장 번호">
            </div>
            <button type="submit" class="btn btn-primary my-2">제품 배송등록</button>
        </form>
		</div>
	</div>
</div>





        

 
</body>
</html>