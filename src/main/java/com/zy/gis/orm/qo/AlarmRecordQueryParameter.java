package com.zy.gis.orm.qo;

import com.zy.gis.pojo.AlarmRecord;

/**
@author Wangchong
@date 2021/10/22 19:38
@description 报警记录查询参数封装类
*/
public class AlarmRecordQueryParameter extends AlarmRecord {

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
     * 查询开始时间
     */
    private String queryStartTime;

    /**
     * 查询结束时间
     */
    private String queryEndTime;

    /**
     * 派单到运维操作人员的id
     */
    private String dispatchToUserId;

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

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getQueryStartTime() {
        return queryStartTime;
    }

    public void setQueryStartTime(String queryStartTime) {
        this.queryStartTime = queryStartTime;
    }

    public String getQueryEndTime() {
        return queryEndTime;
    }

    public void setQueryEndTime(String queryEndTime) {
        this.queryEndTime = queryEndTime;
    }

    public String getDispatchToUserId() {
        return dispatchToUserId;
    }

    public void setDispatchToUserId(String dispatchToUserId) {
        this.dispatchToUserId = dispatchToUserId;
    }

    @Override
    public String toString() {
        return "AlarmRecordQueryParameter{" +
                "page=" + page +
                ", offset=" + offset +
                ", limit=" + limit +
                ", queryStartTime='" + queryStartTime + '\'' +
                ", queryEndTime='" + queryEndTime + '\'' +
                ", dispatchToUserId='" + dispatchToUserId + '\'' +
                '}';
    }
}
