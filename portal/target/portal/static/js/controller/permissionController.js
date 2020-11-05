 //控制层 
app.controller('permissionController' ,function($scope,$controller,permissionService){
	
	$controller('baseController',{$scope:$scope});//继承

	//查询所有分类信息。
	$scope.findAll = function () {
		permissionService.findAll().then(function (response) {
			$scope.roleList = response.data.data;

        })
    }

    //select2 初始化。
    $scope.select2init = function(){
        $('#menu').select2({
            placeholder: '请给角色配置菜单',
            allowClear: true,
            width:'100%',
            minimumResultsForSearch:1,
            ajax: {
                url: "../menu/listMenus.do",
                dataType: 'json',
                Method: 'get',
                delay: 250,
                data: function (params) {
                    return {
                        search: params.term,
                    };
                },
                processResults: function (data) {
                    console.log(data.data);
                    return {
                        results: data.data
                    };
                },
                cache: true
            }
        });
    }

    $scope.roleMenuGroup={sysRole:'',menuIds:[]};

    //保存数据。
    $scope.save = function(){
	    var data = $('#menu').select2("val");

	    console.log(data);


        $scope.roleMenuGroup.sysRole=$scope.entity;
        $scope.roleMenuGroup.menuIds = data;

        console.log($scope.roleMenuGroup);

        permissionService.save($scope.roleMenuGroup).then(function (response) {
            $("#categoryModal").modal("hide");
            responseInfo(response);
            $scope.findAll();
        })


    };




    $scope.updatePermission = function (entity) {
		$scope.entity = entity ;
        $("#menu").val(null).trigger('change');
        $scope.select2init();
    }

    //显示菜单列表。
    $scope.showMenu = function (menuList) {
        var menuStr = '';
        menuList.forEach(function (item, index) {
           menuStr+=item.name+",";
        });
        var index = menuStr.lastIndexOf(",");

        if (menuStr.length == index + 1) {
           menuStr =  menuStr.substr(0,menuStr.length-1);
        }
        return menuStr;
    }

});	
