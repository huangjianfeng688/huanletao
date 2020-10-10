package com.huanletao.huanletao.util;

import com.huanletao.huanletao.entity.WebGoodDesc;
import com.huanletao.huanletao.mapper.WebGoodDescMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/10/12
 * Time: 15:05
 * Description:solr 工具类.
 */@Component
public class SolrUtils {

    @Autowired
    private WebGoodDescMapper webGoodDescMapper;

    @Autowired
    private SolrTemplate solrTemplate;

    //将数据库的数据导入索引库中,
    public void importDatatoSolr(){
        List<WebGoodDesc> passGood = webGoodDescMapper.findPassGood();

        //添加数据到索引库中
        solrTemplate.saveBeans(passGood);
        //提交
        solrTemplate.commit();
    }

    //将审核通过的商品添加到索引库中，
    public void saveSolr(WebGoodDesc webGoodDesc){
        solrTemplate.saveBean(webGoodDesc);
        solrTemplate.commit();
    }
}
