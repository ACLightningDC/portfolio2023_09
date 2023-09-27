<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!DOCTYPE html>
<html>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<head>
<meta charset="UTF-8">
<%--
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty requestScope.sellermalls }">
<div class="row-12">
	<div class="card col-12 col-sm-4" >
	  <div class="card-body">
	    <h5 class="card-title">홈쇼핑 이름 ${sellermall.name}</h5>
	    <p class="card-text">
			<br>판매자 번호 ${sellermall.seller_id}
			<br>홈쇼핑 이름 ${sellermall.name}
			<br>생성 날짜 ${sellermall.create_date}
			<br>쇼핑몰 등급 ${sellermall.grade}
	    </p>
			<button onclick="location.href='Mallpage.shop'">${product.name}해당 상품 보기</button>
	  </div>
	</div>

</div>
</c:if> --%>


<!-- 페이지네이션 - 리스트내역 추가(둘다가능)
	이 코드는 sellermalls와 inquiryList 데이터 모두가 있는 경우, sellermalls를 우선적으로 표시하고, 
	inquiryList를 표시합니다. 어느 데이터도 없는 경우 "표시할 데이터가 없습니다."라는 메시지를 출력합니다. 
	이렇게 하면 데이터의 존재 여부에 따라 화면을 제어할 수 있습니다
-->

    <title>페이지 타이틀</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty requestScope.sellermalls}">
            <!-- 홈쇼핑 목록 표시 -->
            <div class="row-12">
                <div class="card col-12 col-sm-4">
                    <div class="card-body">
                        <h5 class="card-title">홈쇼핑 이름 ${sellermall.name}</h5>
                        <p class="card-text">
                            <br>판매자 번호 ${sellermall.seller_id}
                            <br>홈쇼핑 이름 ${sellermall.name}
                            <br>생성 날짜 ${sellermall.create_date}
                            <br>쇼핑몰 등급 ${sellermall.grade}
                        </p>
                        <button onclick="location.href='Mallpage.shop'">${product.name} 해당 상품 보기</button>
                    </div>
                </div>
            </div>
        </c:when>
        
        <c:when test="${not empty requestScope.inquiryUserList}">
            <!-- 상품 문의 리스트 표시 -->
            <h1 class="text-center">문의 리스트</h1>
            <div class="container">
             <table class="table table-bordered table-striped  text-center">
	                <thead class="table-dark"> 
	                    <tr>
	                    	<th scope="col">#</th> <!-- 번호매기기위한 열추가 -->
	                        <th scope="col">문의 제목</th>
	                        <th scope="col">작성자</th>
	                        <th scope="col">작성일</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <c:forEach items="${inquiryUserList}" var="inquiry" varStatus="loop">
	                        <tr>
	                        	<th scope="row">${loop.index + 1}</td> <!-- 인덱스(0부터 시작)를 숫자로 표시 -->
	                            <td>${inquiry.name}</td>
	                            <td>${inquiry.users_id}</td>
	                            <td>${inquiry.inquiryDate}</td>
	                        </tr>
	                    </c:forEach>
	                </tbody>
               </table>
      		</div>
    
            <c:if test="${pageInfo.maxPage > 1}">
                <div>
                    <c:if test="${pageInfo.page > 1}">
                        <a href="inquiryUser.shop?page=${pageInfo.page - 1}">이전</a>
                    </c:if>
                    
                    <c:forEach begin="${pageInfo.startPage}" end="${pageInfo.endPage}" var="page">
                        <c:choose>
                            <c:when test="${pageInfo.page eq page}">
                                <strong>${page}</strong>
                            </c:when>
                            <c:otherwise>
                                <a href="inquiryUser.shop?page=${page}">${page}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    
                    <c:if test="${pageInfo.page < pageInfo.maxPage}">
                        <a href="inquiryUser.shop?page=${pageInfo.page + 1}">다음</a>
                    </c:if>
                </div>
            </c:if>
        </c:when>
        <c:otherwise>
            <!-- 어느 데이터도 없는 경우 처리 -->
            <p>표시할 데이터가 없습니다.</p>
        </c:otherwise>
    </c:choose>
    
</body>
</html>

    