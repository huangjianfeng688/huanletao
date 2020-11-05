//控制层
app.controller('adminController' ,function($scope,$controller,adminService){

    $controller('baseController',{$scope:$scope});//继承

    // 获取活动的用户信息，
      $scope.showActiveUser = function () {
          var activeUser = localStorage.getItem("activeUser");
          $scope.activeUser = JSON.parse(activeUser);
      }

      //退出系统。logout
      $scope.logout = function () {
          adminService.logout().then(function () {
              localStorage.removeItem("activeUser");
              window.location.href="login.html";
          })
      }
});
