//服务层
app.service('personalService',function($http){

    //查找我的商品信息，
    this.findMyGoods = function (username) {
        return $http.get("../personal/findMyGood.do?username="+username)
    };

    //更新用户信息。
    this.updateUser = function (user) {
        return $http.post("../personal/update.do",user);
    };

    //根据用户名，查找一个用户的信息，
    this.findByUserCode = function (username) {
        return $http.get("../personal/findByUserCode.do?username="+username);
    };

    //发布商品信息。
    this.addMyGood = function (webGoodDesc,username) {
        return $http.post("../personal/addGood.do?username="+username,webGoodDesc)
    };

    //删除商品信息。
    this.deleteGood = function (goodid) {
        return $http.get("../personal/deleteGood.do?goodid="+goodid);
    };

    //查询所有的买家
    this.findBuyersByGoodId = function (goodid) {
        return $http.get("../personal/findBuyer.do?goodid="+goodid);
    };

    //生成订单数据。
    this.generateOrder = function (order) {
        return $http.post("../personal/generateOrder.do",order);
    };

    //查找我的订单数据
    this.findMyOrder = function (username) {
        return $http.get("../personal/findMyOrders.do?username="+username);
    };

    //修改订单状态
    this.updateOrderStatus = function (orderid,status) {
        return $http.get("../personal/updateOrder.do?orderid="+orderid+"&status="+status);
    };

    //查询我的收藏商品信息。
    this.findMyCollect =function (username) {
        return $http.get("../personal/findMyCollect.do?username="+username);
    }

    //移除收藏的商品信息。
    this.removeCollect = function (goodid) {
        return $http.get("../personal/removeCollect.do?goodid="+goodid);
    }

    //查询自己想要的商品信息。
    this.findMyWants = function (username) {
         return $http.get("../personal/findMyWants.do?username="+username);
    };

    //取消想要
    this.removeWant = function (goodid) {
        return $http.get("../personal/removeWant.do?goodid="+goodid);
    };


    //上传文件功能实现。
    //将前端的文件上传到后台（前端：利用h5+angularjs技术，后端：springmvc+commonsMultipartResolver组件）
    this.upload = function (path) {
        //1.定义要上传的数据对象
        var data = new FormData();
        data.append("uploadFile",file.files[0]);
        data.append("path",path);
        //2.进行文件上传
        return $http({
            url:'../File/upload.do',
            data:data,
            method:'post',
            headers:{'Content-Type' :undefined},  //如果这里是undefined,前端就会将其转换为：multipart/form-data
            transformRequest:angular.identity     //angular对上传的数据进行序列化处理
        })
    }

});
