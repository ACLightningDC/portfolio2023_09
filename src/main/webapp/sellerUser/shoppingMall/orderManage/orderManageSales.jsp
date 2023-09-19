<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css"/>
<script type="text/javascript">
var url = "http:/localhost:7800/dic";
$(function(){
  $.ajax({
    url: url
    }).done(function(d){
        var table = $("#dic").DataTable({
        data: d,
        dataSrc: "",
        columns : [
          { "data" : "ENT_ID" },
          { "data" : "ID" },
          { "data" : "NAME" },
          { "data" : "TYPE1" },
          { "data" : "TYPE2" },
          { "data" : "REG_USER" }
        ],
        columnDefs: [
          {
          "targets" : [5],
          "visible" : false
          }
        ]
    });
  })
})

$("#data_list").DataTable({
    ajax: { url: "data.json", dataSrc: '' },
    columns: [
        { data: "id" },
        { data: "name" },
        { data: "location" }
    ]
});

language : {
  emptyTable: "데이터가 없습니다.",
  lengthMenu: "_MENU_",
  info: "현재 _START_ - _END_ / 총 _TOTAL_건",
  infoEmpty: "데이터 없음",
  infoFiltered: "( _MAX_건의 데이터에서 필터링됨 )",
  loadingRecords: "로딩중...",
  processing:     "잠시만 기다려 주세요...",
  paginate: {
  	"next": "다음",
	"previous": "이전"
  },
  select: {
    rows: ""
  }
}
</script>
</head>
<body>
	<c:set var="totalmoney" value="0"></c:set>
<div class="container-fluid">
  <h1 class="h3 mb-2 text-gray-800">수익 표</h1>
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
</div>

<table id="data_list" class="table table-borderd">
	<thead>
		<tr>
			<th>주문번호</th>
			<th>유저 아이디</th>
			<th>제품 이름</th>
			<th>제품 종류</th>
			<th>주문 개수</th>
			<th>가격</th>
			<th>주문 상태</th>
			<th>시간</th>
			<th>제품 링크</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>

</body>
</html>