 //控制层 
app.controller('orderController' ,function($scope,$controller,orderService){
	
	$controller('baseController',{$scope:$scope});//继承

	//查询所有订单信息，
	$scope.findAll = function () {
		orderService.findAll().then(function (response) {
			$scope.list = response.data;
        })
    }

    //订单状态显示,  0表示正在交易，1表示交易成功，2表示交易失败
    $scope.status = ['正在交易','交易完成','订单失败'];

	//管理员删除订单数据，
	$scope.deleteOrder = function () {
		orderService.deleteOrder($scope.selectIds).then(function (value) {
			messge(value.data.message);
			$scope.findAll();
		})
    }


});	
