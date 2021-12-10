/**
 * 2021-11-10 Wangchong
 * 设施设备管理中繁易屏数据渲染格式,历史记录中也用到
 */
var limitArray = [5, 10, 20, 50, 100]
// 雨水监测点数据
var rainMonitorFlexDataTableRenderJsonObject = {
    elem: '#flexemDataTable'
    ,url: 'getRainMonitorFlexDataList' //数据接口
    ,where:{}
    ,skin: 'nob'// 无边框风格
    ,method: "post"
    ,even: true //开启隔行背景
    ,page:true
    ,limits:limitArray
    ,height: 'full-190'
    ,event:true
    , contentType: 'application/json'
    , cols: [
        [ //表头
            {field: 'id', title: 'ID', width: 80, sort: true, hide: true},
            {field: 'No.', title: '序号', width: 80, type:'numbers' }
            , {field: 'boxNo', title: '繁易屏编号', align: "center", sort: true, width: 200}
            , {field: 'waterTemperature', title: '水温(℃)', event: 'row', align: 'center'}
            , {field: 'ammoniaNitrogen', title: '氨氮(mg/L)', event: 'row', align: 'center', width: 80}
            , {field: 'cod', title: '化学需氧量(mg/L)', event: 'row', align: 'center', width: 140}
            , {field: 'conductivity', title: '电导率(S/m)', event: 'row', align: 'center'}
            , {field: 'ph', title: '酸碱度', event: 'row', align: 'center'}
            , {field: 'turbidity', title: '浊度(NTU)', event: 'row', align: 'center'}
            , {field: 'flexemTimeStamp', title: '消息时间', event: 'row', align: 'center', width: 200}
        ]
    ]
    , done: function (res, curr, count) {

    }
}

// 污水监测点数据
var sewageMonitorFlexDataTableRenderJsonObject = {
    elem: '#flexemDataTable'
    ,url: 'getSewageMonitorFlexDataList' //数据接口
    ,where:{}
    ,skin: 'nob'// 无边框风格
    ,method: "post"
    ,even: true //开启隔行背景
    ,page:true
    ,limits:limitArray
    ,height: 'full-50'
    ,event:true
    , contentType: 'application/json'
    , cols: [
        [ //表头
            {field: 'id', title: 'ID', width: 80, sort: true, hide: true},
            {field: 'No.', title: '序号', width: 80, type:'numbers' }
            , {field: 'boxNo', title: '繁易屏编号', align: "center", sort: true, width: 200}
            , {field: 'waterTemperature', title: '水温(℃)', event: 'row', align: 'center'}
            , {field: 'liquidLevel', title: '液位(m)', event: 'row', align: 'center', width: 80}
            , {field: 'ammoniaNitrogen', title: '氨氮(mg/L)', event: 'row', align: 'center', width: 80}
            , {field: 'cod', title: '化学需氧量(mg/L)', event: 'row', align: 'center', width: 140}
            , {field: 'conductivity', title: '电导率(S/m)', event: 'row', align: 'center'}
            , {field: 'ph', title: '酸碱度', event: 'row', align: 'center'}
            , {field: 'turbidity', title: '浊度(NTU)', event: 'row', align: 'center'}
            , {field: 'currentFlow', title: '流量(m³/h)', event: 'row', align: 'center'}
            , {field: 'flexemTimeStamp', title: '消息时间', event: 'row', align: 'center', width: 200}
        ]
    ]
    , done: function (res, curr, count) {

    }
}

// 泵站数据
var pumpStationFlexDataTableRenderJsonObject = {
    elem: '#flexemDataTable'
    ,url: 'getPumpStationFlexDataList' //数据接口
    ,where:{}
    ,skin: 'nob'// 无边框风格
    ,method: "post"
    ,even: true //开启隔行背景
    ,page:true
    ,limits:limitArray
    ,height: 'full-190'
    ,event:true
    , contentType: 'application/json'
    , cols: [
        [ //表头
            {field: 'id', title: 'ID', width: 80, sort: true, hide: true},
            {field: 'No.', title: '序号', width: 80, type:'numbers' }
            , {field: 'boxNo', title: '繁易屏编号', align: "center", sort: true, width: 200}
            , {field: 'waterTemperature', title: '水温(℃)', event: 'row', align: 'center'}
            , {field: 'ammoniaNitrogen', title: '氨氮(mg/L)', event: 'row', align: 'center', width: 80}
            , {field: 'cod', title: '化学需氧量(mg/L)', event: 'row', align: 'center', width: 140}
            , {field: 'conductivity', title: '电导率(S/m)', event: 'row', align: 'center'}
            , {field: 'ph', title: '酸碱度', event: 'row', align: 'center'}
            , {field: 'turbidity', title: '浊度(NTU)', event: 'row', align: 'center'}
            , {field: 'pumpSumpLevel', title: '泵池液位(m)', event: 'row', align: 'center'}
            , {field: 'outletTankLiquidLevel', title: '出水池液位(m)', event: 'row', align: 'center'}
            , {field: 'outletTankLiquidLevel', title: '出水瞬时流量(m3/h)', event: 'row', align: 'center'}
            , {field: 'flexemTimeStamp', title: '消息时间', event: 'row', align: 'center', width: 200}
        ]
    ]
    ,done: function (res, curr, count) {

    }
}