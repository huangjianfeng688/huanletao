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
 * @auther: huangjianfeng
 * @Date: 2020/10/20
 * @Time: 21:23
 * Description: 卖家观察者。
 */
@Component
public class GoodOwnerObserver implements Observer {

    @Override
    public void sendNotice(Map<String,String> map) {
        String context = "主人，你的宝贝已经被订阅啦。";
        String woner = map.get("owner");
        try {
            MailUtils.sendSimpleMail(woner,context);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        System.out.println("ok owner");
    }


}
