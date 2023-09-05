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
<button onclick="location.href='shopCreateForm.shop'">쇼핑몰 생성하기</button>

출력 ${sellermalls[0].name}
<c:if test="${not empty requestScope.sellermalls }">
	<c:forEach var="sellermall" items="${requestScope.sellermalls}">
		<br>판매자 번호 ${sellermall.seller_id}
		<br>홈쇼핑 이름 ${sellermall.name}
		<br>생성 날짜 ${sellermall.create_date}
		<br>쇼핑몰 등급 ${sellermall.grade}
	</c:forEach>
</c:if>


<button>쇼핑몰 관리</button>
</body>
</html>