//服务层
app.service('orderService',function($http){

    //查询所有
    this.findAll = function () {
        return $http.get("../order/findAll.do");
    }

    //管理员删除订单数据，
    this.deleteOrder = function (selectIds) {
        return $http.get("../order/delete.do?ids="+selectIds);
    }

});
