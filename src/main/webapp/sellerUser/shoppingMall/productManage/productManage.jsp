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

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">쇼핑몰 이름 변경</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
<form action="productAddAction.shop" method="post" enctype="multipart/form-data">
          <div class="mb-1">
            <label for="price" class="col-form-label">가격:</label>
            <input type="text" class="form-control" id="price" name="price">
          </div>
          <div class="mb-1">
            <label for="name" class="col-form-label">이름:</label>
            <input type="text" class="form-control" id="name" name="name">
          </div>
          <div class="mb-1">
            <label for="kind" class="col-form-label">종류:</label>
            <input type="text" class="form-control" id="kind" name="kind">
          </div>
          <div class="mb-1">
            <label for="img" class="col-form-label">사진:</label>
            <input type="file" class="form-control" id="img" name="img">
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        <input type="submit" class="btn btn-primary" value="제품 등록">
      </div>
        </form>
    </div>
  </div>
</div>

<div class="container-fluid ">
  <h1 class="h3 mb-2 text-gray-800 py-3">상품 관리하기</h1>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
                           <h6 class="m-0 font-weight-bold text-primary">
                           <!-- <button class="btn btn-primary" onclick="location.href='productAdd.Seller'">상품 추가하기</button> -->
                           <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">상품 추가하기</button>
                           
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