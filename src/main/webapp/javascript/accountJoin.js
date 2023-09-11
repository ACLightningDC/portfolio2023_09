/**
 * 
 */

 function check_email(){
	 
if(document.f.email.value==""){
alert("이메일을 입력하세요");
document.f.email.focus();
return;
 }
 url="accountEmailCheck.shop?email="+document.f.email.value;
 var popupWidth = 500;
 var popupHeight = 400;
 
 var popupX = (window.screen.width/ 2)-(popupWidth / 2);
 var popupY = (window.screen.height/ 2)-(popupHeight / 2);
 open(url,"이메일 중복체크",'width='+popupWidth+',height='+popupHeight+',left='+popupX+',top='+popupY);
 
 }
 
 function check_id(){
	 
if(document.f.userid.value==""){
alert("아이디를 입력하세요");
document.f.userid.focus();
return;
 }
 url="accountUseridCheck.shop?userid="+document.f.userid.value;
 var popupWidth = 500;
 var popupHeight = 400;
 
 var popupX = (window.screen.width/ 2)-(popupWidth / 2);
 var popupY = (window.screen.height/ 2)-(popupHeight / 2);
 open(url,"id 중복체크",'width='+popupWidth+',height='+popupHeight+',left='+popupX+',top='+popupY);
 
 }
 
 function joinComRegCheck(){
	 
if(document.f.b_no.value==""){
alert("사업자 등록번호를 입력하세요");
document.f.b_no.focus();
return;
 }
 url="accountB_noCheck.shop?userid="+document.f.b_no.value;
 var popupWidth = 500;
 var popupHeight = 400;
 
 var popupX = (window.screen.width/ 2)-(popupWidth / 2);
 var popupY = (window.screen.height/ 2)-(popupHeight / 2);
 open(url,"사업자 등록번호 중복체크",'width='+popupWidth+',height='+popupHeight+',left='+popupX+',top='+popupY);
 
 }
 