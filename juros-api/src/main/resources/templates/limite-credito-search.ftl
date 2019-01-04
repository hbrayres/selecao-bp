<div class="form-horizontal">
    <h3>Criar um novo Limite de Crédito</h3>
    <div class="form-group">
        <div class="col-md-offset-2 col-sm-2">
            <a id="Create" name="Create" class="btn btn-primary" href="#/LimiteCreditos/new"><span class="glyphicon glyphicon-plus-sign"></span> Novo</a>
        </div>
    </div>
</div>
<hr/>
<div>
    <h3>Limites de Crédito</h3>
    
    <form id="LimiteCreditoSearch" class="form-horizontal">
        
	    <div class="form-group">
	        <label for="limiteCredito" class="col-sm-2 control-label">Limite Crédito</label>
	        <div class="col-sm-10">
	            <input id="limiteCredito" name="limiteCredito" class="form-control" type="number" step="0.01" min="0" ng-model="search.limiteCredito" placeholder="Valor do Limite de Crédito"></input>
	        </div>
	    </div>
	
	    <div class="form-group">
	        <label for="nomeCliente" class="col-sm-2 control-label">Nome Cliente</label>
	        <div class="col-sm-10">
	            <input id="nomeCliente" name="nomeCliente" class="form-control" type="text" ng-model="search.nomeCliente" placeholder="Nome Cliente"></input>
	        </div>
	    </div>
	
	    <div class="form-group">
	        <label for="risco" class="col-sm-2 control-label">Risco</label>
	        <div class="col-sm-10">
	            <select id="risco" name="risco" class="form-control" ng-model="search.risco" ng-options="r as r for r in riscoList">
	                <option value="">--</option>
	            </select>
	        </div>
	    </div>

        <div class="form-group">
            <div class="col-md-offset-2 col-sm-10">
                <a id="Search" name="Search" class="btn btn-primary" ng-click="performSearch()"><span class="glyphicon glyphicon-search"></span> Search</a>
            </div>
        </div>
    </form>
</div>

<div id="search-results">
    <div class="table-responsive">
        <table class="table table-responsive table-bordered table-striped clearfix">
            <thead>
                <tr>
                    <th>Limite Credito</th>
                    <th>Nome Cliente</th>
                    <th>Risco</th>
                    <th>Taxa de Juros</th>
                </tr>
            </thead>
            <tbody id="search-results-body">
                <tr ng-repeat="result in filteredResults | startFrom:currentPage*pageSize | limitTo:pageSize">
                    <td><a href="#/LimiteCreditos/edit/{{result.id}}">{{result.limiteCredito}}</a></td>
                    <td><a href="#/LimiteCreditos/edit/{{result.id}}">{{result.nomeCliente}}</a></td>
                    <td><a href="#/LimiteCreditos/edit/{{result.id}}">{{result.risco}}</a></td>
                    <td><a href="#/LimiteCreditos/edit/{{result.id}}">{{result.juros}}</a></td>
                </tr>
            </tbody>
        </table>
    </div>

    <ul class="pagination pagination-centered">
        <li ng-class="{disabled:currentPage == 0}">
            <a id="prev" href ng-click="previous()">Anterior</a>
        </li>
        <li ng-repeat="n in pageRange" ng-class="{active:currentPage == n}" ng-click="setPage(n)">
            <a href ng-bind="n + 1">1</a>
        </li>
        <li ng-class="{disabled: currentPage == (numberOfPages() - 1)}">
            <a id="next" href ng-click="next()">Próximo</a>
        </li>
    </ul>

</div>