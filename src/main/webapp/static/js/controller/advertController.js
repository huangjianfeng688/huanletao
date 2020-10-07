 //控制层 
app.controller('advertController' ,function($scope,$controller,advertService){
	
	$controller('baseController',{$scope:$scope});//继承
	
  	//查询广告信息。
	$scope.findAll = function () {
		advertService.findAll().then(function (value) {
			$scope.list = value.data;
		})
    }

	//显示状态，
	$scope.advertstatus = ['禁用','启用'];

	//显示下拉选项
    $scope.selectOption = {'禁用':0,'启用':1};

	//更新修改界面。
    $scope.updateUI = function (advert) {
        $scope.entity = advert;
        $("#advertModal").modal("show");
    }

    //上传广告图。并进行回显。
    $scope.upload = function () {
        advertService.upload().then(function (value) {
           $scope.entity.picaddress = value.data.msg;
        })
    }

    //将添加或者修改的广告数据保存到数据库中。
    $scope.save = function () {
        advertService.save($scope.entity).then(function (value) {
            //关闭模态框。回显数据，
            $("#advertModal").modal("hide");
            messge("操作成功");
            //回显数据。
            $scope.findAll();
        })
    }

    //删除广告功能。
    $scope.deleteAdvert = function () {
        advertService.deleAdvert($scope.selectIds).then(function (value) {
            //回显数据。
            messge("删除成功");
            $scope.findAll();

        })
    }

});	
