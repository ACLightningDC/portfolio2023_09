<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품문의</title>
<style type="text/css">

#registForm {
	width: 500px;
	height: 610px;
	border: 1px solid red;
	margin: auto;
}

h2 {text-align: center;}


table {
	margin: 0 auto;
	width: 500px;
	border: 2px solid orange;
	padding: 1px;
}

.td_left {
	width: 150px;
	border: 1px solid orange;
	padding: px;
	text-align: center;
}

.td_right {
	width: 300px;
	border: 1px solid orange;
	padding: 5px;
	margin: 2px;
}

input {padding: 5px;}

select {padding: 5px; width: 175px; }


#commandCell {
	text-align: center;
	margin-top: 4px;
}

</style> 

</head>
${seller_Mall_id}
${product_id}
<body>
<!-- 상품문의 등록 -->

<form method="post" action="inquiryAction.shop">
	<section id="writeForm">

	<h2>문의하기</h2>
		<table>
			<tr>
				<td class="td_left"><label for="BOARD_NAME">[문의유형]</label></td>
				<td class="td_right">
					<select>
				        <option value="product">상품문의</option>
				        <option value="payment">결제문의</option>
				        <option value="delivery">배송문의</option>
				        <option value="etc">기타</option>
				    </select>
				</td>
			</tr>
			
			<tr>
				<td class="td_left">
					<label for="BOARD_NAME">[소속 쇼핑몰]</label>
				</td>
				<td class="td_right">
					<input name="seller_Mall_id" type="text" value="${param.seller_Mall_id}"/>
				</td>
			</tr>
			
			<tr>
				<td class="td_left">
					<label for="BOARD_PASS">[제품 번호]</label>
				</td>
				<td class="td_right">
					<input name="product_id" type="text" value="${param.product_id}"/>
				</td>
			</tr>
			
			<tr>
				<td class="td_left">
					<label for="BOARD_SUBJECT">[주문 ID]</label>
				</td>
				<td class="td_right">
					<input name="order_id" type="text" value="${param.order_id}"/>
				</td>
			</tr>
			
			<tr>
				<td class="td_left">
					<label for="BOARD_SUBJECT">[제 목]</label>
				</td>
				<td class="td_right">
					<input name="name" type="text" required="required"/>
				</td>
			</tr>
				
			<tr>
				<td class="td_left">
					<label for="BOARD_CONTENT">[내 용]</label>
				</td>
				<td>
					<textarea name="contents" type="text" id="BOARD_CONTENT" name="BOARD_CONTENT" cols="40" rows="15" 
						required="required" style="resize: none; margin-left:5px;" maxlength="1024" placeholder="텍스트를 입력하세요."></textarea>
				</td>
			</tr>
		</table>
	</section>
	
	<section id="commandCell">
		<input type="submit" value="전송하기">
	</section>	
</form>
<!-- 상품문의 등록 -->		
</body>
</html>