//控制层、
app.controller('myGoodController', function ($scope, $route,$controller,personalService) {
    //继承数据控制器。
    $scope.$route = $route;
    $controller('personalController',{$scope:$scope});//继承

    //商品状态，0表示为未审核,1表示审核通过，2表示审核未通过
    $scope.staus = ['未审核','审核通过','审核不通过'];

    //定义一个订单对象数据。
    $scope.orderdata = {goodid:'',buyerid:'',sellerid:$scope.entity.userid};



    //删除商品信息。删除成功进行回显。
    $scope.deleteGood = function (goodid) {
        personalService.deleteGood(goodid).then(function (value) {
            $scope.findMyGoods();
        })
    }

    //根据商品id，查询想要该商品的用户。同时记录当前选中的商品id。作为订单表中的id。
    $scope.showwant = function (goodid) {
        $scope.orderdata.goodid=goodid;
        personalService.findBuyersByGoodId(goodid).then(function (value) {
            $scope.buyers = value.data;
            $("#myModal").modal("show");
        })
    };

    //当用户选中一个用户作为交易对象时，就把选中的用户id记录为订单表中的买家id。
    //初始化数组。
    $scope.buyerids=[];
    $scope.selectBuyer = function ($event,buyerid) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.buyerids.push( buyerid);
        }else{
            var idx = $scope.buyerids.indexOf(buyerid);
            $scope.buyerids.splice(idx, 1);//删除
        }
    };

    //提交订单数据到后台。
    $scope.subimit = function () {
        if ($scope.buyerids.length == 0){
            alert("必须选中一个买家才能生成订单")
        }
        if ($scope.buyerids.length > 1){
            alert("只能选中一个买家生成订单数据")
        }
        if ($scope.buyerids.length == 1) {
            $("#myModal").modal("hide");
            $scope.orderdata.buyerid= $scope.buyerids[0];
            personalService.generateOrder($scope.orderdata).then(function (value) {
                alert("生成订单数据成功。");
            })
        }
    }


})