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
 <div class="album py-5 bg-body-tertiary">
    <div class="container">
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
	<c:forEach var="sellermall" items="${requestScope.sellermalls}">
      

      
        <div class="col">
          <div class="card shadow-sm">
            <div class="card-body">
            <h5 class="card-title">${sellermall.name}</h5>
              <p class="card-text">
			<br>판매자 번호 ${sellermall.seller_id}
			<br>생성 날짜 ${sellermall.create_date}
			<br>쇼핑몰 등급 ${sellermall.grade}              </p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='Mallpage.shop'">${product.name}쇼핑몰 보기</button>
                </div>
                <small class="text-body-secondary">9 mins</small>
              </div>
            </div>
          </div>
        </div>
        
	</c:forEach>
      </div>
    </div>
  </div>
</c:if>

페이지별로 15개씩 만들기
</body>
</html>