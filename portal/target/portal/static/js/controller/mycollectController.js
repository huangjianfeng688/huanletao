//控制层、
app.controller('myCollectController', function ($scope,$location,$route,$controller,personalService) {
    //继承数据控制器。
    $scope.$route = $route;
    $controller('personalController', {$scope: $scope});//继承

    //显示商品详细信息。
    $scope.gooddetail = function (goodid) {
        window.location.href='/goods_detail.html?goodid='+goodid;
    }

    //移除我的收藏。
    $scope.removeCollect = function (goodid) {
        personalService.removeCollect(goodid).then(function (value) {
            $scope.findMyCollect();
            responseInfo(value)
        })
    }
})
