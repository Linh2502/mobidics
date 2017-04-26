/**
 * Created by fertigt on 14/04/16.
 */
var baseUrl = 'http://localhost\\:8080/template/org.mobidics.api';

var services = angular.module('sampleApp.services', ['ngResource']);

services.factory('SamplesFactory', function ($resource) {
    return $resource(baseUrl + '/samples', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    });
});

services.factory('SampleFactory', function ($resource) {
    return $resource(baseUrl + '/samples/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@id'}},
        delete: {method: 'DELETE', params: {id: '@id'}}
    })
});
