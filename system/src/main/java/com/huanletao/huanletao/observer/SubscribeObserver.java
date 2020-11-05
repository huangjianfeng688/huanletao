package com.huanletao.huanletao.observer;

import com.huanletao.huanletao.observer.api.Observer;
import com.huanletao.huanletao.util.MailUtils;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕。
 * @Date: 2020/10/20
 * @Time: 22:03
 * Description:
 */
@Component
public class SubscribeObserver implements Observer {

    @Override
    public void sendNotice(Map<String, String> map) {
        String buyser = map.get("buyer");

        String content = "你已经订阅成功";

        System.out.println("ok buyer");
        try {
            MailUtils.sendSimpleMail(buyser,content);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
