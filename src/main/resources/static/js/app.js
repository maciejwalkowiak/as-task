var app = angular.module('as-recruitment', []);

app.service('CharGrouper', function ($http) {
    this.group = function (input) {
        return $http.get('/group?input=' + input);
    };
});

app.controller('homeController', function ($scope, CharGrouper) {
    $scope.input = 'abzuaaissna';

    $scope.submit = function () {
        if ($scope.input !== '') {
            CharGrouper.group($scope.input).success(function (data) {
                $scope.result = data;
            });
        }
    }
});
