angular.module('juros-front').factory('LimiteCreditoResource', function($resource){
    var resource = $resource('../api/limites-creditos/:LimiteCreditoId',{LimiteCreditoId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});