<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en" data-bs-theme="auto">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>사업자 회원가입</title>
    <script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/resource/js/bootstrap.bundle.js"></script>
	<link rel="stylesheet"href = "${pageContext.request.contextPath}/resource/css/bootstrap.css">
	<script src="${pageContext.request.contextPath}/resource/javascript/accountJoin.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
  </head>
  <body class="bg-body-tertiary">
 


    
<div class="container">
  <main>
    <div class="py-5 text-center">
      <h2>구매자 회원가입 입니다.</h2>
      <p class="lead">방문해주셔서 감사합니다. 필수입력은 빠짐없이 입력해주시기 바랍니다. </p>
    </div>

    <div class="row g-5 ">

      <div class=" col-xl-8 d-grid mx-auto">
      
        <form id="acountForm" name="f"method="post" action="accountAction.shop" class="needs-validation" novalidate id="acountForm">
          <div class="row g-3">
          
          <div class="col-12">
              <label for="userid" class="form-label">아이디</label>
              <input type="text" class="form-control" name="userid" id="userid" autofocus="autofocus" placeholder="필수입력" required="required" readonly="readonly">
               <div class="invalid-feedback">
                          아이디를 입력해주세요.
              </div>
           </div>
           <div class="col-12">
           	<button type="button" class="btn btn-primary" onclick="check_id();" >아이디 중복 확인</button>
           </div>
           
            <div class="col-12">
              <label for="email" class="form-label">Email</label>
              <input type="email" class="form-control" name="email" id="email" autofocus="autofocus" placeholder="user@example.com" required="required" readonly="readonly">
              <div class="invalid-feedback">
                주문확인을 위해 이메일 주소를 입력해주세요.
              </div>
            </div>
            
			<div class="col-12">
           	<button type="button" class="btn btn-primary" onclick="check_email();">이메일 확인</button>
           </div>
           
           <div class="col-12">
              <label for="password" class="form-label">비밀번호</label>
              <input type="password" class="form-control" name="password" id="password" autofocus="autofocus" placeholder="영문대소문자포함 4~20자 입니다." required="required">
               <div class="invalid-feedback">
                          비밀번호를 입력해주세요.
              </div>
           </div>
           
            <div class="col-12">
              <label for="name" class="form-label">이 름</label>
              <input type="text" class="form-control" name="name" id="name" autofocus="autofocus" placeholder="필수입력"  required="required">
               <div class="invalid-feedback">
                            이름을 입력해주세요.
              </div>
            </div>

            
            <div class="col-12">
              <label for="phone" class="form-label">휴대 전화번호</label>
             <div class="input-group has-validation">
                <input type="text" class="form-control" name="phone" id="phone" autofocus="autofocus" placeholder="필수입력" required="required">
                  <div class="invalid-feedback">
                               전화번호를 입력해주세요.
             	  </div>
             </div>
            </div>


            <div class="col-12">
              <label for="birthday" class="form-label">생 일</label>
              <input type="date" class="form-control" id="birthday" name="birthday" value="" placeholder="YYYY-MM-DD" required="required">
              <div class="invalid-feedback">
                생년월일을 입력해주세요.
              </div>
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
		
 		<label for="grade" class="form-label">성 별</label>
		<div class="col-md-3">
          <div class="form-check  form-check">
            <input type="radio" name ="gender" value="M" class="form-check-input" >
            <label class="form-check-label" for="same-address">남</label>
          </div>
 		</div>
 
		<div class="col-md-3">
          <div class="form-check  form-check-inline">
            <input type="radio" name ="gender" value="F" class="form-check-input">
            <label class="form-check-label" for="save-info">여</label>
          </div>
 		</div>
          <hr class="my-4">

          </div>

          <button class="w-100 btn btn-primary btn-lg" type="submit" onclick="CheckAllSubmit(this); return false;">회원가입</button>
        </form>
      </div>
    </div>
  </main>


</div>

    <script src="checkout.js"></script></body>
</html>
