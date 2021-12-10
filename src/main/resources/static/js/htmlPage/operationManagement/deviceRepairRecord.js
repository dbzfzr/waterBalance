/**
 * 设备维修记录页面 js
 * @author Wangchong
 * @date 202112031103
 */
var table,layer;
var tableIndex;

layui.use(['table',  'layer', 'laydate'], function () {
    table = layui.table;
    layer = layui.layer;

    var laydate = layui.laydate;

    tableIndex = table.render({
        elem: '#infoTable'
        , url: 'selectDeviceRepairRecordList' //数据接口
        ,defaultToolbar:["filter", "exports", "print"]//头部工具栏右侧图标 筛选图标 导出图标 打印图标
        ,where:{}
        , page: true // 开启分页
        ,skin: 'nob'// 无边框风格
        , method: "post"
        ,height: 'full-100'
        ,even: true // 开启隔行背景
        ,limits:[5, 10, 20]
        ,event:true
        , contentType: 'application/json'
        , cols: [
            [ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, hide: true},
                {field: 'No.',fixed:'left', title: '序号', width: 80, type:'numbers'}
                , {field: 'createTime', title: '时间',width: 200,sort:true,align:"center"}
                , {field: 'organizationName', title: '区划',width:130,sort:true,align:"center"}
                , {field: 'boxAlias', title: '点位', align: "center", sort: true, width: 320 }
                , {field: 'userArrayStr', title: '人员', event: 'row', align: 'center', width:200,sort:true,align:"center",templet:function (res) {
                    var user = JSON.parse(res.userArrayStr)[0];
                    return user.userName;
                } }
                , {field: 'breakdownDescription', title: '故障情况描述', align: "center", sort: true, width: 200 }
                , {field: 'repairDescription', title: '维修/处理情况', align: "center", sort: true, width: 200 }
                , {field: 'remark', title: '遗留问题或其他需说明的情况', align: "center", sort: true, width: 300 }
                , {fixed:'right', toolbar: '#recordBar',title:'操作',align:"center",width:200}
            ]
         ]
        ,done: function (res, curr, count) {
        }
    });

    // 操作栏事件
    table.on('tool(infoTable)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        switch (layEvent) {
            case 'view':
                viewInfo(data);
                break;
        }
    });
    //双控件
    laydate.render({
        elem: '#timeSelect' //指定元素
        ,type: 'datetime'
        ,trigger: 'click'
        ,max: DateUtil.dateformat(new Date(),"yyyy-MM-dd 23:59:59")
        ,done: function(value, date, endDate){
        }
        ,change: function(value, date, endDate){
        }
    });

    $("#add").click(function () {
        layer.open({
            type: 2,
            area: ['800px', '600px'],
            title:'新建设备维护记录',
            content:'addDeviceRepairRecordPage'
        })
    });

    function viewInfo(data) {
        $("#timeTd").html(data.createTime)
        $("#orgTd").html(data.organizationName)
        var user = JSON.parse(data.userArrayStr)[0];

        $("#userTd").html(user.userName);
        $("#boxAliasTd").html(data.boxAlias);
        $("#breakdownDescriptionTd").html(data.breakdownDescription);
        $("#repairDescriptionTd").html(data.repairDescription);
        $("#remarkTd").html(data.remark);

        layer.open({
            type: 1,
            content: $("#detailDiv"),
            title: "设备维修记录详情",
            area:["540px", '450px'],

        })
    }
});