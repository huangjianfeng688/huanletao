//控制层、
app.controller('userInfoController', function ($scope, $route,$controller,personalService) {
    //继承数据控制器。
    $scope.$route = $route;
    $controller('personalController',{$scope:$scope});//继承

    //上传头像功能。
    $scope.changeAvatar = function () {
        personalService.upload('avatar').then(function (value) {
            $scope.entity.headimage = value.data.msg;
            messge("更换头像成功","success");
        })
    }

    //保存到后台数据库，更换生效。
    $scope.changUserInfo = function () {
        personalService.updateUser($scope.entity).then(function (value) {
          messge("修改成功",'success');
        })
    }

})