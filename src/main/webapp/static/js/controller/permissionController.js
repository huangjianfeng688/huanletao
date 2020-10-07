 //控制层 
app.controller('permissionController' ,function($scope,$controller,permissionService){
	
	$controller('baseController',{$scope:$scope});//继承

	//查询所有分类信息。
	$scope.findAll = function () {
		permissionService.findAll().then(function (response) {
			$scope.roleList = response.data.data;

        })
    }


    $scope.updatePermission = function (entity) {
		$scope.entity = entity ;
        $('.selectpicker').selectpicker('val', 'Mustard');
    }

    //显示菜单列表。
    $scope.showMenu = function (menuList) {
        var menuStr = '';
        menuList.forEach(function (item, index) {
           menuStr+=item.name+",";
        });
        var index = menuStr.lastIndexOf(",");

        if (menuStr.length == index + 1) {
           menuStr =  menuStr.substr(0,menuStr.length-1);
        }
        return menuStr;
    }

});	
