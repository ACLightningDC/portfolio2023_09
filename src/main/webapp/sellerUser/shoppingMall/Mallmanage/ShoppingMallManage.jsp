<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="modal fade"  id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">2단계 보안설정하기</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      	<form action="CreateMall.shop" method="get">
      	
          <div class="mb-1">
            <label for="name" class="col-form-label">쇼핑몰 이름 입력:</label>
            <input type="text" class="form-control" id="name" name="name" maxlength="45">
          </div>
			<input type="submit" class="btn btn-primary" value="확인" >	
		</form>
      </div>
    </div>
  </div>
</div>
<div>

<div class="container-fluid ">
  <h1 class="h3 mb-2 text-gray-800 py-5">쇼핑몰 관리하기</h1>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
                           <h6 class="m-0 font-weight-bold text-primary">
                           <!-- <button class="btn btn-primary" onclick="location.href='shopCreateForm.Seller'">쇼핑몰 생성하기</button> -->
                           <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">쇼핑몰 생성하기</button>
                           </h6>
        </div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered">
				<tr>
					<th>판매자 번호</th><th>홈쇼핑 이름</th><th>생성 날짜</th><th>쇼핑몰 등급</th><th>관리하러 가기</th>
				</tr>
					<c:if test="${not empty requestScope.sellermalls }">
						<c:forEach var="sellermall" items="${requestScope.sellermalls}">
						<tr>
							<td>${sellermall.seller_id}</td>
							<td>${sellermall.name}</td>
							<td>${sellermall.create_date}</td>
							<td>${sellermall.grade}</td>
							<td><button class="btn btn-primary" type="button" onclick="location.href='ShoppingMallManageOne.shop?sellerMallid=${sellermall.id}'">${sellermall.name} 관리하러 가기</button></td>
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

<br>
</body>
</html>