package com.huanletao.huanletao.mapper;

import com.huanletao.huanletao.entity.WebUser;
import com.huanletao.huanletao.entity.WebUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebUserMapper {
    int countByExample(WebUserExample example);

    int deleteByExample(WebUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(WebUser record);

    int insertSelective(WebUser record);

    List<WebUser> selectByExample(WebUserExample example);

    WebUser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") WebUser record, @Param("example") WebUserExample example);

    int updateByExample(@Param("record") WebUser record, @Param("example") WebUserExample example);

    int updateByPrimaryKeySelective(WebUser record);

    int updateByPrimaryKey(WebUser record);

    //根据登录名称，查询用户信息，
    WebUser findOneByUserCode(String userCode);

    //根据商品名称，查询买家信息。
    List<WebUser> findBuyers(int goodid);

    //后台管理员登陆
    WebUser findAdmin(String username);

    //根据商品编码查询用户
    WebUser findByGoodId(int goodid);
}