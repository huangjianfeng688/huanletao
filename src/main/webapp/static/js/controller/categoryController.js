 //控制层 
app.controller('categoryController' ,function($scope,$controller,categoryService){
	
	$controller('baseController',{$scope:$scope});//继承

	//查询所有分类信息。
	$scope.findAll = function () {
		categoryService.findAll().then(function (response) {
			$scope.cateList = response.data;

        })
    }
    //修改分类信息，
	$scope.updateCate = function (cate) {
		$scope.entity = cate;
    }

    //将修改或者添加的信息保存到数据库中，
	$scope.save = function () {
		$("#categoryModal").modal("hide");
		categoryService.save($scope.entity).then(function (response) {
			alert(response.message);
            $scope.findAll();
        })
    }

    //删除分类信息，
	$scope.deleteCate = function () {
		categoryService.deleteCate($scope.selectIds).then(function (response) {
			$scope.findAll();
			alert(response.message);
        })
    }


});	
