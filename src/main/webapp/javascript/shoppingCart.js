/**
 * 
 */

 function CheckAll(theForm){
	 if(theForm.remove.length == undefined){ //개상품이 1개만 있다면
		theForm.remove.checked = theForm.allCheck.checked;//checked="checked"
	}else{
		for(var i=0;i<theForm.remove.length ;i++ ){
			theForm.remove[i].checked = theForm.allCheck.checked;
		}	
	}
 }
 
 function productPluse(orderCount , id){
	 orderCount = Number(orderCount);
	 location.href='CartCountUpdate.shop?orderCount='+(orderCount+1)+'&id='+id;
 }
 function productMinus(orderCount , id){
	 orderCount = Number(orderCount);
	 if(orderCount == 1){
		 alert("더이상 감소시킬수 없습니다");
	 }else{
	 location.href='CartCountUpdate.shop?orderCount='+(orderCount+-1)+'&id='+id;
	 }
 }
 function productCount(){
	 const order_id = document.getElementById("order_id").value;
	 const orderCount = document.getElementById("orderCount").value;
	 if(orderCount == null & orderCount<0){
		 alert("0이상의 개수를 적어주세요");
	 }else{
		 if(orderCount == 1){
			 alert("더이상 감소시킬수 없습니다");
		 }else{
			 location.href='CartCountUpdate.shop?orderCount='+orderCount+'&id='+order_id;
		 }		 
	 }
 }
 
 function submit_Cart(){
	var Check_arr =  document.getElementsByName("remove");
		
	for(var i = 0 ; i <Check_arr.length ; i++){
		if(Check_arr == false)return false;
	}
	
	document.CartForm.submit();
 }