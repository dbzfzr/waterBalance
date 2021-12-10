package com.zy.gis.pojo;

import java.io.Serializable;

/**
 * 查询封装数据的基类型
 * @date 202108201015
 * @author Wangchong
 */
public class BaseQueryEntity implements Serializable {

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


    public Integer getPage() {
        return page;
    }

//    public void setPage(Integer page) {
//        this.page = page;
//    }
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

//    public void setLimit(Integer limit) {
//        this.limit = limit;
//    }
    public void setLimit(int limit) {
        this.limit = limit;
        if(page != null && page != 0 && limit != 0){
            offset = (page - 1) * limit;
        }
    }

    @Override
    public String toString() {
        return "BaseQueryEntity{" +
                "page=" + page +
                ", offSet=" + offset +
                ", limit=" + limit +
                '}';
    }
}
