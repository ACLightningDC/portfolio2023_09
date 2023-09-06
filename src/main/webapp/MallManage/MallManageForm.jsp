<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 관리</title>
</head>
<body>

셀러몰 id ${sellerMallid}
<br><button onclick="location.href='productManage.shop'">상품 관리하기</button>

<br><button onclick="location.href='inquiryManage.shop'">문의사항 답변하기</button>
<br><button onclick="location.href='orderManage.shop'">배송 관리하기</button>

<br><button onclick="location.href='ShopUpdate.shop'">쇼핑몰 변경하기</button>
<br><button onclick="location.href='ShopDelete.shop'">쇼핑몰 삭제</button>

</body>
</html>