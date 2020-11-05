//服务层
app.service('advertService',function($http){

    //查询所有广告数据
    this.findAll = function () {
        return $http.get("../advert/findAll.do");
    };

    //查询启用的广告
    this.findEnable = function () {
        return $http.get("../advert/findEnable.do");
    };

    //将更新和添加的数据保存到数据库中。
    this.save = function (advert) {
        return $http.post("../advert/save.do",advert);
    };

    //删除广告数据功能实现。
    this.deleAdvert = function (ids) {
        return $http.get("../advert/delete.do?ids="+ids);
    }



    //上传广告图片的功能实现。
    //将前端的文件上传到后台（前端：利用h5+angularjs技术，后端：springmvc+commonsMultipartResolver组件）
    this.upload = function () {
        //1.定义要上传的数据对象
        var data = new FormData();
        data.append("uploadFile",file.files[0]);
        data.append("path","wheel");
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
