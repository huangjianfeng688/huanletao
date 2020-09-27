package com.huanletao;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/8/28
 * @Time: 16:46
 * Description:
 */
public class demo {

    public static void main(String[] args) {
        File file = new File("D:\\demo05.xlsx");

        String fileName = file.getName();
        File file1 = new File("D:\\demo05.csv");
        file.renameTo(file1);
    }
}
