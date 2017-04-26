/**
 * Created by fertigt on 14/04/16.
 */
var app = angular.module('sampleApp.controllers', []);

app.controller('SampleListCtrl', ['$scope', 'SamplesFactory', 'SampleFactory', '$location',
    function ($scope, SamplesFactory, SampleFactory, $location) {

        /* callback for ng-click 'editSample': */
        $scope.editSample = function (sampleId) {
            $location.path('/sample-detail/' + sampleId);
        };

        /* callback for ng-click 'deleteSample': */
        $scope.deleteSample = function (sampleId) {
            SampleFactory.delete({ id: sampleId });
            $scope.samples = SamplesFactory.query();
        };

        /* callback for ng-click 'createSample': */
        $scope.createNewSample = function () {
            $location.path('/sample-creation');
        };

        $scope.samples = SamplesFactory.query();
    }]);

app.controller('SampleDetailCtrl', ['$scope', '$routeParams', 'SampleFactory', '$location',
    function ($scope, $routeParams, SampleFactory, $location) {

        /* callback for ng-click 'updateSample': */
        $scope.updateSample = function () {
            SampleFactory.update($scope.sample);
            $location.path('/sample-list');
        };

        /* callback for ng-click 'cancel': */
        $scope.cancel = function () {
            $location.path('/sample-list');
        };

        $scope.sample = SampleFactory.show({id: $routeParams.id});
    }]);

app.controller('SampleCreationCtrl', ['$scope', 'SamplesFactory', '$location',
    function ($scope, SamplesFactory, $location) {

        /* callback for ng-click 'createNewSample': */
        $scope.createNewSample = function () {
            SamplesFactory.create($scope.sample);
            $location.path('/sample-list');
        }
    }]);
