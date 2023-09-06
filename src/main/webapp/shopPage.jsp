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
<c:if test="${not empty requestScope.sellermalls }">
	<c:forEach var="sellermall" items="${requestScope.sellermalls}">
		<br>판매자 번호 ${sellermall.seller_id}
		<br>홈쇼핑 이름 ${sellermall.name}
		<br>생성 날짜 ${sellermall.create_date}
		<br>쇼핑몰 등급 ${sellermall.grade}
		<button onclick="location.href='#'">${product.name}쇼핑몰 보기</button>
	</c:forEach>
</c:if>

페이지별로 15개씩 만들기
</body>
</html>