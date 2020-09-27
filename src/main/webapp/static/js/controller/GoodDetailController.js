//控制层
app.controller('GoodDetailController' ,function($scope,$location,$controller,goodService,personalService,gooddetailService){

    $controller('goodController',{$scope:$scope});//继承

    //用户查看商品信息。,同时显示商品的评论信息。
    $scope.findDetail = function () {
        //这一段代码是从url 中取出商品的id 然后进行查询商品信息。
        var url= window.location.href;
        var index = url.substring(url.lastIndexOf('=') + 1);

        goodService.findGoodDescById(index).then(function (response) {
            $scope.GoodDesc = response.data;
        });
        gooddetailService.showComment(index).then(function (value) {
            $scope.commentList = value.data;
        })
    }

    $scope.loginuser = $scope.getSession();

    //用户添加我想要，
    $scope.addMyWant = function (goodid) {
        gooddetailService.addMyWant(goodid,$scope.loginuser ).then(function (value) {
           alert(value.data.message);
        })
    }

    //用户添加收藏。
    $scope.addMyCollect = function (goodid) {
        gooddetailService.addMyCollect(goodid,$scope.loginuser ).then(function (value) {
            alert(value.data.message);
        })
    }

    //定义一个初始化一个评论对象。
    $scope.comment = {goodid:'',context:''};

    //用户发表评论。
    $scope.reportComment = function (goodid) {
        $scope.comment.goodid=goodid;
        gooddetailService.reportComment($scope.comment,$scope.getSession()).then(function (value) {
            gooddetailService.showComment(goodid).then(function (value) {
                $scope.commentList = value.data;
            })
            $scope.comment.context='';
        })

    };

    //定义用户权限，
    $scope.permission={show:$scope.isLogin()};

});