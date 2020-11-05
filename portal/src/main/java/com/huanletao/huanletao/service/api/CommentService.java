package com.huanletao.huanletao.service.api;

import com.huanletao.huanletao.entity.WebComment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/6
 * @Time: 10:54
 * Description:
 */
public interface CommentService {

    List<WebComment> findCommentByGood(int goodid);

    void save(WebComment webComment, String username);
}
