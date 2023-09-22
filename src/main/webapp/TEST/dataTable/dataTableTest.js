/**
 * 
 */


$(document).ready( function(){
	$("#data_list").DataTable({
	    ajax: { url: "data.json", dataSrc: '' },
	    columns: [
	        { data: "id" },
	        { data: "name" },
	        { data: "location" }
	    ]
	});
});