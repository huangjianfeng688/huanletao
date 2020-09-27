package com.huanletao;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/6
 * @Time: 11:06
 * Description:
 */

import com.huanletao.huanletao.entity.WebComment;
import com.huanletao.huanletao.mapper.WebCommentMapper;
import com.huanletao.huanletao.mapper.WebUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;



//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath*:spring/applicationContext.xml")
//public class mapperTest {
//    @Autowired
//    private WebCommentMapper webCommentMapper;
//    @Autowired
//    private WebUserMapper webUserMapper;
//
//    @Test
//    public void test01(){
//        List<WebComment> goodComments = webCommentMapper.findGoodComments(10);
//        for (WebComment goodComment : goodComments) {
//            System.out.println("goodComment = " + goodComment);
//        }
//    }
//
//    @Test
//    public void test02(){
//        System.out.println(webUserMapper.findAdmin("wangwu"));
//    }
//
//}

