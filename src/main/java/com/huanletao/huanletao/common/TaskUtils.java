package com.huanletao.huanletao.common;

import com.huanletao.huanletao.contants.CommonContants;
import com.huanletao.huanletao.contants.TaskContants;
import com.huanletao.huanletao.dto.RetObj;
import com.huanletao.huanletao.dto.SpringUtils;
import com.huanletao.huanletao.entity.ScheduleJob;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕。
 * @Date: 2020/9/25
 * @Time: 11:26
 * Description: task 的相关工具类。
 */
public class TaskUtils {

    public static boolean dataCheckd(ScheduleJob scheduleJob, RetObj retObj) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Object obj = null;
        if (StringUtils.isNotBlank(scheduleJob.getSpringId())) {
            obj = SpringUtils.getBean(scheduleJob.getSpringId());
        } else {
            Class clazz = Class.forName(CommonContants.BASE_PACKAGE + scheduleJob.getBeanClass());
            obj = clazz.newInstance();
        }

        if (obj == null) {
            retObj.setMsg("未找到目标类！");
            return true;
        } else {
            Class clazz = obj.getClass();
            Method method = null;
            try {
                method = clazz.getMethod(scheduleJob.getMethodName(), null);
            } catch (Exception e) {
                // do nothing.....
            }
            if (method == null) {
                retObj.setMsg("未找到目标方法！");
                return true;
            }
        }
        return false;
    }
}
