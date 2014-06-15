var mangaNetworkApi = new $.RestClient('/3m-server/api/');
mangaNetworkApi.add('users');

function create(user, callbackSuccess, callbackFail) {
	mangaNetworkApi.users.create(user).fail(function(data){
		callbackFail(data);
	}).done(function(data){
		callbackSuccess(data);
	});
}

function find(id, callbackSuccess, callbackFail){
	mangaNetworkApi.users.read(id).fail(function(data){
		callbackFail(data);
	}).done(function(data){
		callbackSuccess(data);
	});
}

function findAll(callbackSuccess, callbackFail){
	mangaNetworkApi.users.read().fail(function(data){
		callbackFail(data);
	}).done(function(data){
		callbackSuccess(data);
	});
}