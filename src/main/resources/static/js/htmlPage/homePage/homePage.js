
var layuiLayer;

layui.use(['layer'], function () {
    layuiLayer = layui.layer;
})

/**
 * 显示水平衡信息页面
 * @date 2021-11-27 11:30
 * @author Wangchong
 */
function showWaterBalanceDetail() {
    layuiLayer.open({
        type: 2,
        title:'水平衡信息',
        area:['1000px', '800px'],
        content:'waterBalancePage'
    })
}

<!--管道查看-->
var allPoint = [];              //系统分布--所有点位集合
var allPipeline = [];           //系统分布--所有管线集合
var allCheckedPoint = [];       //系统分布--所有选中点位集合
var allCheckedPipeline = [];    //系统分布--所有选中管线集合
var netWorkArray = [];

function selectTreeCheckBox(data) {
    console.info(data);
    for (var i = 0; i < data.length; i++) {
        if (data[i].iconCls == "my-tree-icon-3" && data[i].text == "雨水井") {
            console.info(data[i]);
            var node = $('#networkTree').tree('find', data[i].id);
            console.info(node);
            $('#networkTree').tree('check', node.target);
        }
        var childTree = data[i].children;
        console.info(childTree);
        if (childTree != null && childTree.length > 0) {
            selectTreeCheckBox(childTree);
        }
    }

}

function restartDrawSystemTree(rootText, checkedState, checkedText, netWorkArray) {
    console.info("rootText:" + rootText + "  checkedState:" + checkedState + "  checkedText:" + checkedText + "  netWorkArray:" + netWorkArray)
    drawPoints(allCheckedPoint, netWorkArray);
    drawPipeline(allCheckedPipeline);
}

