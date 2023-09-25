<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>쇼핑몰 헤더</title>
<script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.bundle.js"></script>
<link rel="stylesheet"href = "${pageContext.request.contextPath}/resource/css/bootstrap.css">
</head>
<body>
몰 헤더
${sessionScope.id}
<a href="Mallproduct.Mall?id=${id}">전체 제품</a>
<a href="MallBulletinBoard.Mall?id=${id}">쇼핑몰 메인 가기</a>
<a href="MallSellerInfo.Mall?id=${id}">판매자 정보</a>

</body>
</html>