package com.zy.gis.orm.qo;

import java.io.Serializable;

/**
@author Wangchong
@date 2021/11/30 18:59
@description TODO 封装查询参数的对象
*/
public class QueryParameter<T> implements Serializable {

    /**
     * 页数
     */
    private Integer page;

    /**
     * 偏移量
     */
    private Integer offset;

    /**
     * 页面大小限制
     */
    private Integer limit;

    /**
     * 实际的查询参数封装的对象
     */
    private T parameter;

    public Integer getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
        if(limit != null && page != 0 && limit != 0){
            offset = (page - 1) * limit;
        }
    }

    public Integer getOffSet() {
        return offset;
    }

    public void setOffSet(Integer offSet) {
        this.offset = offSet;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
        if(page != null && page != 0 && limit != 0){
            offset = (page - 1) * limit;
        }
    }

    public T getParameter() {
        return parameter;
    }

    public void setParameter(T parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return "QueryParameter{" +
                "page=" + page +
                ", offset=" + offset +
                ", limit=" + limit +
                ", parameter=" + parameter +
                '}';
    }
}
