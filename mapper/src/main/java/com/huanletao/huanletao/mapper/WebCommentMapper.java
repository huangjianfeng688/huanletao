package com.huanletao.huanletao.mapper;

import com.huanletao.huanletao.entity.WebComment;
import com.huanletao.huanletao.entity.WebCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebCommentMapper {
    int countByExample(WebCommentExample example);

    int deleteByExample(WebCommentExample example);

    int deleteByPrimaryKey(Integer commentid);

    int insert(WebComment record);

    int insertSelective(WebComment record);

    List<WebComment> selectByExample(WebCommentExample example);

    WebComment selectByPrimaryKey(Integer commentid);

    int updateByExampleSelective(@Param("record") WebComment record, @Param("example") WebCommentExample example);

    int updateByExample(@Param("record") WebComment record, @Param("example") WebCommentExample example);

    int updateByPrimaryKeySelective(WebComment record);

    int updateByPrimaryKey(WebComment record);

    List<WebComment> findGoodComments(int goodid);
}