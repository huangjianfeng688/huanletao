//控制层、
app.controller('myWantController', function ($scope,$location,$route,$controller,personalService) {
    //继承数据控制器。
    $scope.$route = $route;
    $controller('personalController', {$scope: $scope});//继承

    //取消想要。
    $scope.removeWant = function (goodid) {
        personalService.removeWant(goodid).then(function (value) {
            $scope.findMyWants();
        })
    }


})
