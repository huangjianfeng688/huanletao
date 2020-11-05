package com.huanletao.huanletao.service.api;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/5
 * @Time: 12:56
 * Description:
 */
public interface GoodSearchService {

    //实现搜索的逻辑功能。
    Map<String,Object> search(Map map);

    //将数据导入到索引库中。
    void importToSolr(List list);

    //从索引库中删除数据。
    void deleteSolr(List<Long> goodList);
}
