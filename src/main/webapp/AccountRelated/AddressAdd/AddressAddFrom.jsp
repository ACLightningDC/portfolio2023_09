<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head><script src="../assets/js/color-modes.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Checkout example · Bootstrap v5.3</title>

    
    <!-- Custom styles for this template -->
    <link href="checkout.css" rel="stylesheet">
    
    <link rel="stylesheet"href = "/resource/css/bootstrap.css">
	<script src="/resource/js/bootstrap.bundle.js"></script>
    
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.bundle.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link rel="stylesheet"href = "${pageContext.request.contextPath}/resource/css/bootstrap.css">
<script src="${pageContext.request.contextPath}/javascript/accountJoin.js"></script>
<script >
	function findAddr(){
		//카카오 지도 발생-> 주소 입력 후 [검색]-> 찾는 주소[선택]
		new daum.Postcode({
			oncomplete : function(data) {//[선택]시 입력값 세팅
				console.log(data);
				//alert(data);
				
				document.getElementById("postcode").value = data.zonecode;
				
				let roadAddr = data.roadAddress;//도로명 주소
				let JibunAddr = data.JibunAddress;//도로명 주소
				
				if(roadAddr != ''){//도로명 주소가 있으면 도로명 주소가 등록되고
					document.getElementById("address1").value = roadAddr;
				}else if(jibunAddr != ''){//도로명 주소가 없고 지번주소만 있으면 지번주소가 등록함
					document.getElementById("address1").value = jibunAddr;
				}
				
				document.getElementById("address2").focus();//커서 둠 가이 
				
			}
		}).open();
	}
	
</script>
	    <script>
        $(document).ready(function() {
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
                        $("#response").text(JSON.stringify(result, null, 2));
                    },
                    error: function(xhr, textStatus, errorThrown) {
                        $("#response").text("에러 상태 코드: " + xhr.status + "\n에러 메시지: " + errorThrown + "\n응답 텍스트: " + xhr.responseText);
                    },
                });
            });
        });
    </script>
  </head>
  <body class="bg-body-tertiary">
 


    
<div class="container">
  <main>
    <div class="py-5 text-center">
      <h2>주소 입력 입니다.</h2>
      <p class="lead">주소 추가입니다. </p>
    </div>

    <div class="row g-5 ">

      <div class=" col-xl-8 d-grid mx-auto">
      
        <form name="f"method="post" action="AddressAdd.shop" class="needs-validation" novalidate>
          <div class="row g-3">

            </div>
              <div class="col-12">
				<button type="button" class="btn btn-primary" onclick="findAddr();">주소 찾기</button>
              </div>
            <div class="col-12">
              <label for="postcode" class="form-label">우편번호</label>
              <input name="postcode" type="text" class="form-control" id="postcode" value="" placeholder="" required="required" readonly="readonly">
              <div class="invalid-feedback">
              	우편번호를 입력해주세요
              </div>
            </div>
            <div class="col-12">
              <label for="address1" class="form-label">주소</label>
              <input name="address1" type="text" class="form-control" id="address1" value="" placeholder="" required="required" readonly="readonly">
              <div class="invalid-feedback">
                주소를 입력해주세요.
              </div>
            </div>
            <div class="col-12">
              <label for="address2" class="form-label">상세주소</label>
              <input name="address2" type="text" class="form-control" id="address2" value="" placeholder="" required="required">
              <div class="invalid-feedback">
                상세주소를 입력해주세요.
              </div>
            </div>

          </div>

<div class="col-8 mx-auto">
          <button class=" btn btn-primary btn-lg" type="submit">입력완료</button>
</div>
        </form>
      </div>
    </div>
  </main>


</div>

    <script src="checkout.js"></script></body>
</html>
