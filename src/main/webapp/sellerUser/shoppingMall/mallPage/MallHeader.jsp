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

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
몰 헤더
<a>전체 제품</a>
<a>쇼핑몰 메인 가기</a>
<a>판매자 정보</a>

</body>
</html>