//服务层
app.service('gooddetailService',function($http){

    //用户添加想要的商品
    this.addMyWant = function (goodid,username) {
        return $http.get("./detail/addWant.do?goodid="+goodid+"&username="+username);
    }

    //用户添加收藏商品。
    this.addMyCollect = function (goodid,username) {
        return $http.get("./detail/addCollect.do?goodid="+goodid+"&username="+username);
    }

    //显示评论信息。
    this.showComment = function (goodid) {
        return $http.get("./detail/showComment.do?goodid="+goodid);
    }

    //用户发表评论。
    this.reportComment = function (comment,username) {
        return $http.post("./detail/reportComment.do?username="+username,comment);
    }

});
