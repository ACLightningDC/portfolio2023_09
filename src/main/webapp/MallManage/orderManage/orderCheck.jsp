<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script>
$(document).ready(function(){
	document.postform.submit();
});

</script>
<body style="display: none">

<form action="http://info.sweettracker.co.kr/tracking/5" method="post" name="postform">
<div class="form-group">
  <label for="t_key">API key</label>
  <input type="hidden" class="form-control" id="t_key" name="t_key" placeholder="�������� APIKEY" value="um4IttvBOTuvNj1IjsEZJg">
</div>
<div class="form-group">
  <label for="t_code">�ù�� �ڵ�</label>
  <input type="text" class="form-control" name="t_code" id="t_code" placeholder="�ù�� �ڵ�" value="${del.delivery_company}">
</div>
<div class="form-group">
  <label for="t_invoice">����� ��ȣ</label>
  <input type="text" class="form-control" name="t_invoice" id="t_invoice" placeholder="����� ��ȣ" value="${del.delivery_num}">
</div>
</form>
</body>
</html>