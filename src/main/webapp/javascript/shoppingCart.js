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
	 alert(order_id,+"추가 "+orderCount)
	 if(orderCount == null){
		 alert("개수를 적어주세요");
	 }else{
		 if(orderCount == 1){
			 alert("더이상 감소시킬수 없습니다");
		 }else{
			 location.href='CartCountUpdate.shop?orderCount='+orderCount+'&id='+order_id;
		 }		 
	 }
 }