<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "java.util.*" %>
    <%@ page import="fruit.*" %>
  
    
    <%@ include file="header55.jsp" %>
    
    <%
    List<Fruit> fruits = new ArrayList<>(); 
    fruits.add(new Fruit("홍로(사과)" , 8000 , "공판장에서 사온 가격 그대로 판매합니다. 10kg 이고 33과짜리입니다."));
    fruits.add(new Fruit("자두(홍자두)" , 6000 , "공판장에서 사온 가격 그대로 판매합니다.5kg "));
    fruits.add(new Fruit("포도(거봉)" , 40000 , "공판장에서 사온 가격 그대로 판매합니다. 1kg으로 거래합니다."));
    %>
    
 	<script>
 	function point_view() {
 		
 		alert("해당상품의 정보를 보여줍니다.")
 	
 	}
 	function point_viewout() {
 		
 		alert("해당상품의 정보를 보지않습니다.")
 		
 	}
 	
 	</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게1
</title>
		 <style>
        #box {
            width: 200px;
            height: 200px;
            background-color: lightgray;
            text-align: center;
            line-height: 200px;
            cursor: pointer;
        }
    </style>
	
</head>
	<style>
	
	
	
	</style>

<body>
		
		<h2>상품</h2>
		
		상품명 : <%= fruits.get(0).getKind() %> <br>
    <h4>1kg당 <%=fruits.get(0).getPrice() %> </h4><br>
    <div>
		<img src="image/1.JPG">
		 
		</div>
		<br> <br>
	
	
	<br> <br>

		상품명 : <%= fruits.get(1).getKind() %> <br>
	 <h4>1kg당	 <%=fruits.get(1).getPrice() %></h4><br>
		<img src="image/2.JPG">
		
		<br> <br>
		
		
		상품명 : <%= fruits.get(2).getKind() %> <br>
	 <h4>1kg당	 <%=fruits.get(2).getPrice() %></h4><br>
		<img src="image/3.JPG">
		
		<br> <br>
	
<br> <br>
</body>
</html>