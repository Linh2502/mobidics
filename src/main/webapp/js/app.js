/**
 * Created by fertigt on 14/04/16.
 */
angular.module('sampleApp', [
        'ngRoute',
        'sampleApp.services',
        'sampleApp.controllers'
    ])
    .config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider.when('/sample-list', {templateUrl: 'views/sample-list.html', controller: 'SampleListCtrl'});
            $routeProvider.when('/sample-detail/:id', {templateUrl: 'views/sample-detail.html', controller: 'SampleDetailCtrl'});
            $routeProvider.when('/sample-creation', {templateUrl: 'views/sample-creation.html', controller: 'SampleCreationCtrl'});
            $routeProvider.otherwise({redirectTo: '/sample-list'});
    }]);
