//服务层
app.service('jobService',function($http){

    this.findAll = function () {
       return $http.get("../task/taskList.do");
    }

    this.save = function (job) {
        return $http.post("../task/add.do",job);
    }

    this.deleJob = function (id) {
        return $http.delete("../task/delete/"+id+".do")
    }

    this.updateJob = function (job) {
        return $http.put("../task/update.do",job);
    }

    //更新任务状态
    this.changeStatus = function (jobId, cmd) {
        return $http.put("../task/updateStatus.do",jobId,cmd)
    }

    this.runOnce = function (jobId) {
        return $http.get("../task/runOnce.do?"+jobId);
    }

});
