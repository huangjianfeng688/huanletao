//服务层
app.service('userService',function($http){

    //查询所有用户数据
    this.findAll = function () {
        return $http.get("../user/findAll.do");
    }

    //删除用户信息，
    this.deleteUser = function (selectIds) {
        return $http.get("../user/delete.do?ids="+selectIds);
    }

    //查找用户信息
    this.search = function (keyword) {
        return $http.get("../user/search.do?keyword="+keyword);
    }

    //保存用户注册信息
    this.saveUser = function (user) {
        return $http.post("./user/register.do",user);
    }

    //发送短信验证码
    this.sendCode = function (phone) {
        return $http.get("../user/sendCode.do?phone="+phone);
    }

    //用户登录的方法
    this.userlogin = function (username,password) {
        return $http.get("./user/login.do?username="+username+"&password="+password);
    }

    //用户登出的方法。
    this.logout = function (username) {
        return $http.get("./user/logout.do?username="+username);
    }
});
