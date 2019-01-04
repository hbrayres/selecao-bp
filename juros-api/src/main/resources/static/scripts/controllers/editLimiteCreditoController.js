

angular.module('juros-front').controller('EditLimiteCreditoController', function($scope, $routeParams, $location, flash, LimiteCreditoResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.limiteCredito = new LimiteCreditoResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'O Limite de crédito não foi encontrado.'});
            $location.path("/LimiteCreditos");
        };
        LimiteCreditoResource.get({LimiteCreditoId:$routeParams.LimiteCreditoId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.limiteCredito);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'Limite de crédito atualizado com sucesso.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Ocorreu algum erro na requisição.'}, true);
            }
        };
        $scope.limiteCredito.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/LimiteCreditos");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'Limite de crédito removido com sucesso'});
            $location.path("/LimiteCreditos");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Ocorreu algum erro na requisição.'}, true);
            }
        }; 
        $scope.limiteCredito.$remove(successCallback, errorCallback);
    };
    
    $scope.riscoList = [
        "A",  
        "B",  
        "C"  
    ];
    
    $scope.get();
});