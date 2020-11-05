 //控制层 
app.controller('menuController' ,function($scope,$controller,menuService){
	
	$controller('baseController',{$scope:$scope});//继承

	//查询所有分类信息。
	$scope.findAll = function () {
		menuService.findAll().then(function (response) {
			$scope.menuList = response.data.data;

        })
    }

    $scope.type = ['','页签','新窗口'];

    $scope.updateMenu = function (entity) {
		$scope.entity = entity ;
    }

});	
