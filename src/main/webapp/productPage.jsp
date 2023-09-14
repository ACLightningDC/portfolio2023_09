<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  </head>
  <body class="p-3 m-0 border-0 bd-example">
<title>Insert title here</title>
</head>

<script>
	//이전 버튼
	function fn_prev(page, range, rangeSize){
		var page = ((range - 2) * rangeSize) + 1;
		var range = range -1;
		
	    var url = "productPage.shop"; //확인요
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
	
	//페이지 번호 클릭
	function fn_page(page, range, rangeSize, searchType, keyword){
		var url = "productPage.shop"; //확인요
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	} 
	
	//다음 버튼
	function fn_next(page, range, rangeSiae){
		var page = parseInt((range * rangeSiae)) + 1;
		var range = parseInt(range) + 1;
		
		var url = "productPage.shop"; //확인요
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
	
</script>
<body>

products
${requestScope.products[0].name}
<c:if test="${not empty requestScope.products }">
	<c:forEach var="product" items="${requestScope.products}">
		<br>제품 번호 : ${product.id}
		<br>소속 쇼핑몰 : ${product.sellerMall_id}
		<br>제품 이름 : ${product.name}
		<br>제품 가격 : ${product.price}
		<br>제품 종류 : ${product.kind}
		<br>제품 일자 : ${product.date}
		<br>제품 구매수 : ${product.buycount}
		<br>제품 사진경로 : ${product.img}
		<form>
			<input>
		</form>
		<br><img width="50px" alt="안나옴" src="images/${product.img}">
		<button onclick="location.href='#'">${product.name}상품 바로구매</button>
		<button onclick="location.href='shoppingCartProductAdd.shop?product_id=${product.id}&order_count=1'">${product.name}상품 장바구니</button>
		<button onclick="location.href='shoppingCartProductDetail.shop?product_id=${product.id}'">${product.name}상품 상세보기</button>
	</c:forEach>
</c:if>

<BR>상품개수${page.listCnt}
<BR>페이지${page.page}
<br>이전 페이지${page.prev}
<br>이전 페이지${page.pageCnt}
<!-- 페이지네이션 -->
<nav id="" aria-label="Page navigation example">
  <ul class="pagination">
  	<c:if test="${page.prev}">
   	 	<li class="page-item">
   	 		<a class="page-link" href="#" onClick="fn_prev('${page.page}', ${page.range}, ${page.rangeSize})">Previous</a>
   	 	</li>
	</c:if>
	
	<c:forEach begin="${page.startPage}" end="${page.endPage}" var="idx">
    	<li class="page-item ${page.page == idx ? 'active' : ''}">
    		<a class="page-link" href="#" onClick = "fn_page('${idx}', ${page.range}, ${page.rangeSize})">${idx}</a>
    	</li>
    </c:forEach>
    
    <c:if test="${page.next}">
    	<li class="page-item">
  			<a class="page-link" href="#" onClick="fn_next('${page.rangSize}', ${page.range}, ${page.rangeSize})">Next</a>
  		</li>
    </c:if>
  </ul>
</nav>


<a href="productPage.shop?page=1">상품별 보기</a>
</body>
</html>