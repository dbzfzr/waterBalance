/**
 * 创建日常维护记录页面 js
 * @author Wangchong
 * @date 202110261652
 */
var table, layer;
var tableIndex;

// 区划名称
var organizeName;

// 人员信息数组
// var operationPersonArray = [
//     {'userName': '张三', 'phone': '18888888888', 'id': 1},
//     {'userName': '李四', 'phone': '18888888888', 'id': 2},
//     {'userName': '王五', 'phone': '18888888888', 'id': 3}
// ]
// var selectedOperationPersonIdArray = []
// var noSelectedOperationPersonArray = [];

// function delOperationPeople(obj) {
//     var tr = $(obj).parent().parent();
//     tr.remove();
// }
layui.use(['table', 'form', 'layer', 'laydate'], function () {
    table = layui.table;
    layer = layui.layer;

    var form = layui.form;
    var laydate = layui.laydate;

    laydate.render({
        elem: '#timeSelect' //指定元素
        , type: 'datetime'
        , trigger: 'click'
        // ,range: '~'
        , max: DateUtil.dateformat(new Date(), "yyyy-MM-dd HH:mm:ss")
        , done: function (value, date, endDate) {
        }
        , change: function (value, date, endDate) {
        }
    });

    // function renderOperationPersonTable(){
    //     //直接赋值数据
    //     table.render({
    //         elem: '#operationPersonTable'
    //         , cols: [[ //标题栏
    //             {type: 'checkbox', LAY_CHECKED: false}
    //             , {field: 'id', title: 'id', width: 80}
    //             , {field: 'userName', title: '用户名', width: 120}
    //             , {field: 'phone', title: '手机号码', width: 150}
    //         ]]
    //         , data: noSelectedOperationPersonArray
    //         , skin: 'row' //表格风格
    //         , even: true
    //         , page: false
    //     });
    //
    // }

    // 运维人员弹窗索引
    var layerIndex;

    // 添加人员点击
    // $("#addOperationPeople").click(function () {
    //     noSelectedOperationPersonArray = [];
    //     var selected = false;
    //
    //     var trs = $("#operationPeopleTable tr");
    //
    //     for (var i=0; i<trs.length; i++){
    //         selectedOperationPersonIdArray.push($(trs[i]).children("td").get(0).innerHTML);
    //     }
    //     console.log(selectedOperationPersonIdArray);
    //
    //     for (var j = 0; j < operationPersonArray.length; j++) {
    //         for (var i = 0; i < selectedOperationPersonIdArray.length; i++) {
    //             if (operationPersonArray[j].id == selectedOperationPersonIdArray[i]){
    //                 selected = true;
    //                 break;
    //             }
    //         }
    //
    //         if (!selected){
    //             noSelectedOperationPersonArray.push(operationPersonArray[j]);
    //         }
    //         selected = false;
    //     }
    //
    //     selectedOperationPersonIdArray = [];
    //     renderOperationPersonTable();
    //     layerIndex = layer.open({
    //         type: 1,
    //         title: '添加人员',
    //         area: ['468px', '240px'],
    //         content: $("#operationPersonSelectBlock")
    //     })
    // })

    // 确定添加人员
    // $("#submitAddOperationPerson").click(function () {
    //
    //     var data = table.checkStatus('operationPersonTable').data;
    //
    //     if (data.length == 0) {
    //         return;
    //     }
    //
    //     layer.close(layerIndex);
    //
    //     for (var i = 0; i < data.length; i++) {
    //         var operationPeopleTable = $("#operationPeopleTable");
    //
    //         var tr = "<tr><td>" + data[i].id + "</td><td>" + data[i].userName + "</td><td>" + data[i].phone + "</td><td><button onclick='delOperationPeople(this)'><i class='layui-icon'>&#xe640;</i></button></td></tr>";
    //         operationPeopleTable.append(tr);
    //     }
    // })

    // 确定添加日常维护记录
    $("#submit").click(function () {
        //点位
        var boxNo = $("#pointSelect").val();
        if (boxNo == ""){
            layer.msg("请选择点位");
            return;
        }

        var organizationCode = $("#organizationCode").val();
        var organizationName = $("#organizationCode option:selected").text()

        var createTime = $("#timeSelect").val();
        if (createTime == ""){
            layer.msg("请选择时间");
            return;
        }
        var userArray = [];

        debugger
        // 人员
        var operationPeopleTableTrs = $("#operationPeopleTable tr");
        for (var i=0; i<operationPeopleTableTrs.length; i++){
            var tds = $(operationPeopleTableTrs[i]).children("td");
            var userJson = {};
            userJson.userName = tds.get(0).innerHTML;
            userJson.phone = tds.get(1).innerHTML;
            userJson.userId = tds.get(2).innerHTML;

            userArray.push(userJson);
        }

        // 维护项
        var trs = $("#infoTable tr");
        var maintenanceArray = [];
        var tds;
        var td;

        for (var i = 1; i < trs.length; i++) {
            tds = $(trs[i]).children("td");
            var maintenanceObj = {};

            var td1Str = tds.get(1).innerHTML;
            if (td1Str == ""){
                continue;
            }
            maintenanceObj.maintenanceItem = td1Str;

            var td3Str = tds.get(3).innerHTML;
            if (td3Str == ""){
                continue;
            }
            maintenanceObj.maintenanceContent = tds.get(3).innerHTML;

            // 单选内容
            td = $(tds.get(2));
            if (true == $(td.children("input").get(1)).prop('checked')) {
                maintenanceObj.state = "故障";
            } else {
                maintenanceObj.state = "正常";
            }
            maintenanceArray.push(maintenanceObj)
        }

        if (maintenanceArray.length == 0){
            layer.msg("请添加维护项");
            return;
        }
         var paramJson = {createTime:createTime, organizationCode: organizationCode, organizationName: organizationName,
         userArrayStr: JSON.stringify(userArray), userId: userArray[0].userId, maintenanceArrayStr: JSON.stringify(maintenanceArray),
                  boxNo: boxNo};
        $.ajax({
            url: 'addRoutineMaintenance',
            type: 'post',
            contentType: 'application/json;charset=utf-8;',
            data: JSON.stringify(paramJson),
            success:function (res) {
                if (res.code > 0){
                    layer.msg("添加成功");
                    parent.tableIndex.reload();
                }else{
                    layer.msg("添加失败");
                }
            },
            error:function (res) {
                console.log(res)
                layer.msg("添加失败")
            }
        });
    })
});

