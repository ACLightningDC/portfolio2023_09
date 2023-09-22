/**
 * 
 */

 
function CheckAllSubmit(){
	const regex_phone = /^\d{3}\d{3,4}\d{4}$/;
	
	if (name.value) {
    alert("이름 입력 부탁드립니다.");
    $("#name").focus();
    return false;
	}
    else if (!regex_phone.test(phone.value)) {
    alert("휴대전화 번호 \"-\" 없이 11글자 부탁드립니다 .");
    $("#phone").focus();
    return false;
	}
	
	document.getElementById("updateForm").submit();
}


 function check_email(){
	 
 url="accountEmailCheck.User?email="+document.f.email.value;
 var popupWidth = 500;
 var popupHeight = 400;
 
 var popupX = (window.screen.width/ 2)-(popupWidth / 2);
 var popupY = (window.screen.height/ 2)-(popupHeight / 2);
 open(url,"이메일 중복체크",'width='+popupWidth+',height='+popupHeight+',left='+popupX+',top='+popupY);
 }
 
  function check_id(){
	 
 url="accountUseridCheck.User?userid="+document.f.userid.value;
 var popupWidth = 500;
 var popupHeight = 400;
 
 var popupX = (window.screen.width/ 2)-(popupWidth / 2);
 var popupY = (window.screen.height/ 2)-(popupHeight / 2);
 open(url,"id 중복체크",'width='+popupWidth+',height='+popupHeight+',left='+popupX+',top='+popupY);
 }