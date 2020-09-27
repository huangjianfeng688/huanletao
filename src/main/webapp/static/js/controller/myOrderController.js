//控制层、
app.controller('myOrderController', function ($scope, $route,$controller,personalService) {
    //继承数据控制器。
    $scope.$route = $route;
    $controller('personalController',{$scope:$scope});//继承

    //订单状态，0表示为未审核,1表示审核通过，2表示审核未通过
    $scope.staus = ['正在交易','交易完成','交易失败'];

    //修改订单状态。
    $scope.updateOrderStatus = function (orderid,status) {
        console.log(orderid,status)
        personalService.updateOrderStatus(orderid,status).then(function (value) {
            $scope.findMyOrder();
        })
    }



})