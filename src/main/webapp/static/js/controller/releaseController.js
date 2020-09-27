//控制层、
app.controller('releaseController', function ($scope, $route,$controller,$location,personalService) {
    //继承数据控制器。
    $scope.$route = $route;
    $controller('personalController',{$scope:$scope});//继承

    $scope.loginuser= $scope.getSession();
    //将数据发送到后台。
    $scope.release = function () {
        personalService.addMyGood($scope.GoodDesc,$scope.loginuser).then(function (value) {
            alert(value.data.message);
        })
    };

    $scope.GoodDesc={pictures:''};
    //给商品添加图片。
        $scope.addPic = function () {
        personalService.upload("good").then(function (value) {
            $scope.GoodDesc.pictures = value.data.msg;

        })
    }

})