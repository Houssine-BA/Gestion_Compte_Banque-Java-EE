var app = angular.module('MyApp', []);

app.controller("MyController", function($scope, $http) {
	
	$scope.compte = null;
	$scope.codeCompte = "";
	$scope.pageOperations = [];
	$scope.pageCounter = 0;
	$scope.size= 4;
	$scope.pages = [];
	$scope.operation = {"type": "versement", "montant": 0, 'codeEmp': 1};
	$scope.errorMessage = null;

	$scope.search = function() {
		var url = "http://localhost:8080/comptes/"+$scope.codeCompte + "?page="+$scope.pageCounter+"&size="+$scope.size;
		$http.get(url)
		.then(function mySuccess(response) {
			$scope.compte = response.data;
	    }, function error(response) {
			$scope.compte = null;
			$scope.errorMessage = response.data.message;
		});
		$scope.chargeOperation();
	};
	
	$scope.gotoPage = function (p) {
		$scope.pageCounter = p;
		$scope.chargeOperation();
	}
	
	$scope.saveOperation = function(){
		var url = "http://localhost:8080/comptes/"+$scope.codeCompte + "?page="+$scope.pageCounter+"&size="+$scope.size;
		$http({
			method: 'PUT',
			url: $scope.operation.type,
			data: "code=" + $scope.codeCompte + "&montant=" + $scope.operation.montant + "&codeEmp=" + $scope.operation.codeEmp,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).then(function(response){
			console.log(response);
			$scope.chargeOperation();
		}, function error(response){
			$scope.errorMessage = response.data.message;
		});

	}

	$scope.chargeOperation = function(){
		var url = "http://localhost:8080/operations/"+$scope.codeCompte + "?page="+$scope.pageCounter+"&size="+$scope.size;
		$http({
			method: 'GET',
			url: url,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).then(function(response){
			console.log(response);
			$scope.pageOperations = response.data;
			$scope.pages = new Array(response.data.totalPage);
		}, function error(response){
			console.log(response);
		});
	}
});

