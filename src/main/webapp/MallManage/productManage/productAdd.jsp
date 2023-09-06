<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="productAddAction.shop" method="post" enctype="multipart/form-data">
	<br>가격<input type="text" name="price">
	<br>이름<input type="text" name="name">
	<br>종류<input type="text" name="kind">
	<br>사진<input type="file" name="img">
	
	<br><button onclick="">상세 스펙 추가</button>
	
	<br><input type="submit" value="제품 추가">
</form>

</body>
</html>