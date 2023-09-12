<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
${seller_Mall_id}
${product_id}
<body>
	<form>
		<form method="post" action="inquiryAction.shop">
			<input name="seller_Mall_id" type="text" value="${param.seller_Mall_id}">
			<input name="product_id" type="text" value="${param.product_id}">
			제목<input name="name" type="text">
			텍스트<input name="contents" type="text">
			<input type="submit" value="전송하기">
		</form>
	</form>
</body>
</html>