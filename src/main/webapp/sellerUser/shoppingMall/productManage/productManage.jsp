<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리하기</title>
</head>
<body>


<div class="container-fluid ">
  <h1 class="h3 mb-2 text-gray-800 py-3">상품 관리하기</h1>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
                           <h6 class="m-0 font-weight-bold text-primary">
                           <button class="btn btn-primary" onclick="location.href='productAdd.Seller'">상품 추가하기</button>
                           </h6>
        </div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered">
				<tr>
					<th>제품 번호</th><th>소속 쇼핑몰</th><th>제품 이름</th><th>제품 가격</th><th>제품 종류</th><th>제품 일자</th><th>제품 구매수</th>
					<th>제품 사진</th>
				</tr>
					<c:if test="${not empty requestScope.products }">
						<c:forEach var="product" items="${requestScope.products}">
						<tr>
							<td>${product.id}</td>
							<td>${product.sellerMall_id}</td>
							<td>${product.name}</td>
							<td>${product.price}</td>
							<td>${product.kind}</td>
							<td>${product.date}</td>
							<td>${product.buycount}</td>
							<td><img width="50px" alt="안나옴" src="images/${product.img}"></td>
							<td><button class="btn btn-primary" type="button"  onclick="location.href='#'">${product.name}상품 관리하러 가기</button></td>
						</tr>	
						</c:forEach>
					</c:if>
				<tr>
				</tr>
				</table>
			</div>
		</div>
	</div>
</div>

</body>
</html>