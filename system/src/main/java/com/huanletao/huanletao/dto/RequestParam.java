package com.huanletao.huanletao.dto;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕。
 * @Date: 2020/10/11
 * @Time: 0:07
 * Description:
 */
public class RequestParam {
    private Integer page ;
    private Integer limit;
    private Integer merId;
    private String  timeOrder;

    public Integer getPage() {
        return page;
    }

    public RequestParam setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public RequestParam setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getMerId() {
        return merId;
    }

    public RequestParam setMerId(Integer merId) {
        this.merId = merId;
        return this;
    }

    public String getTimeOrder() {
        return timeOrder;
    }

    public RequestParam setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
        return this;
    }

    @Override
    public String toString() {
        return "page=" + page +
                "&limit=" + limit +
                "&mer_id=" + merId +
                "&timeOrder='" + timeOrder + '\'';
    }

    //构建请求参数。
    public static String buildParam(Integer page,Integer limit){
        return new RequestParam().setPage(page).setLimit(limit).setMerId(0).setTimeOrder("desc").toString();
    }
}
