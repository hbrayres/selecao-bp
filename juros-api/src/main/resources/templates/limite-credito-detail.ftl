<header ng-switch on="$location.path().indexOf('/LimiteCreditos/new') > -1">
    <h3 ng-switch-when="true">Novo Limite de Crédito</h3>
    <h3 ng-switch-when="false">Visualizar/Editar Limite de Crédito</h3>
</header>
<form id="LimiteCreditoForm" name="LimiteCreditoForm" class="form-horizontal" role="form">
    
	<div class="form-group" ng-class="{'has-error': LimiteCreditoForm.limiteCredito.$invalid}">
        <label for="limiteCredito" class="col-sm-2 control-label">Limite Credito</label>
        <div id="limiteCreditoControls" class="col-sm-10">
            <input id="limiteCredito" name="limiteCredito" type="number" min="0" step="0.01" required class="form-control" ng-model="limiteCredito.limiteCredito" placeholder="Valor do Limite de crédito"></input>
            <span class="help-block error" ng-show="LimiteCreditoForm.limiteCredito.$error.required">Obrigatório</span> 
        </div>
    </div>

    <div class="form-group" ng-class="{'has-error': LimiteCreditoForm.nomeCliente.$invalid}">
        <label for="nomeCliente" class="col-sm-2 control-label">Nome do Cliente</label>
        <div id="nomeClienteControls" class="col-sm-10">
            <input id="nomeCliente" name="nomeCliente" type="text" required ng-maxlength="100" class="form-control" ng-model="limiteCredito.nomeCliente" placeholder="Nome Cliente"></input>
            <span class="help-block error" ng-show="LimiteCreditoForm.nomeCliente.$error.required">Obrigatório</span> 
            <span class="help-block error" ng-show="LimiteCreditoForm.nomeCliente.$error.maxlength">Tamanho máximo é 100 caracteres</span>
        </div>
    </div>

    <div class="form-group" ng-class="{'has-error': LimiteCreditoForm.risco.$invalid}">
        <label for="risco" class="col-sm-2 control-label">Risco</label>
        <div id="riscoControls" class="col-sm-10">
        <select id="risco" name="risco" class="form-control" ng-model="limiteCredito.risco" ng-options="r for r in riscoList" required >
            <option value="">Selecione</option>
        </select>
        <span class="help-block error" ng-show="LimiteCreditoForm.risco.$error.required">Obrigatório</span> 
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button id="saveLimiteCredito" name="saveLimiteCredito" class="btn btn-primary" ng-disabled="isClean() || LimiteCreditoForm.$invalid" ng-click="save()"><span class="glyphicon glyphicon-ok-sign"></span> Salvar</button>
            <button id="cancel" name="cancel" class="btn btn-default" ng-click="cancel()"><span class="glyphicon glyphicon-remove-sign"></span> Cancelar</button>
            <button id="deleteLimiteCredito" name="deleteLimiteCredito" class="btn btn-danger" ng-show="limiteCredito.id" ng-click="remove()"><span class="glyphicon glyphicon-trash"></span> Remover</button>
        </div>
    </div>
</form>