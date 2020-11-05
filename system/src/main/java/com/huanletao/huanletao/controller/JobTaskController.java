package com.huanletao.huanletao.controller;

import com.huanletao.huanletao.common.TaskUtils;
import com.huanletao.huanletao.contants.CommonContants;
import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.dto.RetObj;
import com.huanletao.huanletao.entity.ScheduleJob;
import com.huanletao.huanletao.task.service.JobTaskService;
import com.huanletao.huanletao.tenum.ResponseEnum;
import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/task")
public class JobTaskController {

	public final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private JobTaskService taskService;

	@RequestMapping("taskList")
	public List<ScheduleJob> taskList(HttpServletRequest request) {
		List<ScheduleJob> taskList = taskService.getAllTask();
		return taskList;
	}

	@RequestMapping(value = "add",method = RequestMethod.POST)
	@ResponseBody
	public RetObj taskList(@RequestBody ScheduleJob scheduleJob) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		RetObj retObj = new RetObj();
		retObj.setFlag(false);
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
				.cronSchedule(scheduleJob.getCronExpression());
		Object obj = null;
		if (TaskUtils.dataCheckd(scheduleJob, retObj)) return retObj;
		try {
			taskService.addTask(scheduleJob);
		} catch (Exception e) {
			e.printStackTrace();
			retObj.setFlag(false);
			retObj.setMsg("保存失败，检查 name group 组合是否有重复！");
			log.info("保存失败，检查 name group 组合是否有重复！");
			return retObj;
		}

		retObj.setFlag(true);
		return retObj;
	}

	/**
	 *
	 * @return
	 */
	@ResponseBody
	@DeleteMapping("delete/{id}")
	public ResponseObject deleteJob(@PathVariable int id) throws SchedulerException {

		taskService.deleJob(id);
		return ResponseObject.success(ResponseEnum.DELETESUCCESS);

	}

	/**
	 * 更新任务信息。
	 * @param scheduleJob
	 * @return
	 */
	@RequestMapping(value = "update",method = RequestMethod.PUT)
	@ResponseBody
	public ResponseObject changeJobStatus(@RequestBody ScheduleJob scheduleJob) {
		RetObj retObj = new RetObj();
		retObj.setFlag(false);
		try {
			taskService.updateJob(scheduleJob);
			return ResponseObject.success(CommonContants.SUCCESS_CODE,"更新任务成功");
		} catch (SchedulerException e) {
			log.error("更新任务失败");
			return ResponseObject.fail(CommonContants.FAIL_CODE,"更新任务失败");
		}

	}

	/**
	 *
	 * @param jobId
	 * @param cmd
	 * @return 更新任务状态。
	 */
	@RequestMapping(value = "updateStatus",method = RequestMethod.PUT)
	@ResponseBody
	public ResponseObject changeStatus(Long jobId, String cmd){
		RetObj retObj = new RetObj();
		retObj.setFlag(false);
		try {
			taskService.changeStatus(jobId,cmd);
			return ResponseObject.success(CommonContants.SUCCESS_CODE,"更新任务状态成功");
		} catch (SchedulerException e) {
			e.printStackTrace();
			log.error("更新状态失败");
			return ResponseObject.fail(CommonContants.FAIL_CODE,"更新任务状态失败");
		}
	}

	/**
	 * 执行一次。
	 * @param jobId
	 * @return
	 */
	@RequestMapping(value = "runOnce",method = RequestMethod.GET)
	@ResponseBody
	public ResponseObject runingOnce(String jobId){
		try {
			taskService.runOnce(jobId);
			return ResponseObject.success(ResponseEnum.OK);
		} catch (SchedulerException e) {
			log.error("执行失败。");
			return ResponseObject.fail(ResponseEnum.Fail);
		}

	}
}
