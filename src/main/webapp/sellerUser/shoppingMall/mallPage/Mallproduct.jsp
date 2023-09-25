<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 전체제품</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css"/>
<script>
$(function(){
	$('#product').DataTable();
	
	$.ajax({
		url:"MallproductAjax.Mall",
		type:"post",
		data: {"id" : "${id}"},
		dataType : "text",
		},
		success:function(data){
			
		},
		error:function(){
			alert("에러")
		}
		
	});
});
</script>
</head>
<body>
	<table id="product" class="table table-striped" >
		<thead>
			<tr>
				<th>이름</th>
				<th>종류</th>
				<th>가격</th>
				<th>게시일자</th>
				<th>이미지</th>
				<th>구매수</th>
				<th>재고</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
			</tr>
		</tbody>
	</table>
	
</body>
</html>