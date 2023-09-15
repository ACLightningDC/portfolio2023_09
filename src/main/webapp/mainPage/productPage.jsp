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
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Shop in style</h1>
                    <p class="lead fw-normal text-white-50 mb-0">With this shop hompeage template</p>
                </div>
            </div>
        </header>
        <!-- Section-->
        <section class="py-5">
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
													<button class="btn btn-outline-dark mt-auto" onclick="location.href='shoppingCartProductAdd.shop?product_id=${product.id}&order_count=1'">장바구니</button>
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
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        
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
        
    </body>
</html>
