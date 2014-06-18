function deleteUser(id) {
	destroy(id,deleteCallbackSuccess, deleteCallbackError);
}

$(document).ready(function() {
	$('#usersListInfoPanel').hide();
	$('#usersListErrorPanel').hide();
	findAll(findAllCallbackSuccess, findAllCallbackError);
});

function daydiff(first, second) {
    return (second-first)/(1000*60*60*24);
}

function findAllCallbackSuccess(data){
	var table_obj = $('table');
	$('table > tbody > tr').not(function(){if ($(this).has('th').length){return true}}).remove();
    $.each(data, function(index, item){    	
    	 var nombre_jour = parseInt(daydiff(new Date(item.subscribeDate), new Date()));
         var table_row = $('<tr>', {id: item.id});
         var table_cell_id = $('<td>', {html: '<b>' + item.id + '</b>'});
         var table_cell_username = $('<td>', {html: item.username});
         var table_cell_email = $('<td>', {html: item.email});
         var table_cell_enabled = $('<td>', {html: item.enabled ? '<span class="glyphicon glyphicon-check"></span>' : '<span class="glyphicon glyphicon-unchecked"></span>'});
         if(nombre_jour < 7){
        	 var table_cell_subscribe_date = $('<td>', {html: '<span class="label label-warning">Nouveau!</span>'});
         }else{
        	 var table_cell_subscribe_date = $('<td>', {html: nombre_jour + ' jour(s)'});
         }
         
         var table_cell_xp = $('<td>', {html: '<span class="badge">' + item.xp + '&nbsp;&nbsp;<span class="glyphicon glyphicon-flash"></span></span>'});
         var table_cell_followers = $('<td>', {html : '<span class="badge">0&nbsp;&nbsp;<span class="glyphicon glyphicon-link"></span></span>'})
    	 var table_cell_actions = $('<td>', {html: '<button type="button" onclick="deleteUser('+item.id+')" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-remove"></span></button>'});
         
         table_row.append(table_cell_id);
         table_row.append(table_cell_username);
         table_row.append(table_cell_email);
         table_row.append(table_cell_enabled);
         table_row.append(table_cell_subscribe_date);
         table_row.append(table_cell_xp);
         table_row.append(table_cell_followers);
         table_row.append(table_cell_actions);
         table_obj.append(table_row);
    })
}

function findAllCallbackError(error){
	$('#usersListInfoPanel').hide();
	if(error.responseText){
		var errorText = JSON.parse(error.responseText);
		$('#usersListErrorPanel').html(errorText.message);
		$('#usersListErrorPanel').show();
		
	}
}

function deleteCallbackSuccess(data){
	$('#usersListErrorPanel').hide();
	findAll(findAllCallbackSuccess, findAllCallbackError);
	$('#usersListInfoPanel').html(data.controllerResponse);
	$('#usersListInfoPanel').show();
}

function deleteCallbackError(error){
	$('#usersListInfoPanel').hide();
	if(error.responseText){
		var errorText = JSON.parse(error.responseText);
		$('#usersListErrorPanel').html(errorText.message);
		$('#usersListErrorPanel').show();
	}
}