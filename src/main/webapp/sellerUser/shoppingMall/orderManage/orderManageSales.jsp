<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src="https://cdn.datatables.net/datetime/1.5.1/js/dataTables.dateTime.min.js"></script>
<script src="https://cdn.datatables.net/buttons/2.4.1/js/dataTables.buttons.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/datetime/1.5.1/css/dataTables.dateTime.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/2.4.1/css/buttons.dataTables.min.css"/>


<script type="text/javascript">

url = "${pageContext.request.contextPath}/resource/json/saleDatabase${sellerMallid}.json";
$(function(){
  $.ajax({
    url: url
    })
    .fail(function() {
        	alert("테이블을 생성하는 중입니다. 새로고침을 해주세요")
     })
    .done(function(d){
        var table = $("#data_list").DataTable({
         	deferRender : true,
             buttons: [
                 {
                     text: '정렬',
                     action: function ( e, dt, node, config ) {
                     }
                 }
             ],
             
	        responsive : true,
	        data: d,
	        dataSrc: "",
	        columns : [
	          { "data" : "id" },
	          { "data" : "users_id" },
	          { "data" : "name" },
	          { "data" : "kind" },
	          { "data" : "order_count" },
	          { "data" : "price" },
	          { "data" : "result" },
	          { "data" : "date" },
	          { "data" : "product_id" },
	        ],
	        columnDefs: [
	        	{

        		   "targets": -1,
        		   "render": function(data, type, row){
        		    return "<button class=\"btn btn-primary\" onclick=\"location.href='shoppingCartProductDetail.shop?product_id="+data+"'\">제품 페이지</button>";
        			},
        		   "orderable": false
        		  },
        		  
	        ],
	    	"language": {
	            "decimal":        "",
	            "emptyTable":     "표에서 사용할 수있는 데이터가 없습니다.",
	            "info":           "총 _TOTAL_명   _START_에서 _END_까지 표시",
	            "infoEmpty":      "0 개 항목 중 0 ~ 0 개 표시",
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
		 
		        // Total over all pages
		        total = api
		            .column(5)
		            .data()
		            .reduce((a, b) => intVal(a) + intVal(b), 0)
		            * 
		            api
		            .column(4)
		            .data()
		            .reduce((a, b) => intVal(a) + intVal(b), 0)
		            ;
		 
		        // Total over this page
		        pageTotal = api 
		            .column(5, { page: 'current' })
		            .data()
		            .reduce((a, b) => intVal(a) + intVal(b), 0)
		            *
		            api 
		            .column(4, { page: 'current' })
		            .data()
		            .reduce((a, b) => intVal(a) + intVal(b), 0)
		            ;
		 
		        // Update footer
		        api.column(6).footer().innerHTML =  pageTotal + '원 ( ' + total + '원 총합)';
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
</head>
<body>
	<c:set var="totalmoney" value="0"></c:set>
<div class="container-fluid">
		<div class="card shadow mb-4">
			<div class="card-body">
<table border="0" cellspacing="5" cellpadding="5">
        <tbody><tr>
            <td>최소 날짜:</td>
            <td><input type="text" id="min" name="min"></td>
        </tr>
        <tr>
            <td>최대 날짜:</td>
            <td><input type="text" id="max" name="max"></td>
        </tr>
    </tbody></table>
    <table id="data_list" class="display nowrap" style="width:100%">
			<thead>
				<tr>
					<th>주문번호</th>
					<th>유저 아이디</th>
					<th>제품 이름</th>
					<th>제품 종류</th>
					<th>주문 개수</th>
					<th>가격</th>
					<th>주문 상태</th>
					<th>시간</th>
					<th>상세보기</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
            <tr>
                <th colspan="8" style="text-align:right">합계:</th>
                <th ></th>
            </tr>
      		</tfoot>
		</table>
		</div>
	</div>
</div>

</body>
</html>