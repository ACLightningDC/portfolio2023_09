<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 관리</title>
<script>
$(window).bind("beforeunload", function (e){
		opener.document.infoPayForm.address_id.value = "${sessionScope.userinfo.address_id}";
		
		Addressrefresh("${sessionScope.userinfo.address_id}");
});

function Addressrefresh(address_id){
	alert("문자");
	
	postcode = document.getElementById(address_id + "postcode").innerText;
	address1 = document.getElementById(address_id + "address1").innerText;
	address2 = document.getElementById(address_id + "address2").innerText;
	
	opener.document.getElementById("postcode").innerText = postcode ;
	opener.document.getElementById("address1").innerText = address1 ;
	opener.document.getElementById("address2").innerText = address2 ;
}
</script>
</head>
<body>
<c:if test="${not empty requestScope.address}">
<div class="container ">
	<div class="row mx-auto text-center">
	<c:forEach var="addressList" items="${requestScope.address}">
	<div class="card col-11 col-sm-4 mx-auto" >
	  <div class="card-body">
	    <h5 class="card-title"></h5>
	    <p class="card-text">
	    
			<br>아이디${addressList.id}
			<br>${sessionScope.userinfo.address_id}
			<br>우편번호<span id="${addressList.id}postcode"> ${addressList.postcode}</span>
			<br>주소<span id="${addressList.id}address1">${addressList.address1}</span>
			<br>상세 주소<span id="${addressList.id}address2">${addressList.address2}</span>
	    </p>
			<button class="btn btn-primary" onclick="location.href='AddressDelete.address?id=${addressList.id}'">주소 삭제</button>
			<button class="btn btn-primary" onclick="location.href='AddressBasicSelect.address?id=${addressList.id}'"  ${sessionScope.userinfo.address_id == addressList.id ? "disabled='disabled'":"" } >${sessionScope.userinfo.address_id == addressList.id ? "선택됨":"기본주소로 선택" }</button>
	  </div>
	</div>
	</c:forEach>
	</div>
</c:if>
	<div class="mx-auto py-3">
		<button class="btn btn-primary" onclick="location.href='AddressAddForm.address'">주소 추가</button>	
	</div>
</div>
</body>
</html>