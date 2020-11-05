//个人中心的控制层
app.controller("personalController",function ($scope,$controller,personalService) {
    //继承
    $controller('categoryController',{$scope:$scope});


    //请求登录用户的信息。
    $scope.findUserInfo = function () {
        //取出登录用户名。
        $scope.loginuser= $scope.getSession();
        personalService.findByUserCode($scope.loginuser).then(function (value) {
            $scope.entity = value.data;
        })
    };

    //请求数据我的商品数据信息。
    $scope.findMyGoods = function () {
        personalService.findMyGoods($scope.loginuser).then(function (value) {
            $scope.myGoods = value.data;
        })
    };

    //查询到所有的分类信息，
    $scope.getAllCategorys = function () {
        $scope.findAll();
    };

    //请求我的订单数据信息。
    $scope.findMyOrder = function () {
        personalService.findMyOrder($scope.loginuser).then(function (value) {
            $scope.myOrders = value.data;
        })
    };

    //查询我的收藏的商品。
    $scope.findMyCollect = function () {
        personalService.findMyCollect($scope.loginuser).then(function (value) {
            $scope.myCollects = value.data;
        })
    }

    //查询想要的商品信息。
    $scope.findMyWants = function () {
        personalService.findMyWants($scope.loginuser).then(function (value) {
            $scope.myWants = value.data;
        })
    }

    //个人中心。退出登录的方法。。。
    $scope.tuichu = function () {
        $scope.logout();
        window.location.href='index.html';
    }



})