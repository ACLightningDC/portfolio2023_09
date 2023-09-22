/**
 * 
 */

 function CheckAll(theForm){

	 var select_count = 0;
	 
	var sumPrice = 0;
	var getSumPrice = Number(document.getElementById("sum_price").innerText);	
			if(theForm.remove.length == undefined){
		let orderCount =  Number(document.getElementById(0+"order_count").innerText);
				let Price =  Number(document.getElementById(0+"price").innerText);
					if(theForm.allCheck.checked === false){
						
						}else{
							sumPrice += orderCount * Price; 
						}
		}else{
		for(var i=0; i<theForm.remove.length ; i++){
				let orderCount =  Number(document.getElementById(i+"order_count").innerText);
				let Price =  Number(document.getElementById(i+"price").innerText);
					if(theForm.allCheck.checked === false){
						
						}else{
							sumPrice += orderCount * Price; 
						}
		}
	}

	
	 if(theForm.remove.length == undefined){ //개상품이 1개만 있다면
		theForm.remove.checked = theForm.allCheck.checked;//checked="checked"
		select_count++;
	}else{
		for(var i=0;i<theForm.remove.length ;i++ ){
			if(theForm.allCheck.checked==true){
			select_count++;				
			}
			theForm.remove[i].checked = theForm.allCheck.checked;
		}
	}
	document.getElementById("sum_price").innerText = sumPrice;

	document.getElementById("select_count").innerText = select_count
 }
 
 function checkbox(box , price , count){
	 var select_count = Number(document.getElementById("select_count").innerText);
	 let sum_price=0;
	 if(box.checked==true)
		{
		 select_count++;
		 sum_price += price * count;
		}
	else{		
		select_count--;
		sum_price -= price * count;
	}

	 document.getElementById("select_count").innerText = select_count;
	 sumPriceFuc(sum_price);
 }
 
 
 function sumPriceFuc(getsumPrice){
	 	 var sum_price = Number(document.getElementById("sum_price").innerText);
	 	 getsumPrice =  Number(getsumPrice);
	 	 sum_price += getsumPrice;
	 	 	document.getElementById("sum_price").innerText = sum_price;
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
 function productCount(id){
	 const order_id = document.getElementById(id+"order_id").value;
	 const orderCount = document.getElementById(id+"orderCount").value;
	 if(orderCount == 0 || orderCount<0){
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