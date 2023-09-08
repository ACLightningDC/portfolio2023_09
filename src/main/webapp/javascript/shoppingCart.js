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