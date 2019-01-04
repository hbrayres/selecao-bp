
angular.module('juros-front').controller('NewLimiteCreditoController', function ($scope, $location, locationParser, flash, LimiteCreditoResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.limiteCredito = $scope.limiteCredito || {};
    
    $scope.riscoList = [
        "A",
        "B",
        "C"
    ];
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders) {
            $location.path("/LimiteCreditos");
            flash.setMessage({'type':'success','text':'Limite de Crédito criado com sucesso.'});
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Ocorreu algum erro na requisição.'}, true);
            }
        };
        LimiteCreditoResource.save($scope.limiteCredito, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/LimiteCreditos");
    };
});