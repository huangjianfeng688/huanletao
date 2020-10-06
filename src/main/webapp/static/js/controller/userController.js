 //控制层 
app.controller('userController' ,function($scope,$rootScope,$controller,userService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //查询所有用户数据。
	$scope.findAll = function () {
		userService.findAll().then(function (response) {
			$scope.list=response.data;
			$scope.paginationConf.totalItems=10;
        })
    }

    //显示用户类型和性别。
	$scope.sex=['男','女'];
	$scope.usertype=['','普通用户','管理员'];
	$scope.selectOption = {'男':0,"女":1};

	//选择用户，进行删除功能，
	$scope.deleteUser = function () {
		userService.deleteUser($scope.selectIds).success(function (response) {
			alert(response.message);
            $scope.findAll();
        })
    }

    //搜索查找用户信息，
	$scope.search = function () {
		userService.search($scope.keyword).then(function (response) {
			$scope.list = response.data;
            $scope.paginationConf.totalItems=response.pageSize;
        })
    }



    //初始化常量信息。
    $scope.msg='';
	$scope.codemsg='';
    $scope.user={phone:''};

    //获取验证码
	$scope.getCode = function () {
        //判断电话是否填入。
        if ($scope.user.phone==''){
            $scope.msg='请输入手机号码';
        }else{
            $scope.msg='';
            //发送短信验证码
            userService.sendCode($scope.user.phone).then(function (value) {
                alert(value.data.message);

			})
        }
    }

    //新用户注册功能。
    $scope.register = function () {
        userService.saveUser($scope.user).then(function (response) {
            alert(response.data.message);
            $scope.user={};
        })
    }

    $scope.loginmsg = '';

    //用户登录。
    $scope.login = function () {
        userService.userlogin($scope.username,$scope.password).then(function (value) {
            //登录失败的情况，显示提示信息。

            console.log(value)
            console.log(value.data.statusCode)

            if (value.data.statusCode == 4000) {
                $scope.loginmsg = value.data.message;
            }else{
                //保存用户信息，
                $scope.saveSession($scope.username);
                //跳转到个人中心。
                window.location.href='personal.html';
            }

        })
    }

});	
