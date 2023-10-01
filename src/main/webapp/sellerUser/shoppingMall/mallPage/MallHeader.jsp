<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String id = "";
    if(request.getAttribute("id")!=null){
    	id = (String)request.getAttribute("id");
    	request.setAttribute("id", id);
    }else if(request.getParameter("id")!=null){
    	id = request.getParameter("id");
    	request.setAttribute("id", id);
    }else {
		response.setContentType("text/html;charset=UTF-8");
		
		out.println("<script>");
		out.println("alert('잘못된 접근 입니다.');");
		out.println("href.location='homePage.shop'");
		out.println("</script>");
    }
    %>
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

	

  <div class="container">
    <header class="d-flex justify-content-center py-3">
      <ul class="nav nav-pills">
      	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/homePage.shop">쇼핑몰 홈페이지</a></li>
        <li class="nav-item"><a class="nav-link" href="Mallpage.Mall?id=${id}">개인 몰 메인</a></li>
        <li class="nav-item"><a class="nav-link" href="Mallproduct.Mall?id=${id}">전체 제품</a></li>
        <li class="nav-item"><a class="nav-link" href="MallSellerInfo.Mall?id=${id}">판매자 정보</a></li>
      </ul>
    </header>
  </div>





</body>
</html>