//服务层
app.service('goodService',function($http){

    //请求后台查询所有数据信息。
    this.findAll = function () {
        return $http.get("../good/findAll.do")
    }

    //查询商品详情
    this.findGoodDescById = function (id) {
        return $http.get("../good/findGoodDescById.do?id="+id);
    }

    //审核商品信息。
    this.check = function (goodid,status) {
        return $http.get("../good/check.do?goodid="+goodid+"&status="+status);
    }

    //查找我的商品信息，
    this.findMyGoods = function () {
        return $http.get("../good/findMyGood.do")
    }

    //显示20个商品信息在首页。
    this.showGood = function () {
        return $http.get("../good/showGood.do")
    }

});
