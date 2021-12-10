package com.zy.gis.common.layui;

import java.io.Serializable;
import java.util.List;
/**
@author Wangchong
@date 2021/12/2 15:25
@description TODO 封装layui table 格式数据
*/
public class LayuiTableResult implements Serializable {

    /**
     * code 默认为 0
     */
    private Integer code;

    /**
     * 数据
     */
    private List<? extends Object> data;

    /**
     * 数据条数
     */
    private Integer count;

    /**
     * 封装layui table 格式数据
     * @author Wangchong
     * @date 202108201740
     * @param resultCount
     * @param resultList
     * @return
     */
    public LayuiTableResult(Integer resultCount, List<? extends Object> resultList){
       this.count = resultCount;
       this.data = resultList;
       this.code = 0;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<? extends Object> getData() {
        return data;
    }

    public void setData(List<? extends Object> data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LayuiTableResult{" +
                "code=" + code +
                ", data=" + data +
                ", count=" + count +
                '}';
    }
}
