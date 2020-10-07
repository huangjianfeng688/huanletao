 //品牌控制层 
app.controller('baseController' ,function($scope,userService){

    //重新加载列表 数据
    $scope.reloadList=function(){
    	$scope.search($scope.keyword);
    }

	//分页控件配置
	$scope.paginationConf = {
         currentPage: 1,
         totalItems: 10,
         itemsPerPage: 10,
         perPageOptions: [5, 10, 15, 20, 30, 40, 50],
         onChange: function(){
        	 $scope.findAll();//重新加载
     	 }
	};

	$scope.selectIds=[];//选中的ID集合

	//更新复选
	$scope.updateSelection = function($event, id) {
		if($event.target.checked){//如果是被选中,则增加到数组
			$scope.selectIds.push( id);
		}else{
			var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除
		}
	}

	//日期转换
    $scope.transform = function (transTime) {
        var date = new Date(transTime);
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        month = month < 10 ? '0' + month : month;
        var d = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
        return year + '/' + month + '/' + d;
    };

    //前端保存用户会话，session，
    $scope.saveSession = function (usercode){
        window.sessionStorage["user"] = usercode;
    }

    //取出session中的值，session .
    $scope.getSession = function () {
        return window.sessionStorage.getItem("user");
    }

    //判断是否登录。
    $scope.isLogin = function () {
        //判断session是否存在
        if (window.sessionStorage["user"]) {
            $scope.loginuser=$scope.getSession();

            return true;
        } else{
            return false;
        }
    }

    //用户退出登录，做两件事情，第一是清除前端的session，第二是清除服务器的session。
    $scope.logout = function () {

        //清除后台服务器的session。
        userService.logout($scope.getSession()).then(function (value) {

            //移除前端的session
            window.sessionStorage.removeItem("user");
        })

    }

    //弹窗的控件封装。
    messge = function (message,icon) {
        swal({
            title:'',
            text:message,
            icon: icon==undefined? "success":icon
        })
    };
    responseInfo = function (response) {
        swal({
            title:'',
            text:response.message,
            icon:response.statusCode == 2000 ? "success":"error"
        });
    }

});