var tableRecordIndex = 1;
var tableRecordId = 1;

// 取消
function resertEditTd(obj) {
    $(obj).parent().parent().remove();
    resetRecordNo();
}

// 重置序号
function resetRecordNo() {
    var trs = $("#infoTable tr");

    for (var i = 1; i < trs.length; i++) {
        var tr = $(trs[i]);
        tr.children("td").get(0).innerHTML = i;
    }
}

// 编辑当前行
function editTd(obj) {
    var tr = $(obj).parent().parent();
    // 维护项
    var td1 = $(tr.children("td").get(1));

    var td1Value = td1.html();

    var td1Input = "<input type='text' class='layui-input' value = '" + td1Value + "'/>";
    td1.empty();
    td1.html(td1Input);

    // 状态
    var td2 = $(tr.children("td").get(2));

    td2.children('input').get(0).disabled = false;
    td2.children('input').get(1).disabled = false;

    // 维护内容
    var td3 = $(tr.children("td").get(3));
    var td3Value = td3.html();
    var td3Input = "<input type='text' class='layui-input' value = '" + td3Value + "'/>";
    td3.empty();
    td3.append(td3Input);


    var tdParent = $(obj).parent();
    $(obj).remove();
    var btn = "<button onclick='confirmAdd(this)'>确定</button>";
    tdParent.prepend(btn);
}

// 删除td
function delTd(obj) {
    $(obj).parent().parent().remove();
    resetRecordNo();
}

// 编辑或者修改时确认
function confirmAdd(obj) {
    var tr = $(obj).parent().parent();

    // 维护项
    var td1 = $(tr.children("td").get(1));

    td1.html(td1.children('input').get(0).value);

    // 状态
    var td2 = $(tr.children("td").get(2));
    td2.children('input').get(0).type.disabled = true;
    td2.children('input').get(1).type.disabled = true;

    // 维护内容
    var td3 = $(tr.children("td").get(3));

    td3.html(td3.children('input').get(0).value);

    var tdParent = $(obj).parent();
    tdParent.empty();

    var btns = "<button onclick='editTd(this)'>修改</button> <button onclick='delTd(this)'>删除</button> ";
    tdParent.append(btns);

}
// 新建一行
$("#addNew").click(function () {
    var infoTable = $("#infoTable");

    var trs = $("#infoTable tr");
    var tr;
    if (trs.length % 2 == 0) {
         tr = "<tr>";//style='background-color: rgba(0, 110, 255, 0.5)'
    } else {
        tr = "<tr>";
    }
    tr = tr + "<td>" + trs.length + "</td><td><input type='text' class='layui-input' style='background-color: #E6E7E9'/></td>" +
        "<td><input type='radio' name ='state" + tableRecordId + "'value='正常'>正常</><input type='radio' name ='state" + tableRecordId + "'value='故障'>故障</></td>" + "<td><input type='text' class='layui-input'style='background-color: #E6E7E9'/></td>";

    tr = tr + "<td><button onclick='confirmAdd(this)'>确定</button><button onclick='resertEditTd(this)'>取消</button></td>";
    tr = tr + "</tr>";

    infoTable.append(tr);
    tableRecordIndex++;
    tableRecordId++;
})


