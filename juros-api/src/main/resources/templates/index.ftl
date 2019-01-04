<!DOCTYPE html>
<html lang="en" ng-app="juros-front">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Juros-front</title>
    <link href="styles/bootstrap.css" rel="stylesheet" media="screen">
    <link href="styles/bootstrap-theme.css" rel="stylesheet" media="screen">
    <link href="styles/main.css" rel="stylesheet" media="screen">
</head>
<body>
    <div id="wrap">
    	
    	<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="offcanvas">
                      <span class="sr-only">Toggle navigation</span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                    </button>
				    <a class="navbar-brand" href="#">Juros-front</a>
			    </div>
			</div>
    	</div>
        
        <div class="container">
            <div class="row row-offcanvas row-offcanvas-left">
                <!-- sidebar -->
                <div class="col-xs-6 col-sm-3 well sidebar-offcanvas">
                    <nav class="sidebar-nav" ng-controller="NavController" role="navigation">
                        <div id="sidebar-entries" class="list-group">
                        	<a class="list-group-item" ng-class="{active: matchesRoute('LimiteCreditos')}" href="#/LimiteCreditos" data-toggle="offcanvas">Limite de Creditos</a>
                        </div>
                    </nav>
                </div>
                <!-- main area-->
                <div class="col-sm-offset-1 col-xs-12 col-sm-8 well mainarea">
                    <div ng-controller="FlashController" class="alert alert-dismissible" ng-class="'alert-' + flash.getMessage().cssClass" role="alert" ng-show="showAlert">
                        <button type="button" class="close" ng-click="hideAlert()" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        {{flash.getMessage().text}}
                    </div>
                    <div id="main" ng-view>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div id="footer">
    </div>
    
    <script src="scripts/vendor/modernizr-2.8.3.min.js"></script>
    <script src="scripts/vendor/jquery-2.1.1.js"></script>
    <script src="scripts/vendor/bootstrap.js"></script>
    <script src="scripts/vendor/angular.js"></script>
    <script src="scripts/vendor/angular-route.js"></script>
    <script src="scripts/vendor/angular-resource.js"></script>
    <script src="scripts/app.js"></script>
    <script src="scripts/offcanvas.js"></script>
    <script src="scripts/directives/datepicker.js"></script>
    <script src="scripts/directives/timepicker.js"></script>
    <script src="scripts/directives/datetimepicker.js"></script>
    <script src="scripts/filters/startFromFilter.js"></script>
    <script src="scripts/filters/genericSearchFilter.js"></script>
    <script src="scripts/services/flash.js"></script>
    <script src="scripts/services/locationParser.js"></script>
    <script src="scripts/controllers/flashController.js"></script>
    <script src="scripts/services/LimiteCreditoFactory.js"></script>
    <script src="scripts/controllers/newLimiteCreditoController.js"></script>
    <script src="scripts/controllers/searchLimiteCreditoController.js"></script>
    <script src="scripts/controllers/editLimiteCreditoController.js"></script>
</body>
</html>