<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<scipt>
	//이전 버튼
	function
</scipt>
<body>
<c:if test="${not empty requestScope.sellermalls }">
 <div class="album py-5 bg-body-tertiary">
    <div class="container">
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
	<c:forEach var="sellermall" items="${requestScope.sellermalls}">
<<<<<<< HEAD
		<br>판매자 번호 ${sellermall.seller_id}
		<br>홈쇼핑 이름 ${sellermall.name}
		<br>생성 날짜 ${sellermall.create_date}
		<br>쇼핑몰 등급 ${sellermall.grade}
		<button onclick="location.href='Mallpage.shop'">${product.name}쇼핑몰 보기</button>
		
	<div class="card col-12 col-sm-4" >
	  <div class="card-body">
	    <h5 class="card-title">홈쇼핑 이름 ${sellermall.name}</h5>
	    <p class="card-text">
			<br>판매자 번호 ${sellermall.seller_id}
			<br>홈쇼핑 이름 ${sellermall.name}
			<br>생성 날짜 ${sellermall.create_date}
			<br>쇼핑몰 등급 ${sellermall.grade}
	    </p>
			<button onclick="location.href='Mallpage.shop'">${product.name}쇼핑몰 보기</button>
	  </div>
	</div>
	</c:forEach>
</div>
</c:if>
<c:for>
=======
      

      
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
>>>>>>> branch 'master' of https://github.com/ACLightningDC/portfolio2023_09.git
${page.listCnt}
${page.page}

<!-- 페이지네이션 -->
<nav id="" aria-label="Page navigation example">
  <ul class="pagination">
  	<c:if test="${pagination.prev}">
   	 	<li class="page-item">
   	 		<a class="page-link" href="#" onClick="fn_prev('${pagination.page}', ${pagination.range}, ${pagination.rangeSize})">Previous</a>
   	 	</li>
	</c:if>
	
	<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
    	<li class="page-item ${pagination.page == idx ? 'active' : ''}">
    		<a class="page-link" href="#" onClick = "fn_pagination('${idx}', ${pagination.range}, ${pagination.rangeSize})">${idx}</a>
    	</li>
    </c:forEach>
    
    <c:if test="${pagination.next}">
    	<li class="page-item">
  			<a class="page-link" href="#" onClick="fn_next('${pagination.rangSize}', ${pagination.range}, ${pagination.rangeSize})">Next</a>
  		</li>
    </c:if>
  </ul>
</nav>
페이지별로 15개씩 만들기
</body>
</html>