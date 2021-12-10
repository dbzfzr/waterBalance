package com.zy.gis.waterbalance;

/**
@author Wangchong
@date 2021/11/25 14:30
@description TODO 模拟数据 参照半岛国际数据
*/
public class ImitateData {
    /**
    @author Wangchong
    @date 2021/11/25 14:31
    @description TODO 模拟的每小时的供水量 15m3/h
    */
    public static float SUPPLY_WATER_HOUR = 15.0f;

    // 开始供水量220吨
    public static float BASE_SUPPLY_WATER = 220.0f;

    // 开始污水排出量 176吨
    public static float BASE_SEWAGE_OUT_PUT = 176.0f;

    // 每小时污水排出量
    public static float SEWAGE_OUT_PUT_HOUR = 11.0f;

    /**
    @author Wangchong
    @date 2021/11/25 14:45
    @description TODO A区域排水单元个数
    @see 技术资料.pdf
    */
    public static final Integer  A_AREA_VILLAGE_UNIT_COUNT = 7;

    // B区域排水单元个数
    public static  final Integer  B_AREA_VILLAGE_UNIT_COUNT = 7;

    // C区域排水单元个数
    public static  final Integer  C_AREA_VILLAGE_UNIT_COUNT = 9;

    // D区域排水单元个数
    public static  final Integer  D_AREA_VILLAGE_UNIT_COUNT = 15;

    // E区域排水单元个数
    public static  final Integer  E_AREA_VILLAGE_UNIT_COUNT = 4;

    // F区域排水单元个数
    public static  final Integer  F_AREA_VILLAGE_UNIT_COUNT = 27;

    // G区域排水单元个数
    public static  final Integer  G_AREA_VILLAGE_UNIT_COUNT = 4;
}
