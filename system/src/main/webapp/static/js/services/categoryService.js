//服务层
app.service('categoryService',function($http){

    //请求后台查询所有数据信息。
    this.findAll = function () {
        return $http.get("../cate/findAll.do")
    }

    //将数据保存到数据库
    this.save = function (entity) {
        return $http.post("../cate/save.do",entity);
    }

    //删除指定的分类信息。
    this.deleteCate = function (ids) {
        return $http.get("../cate/delete.do?ids="+ids);
    }



});
