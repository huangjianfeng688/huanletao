 //控制层 
app.controller('goodController' ,function($scope,$location,$controller,goodService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //查询所有商品数据。
	$scope.findAll = function () {
		goodService.findAll().then(function (response) {
			$scope.list=response.data;
        })
    }

    //商品状态，0表示为未审核,1表示审核通过，2表示审核未通过
	$scope.staus = ['未审核','审核通过','审核不通过'];
	//商品详情的状态,是否是卖出，0表示为未卖出，1表示已出售，2表示正在交易中
	$scope.descStatus = ['未卖出','已出售','交易中'];

	//获取商品详细信息，
	$scope.detail = function (id) {
		goodService.findGoodDescById(id).then(function (response) {
			$scope.GoodDesc = response.data;
        $("#exampleModal").modal("show");
        })
    }

    //审核商品信息，
	$scope.check = function (goodid,status) {
		goodService.check(goodid,status).then(function (response) {
            $("#exampleModal").modal("hide");
            location.reload();
        })
    }


});	
