package com.huanletao.huanletao.task;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/9/4
 * @Time: 15:19
 * Description: 定时完成订单。
 */
@Component
public class TaskCompeteOrder {

    private static  Logger logger = Logger.getLogger(TaskCompeteOrder.class);
    /**
     *
     */
   // @Scheduled(cron = "0/10 * * * * ?")
    public void SysTaskCompeteOrder() {
        logger.info("定时完成买家未完成的订单任务。时间：{}"+new Date());
    }

    //@Scheduled(cron = "0/10 * * * * ?")
    public void createCsvDile(){
        logger.info("定时生成订单对账文件任务。时间：{}"+new Date());
    }
}
