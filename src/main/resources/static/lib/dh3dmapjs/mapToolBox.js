
/**
  @param {*} viewer 
 * 地图工具模块
 */
//量算进行初始化
var measureSurface;
function init_make_measure(viewer, label) {
    measureSurface = new gsp3d.Measure({

        viewer: viewer,
        removeScreenSpaceEvent: true,
        label: label
    });

}
//空间距离
function make_measure_length() {
    measureSurface.measuerLength({ terrain: false });

}
//贴地距离
function make_measure_tiedi_length() {
    measureSurface.measuerLength({ terrain: true });
}
//面积测量
function make_measure_area() {
    measureSurface.measureArea();
}

//方位角
function make_measure_Angle() {
    measureSurface.measureAngle();
}
//高度差
function make_measure_eHeight() {
    measureSurface.measureHeight({ isSuper: false });
}


//三角测量
function make_measure_trigon() {
    measureSurface.measureHeight({ isSuper: true });
}
//清除
function clear_draw() {
    measureSurface.clearMeasure();
}
/**
 * 地图工具模块
 */
//框选数据
function draw_polygon_data() {
    viewer.gsp.centerAt({
        "y": 29.877073, "x": 121.539334, "z": 57.23, "heading": 195.7, "pitch": -20.2, "roll": 360//坐标位置
    }, 0);

    var url = 'http://69.234.224.124:9000/qxsy/tileset.json';//模型地址
    var extent = gsp3d.point.getExtent(viewer);
    $.ajax({
        url: url,
        data: {
            "xmin": extent.xmin,
            "ymin": extent.ymin,
            "xmax": extent.xmax,
            "ymax": extent.ymax,
            "count": 100
        },
        type: "get",
        dataType: 'json',
        //   contentType: "application/x-www-form-urlencoded",
        success: function (data) {
            addData(data.data)
        },
        error: function (data) {
            console.log("请求出错(" + data.status + ")：" + data.statusText);
        }
    });
}
var arrEntity = [];
var selectEntity = [];

function addData(arr) {

    for (var i = 0, len = arr.length; i < len; i++) {
        var item = arr[i];
        //添加实体
        var entity = viewer.entities.add({
            name: item.name,
            position: Cesium.Cartesian3.fromDegrees(item.x, item.y, 0),
            billboard: {
                image: 'http://69.234.224.124:7003/Esvsample/img/marker/mark3.png',
                scale: 0.8,
                horizontalOrigin: Cesium.HorizontalOrigin.CENTER,//高度相对于中心位置
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,//垂直位置
                heightReference: Cesium.HeightReference.RELATIVE_TO_GROUND,
            },
            tooltip: item.name,
            data: item,
        });
        arrEntity.push(entity);
    }
    return arrEntity;
}

//在范围内的改变图标为红色
function updateSelect(entity) {
    entity.billboard.image = 'http://69.234.224.124:7003/Esvsample/img/marker/mark1.png';
    selectEntity.push(entity);
}
function clearDraw() {
    viewer.gsp.draw.clearDraw();
    // for (var i = 0; i < selectEntity.length; i++) {
    //     selectEntity[i].billboard.image = 'http://69.234.224.124:7003/Esvsample/img/marker/mark3.png';
    // }
    selectEntity = [];
}
function draw_redpolygon(style) {
    clearDraw();
    viewer.gsp.draw.startDraw({
        type: "polygon",
        style: style,
        success: function (entity) {
            var poly = viewer.gsp.draw.toGeoJSON(entity);
            for (var i = 0; i < arrEntity.length; i++) {
                var entity = arrEntity[i];
                var pt = gsp3d.draw.attr.billboard.toGeoJSON(entity);
                var isInArea = turf.booleanPointInPolygon(pt, poly); //turf插件计算的
                if (isInArea) {
                    updateSelect(entity);
                }
            }
        }
    });
}

/**
 * 地图工具模块
 */
//鼠标事件简单处理
function  mouseClick() {
    viewer.gsp.centerAt({"y":31.808241,"x":117.224601,"z":4071.32,"heading":356.7,"pitch":-61,"roll":360});
}



