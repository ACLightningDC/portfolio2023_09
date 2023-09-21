<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/javascript/JoinCheck.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.bundle.js"></script>
<link rel="stylesheet"href = "${pageContext.request.contextPath}/resource/css/bootstrap.css">
<script type="text/javascript">

function b_noChange(){
	var CheckButton = document.getElementById('CheckButton');
	var divText = document.getElementById('divText');
	
	divText.innerText="사업자 등록번호가 수정되었습니다. \n 확인 부탁드립니다";
	
	CheckButton.style.display ='none';
	
	} 


</script>
<script>
        $(document).ready(function() {
            let Checkbutton = document.getElementById("CheckButton");
            Checkbutton.style.display ='none';

            $("#requestButton").click(function() {
                // 입력 필드에서 사업자 등록번호 가져오기
                var bNo = $("#b_no").val();

                var data = {
                    "b_no": [bNo]
                };

                $.ajax({
                    url: "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=oDzQWmOxHyVL7lTw1kHZO3QAZ3afJHiEN7j7XCDOO%2FfBTlWH3ax7z%2FGSAaN4bl%2BxkmB1Bk%2BYHq2Q6M1dc30MkQ%3D%3D",
                    type: "POST",
                    data: JSON.stringify(data),
                    dataType: "json",
                    contentType: "application/json",
                    success: function(result) {
                        // 결과를 페이지의 "response" <pre> 태그에 표시하고 JSON 문자열로 변환
                       	
                        $("#CheckText").text(result.data[0].tax_type);
                        $("#response").text(JSON.stringify(result, null, 2));
                        
                        if(result.data[0].b_stt_cd){
		                 let divText =document.getElementById("divText");
		                 divText.innerHTML ="사용가능한 사업자 등록번호 입니다";	
		                 
		                 Checkbutton.style.display ='block';
		                 
                        }
                   	
                   	
                        
                         
                    },
                    error: function(xhr, textStatus, errorThrown) {
                        $("#response").text("에러 상태 코드: " + xhr.status + "\n에러 메시지: " + errorThrown + "\n응답 텍스트: " + xhr.responseText);
                    },
                });
            });
        });
    </script>

</head>
<body>
	<form method="get" action="" name="Form">

<div class="container">
		<div id="mainContainer"class="container-fluid p-2">
			<div class= "row py-3">
				<div class="col">
					<label for="email" class="form-label">사업자 등록번호 확인</label>
					<input id = "b_no"  class="form-control" name="b_no" type="text" value="${param.email}" required="required" onchange="b_noChange()">			
				</div>
			</div>
			<div class="row py-3">
				<div class="d-grid col mx-auto">
					<input id="requestButton" class="btn btn-primary" type="button" value="확인하기" >
				</div>
			</div>
<%-- 			<c:choose>
				<c:when test="${result.data[0].b_stt_cd == 01}">
					<div class= "row py-3">
						<div id= "divText" class="col">
								사용가능한 사업자등록번호 입니다				
						</div>
					</div>
					<div class="row py-3">
						<div class="col d-grid mx-auto">
							<button id="CheckButton"class="btn btn-primary" type="button" onclick="namesendEmail()">이 사업자 등록번호로 결정 </button>
						</div>
					</div>
				</c:when> 
				<c:when test="${result.data[0].b_stt_cd == 02}">
								<div class= "row py-3" >
					<div class="col" >
							사용불가능한 사업자 등록번호 입니다				
					</div>
				</div>
				</c:when>
				
				<c:when test="${empty result.data[0].b_stt_cd}">
				<div class= "row py-3">
					<div id="divText" class="col" >
							사업자 등록번호 확인 부탁드립니다.				
					</div>
				</div>
				</c:when>
			</c:choose> --%>
			<div class="row py-3">
				<div id ="divText" class="col">
												사업자 등록번호 확인 부탁드립니다.
				</div>
			</div>
			<div class="row py-3">
				<div class="col d-grid mx-auto" id="CheckButtonDiv">
					<button type="button" id="CheckButton" class="btn btn-primary" onclick="namesendB_no()" style="display: block">이 사업자 등록번호로 결정</button>    
				</div>
			</div>
			
    		<pre id="CheckText"></pre>
    		<!-- <pre id="response"></pre> -->
    		
</div>


	</form>
</body>
</html>
 