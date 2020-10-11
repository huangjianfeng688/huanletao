 //控制层 
app.controller('indexController' ,function($scope,$controller,categoryService,advertService,goodService){
	
	$controller('baseController',{$scope:$scope});//继承

	//初始化方法
	$scope.htmlinit = function (){
		$scope.findAll();
		$scope.findAdert();
		$scope.showGood();
	}

	//查询分类信息，
	$scope.findAll = function () {
		categoryService.findAll().then(function (response) {
			$scope.cateList = response.data;
        })
    }

    //查询轮播图数据信息。
	$scope.findAdert = function () {
		advertService.findEnable().then(function (response) {
			$scope.advertList = response.data;
        })
    };

	//显示12个已经通过审核的商品。
	$scope.showGood = function () {
		goodService.showGood().then(function (value) {
			$scope.goodList = value.data;
        })
    }

    $scope.search = function(){
        location.href="http://localhost:8081/search.html?keywords="+$scope.keywords;
	}


});	
