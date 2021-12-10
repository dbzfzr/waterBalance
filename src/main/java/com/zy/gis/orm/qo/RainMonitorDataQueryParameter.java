package com.zy.gis.orm.qo;

import com.zy.gis.pojo.BaseQueryEntity;

/**
@author Wangchong
@date 2021/11/2 16:00
@description TODO 雨水监测点数据查询参数
*/
public class RainMonitorDataQueryParameter extends BaseQueryEntity {

    /**
     * 繁易屏设备编号
     */
    private String boxNo;

    /**
     * 查询开始时间
     */
    private String startTime;

    /**
     * 查询结束时间参数
     */
    private String endTime;

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "RainMonitorDataQueryParameter{" +
                "boxNo='" + boxNo + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
