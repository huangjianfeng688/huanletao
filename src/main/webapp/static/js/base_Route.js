var app = angular.module('huanletao',['ngRoute'])
    .config(['$routeProvider', function($routeProvider){
        $routeProvider
            .when('/',{templateUrl:'personal/userinfo.html',
                        controller:'userInfoController'
            })
            .when('/goods',{templateUrl:'personal/myGoods.html',
                        controller:'myGoodController'
            })
            .when('/collect',{templateUrl:'personal/mycollect.html',
                        controller:'myCollectController'
            })
            .when('/order',{templateUrl:'personal/myorder.html',
                        controller:'myOrderController'
            })
            .when('/release',{templateUrl:'personal/release.html',
                        controller:'releaseController'
            })
            .when('/want',{templateUrl:'personal/mywant.html',
                        controller:'myWantController'
            })

    }]);
