app.controller("searchController",function ($scope,$controller,$location,searchService) {
    $controller('baseController', {$scope: $scope});//继承

    //定义查询实体
    $scope.searchMap = {"keywords":"",
                        "price":"",
                        "page":1,
                        "pageSize":20
    };
    //生成分页导航
    createPageLabel = function(){

        //1.生成有存放分页数字的数组
        $scope.pageLabel = [];

        //定义首页和尾页标签
        var firstPage = 1;
        var lastPage = $scope.resultMap.totalPages;

        //定义表示前后省略号的编制
        $scope.firstDot = true;
        $scope.lastDot = true;

        //根据情况动态得到首页及尾页标签的值
        if ($scope.resultMap.totalPages > 5){
            //总页数大于5 同时当前页小于3
            if ($scope.searchMap.page < 3){
                lastPage = 5;
                $scope.firstDot = false;
            } else if($scope.searchMap.page > $scope.resultMap.totalPages - 2){
                firstPage = $scope.resultMap.totalPages - 4;
                $scope.lastDot = false;
            }else{
                firstPage = $scope.searchMap.page - 2;
                lastPage  = $scope.searchMap.page + 2;
            }

        }else{
            $scope.firstDot = false;
            $scope.lastDot = false;
        }
        //想数组中存放分页分数据
        for (var i = firstPage;i <= lastPage;i++){
            $scope.pageLabel.push(i);
        }
    }

    //点击到某个页面
    $scope.skipPage =function (page) {
        $scope.searchMap.page=page;
        $scope.search();
    }

    //跳转下一页/上一页
    $scope.goPage = function(page){
        $scope.searchMap.page = parseInt($scope.searchMap.page)+page;
        $scope.search();
    };

    //1.进行查询
    $scope.search=function () {
        //获取首页传来的参数值.
        var url= window.location.href;
        var index = url.substring(url.lastIndexOf('=') + 1);
        if ($scope.searchMap.keywords ==""){
            $scope.searchMap.keywords = decodeURI(index);
        }
        searchService.search($scope.searchMap).then(function (value) {
            $scope.resultMap = value.data;
            createPageLabel();
        })
    };

    //处理排序.
    $scope.sortSearch =function(sort,sortField){
        $scope.searchMap.sort=sort;
        $scope.searchMap.sortField=sortField;
        $scope.search();
    };
});