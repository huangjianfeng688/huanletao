package com.huanletao;

import com.huanletao.huanletao.entity.WebGoodDesc;

import com.huanletao.huanletao.util.SolrUtil;

import com.huanletao.huanletao.util.SolrUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/10/12
 * Time: 16:46
 * Description:
<<<<<<< HEAD
*/
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath*:spring/applicationContext.xml")
//public class DataToSolr{
//    @Autowired
//    private SolrUtils solrUtils;
//    @Autowired
//    private SolrTemplate solrTemplate;
//
//
//    @Test
//    public void test01(){
//        solrUtils.importDatatoSolr();
//        System.out.println("数据数据导入成功");
//    }
//
//    //分页搜索实现。
//    @Test
//    public void test02(){
//        //查询所有的数据。
//        Query query = new SimpleQuery("*:*");
//        //从第十个显示
//        query.setOffset(0);
//        //每页显示10个数据。
//        query.setRows(10);
//        //开始搜索
//        ScoredPage<WebGoodDesc> tbItems = solrTemplate.queryForPage(query, WebGoodDesc.class);
//
//        System.out.println("总记录数为："+tbItems.getTotalElements());
//        System.out.println("总页数有："+tbItems.getTotalPages());
//
//        //分页查询的结果。
//        List<WebGoodDesc> content = tbItems.getContent();
//        for (WebGoodDesc tbItem : content) {
//            System.out.println(tbItem);
//        }
//
//    }
//
//    @Test
//    public void test03(){
//
//    }
//}

