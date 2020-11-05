//服务层
app.service('roleService',function($http){

    //查询所有用户数据
    this.findAll = function () {
        return $http.get("../role/findAll.do");
    }

});
