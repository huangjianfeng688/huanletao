 //控制层 
app.controller('jobController' ,function($scope,$controller,jobService){
	
	$controller('baseController',{$scope:$scope});//继承

	//查询所有任务信息。
	$scope.findAll = function () {
		jobService.findAll().then(function (response) {
			$scope.jobList = response.data;

        })
    }

    //修改分类信息，
	$scope.updateJobUI = function (job) {
		$scope.entity = job;
    }

    //将修改或者添加的信息保存到数据库中，
	$scope.save = function () {
		$("#jobModal").modal("hide");
		jobService.save($scope.entity).then(function (response) {
			alert(response.message);
            $scope.findAll();
        })
    }

    //删除分类信息，
	$scope.deleteJob = function () {
		jobService.deleJob($scope.selectIds).then(function (response) {
			$scope.findAll();
			alert(response.message);
        })
    }

    //更新任务状态。
	$scope.updateJob = function (job) {
		jobService.updateJob(job).then(function (response) {
            $scope.findAll();
            alert(response.message);
        })
    }

});	
