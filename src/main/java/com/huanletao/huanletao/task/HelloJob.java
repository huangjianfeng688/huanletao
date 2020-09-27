package com.huanletao.huanletao.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/9/8
 * @Time: 15:58
 * Description: 创建一个定时任务。
 */
public class HelloJob implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //打印时间
        System.out.println(new Date());

        //任务
        System.out.println("Hello World");
    }
}
