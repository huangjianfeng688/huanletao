 //控制层 
app.controller('sysUserController' ,function($scope,$rootScope,$controller,sysUserService,roleService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //查询所有用户数据。
	$scope.findAll = function () {
		sysUserService.findAll().then(function (response) {
			$scope.list=response.data.data;

			$scope.paginationConf.totalItems=10;
        })
    }

    //查询所有角色。
    $scope.listRoles = function () {
        roleService.findAll().then(function (response) {
            $scope.listRolesOptions = response.data.data;
            console.log($scope.listRolesOptions)
        })
    }

    //保存一个用户信息。
    $scope.save = function () {
        sysUserService.saveSysUser($scope.entity).then(function (response) {
            $scope.findAll();
        })
    }

    $scope.updateSysUser = function (sysUser) {
        $scope.entity = sysUser;
    }

});	
