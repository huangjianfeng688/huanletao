package com.huanletao.huanletao.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * 邮件工具类。
 */
public class MailUtils {


    //只要在程序运行之初加上
    static{
        //处理附件文件名中文乱码
        System.setProperty("mail.mime.splitlongparameters","false");
        System.setProperty("mail.mime.charset","UTF-8");

    }

    /**
     * 发送附件邮件。
     * @param mail
     * @throws GeneralSecurityException
     * @throws MessagingException
     */
    public static void sendComplexEmail(String mail,String filePath) throws GeneralSecurityException, MessagingException, UnsupportedEncodingException {
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.qq.com");  //设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol", "smtp"); // 邮件发送协议
        prop.setProperty("mail.smtp.auth", "true"); // 需要验证用户名密码


        // QQ邮箱设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        //1、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //传入发件人的姓名和授权码
                return new PasswordAuthentication("1710350112@qq.com","");
            }
        });
        //2、通过session获取transport对象
        Transport transport = session.getTransport();
        //3、通过transport对象邮箱用户名和授权码连接邮箱服务器
        transport.connect("smtp.qq.com","1710350112@qq.com","");
        //4、创建邮件,传入session对象
        MimeMessage mimeMessage = complexEmail(session,filePath);
        //5、发送邮件
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        //6、关闭连接
        transport.close();

    }

    /**
     * 构建邮件信息对象。
     * @param session
     * @return
     * @throws MessagingException
     */
    private static MimeMessage complexEmail(Session session,String filePath) throws MessagingException, UnsupportedEncodingException {
        //消息的固定信息
        MimeMessage mimeMessage = new MimeMessage(session);

        //发件人
        mimeMessage.setFrom(new InternetAddress("1710350112@qq.com"));
        //收件人
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("1710350112@qq.com"));
        mimeMessage.setRecipient(Message.RecipientType.CC,new InternetAddress("1076089968@qq.com"));
        //邮件标题
        mimeMessage.setSubject("数据报表");
        //附件
//        MimeBodyPart appendix = new MimeBodyPart();
//        appendix.setDataHandler(new DataHandler(new FileDataSource("E:/"+filePath)));


        MimeMultipart multi = new MimeMultipart();

        File f = new File("E:/"+filePath);

        FileDataSource fds = new FileDataSource(f);
        BodyPart fileBodyPart = new MimeBodyPart();
        fileBodyPart.setDataHandler(new DataHandler(fds));
        fileBodyPart.setFileName(MimeUtility.encodeText("订单报表数据.xlsx"));//如果附件有中文通过转换没有问题了
        multi.addBodyPart(fileBodyPart);

//        String date = DateUtils.getDate();
//
//        String fileName = date + "订单报表数据.xlsx";
////        MimeUtility.encodeText(fileName);
////        appendix.setFileName(fileName);
//        MimeUtility.encodeWord(fileName);
//        //拼接附件
//        MimeMultipart allFile = new MimeMultipart();
//        allFile.addBodyPart(appendix);//附件
//        BodyPart contentText = new MimeBodyPart();
//        ((MimeBodyPart) contentText).setText("小直降订单数据报表","utf-8");
//        allFile.addBodyPart(contentText);//正文
//        allFile.setSubType("mixed"); //正文和附件都存在邮件中，所有类型设置为mixed
//        //放到Message消息中
        mimeMessage.setContent(multi);
        mimeMessage.saveChanges();//保存修改

        return mimeMessage;
    }

    /**
     * 发送简单邮件。
     * @param mailAddr
     * @throws MessagingException
     * @throws GeneralSecurityException
     */
    public static void sendSimpleMail(String mailAddr,String content) throws MessagingException, GeneralSecurityException {
        //创建一个配置文件并保存
        Properties properties = new Properties();

        properties.setProperty("mail.host","smtp.qq.com");

        properties.setProperty("mail.transport.protocol","smtp");

        properties.setProperty("mail.smtp.auth","true");


        //QQ存在一个特性设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        //创建一个session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1710350112@qq.com","idikyusyymladhhj");
            }
        });

        //开启debug模式
        session.setDebug(true);
        //获取连接对象
        Transport transport = session.getTransport();
        //连接服务器
        transport.connect("smtp.qq.com","1710350112@qq.com","");
        //创建邮件对象
        MimeMessage mimeMessage = new MimeMessage(session);
        //邮件发送人
        mimeMessage.setFrom(new InternetAddress("1710350112@qq.com"));
        //邮件接收人
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("1710350112@qq.com"));
        //邮件抄送人
        mimeMessage.setRecipient(Message.RecipientType.CC, new InternetAddress("1076089968@qq.com"));

        //邮件标题
        mimeMessage.setSubject("Hello Mail");

        //邮件内容
        // mimeMessage.setContent("我的想法是想和你有一个未来","text/html;charset=UTF-8");
         mimeMessage.setContent(content,"text/html;charset=UTF-8");

        //发送邮件
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());

        //关闭连接
        transport.close();
    }



}
