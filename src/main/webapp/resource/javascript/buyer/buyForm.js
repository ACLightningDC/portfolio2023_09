/**
 * 
 */

function address_id(){
	 
document.payForm.address_id.focus();

 url="accountUseridCheck.User?userid="+document.f.userid.value;
 var popupWidth = 500;
 var popupHeight = 1000;
 
 var popupX = (window.screen.width/ 2)-(popupWidth / 2);
 var popupY = (window.screen.height/ 2)-(popupHeight / 2);
 open(url,"id 중복체크",'width='+popupWidth+',height='+popupHeight+',left='+popupX+',top='+popupY);
 
 }