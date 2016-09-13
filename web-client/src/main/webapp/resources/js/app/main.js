(function () {
    var app = angular.module('pokerApp', ['ngResource', 'ui.router']);

    app.config(function($resourceProvider, $stateProvider, $urlRouterProvider, ROOT_PATH) {
        $resourceProvider.defaults.stripTrailingSlashes = false;

        $urlRouterProvider.otherwise("/");

        $stateProvider
            .state('root', {
                url : "/",
                templateUrl: ROOT_PATH
        })

    });

    app.constant('ROOT_PATH', ['/poker']);

    app.controller('PokerCtrl', function($state) {
        var main = this;
    });

    app.init = function() {
        //alert("Hello");
    };

    app.init();

})();


