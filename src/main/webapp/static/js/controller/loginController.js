//控制层
app.controller('loginController' ,function($scope,$controller,adminService){

    $controller('adminController',{$scope:$scope});//继承

    //管理员登录
      $scope.login = function () {

          adminService.login($scope.username,$scope.password).then(function (value) {
              if (value.data.statusCode==2000){
                  $scope.ActiveUser = value.data.data;
                  localStorage.setItem("activeUser",JSON.stringify($scope.ActiveUser));
                  location.href="/admin/index.html";
                  return
              }
              alert(value.data.message);
          })
      }
});
