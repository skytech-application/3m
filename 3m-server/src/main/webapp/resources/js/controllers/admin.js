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
         var table_cell_email = $('<td>', {html: '<a href="mailto:'+item.email+'">' + item.email+ '</a>'});
         var table_cell_role = $('<td>', {html: item.role.name});
         var table_cell_enabled = $('<td>', {html: item.enabled ? '<span class="glyphicon glyphicon-check"></span>' : '<span class="glyphicon glyphicon-unchecked"></span>'});
         if(nombre_jour < 7){
        	 var table_cell_subscribe_date = $('<td>', {html: '<span class="label label-warning">Nouveau!</span>'});
         }else{
        	 var table_cell_subscribe_date = $('<td>', {html: nombre_jour + ' jour(s)'});
         }
         
         var tooltipFollowers = '&quot;<ul>';
         for (follower in item.followers) {
        	  tooltipFollowers+= '<li>'+item.followers[follower].username+'</li>';
    	}
         tooltipFollowers +='</ul>&quot;';
         
         var tooltipFollowed = '&quot;<ul>';
         for (followeded in item.followed) {
        	 tooltipFollowed+= '<li>'+item.followed[followeded].username+'</li>';
    	}
         tooltipFollowed +='</ul>&quot;';
         
         var table_cell_xp = $('<td>', {html: '<span class="badge alert-info">' + item.xp + '&nbsp;&nbsp;<span class="glyphicon glyphicon-flash"></span></span>'});
         var table_cell_followers = $('<td>', {html : '<button type="button" class="btn btn-default btn-sm" '+ (item.followers.length>0 ? 'onclick="bootbox.alert('+tooltipFollowers+')"' : '') +'>' + item.followers.length + '&nbsp;&nbsp;<span class="glyphicon glyphicon-link"></span></button>'})
         var table_cell_followed = $('<td>', {html : '<button type="button" class="btn btn-default btn-sm" '+ (item.followed.length>0 ? 'onclick="bootbox.alert('+tooltipFollowed+')"' : '') +'>' + item.followed.length + '&nbsp;&nbsp;<span class="glyphicon glyphicon-link"></span></button>'})
    	 var table_cell_actions = $('<td>', {html: '<button type="button" onclick="deleteUser('+item.id+')" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-remove"></span>&nbsp;</button>'});
         
         table_row.append(table_cell_id);
         table_row.append(table_cell_username);
         table_row.append(table_cell_email);
         table_row.append(table_cell_role);
         table_row.append(table_cell_enabled);
         table_row.append(table_cell_subscribe_date);
         table_row.append(table_cell_xp);
         table_row.append(table_cell_followers);
         table_row.append(table_cell_followed);
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