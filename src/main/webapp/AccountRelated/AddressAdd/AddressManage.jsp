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
<div class="row-12">
	<c:forEach var="addressList" items="${requestScope.address}">

	<div class="card col-12 col-sm-4" >
	  <div class="card-body">
	    <h5 class="card-title">주소</h5>
	    <p class="card-text">
			<br>우편번호 ${addressList.postcode}
			<br>주소${addressList.address1}
			<br>상세 주소${addressList.address2}
	    </p>
			<button onclick="location.href='AddressDelete.address?id=${addressList.id}'">주소 삭제</button>
	  </div>
	</div>
	</c:forEach>
</div>
</c:if>
			<button onclick="location.href='AddressAddForm.shop'">주소 추가</button>
</body>
</html>