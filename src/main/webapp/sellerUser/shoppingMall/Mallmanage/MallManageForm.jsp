<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 관리</title>
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
        <form action="ShopUpdate.Seller" method="post">
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">변경할 이름:</label>
            <input type="text" class="form-control" id="recipient-name" name="name">
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        <input type="submit" class="btn btn-primary" value="이름 변경">
      </div>
        </form>
    </div>
  </div>
</div>




<div class="container-fluid ">
  <h1 class="h3 mb-2 text-gray-800 py-2">쇼핑몰 관리</h1>
	<div class="card shadow mb-4 col-8 mx-auto">
        <div class="row">
			<div class="card mb-4 m-3 col-md-10 mx-auto py-3">
<button class="btn btn-primary" onclick="location.href='productManage.shop'">상품 관리하기</button>
<br><button class="btn btn-primary" onclick="location.href='orderManage.shop'">배송 관리하기</button>
<br><button class="btn btn-primary" onclick="location.href='inquiryManage.shop'">문의사항 답변하기</button>
			</div>
						<div class="card mb-4 m-3 col-md-10 mx-auto py-3">
			
<button class="btn btn-primary" onclick="location.href='orderManageSales.Seller'">매출 확인</button>
</div>
			<div class="card mb-4 m-3 col-md-10 mx-auto py-3">
			<button class="btn btn-primary" onclick="location.href='ShoppingMallManager.Seller'">쇼핑몰 홈페이지 관리하기</button>
<br><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">쇼핑몰 이름 변경</button>
<br><button class="btn btn-danger" onclick="location.href='ShopDelete.shop?id=${sellerMallid}'">쇼핑몰 삭제</button>
</div>
</div>
	</div>
</div>

</body>
</html>