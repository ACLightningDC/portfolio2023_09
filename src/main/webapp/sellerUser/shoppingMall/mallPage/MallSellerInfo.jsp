<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 제품 페이지</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src="https://cdn.datatables.net/datetime/1.5.1/js/dataTables.dateTime.min.js"></script>
<script src="https://cdn.datatables.net/buttons/2.4.1/js/dataTables.buttons.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/datetime/1.5.1/css/dataTables.dateTime.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/2.4.1/css/buttons.dataTables.min.css"/>



<script type="text/javascript">
$(function(){
	$.ajax({
		url  :  "MallProduct.ForJson",
		type : 'POST',
		data : {
			"id" : "${id}",
		},
		
	}).done(function(d){
        var table = $("#data_list").DataTable({
         	deferRender : true,
             
	        responsive : true,
	        data: d,
	        dataSrc: "",
	        columns : [
	          { "data" : "img" },
	          { "data" : "price" },
	          { "data" : "name" },
	          { "data" : "kind" },
	          { "data" : "date" },
	          { "data" : "buycount" },
	          { "data" : "id" }
	          
	        ],
	        columnDefs: [
	        	{
        		   "targets": 0,
        		   "render": function(data, type, row){
        		    return "<img width = '90%' src=\"images/"+data+"\">";
        			},
        		   "orderable": false
	        	},
	        	{
        		   "targets": -1,
        		   "render": function(data, type, row){
        		    return  "<div class='btn-group'>" + 
        		    "<button class=\"btn btn-outline-dark flex-shrink-0\" onclick=\"location.href='shoppingCartProductDetail.shop?product_id="+data+"'\">제품 페이지</button>" +
					"<button class='btn btn-outline-dark mt-auto' onclick=\"location.href='shoppingCartproductAdd.shop?product_id="+data+"&order_count=1'\">장바구니</button>" + 
                	"</div>";
        			},
        		   "orderable": false
	        	},
	        ],
	    	"language": {
	            "decimal":        "",
	            "emptyTable":     "표에서 사용할 수있는 데이터가 없습니다.",
	            "info":           "총 _TOTAL_개   _START_에서 _END_개 까지 표시",
	            "infoEmpty":      "0 개 제품 중 0 ~ 0 개 표시중",
	            "infoFiltered":   "(_MAX_ 총 항목에서 필터링 됨)",
	            "infoPostFix":    "",
	            "thousands":      ",",
	            "lengthMenu":     "_MENU_",
	            "loadingRecords": "로드 중 ...",
	            "processing":     "처리 중 ...",
	            "search":         "검색:",
	            "zeroRecords":    "일치하는 레코드가 없습니다.",
	            "paginate": {
	                "first":      "처음",
	                "last":       "마지막",
	                "next":       "다음",
	                "previous":   "이전"
	            },
	            "aria": {
	                "sortAscending":  ": 오름차순으로 정렬",
	                "sortDescending": ": 내림차순으로 정렬"
	            },
			},
			
			"footerCallback" : function (row, data, start, end, display) {
		        let api = this.api();
		 
		        // Remove the formatting to get integer data for summation
		        let intVal = function (i) {
		            return typeof i === 'string'
		                ? i.replace(/[\$,]/g, '') * 1
		                : typeof i === 'number'
		                ? i
		                : 0;
		        };
		 
		    },
		    
	   	  "rowCallback": function( row, data ) {
	   	      $('td:eq(1)', row).html( data.price+'원' );
	   	      $('td:eq(2)', row).html( data.name );
	   	      $('td:eq(3)', row).html( '종류 : '+ data.kind );
	   	      $('td:eq(4)', row).html( new Date(data.date).toLocaleDateString('ko-KR')+'게시 제품' );
	   	      $('td:eq(5)', row).html( data.buycount+'개 구매 ' );
	   	  },
		    
		    
		    
        });
        

        
        let minDate, maxDate;
  	  
    	// Custom filtering function which will search data in column four between two values
    	DataTable.ext.search.push(function (settings, data, dataIndex) {
    	    let min = minDate.val();
    	    let max = maxDate.val();
    	    let date = new Date(data[7]);
    	 
    	    if (
    	        (min === null && max === null) ||
    	        (min === null && date <= max) ||
    	        (min <= date && max === null) ||
    	        (min <= date && date <= max)
    	    ) {
    	        return true;
    	    }
    	    return false;
    	});
    	 
    	// Create date inputs
    	minDate = new DateTime('#min', {
    	    format: 'YYYY-MM-DD'
    	});
    	maxDate = new DateTime('#max', {
    	    format: 'YYYY-MM-DD'
    	});
    	 
    	// DataTables initialisation
    	 
    	// Refilter the table
    	document.querySelectorAll('#min, #max').forEach((el) => {
    	    el.addEventListener('change', () => table.draw());
    	});
        
    	
    	table.on('click', 'button', function (e) {
    	    let data = table.row(e.target.closest('tr')).data();
    	 
    	});
    	
    	

    	
        });/*function 끝  */
});


</script>
<style type="text/css">
#data_list tbody tr {
    float: left;
	width: 20em;
	height: 30em;
	margin: 0.5em;
	padding: 0.5em;
	border: 1px solid #bfbfbf;
	border-radius: 0.5em;
	background-color: transparent !important;
	box-shadow: 0.25rem 0.25rem 0.5rem rgba(0, 0, 0, 0.25);
}
#data_list tbody td {
    display: block;
    text-align: center;
}
#data_list thead{
    display: none;
}
#data_list 
</style>
</head>
<body>

<div class="btn"></div>

<div class="container-fluid">
		<div class="card shadow mb-4">
			<div class="card-body">
    <table id="data_list" 
    class="class="table table-bordered compact dataTable no-footer cards"
    cellspacing="0" role="grid">
			<thead>
				<tr >
					<th>가격</th>
					<th>제품이름</th>
					<th>종류</th>
					<th>게시 일자</th>
					<th>구매수</th>
					<th>이미지</th>
					<th>상세보기</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
      		</tfoot>
		</table>
		</div>
	</div>
</div>


</body>
</html>