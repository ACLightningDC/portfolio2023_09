<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include file="header.jsp" %>
템플릿
${forward}
<c:if test="${!empty forward}">
	<div>
		<jsp:include page="${forward}"/>
	</div>
</c:if>


<%@include file="footer.jsp" %>

</body>
</html>