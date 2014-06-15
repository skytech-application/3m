$(document).ready(function() {
	findAll(findAllCallbackSuccess, findAllCallbackError);
});

function findAllCallbackSuccess(data){
	var table_obj = $('table');
    $.each(data, function(index, item){
         var table_row = $('<tr>', {id: item.id});
         var table_cell_id = $('<td>', {html: '<b>' + item.id + '</b>'});
         var table_cell_username = $('<td>', {html: item.username});
         var table_cell_email = $('<td>', {html: item.email});
         var table_cell_enabled = $('<td>', {html: item.enabled ? '<span class="glyphicon glyphicon-check"></span>' : '<span class="glyphicon glyphicon-unchecked"></span>'});
         table_row.append(table_cell_id);
         table_row.append(table_cell_username);
         table_row.append(table_cell_email);
         table_row.append(table_cell_enabled);
         table_obj.append(table_row);
    })
}

function findAllCallbackError(error){
	if(error.responseText){
		var errorText = JSON.parse(error.responseText);
		$('#subscribeErrorPanel').html(errorText.message);
		$('#subscribeErrorPanel').show();
	}
}