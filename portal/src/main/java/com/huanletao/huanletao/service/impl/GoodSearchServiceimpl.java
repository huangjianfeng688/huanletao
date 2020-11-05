package com.huanletao.huanletao.service.impl;

import com.huanletao.huanletao.entity.WebGoodDesc;
import com.huanletao.huanletao.service.api.GoodSearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/5
 * @Time: 12:57
 * Description: 实现搜索的逻辑功能。
 */@Service
public class GoodSearchServiceimpl implements GoodSearchService {

     @Autowired
     private SolrTemplate solrTemplate;

    @Override
    public Map<String, Object> search(Map searchMap) {
        //定义查询返回的结果容器
        Map<String,Object> maps = new HashMap<>();
        //高亮查询方法.
        Map<String,Object> highmap =  highlightQuery(searchMap);
        //将高亮查询的结果存放放发哦map中.

        maps.putAll(highmap);
        //返回。
        return maps;
    }

    /**
     * 导入数据到索引库中
     * @param list
     */
    @Override
    public void importToSolr(List list) {
        solrTemplate.saveBeans(list);
        solrTemplate.commit();
    }

    /**
     * 将删除的商品从索引库移除 .
     * @param goodList
     */
    @Override
    public void deleteSolr(List<Long> goodList) {
        Query query = new SimpleQuery();
        //指定条件.
        Criteria criteria = new Criteria("item_goodsid").in(goodList);
        //添加条件
        query.addCriteria(criteria);
        //删除符合要求的数据.
        solrTemplate.delete(query);
        //提交操作.
        solrTemplate.commit();
    }

    //高亮查询方法.
    private Map<String, Object> highlightQuery(Map searchMap) {
        //构造返回结果对象.
        Map<String,Object> maps = new HashMap<>();
        //进行高亮查询结果
        HighlightQuery query = new SimpleHighlightQuery();
        //添加查询条件
        Criteria criteria;
        //如果查询条件不为空,
        if (searchMap.get("keywords")!=null && StringUtils.isNotBlank(searchMap.get("keywords").toString())){
            System.out.println("searchMap = " + searchMap.get("keywords"));
            criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
        }else{
            System.out.println("searchMap = " + searchMap.get("keywords"));
            criteria = new Criteria("item_keywords");
        }
        //查询条件和高亮查询进行绑定
        query.addCriteria(criteria);
        //设置高亮参数
        HighlightOptions options = new HighlightOptions();
        options.addField("item_title");
        options.setSimplePrefix("<span style='color:red'>");
        options.setSimplePostfix("</span>");
        //将参数和查询进行绑定.
        query.setHighlightOptions(options);

        // ------------------------------------------- 进行过滤查询---------------------------------------------

        /****************************** 价格过滤查询 *********************************/
        if (searchMap.get("price")!=null && StringUtils.isNotBlank(searchMap.get("price").toString())){
            System.out.println("searchMap = " + searchMap.get("price"));
            String[] prices = searchMap.get("price").toString().split("-");
            for (String price : prices) {
                System.out.println("price = " + price);
            }
            //如果第一个不为0
            if (!prices[0].equals("0")){
                FilterQuery filterQuery = new SimpleFilterQuery();
                filterQuery.addCriteria(new Criteria("item_price").greaterThanEqual(prices[0]));
                query.addFilterQuery(filterQuery);
            }

            //第二个参数不为*是
            if (!prices[1].equals("*")){
                FilterQuery filterQuery = new SimpleFilterQuery();
                filterQuery.addCriteria(new Criteria("item_price").lessThan(prices[1]));
                query.addFilterQuery(filterQuery);
            }
        }

        /*------------------------------将结果进行分页显示------------------------------------*/
        //取出当前页
        int page = Integer.parseInt(searchMap.get("page").toString());
        //取出当前页的记录数
        int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());

        System.out.println("pageSize = " + pageSize);
        System.out.println("page = " + page);

        //开始设置分页参数
        //设置起始偏移量
        query.setOffset((page-1)*pageSize);
        //设置每页的记录数
        query.setRows(pageSize);


        /*-------------------------------开始高亮查询-------------------------------------------------*/
        //进行高亮查询.
        HighlightPage<WebGoodDesc> highlightPage = solrTemplate.queryForHighlightPage(query, WebGoodDesc.class);
        //高亮查询入口.
        List<HighlightEntry<WebGoodDesc>> highlighted = highlightPage.getHighlighted();
        //遍历入口对象.
        for (HighlightEntry<WebGoodDesc> tbItemHighlightEntry : highlighted) {
            WebGoodDesc entity = tbItemHighlightEntry.getEntity();
            //得到多个字段的高亮查询对象.
            List<HighlightEntry.Highlight> highlights = tbItemHighlightEntry.getHighlights();
            //得到高亮查询对象
            if (highlights != null && highlights.size() > 0){
                //获取某个字段.
                HighlightEntry.Highlight highlight = highlights.get(0);
                //得到高亮字段的多个值域
                List<String> snipplets = highlight.getSnipplets();
                if (snipplets != null && snipplets.size() >0){
                    entity.setGoodname(snipplets.get(0));
                }
            }
            //存入map集合中
            maps.put("rows",highlightPage.getContent());
            maps.put("totalPages",highlightPage.getTotalPages());
            maps.put("total",highlightPage.getTotalElements());
        }
        //返回结果
        return maps;
    }
}
