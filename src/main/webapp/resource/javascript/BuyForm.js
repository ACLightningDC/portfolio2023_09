/**
 * 
 */
 function select_address(){
	 
 
 url="select_address.address";
 var popupWidth = 500;
 var popupHeight = 1000;
 
 var popupX = (window.screen.width/ 2)-(popupWidth / 2);
 var popupY = (window.screen.height/ 2)-(popupHeight / 2);
 open(url,"주소 선택",'width='+popupWidth+',height='+popupHeight+',left='+popupX+',top='+popupY);
 
 }
	
$(document).ready(function(){ 
	$("#iamportPayment").click(function(){ 
    	payment(); //버튼 클릭하면 호출 
    }); 
})
$(document).ready(function(){ 
	$("#Payment").click(function(){ 
		alert("호출");
    	form_Pay(); //버튼 클릭하면 호출 
    }); 
})


function form_Pay(){
	
	var form = document.getElementById("payForm");
	
	var email = form.email.value;
	var user_name = form.user_name.value;
	var tel = form.tel.value;
	var order_id = form.order_id.value;
	var pay_name = form.pay_name.value;
	var amount = form.amount.value;
	
	payment(email , user_name ,tel, order_id ,pay_name, amount);
	
	return false;
}

//버튼 클릭하면 실행

function payment(email , user_name ,tel, order_id ,pay_name, amount) {
    IMP.init('imp50550415');//아임포트 관리자 콘솔에서 확인한 '가맹점 식별코드' 입력
    IMP.request_pay({// param
        pg: "kakaopay.TC0ONETIME", //pg사명 or pg사명.CID (잘못 입력할 경우, 기본 PG사가 띄워짐)
        pay_method: "card", //지불 방법
        merchant_uid: order_id, //가맹점 주문번호 (아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
        name: pay_name, //결제창에 노출될 상품명
        amount: amount, //금액
        buyer_email : email, 
        buyer_name : user_name,
        buyer_tel : tel
    }, function (rsp) { // callback
        if (rsp.success) {
			alert("작동")
			submit_id();
        } else {
            alert("실패 : 코드("+rsp.error_code+") / 메세지(" + rsp.error_msg + ")");
        }
    });
}

	function submit_id(){
		var resultform = document.getElementById("buyIdResult");
		
		resultform.submit();
	}

  function sendPost(url, params) {
    var form = document.createElement('form');
    form.setAttribute('method', 'post');
    form.setAttribute('target', '_blank');
    form.setAttribute('action', url);
    document.charset = "UTF-8";

    for (var key in params) {
      var hiddenField = document.createElement('input');
      hiddenField.setAttribute('type', 'hidden');
      hiddenField.setAttribute('name', key);
      hiddenField.setAttribute('value', params[key]);
      form.appendChild(hiddenField);
    }

    document.body.appendChild(form);
    form.submit();
  }
