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

셀러몰 id ${sellerMallid}

<div class="container-fluid ">
  <h1 class="h3 mb-2 text-gray-800 py-2">쇼핑몰 관리</h1>
	<div class="card shadow mb-4">
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

<button class="btn btn-primary" onclick="location.href='ShopUpdate.Seller'">쇼핑몰 변경하기</button>
<br><button class="btn btn-danger" onclick="location.href='ShopDelete.shop?id=${sellerMallid}'">쇼핑몰 삭제</button>
</div>
</div>
	</div>
</div>

</body>
</html>