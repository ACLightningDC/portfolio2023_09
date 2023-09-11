<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 관리</title>
</head>
<body>
${sessionScope.userinfo.name} 유저의 주소 관리
${address}
 <c:if test="${not empty requestScope.address }">
	<c:forEach var="addressL" items="${requestScope.address}">
		<br>우편번호: ${addressL.postcode}
		<br>주소: ${addressL.address1}
		<br>상세주소: ${addressL.address2}
	</c:forEach>
</c:if>

</body>
</html>