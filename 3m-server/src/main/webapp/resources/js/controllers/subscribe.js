$(document).ready(function() {
	$('#subscribeForm').submit(function(e) {
		$('#subscribeInfoPanel').hide();
		$('#subscribeErrorPanel').hide();
		e.preventDefault();
		var user = {
				email : $('#subscribeEmail').val(),
				username : $('#subscribeUsername').val(),
				password : $('#subscribePassword').val()
		}
        create(user, createCallbackSuccess, createCallbackError);
      });
});

function createCallbackSuccess(data){
	if(data.id){

		$('#subscribeInfoPanel').html(data.controllerResponse);
		$('#subscribeInfoPanel').show();
	}
}

function createCallbackError(error){
	if(error.responseText){
		var errorText = JSON.parse(error.responseText);
		$('#subscribeErrorPanel').html(errorText.message);
		$('#subscribeErrorPanel').show();
	}
}