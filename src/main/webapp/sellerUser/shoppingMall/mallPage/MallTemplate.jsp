<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.bundle.js"></script>
<link rel="stylesheet"href = "${pageContext.request.contextPath}/resource/css/bootstrap.css">
</head>
<body>
<div>
</div>
<jsp:include page="MallHeader.jsp"/>
<c:if test="${!empty forward}">
	<div>
		<jsp:include page="${forward}"/>
	</div>
</c:if>

<jsp:include page="MallFoter.jsp"/>

</body>
</html>