//服务层
app.service('sysUserService',function($http){

    //查询所有用户数据
    this.findAll = function () {
        return $http.get("./findAll.do");
    }
    //查找用户信息
    this.search = function (keyword) {
        return $http.get("../user/search.do?keyword="+keyword);
    }

    //保存用户注册信息
    this.saveSysUser = function (user) {
        return $http.post("./add.do",user);
    }

});
