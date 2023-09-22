<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>제품별 보기</title>
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <header class="bg py-1">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center ">
                    <h1 class="display-4 fw-bolder">상품 보기</h1>
                    <p class="lead fw-normal text-50 mb-0">상품별 보기</p>
                </div>
            </div>
        </header>
        <!-- Section-->
        <section class="py-3">
            <div class="container px-4 px-lg-5 mt-5">
				<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
	            	<c:if test="${not empty requestScope.products }">
	            		<c:forEach var="product" items="${requestScope.products}">
			                    <div class="col mb-5">
			                        <div class="card h-100">
			                            <!-- Sale badge-->
			                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
			                            <!-- Product image-->
			                            <img width="450" height="300" class="card-img-top" src="images/${product.img}" alt="..." />
			                            <!-- Product details-->
			                            <div class="card-body p-4">
			                                <div class="text-center">
			                                    <!-- Product name-->
			                                    <h5 class="fw-bolder">${product.name}</h5>
			                                    <!-- Product des -->
			                                    <small>종류 : ${product.kind}</small>
			                                    <!-- Product reviews-->
			                                    <div class="d-flex justify-content-center small text-warning mb-2">
			                                        <div class="bi-star-fill"></div>
			                                        <div class="bi-star-fill"></div>
			                                        <div class="bi-star-fill"></div>
			                                        <div class="bi-star-fill"></div>
			                                        <div class="bi-star-fill"></div>
			                                    </div>
			                                    <!-- Product price-->
			                                    <span class="text-muted text-decoration-line-through">2000 &#8361</span>
			                                    ${product.price}&#8361
			                                </div>
			                            </div>
			                            <!-- Product actions-->
			                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
				                            <div class="text-center" >
				                                <div class="btn-group">
													<button class="btn btn-outline-dark mt-auto" onclick="location.href='shoppingCartproductAdd.shop?product_id=${product.id}&order_count=1'">장바구니</button>
													<button class="btn btn-outline-dark mt-auto" onclick="location.href='shoppingCartProductDetail.shop?product_id=${product.id}'">상세보기</button>
				                                </div>
				                            </div>
			                            </div>
			                        </div>
			                    </div>
						</c:forEach>
					</c:if>
				</div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-2 bg">
	         <nav id="" aria-label="Page navigation example">
			  <ul class="pagination justify-content-center">
			  <div class="btn-group text-align-center">
			    <c:if test="${pageInfo.page <= 1}">
			        <div class="btn btn-outline-primary">이전&nbsp;</div>
			    </c:if>
			    <c:choose>
			        <c:when test="${pageInfo.page > 1}">
			            <a class="btn btn-outline-primary" href="productPage.shop?page=${pageInfo.page - 1}">이전</a>&nbsp;
			        </c:when>
			    </c:choose>
			
			    <c:forEach var="page" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
			        <c:choose>
			            <c:when test="${pageInfo.page == page}">
			                <div class="btn btn-outline-primary"><c:out value="${page}"/></div>
			            </c:when>
			            <c:otherwise>
			                <a class="btn btn-outline-primary" href="productPage.shop?page=${page}"><c:out value="${page}"/></a>&nbsp;
			            </c:otherwise>
			        </c:choose>
			    </c:forEach>
			
			    <c:if test="${pageInfo.page >= pageInfo.maxPage}">
			        <div class="btn btn-outline-primary">다음</div>
			    </c:if>
			    <c:choose>
			        <c:when test="${pageInfo.page < pageInfo.maxPage}">
			            <a class="btn btn-outline-primary" href="productPage.shop?page=${pageInfo.page + 1}">다음</a>
			        </c:when>
			    </c:choose>
			    </div>
			  </ul>
			</nav>
        </footer>
        
    </body>
</html>
