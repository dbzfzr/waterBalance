package com.zy.gis.pojo;

import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/16 9:22
 */
@Data
public class EasyUITreeInfo extends BaseQueryEntity{
    private String id;

    /**
     * 节点是否选中 "true" 选中 "false"未选中
     */
    private boolean checked;
    private String text;
    private String state;
    private List<EasyUITreeInfo> children;
    private String pId;

    /**
     * 用来显示图标的 css class 判断节点等级
     */
    private String iconCls;

    /**
     * 给一个节点添加的自定义属性。
     */
    private String attributes;

    /**
     * 父节点id
     */
    private Integer parentId;
}
