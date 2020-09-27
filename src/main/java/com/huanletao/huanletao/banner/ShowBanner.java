package com.huanletao.huanletao.banner;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕。
 * @Date: 2020/9/26
 * @Time: 8:37
 * Description: 启动完成后，显示banner 图案。
 */
@Component
public class ShowBanner{

    private static final Logger logger = Logger.getLogger(ShowBanner.class);


    private ShowBanner(){
        //byte[] banner = readBanner();
        //String str = new String(banner);
        System.out.println("----------------------------------");
        System.out.println("-------huanletao 启动成功！---------");
        System.out.println("-------佛祖保佑   永无 bug---------");
        System.out.println("----------------------------------");
    }

    private static byte[] readBanner() throws IOException {
        InputStream resource = ShowBanner.class.getResourceAsStream("/banner.txt");

        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        while ((len = resource.read(buffer)) != -1){
            out.write(buffer, 0, len);
        }
        out.close();
        return buffer;
    }

}
