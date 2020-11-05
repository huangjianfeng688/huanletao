//服务层
app.service('adminService',function($http){

    //后台管理员登录
    this.login = function (username,password) {
        return $http.post("../admin/login.do?username="+username+"&password="+password);
    };

    //后台管理员退出系统，
    this.logout = function () {
        return $http.post("../admin/logout.do");
    }
});
