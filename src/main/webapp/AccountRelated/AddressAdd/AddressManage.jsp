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
<c:if test="${not empty requestScope.address}">
<div class="container">
	<div class="row mx-auto text-center">
	<c:forEach var="addressList" items="${requestScope.address}">
	<div class="card col-11 col-sm-4 " >
	  <div class="card-body">
	    <h5 class="card-title"></h5>
	    <p class="card-text">
	    
			<br>아이디${addressList.id}
			<br>${sessionScope.userinfo.address_id}
			<br>우편번호 ${addressList.postcode}
			<br>주소${addressList.address1}
			<br>상세 주소${addressList.address2}
	    </p>
			<button class="btn btn-primary" onclick="location.href='AddressDelete.address?id=${addressList.id}'">주소 삭제</button>
			<button class="btn btn-primary" onclick="location.href='AddressBasicSelect.address?id=${addressList.id}'"  ${sessionScope.userinfo.address_id == addressList.id ? "disabled='disabled'":"" } >${sessionScope.userinfo.address_id == addressList.id ? "선택됨":"기본주소로 선택" }</button>
	  </div>
	</div>
	</c:forEach>
	</div>
</c:if>
	<div class="mx-auto py-3">
		<button class="btn btn-primary" onclick="location.href='AddressAddForm.shop'">주소 추가</button>	
	</div>
</div>
</body>
</html>