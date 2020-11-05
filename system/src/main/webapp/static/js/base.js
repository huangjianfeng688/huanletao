var app = angular.module("huanletao",[]);

app.filter("trustHtml",['$sce',function ($sce) {
    return function (data) {
        return $sce.trustAsHtml(data);
    }
}])