package com.huanletao.huanletao.service.impl;

import com.huanletao.huanletao.entity.WebComment;
import com.huanletao.huanletao.entity.WebUser;
import com.huanletao.huanletao.mapper.WebCommentMapper;
import com.huanletao.huanletao.mapper.WebUserMapper;
import com.huanletao.huanletao.service.api.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/6
 * @Time: 10:55
 * Description:
 */@Service
public class CommentServiceimpl implements CommentService {

     @Autowired
     private WebCommentMapper webCommentMapper;
     @Autowired
     private WebUserMapper webUserMapper;


     //显示商品的所有评论信息。
    @Override
    public List<WebComment> findCommentByGood(int goodid) {
        return webCommentMapper.findGoodComments(goodid);
    }

    @Override
    public void save(WebComment webComment,String username) {
        WebUser oneByUserCode = webUserMapper.findOneByUserCode(username);
        webComment.setUserid(oneByUserCode.getUserid());
        webCommentMapper.insert(webComment);
    }
}
