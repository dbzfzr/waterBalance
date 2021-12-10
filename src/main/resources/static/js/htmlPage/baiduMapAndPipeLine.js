/**
 * 驾驶舱页面和综合查询页面百度地图和管网绘制，点位绘制，管道查看，设施设备查看的js
 * @author Wangchong
 * @date 20211129
 */
// 污水管道线数组
var sewagePipeLineArray = [];
// 污水管网点位覆盖物数组
var sewagePointOverlayArray = [];
// 污水监测点
var sewageMonitorArray = [];
// 泵站数组
var pumpStationArray = [];

// 雨水管道线数组
var rainPipeLineArray = [];
// 雨水管网点位覆盖物数组
var rainPointOverlayArray = [];
// 雨水监测点
var rainMonitorArray = [];

//隔油池点位
var oilSeparatorArray = [];

// 百度地图开始
var map = new BMapGL.Map("container");

// var point = new BMapGL.Point(120.20769107795724, 30.183872266995300);//创建点坐标，不一定是点坐标，要看设置
var point = new BMapGL.Point(120.185116, 30.200322);//创建点坐标，不一定是点坐标，要看设置

map.centerAndZoom(point, 18);//设置中心点（确定中心点坐标）

map.setTilt(0);       //设置地图的倾斜角度
// 指定定位位置。
// 当标注显示在地图上时，其所指向的地理位置距离图标左上
// 角各偏移10像素和25像素。您可以看到在本例中该位置即是
// 图标中央下端的尖角位置。
anchor: new BMapGL.Size(10, 25)
// 设置图片偏移。
// 当您需要从一幅较大的图片中截取某部分作为标注图标时，您
// 需要指定大图的偏移位置，此做法与css sprites技术类似。
//imageOffset: new BMapGL.Size(0, 0 - 25)   // 设置图片偏移
//});
//marker.setIcon(myIcon)

map.enableScrollWheelZoom(true);//在PC端可以通过滚轮放大缩小地图，移动端关闭该功能

var mapStyle = {
    features: ["road", "building", "water", "land", "highway"],//隐藏地图上的poi
    style: "dark"
}

map.setMapStyleV2({
    styleId: '95f38494b1f5c7e070759907c618ff81'//自定义地图样式 hhp
    // 726af33cb58954d724aa45935732a562
});
var i = 0;
// 查询区域信息
var queryHouseOutline = function (hid, callback) {
    var baseURL = 'http://map.baidu.com/?reqflag=pcmap&coord_type=3&from=weBMapGL&qt=ext&ext_ver=new&l=18';
    var url = baseURL + "&uid=" + hid;
    callback && (window.queryHouseOutlineCallback = callback);
    $.ajax({
        type: "get",
        async: false,
        url: url,
        dataType: "jsonp",
        jsonpCallback: "queryHouseOutlineCallback",
        success: function (datas) {
        }
    });
};

/**
 * 模糊查询小区信息, 无返回值
 * @param {} house    小区名称
 * @param {} city    所属城市名称
 * @param {} ak        百度地图AK
 * @param {} callback    回调函数，该函数可以接收到请求的返回值
 */
var queryHouse = function (house, city, ak, callback) {
    var baseURL = 'http://api.map.baidu.com/place/v2/search?';
    var url = baseURL + "&query=" + house + "&region=" + city + "&output=json&ak=" + ak;

    console.log(url)
    callback && (window.queryHouseCallback = callback);
    $.ajax({
        type: "get",
        async: false,
        url: url,
        dataType: "jsonp",
        jsonpCallback: "queryHouseCallback",
        success: function (datas) {
        }
    });
};

/**
 * 墨卡托坐标转百度坐标 baidu jsapi WebGL 版本使用
 * @param {} coordinate
 * @return {}
 */
var coordinateToPoints = function (map, coordinate) {
    var points = [];
    if (coordinate) {
        var arr = coordinate.split(";");
        if (arr) {
            for (var i = 0; i < arr.length; i++) {

                var coord = arr[i].split(",");
                if (coord && coord.length == 2) {
                    var lngLat = map.mercatorToLnglat(coord[0], coord[1]);
                    points.push(new BMapGL.Point(lngLat[0], lngLat[1]));
                }
            }
        }
    }
    return points;
};
/**
 * 墨卡托坐标解析
 * @param {} mocator
 * @return {}
 */
var parseGeo = function (mocator) {
    if (typeof mocator != 'string') {
        return {};
    }
    var t = mocator.split("|");
    var n = parseInt(t[0]);
    var i = t[1];
    var r = t[2];
    var o = r.split(";");
    if (n === 4) {
        for (var a = [], s = 0; s < o.length - 1; s++) {
            "1" === o[s].split("-")[0] && a.push(o[s].split("-")[1]);
        }
        o = a;
        o.push("");
    }
    var u = [];
    switch (n) {
        case 1:
            u.push(o[0]);
            break;
        case 2:
        case 3:
        case 4:
            for (var s = 0; s < o.length - 1; s++) {
                var l = o[s];
                if (l.length > 100) {
                    l = l.replace(/(-?[1-9]\d*\.\d*|-?0\.\d*[1-9]\d*|-?0?\.0+|0|-?[1-9]\d*),(-?[1-9]\d*\.\d*|-?0\.\d*[1-9]\d*|-?0?\.0+|0|-?[1-9]\d*)(,)/g,
                        "$1,$2;");
                    u.push(l);
                } else {
                    for (var c = [], d = l.split(","), f = 0; f < d.length; f += 2) {
                        var p = d[f];
                        var h = d[f + 1];
                        c.push(p + "," + h);
                    }
                    u.push(c.join(";"))
                }
            }
            break;
        default:
            break;
    }

    if (u.length <= 1) {
        u = u.toString();
    }

    var result = {
        type: n,
        bound: i,
        points: u
    };
    return result;
};
var tempPly;
/**
 * 第一个参数是城市名，第二参数是小区名
 */
var showArea = function (city, area) {
    queryHouse(area, city, "GFoKC0MaH0l4iCj6bNKZedu5fCPkEXWe", function (data) {
        console.log(data)
        if (data.message == 'ok') {
            var houses = data.results;
            if (houses && houses.length > 0) {
                var house = houses[0];

                queryHouseOutline(house.uid, function (houseOutline) {

                    console.log(houseOutline)
                    var geo = houseOutline.content.geo;
                    var location = house.location;
                    var point = new BMapGL.Point(location.lng, location.lat);
                    //map.centerAndZoom(point, 19);
                    var marker = new BMapGL.Marker(point);
                    marker.setIcon(myIcon);
                    //marker.setAnimation(BMapGL_ANIMATION_BOUNCE);
                    var label = new BMapGL.Label(area, {
                        offset: new BMapGL.Size(0, 0),
                    });
                    marker.setLabel(label);
                    map.addOverlay(marker);
                    if (!geo) {
                    } else {
                        var geoObj = parseGeo(geo);
                        //var bounds = coordinateToPoints(geoObj.bound);
                        //边界点
                        var points = coordinateToPoints(map, geoObj.points);
                        var prism = new BMapGL.Prism(points, 100, {
                            topFillColor: '#064360',
                            topFillOpacity: 0.5,
                            sideFillColor: '#188C8E',
                            sideFillOpacity: 0.8
                        });
                        tempPly = prism;
                        map.addOverlay(prism); //添加覆盖物
                        map.setViewport(prism.getPath()); //调整视野
                    }
                });
            }
        }
    });
};

// 获取行政区域
var boundary = new BMapGL.Boundary()
var prism;

function getDistrict(district) {
    boundary.get(district, function (data) {
        console.log(data)
        var boundaries = data.boundaries[0].split(";");
        var points = [];
        var locationStr;
        for (var i = 0; i < boundaries.length; i++) {
            locationStr = boundaries[i];
            var point = new BMapGL.Point(locationStr.substring(0, locationStr.indexOf(",")), locationStr.substring(locationStr.indexOf(",") + 1));//创建点坐标，不一定是点坐标，要看设置
            points[i] = point;
        }

        prism = new BMapGL.Prism(points,//底面坐标数组
            1000,//高度
            {
                topFillColor: '#6BBAFF',    //顶面填充颜色
                topFillOpacity: 0.5,          //顶面填充颜色透明度，取值范围0-1
                sideFillColor: '#20467C',   //	侧面填充颜色
                sideFillOpacity: 0.9,       //侧面填充颜色透明度，取值范围0-1
                enableMassClear: true        //是否在调用map.clearOverlays清除此覆盖物，默认为true
            });

        map.addOverlay(prism); //添加覆盖物
    });
}
// 百度地图结束

// 点位标记数组
var marker = [];
// 管网点位数组
var initialNetworkPoints = [];

function showAlarmInfoDiv() {
    $("#alarmInfoDiv").removeClass("hide");
    $("#networkPointInfoDiv").addClass("hide");
    $("#flexemDataDiv").addClass("hide");
}

// 显示点位信息框
function showPointInfoDiv() {
    $("#alarmInfoDiv").addClass("hide");
    $("#networkPointInfoDiv").removeClass("hide");
    $("#flexemDataDiv").addClass("hide");
}

//显示管线信息框
function showPipelineInfoDiv() {
    $("#alarmInfoDiv").addClass("hide");
    $("#networkPipelineInfoDiv").removeClass("hide");

}

//显示繁易屏设备信息框
function showFlexemDataDiv() {
    $("#alarmInfoDiv").addClass("hide");
    $("#networkPointInfoDiv").addClass("hide");
    $("#flexemDataDiv").removeClass("hide");
}

var threeInfoWindowsSizeArray = [520, 400];
var twoInfoWindowsSizeArray = [360, 400];
/**
 * @date 20211113
 * @author Wangchong 绘制管网点位
 * @param res
 */
function drawNetworkPoint(res) {
    console.log("绘制点")
    marker = [];

    var pointIconImage;

    $.each(res, function (index, item) {
        var pointIcon;
        var opts = {
            title: item.boxAlias != null ? item.boxAlias : '点位信息', // 信息窗口标题
            enableMessage: true, //设置允许信息窗发送短息
            message: ""
        }

        var text = "<div id='networkPointInfoDiv' class='hide' style='color:#fafafa;position:absolute;top: 40px;left: 1vw'>" +
            "<table cellspacing='1' style='text-align: center;'>";
        text = text + "<tr><td>管网点位编号</td>" + "<td>" + item.pointNo + "</td></tr>";
        text = text + "<tr><td style='width: 150px'>管网点位名称</td>" + "<td>" + item.pointName + "</td></tr>";
        text = text + "<tr><td>管网类型</td>" + "<td>" + item.networkType + "</td></tr>";
        // text = text + "<tr><td>管网等级</td>" + "<td>" + item.networkLevel + "</td></tr>";
        text = text + "<tr><td>管网点位类型</td>" + "<td>" + item.pointType + "</td></tr>";
        text = text + "<tr><td>管网点位系统类型</td>" + "<td>" + item.systemType + "</td></tr>";
        // text = text + "<tr><td>管网材质</td>" + "<td>" + item.material + "</td></tr>";
        //
        // text = text + "<tr><td>管网规格(mm)</td>" + "<td>" + item.specs + "</td></tr>";
        // text = text + "<tr><td>管网顶高程(m)</td>" + "<td>" + item.topDepth + "</td></tr>";
        // text = text + "<tr><td>管网底高程(m)</td>" + "<td>" + item.bottomDepth + "</td></tr>";
        // text = text + "<tr><td>管网竣工日期</td>" + "<td>" + item.completionDate + "</td></tr>";
        text = text + "<tr><td>所属区域</td>" + "<td>" + item.addressName + "</td></tr></table></div>";

        var popupContentHtml;
        var haveDevice = false;
        // 报警点位有设备
        if (item.alarmRecordId != null && item.alarmRecordId != undefined) {
            haveDevice = true;
            pointIconImage = "../image/homePage/alarm.gif";
            pointIcon = new BMapGL.Icon(pointIconImage, new BMapGL.Size(32, 32));
            popupContentHtml = "<div class=\"navigation-bar\">\n" +
                "    <ul id=\"nav\">\n" + "<li onclick='showAlarmInfoDiv()'><a href=\"javascript:;\" '>事件详情</a></li>\n" +
                "        <li onclick='showFlexemDataDiv()'><a href=\"javascript:;\" >设备数据</a></li>\n" +
                "        <li onclick='showPointInfoDiv()'><a href=\"javascript:;\" >点位数据</a></li>\n" +
                "    </ul>\n" +
                "</div>";

            popupContentHtml = popupContentHtml + "<div id='alarmInfoDiv' style='height:330px;'><iframe style='width: 100%;height:100%;border:none;' src='alarmInfoPage?alarmId=" + item.alarmRecordId + "'></iframe></div>";
            popupContentHtml = popupContentHtml + text + "<div id='flexemDataDiv' class='hide' style='height:330px;'>";

            opts.width = threeInfoWindowsSizeArray[0];
            opts.height = threeInfoWindowsSizeArray[1];

            if (item.systemType == '油水分离器') {

            } else if (item.systemType == '雨水监测点') {

            } else if (item.systemType == '泵站') {

            } else if (item.systemType == '雨污分流器') {

            } else if (item.systemType == '污水监测点') {
                popupContentHtml = popupContentHtml + "<iframe style='width: 100%;height:100%;border:none;' src='sewageMonitorFlexDataPage?boxNo=" + item.boxNo + "'></iframe>";
            } else {
            }
            popupContentHtml = popupContentHtml + "</div>";
        } else {
            // 有设备
            if (item.boxNo != null && item.boxNo != undefined) {
                popupContentHtml = "<div class=\"navigation-bar\">\n" +
                    "       <ul id='nav'> <li onclick='showFlexemDataDiv()'><a href=\"javascript:;\" >设备数据</a></li>\n" +
                    "        <li onclick='showPointInfoDiv()'><a href=\"javascript:;\" >点位数据</a></li>\n" +
                    "    </ul>\n" +
                    "</div>";
                haveDevice = true;

                opts.width = twoInfoWindowsSizeArray[0];
                opts.height = twoInfoWindowsSizeArray[1];
            } else {
                if (item.systemType != "无") {// 点位有设备还未安装设备
                    haveDevice = true;
                } else {// 无设备

                    // //因为实际点击marker获取的经度比数据库中的小0.0000000007，所以在设置时先加0.000001，保证marker点击后获取的经纬度与数据库中保存的地点经纬度相同
                    // var a = parseFloat(item.longitude);//parseFloat()函数可解析一个字符串，并返回一个浮点数。
                    // var point = new BMapGL.Point(a, item.latitude);
                    //
                    // marker[index] = new BMapGL.Marker(point);
                    // map.addOverlay(marker[index]);
                    //
                    // marker[index].addEventListener("click", function aaa() {
                    //     console.log("click," + item.pointNo)
                    // })//监听标注事件
                    return;
                }
            }

            // 有设备的点
            if (haveDevice) {
                popupContentHtml = popupContentHtml + text + "<div id='flexemDataDiv' style='height:330px;'>";

                if (item.systemType == '油水分离器') {
                    pointIconImage = "../image/map_point_icon/icon_yellow.png";
                } else if (item.systemType == '雨水监测点') {
                    pointIconImage = "../image/homePage/rainMonitor.png";
                } else if (item.systemType == '泵站') {
                    pointIconImage = "../image/homePage/pumpStation.png";
                } else if (item.systemType == '雨污分流器') {
                    pointIconImage = "../image/map_point_icon/icon_orange.png";
                } else if (item.systemType == '污水监测点') {

                    if (item.pointType == "污水一级管网出入口汇流井") {
                        pointIconImage = "../image/homePage/firstLevelSewageMonitor.png";
                    } else  if (item.pointType == "污水二级管网汇集总口"){
                        pointIconImage = "../image/homePage/secondLevelSewageMonitor.png";
                    }else{
                        pointIconImage = "../image/homePage/thirdLevelSewageMonitor.png";
                    }
                    popupContentHtml = popupContentHtml + "<iframe style='width: 100%;height:100%;border:none;' src='sewageMonitorFlexDataPage?boxNo=" + item.boxNo + "'></iframe>";
                } else {
                    pointIconImage = "../image/map_point_icon/icon_1.png";
                }
            }

            pointIcon = new BMapGL.Icon(pointIconImage, new BMapGL.Size(16, 16));
            opts.width = twoInfoWindowsSizeArray[0];
            opts.height = twoInfoWindowsSizeArray[1];

        }// else结束

        //因为实际点击marker获取的经度比数据库中的小0.0000000007，所以在设置时先加0.000001，保证marker点击后获取的经纬度与数据库中保存的地点经纬度相同
        var a = parseFloat(item.longitude);//parseFloat()函数可解析一个字符串，并返回一个浮点数。
        var point = new BMapGL.Point(a, item.latitude);

        marker[index] = new BMapGL.Marker(point, {icon: pointIcon});

        if (item.networkType == "雨水管网"){
            rainPointOverlayArray.push(marker[index])
        }

        if(item.networkType == "污水管网"){
            if(item.pointType == "隔油池"){
                oilSeparatorArray.push(marker[index])
            }else{
                sewagePointOverlayArray.push(marker[index])
            }
        }

        // 存储设备类型点位进数组
        if (item.systemType == '油水分离器') {
            oilSeparatorArray.push(marker[index])
        } else if (item.systemType == '雨水监测点') {
            rainMonitorArray.push(marker[index])
        } else if (item.systemType == '泵站') {
           pumpStationArray.push(marker[index])
        } else if (item.systemType == '雨污分流器') {

        } else if (item.systemType == '污水监测点') {
           sewageMonitorArray.push(marker[index])
        } else {
        }

        map.addOverlay(marker[index]);

        marker[index].addEventListener("click", function aaa() {
            var point = new BMapGL.Point(item.longitude, item.latitude);
            // 已经添加设设备的点位，点击弹出信息弹窗
            if (haveDevice && item.boxNo != null) {
            } else {// 有设备的点还未添加设备
                popupContentHtml = text.replace("hide", "");
                console.log("click," + item.pointNo);
            }
            var infoWindow = new BMapGL.InfoWindow(popupContentHtml, opts);
            map.openInfoWindow(infoWindow, point);
        });//监听标注事件
    })
}

/**
 * @date 20211113
 * @author Wangchong
 * 查询点位信息附带报警id，并绘制
 */
$.ajax({
    url: 'selectNetworkPointWithAlarmIdList',
    type: 'post',
    contentType: 'application/json',
    data: JSON.stringify({}),
    success: function (res) {

        $.each(res, function (index, item) {
            allCheckedPoint.push(item);
            initialNetworkPoints.push(item);
        })
        //console.log(initialNetworkPoints)
        drawNetworkPoint(initialNetworkPoints);
    }
})

function drawPoint(res, nodeArray) {
    marker = [];
    map.clearOverlays();//清空覆盖物

    $.each(res, function (index, item) {
        if (nodeArray != "" && nodeArray != null) {
            for (var i = 0; i < nodeArray.length; i++) {

                if (item.systemType == nodeArray[i].text) {
                    var pointIconImage;
                    if (item.systemType == '油水分离器') {
                        pointIconImage = "../image/map_point_icon/icon_yellow.png";
                    } else if (item.systemType == '雨水监测点') {
                        pointIconImage = "../image/homePage/rainMonitor.png";
                    } else if (item.systemType == '泵站') {
                        pointIconImage = "../image/homePage/pumpStation.png";
                    } else if (item.systemType == '雨污分流器') {
                        pointIconImage = "../image/map_point_icon/icon_orange.png";
                    } else if (item.systemType == '污水监测点') {
                        pointIconImage = "../image/map_point_icon/icon_green.png";
                    } else {
                        pointIconImage = "../image/map_point_icon/icon_1.png";
                    }
                    var pointIcon = new BMapGL.Icon(pointIconImage, new BMapGL.Size(10, 10));
                    //因为实际点击marker获取的经度比数据库中的小0.0000000007，所以在设置时先加0.000001，保证marker点击后获取的经纬度与数据库中保存的地点经纬度相同
                    var a = parseFloat(item.longitude);//parseFloat()函数可解析一个字符串，并返回一个浮点数。
                    var point = new BMapGL.Point(a, item.latitude);

                    marker[index] = new BMapGL.Marker(point, {icon: pointIcon});
                    map.addOverlay(marker[index]);

                    marker[index].addEventListener("click", function aaa() {
                        var text = "";
                        text = text + "管网点位编号：" + item.pointNo + "<br/>";
                        text = text + "管网类型：" + item.networkType + "<br/>";
                        text = text + "管网等级：" + item.networkLevel + "<br/>";
                        text = text + "管网点位类型：" + item.pointType + "<br/>";
                        text = text + "管网点位系统类型：" + item.systemType + "<br/>";
                        text = text + "管网材质：" + item.material + "<br/>";
                        text = text + "管网规格（mm）：" + item.specs + "<br/>";
                        text = text + "管网顶高程（m）：" + item.topDepth + "<br/>";
                        text = text + "管网底高程（m）：" + item.bottomDepth + "<br/>";
                        text = text + "管网竣工日期：" + item.completionDate + "<br/>";
                        text = text + "所属区域：" + item.addressName + "<br/>";
                        text = text + "所属地点经度(百度经纬度)：" + item.longitude.toString().substring(0, item.longitude.toString().indexOf(".") + 7) + "<br/>";
                        text = text + "所属地点纬度(百度经纬度)：" + item.latitude.toString().substring(0, item.latitude.toString().indexOf(".") + 7) + "<br/>";
                        var point = new BMapGL.Point(item.longitude, item.latitude);
                        var opts = {
                            width: 300, // 信息窗口宽度
                            height: 340, // 信息窗口高度
                            title: '<h4>设施信息</h4>', // 信息窗口标题
                            enableMessage: true, //设置允许信息窗发送短息
                            message: ""
                        }

                        var infoWindow = new BMapGL.InfoWindow(text, opts);
                        map.openInfoWindow(infoWindow, point);
                    });//监听标注事件
                }
            }
        }
    })
}

function drawPoints(res, netWorkArray) {
    marker = [];
    map.clearOverlays();//清空覆盖物

    // console.info(res)
    // console.info(netWorkArray)
    $.each(res, function (index, item) {
        if (netWorkArray != "" && netWorkArray != null) {
            for (var j = 0; j < netWorkArray.length; j++) {

                if (item.pointType == netWorkArray[j].text) {
                    var pointIconImage;
                    if (item.pointType == '隔油池') {
                        pointIconImage = "../image/map_point_icon/icon_yellow.png";
                    } else if (item.pointType == '雨水井') {
                        pointIconImage = "../image/map_point_icon/icon_point_green.png";
                    } else if (item.pointType == '泵站') {
                        pointIconImage = "../image/map_point_icon/icon_2.png";
                    } else if (item.pointType == '污水井') {
                        pointIconImage = "../image/map_point_icon/icon_orange.png";
                    } else if (item.pointType == '雨水口') {
                        pointIconImage = "../image/map_point_icon/icon_brown.png";
                    } else {
                        pointIconImage = "../image/map_point_icon/icon_1.png";
                    }
                    var pointIcon = new BMapGL.Icon(pointIconImage, new BMapGL.Size(8, 8));
                    //因为实际点击marker获取的经度比数据库中的小0.0000000007，所以在设置时先加0.000001，保证marker点击后获取的经纬度与数据库中保存的地点经纬度相同
                    var a = parseFloat(item.longitude);
                    var point = new BMapGL.Point(a, item.latitude);
                    if (index == 0) {
                        map.centerAndZoom(point, 18);//以第一个点为中心，地图等级为15
                    }
                    // trackPoint.push(new BMapGL.Point(a,res[index].latitude));
                    marker[index] = new BMapGL.Marker(point, {icon: pointIcon});
                    map.addOverlay(marker[index]);

                    marker[index].addEventListener("click", function aaa() {
                        console.info("map click");
                        console.info(item)
                        var text = "";
                        text = text + "管网点位编号：" + item.pointNo + "<br/>";
                        text = text + "管网类型：" + item.networkType + "<br/>";
                        text = text + "管网等级：" + item.networkLevel + "<br/>";
                        text = text + "管网点位类型：" + item.pointType + "<br/>";
                        text = text + "管网点位系统类型：" + item.systemType + "<br/>";
                        text = text + "管网材质：" + item.material + "<br/>";
                        text = text + "管网规格（mm）：" + item.specs + "<br/>";
                        text = text + "管网顶高程（m）：" + item.topDepth + "<br/>";
                        text = text + "管网底高程（m）：" + item.bottomDepth + "<br/>";
                        text = text + "管网竣工日期：" + item.completionDate + "<br/>";
                        text = text + "所属区域：" + item.addressName + "<br/>";
                        text = text + "所属地点经度(百度经纬度)：" + item.longitude.toString().substring(0, item.longitude.toString().indexOf(".") + 7) + "<br/>";
                        text = text + "所属地点纬度(百度经纬度)：" + item.latitude.toString().substring(0, item.latitude.toString().indexOf(".") + 7) + "<br/>";
                        var point = new BMapGL.Point(item.longitude, item.latitude);
                        var opts = {
                            width: 300, // 信息窗口宽度
                            height: 340, // 信息窗口高度
                            title: '<h4>设施信息</h4>', // 信息窗口标题
                            enableMessage: true, //设置允许信息窗发送短息
                            message: ""
                        }
                        var infoWindow = new BMapGL.InfoWindow(text, opts);
                        map.openInfoWindow(infoWindow, point);
                    });//监听标注事件

                }
            }
        }
    })
}
// 画管道线
$.post('getAllNetworkPipelineInfo', "", function (res) {         //post提交数据
    console.info(res);
    allPipeline = res;
    $.each(res, function (index, item) {
        allCheckedPipeline.push(item);
    })
    drawPipeline(res)

}).fail(function (xhr) {
    layer.msg('获取所有管网管线坐标点失败 ' + xhr.status);
});

/**
 @author Wangchong
 @date 2021/11/16 16:51 改
 @description TODO 画管道线
 @param res
 */
function drawPipeline(res) {

    $.each(res, function (index, item) {
        var startLongitude = res[index].startLongitude;
        var startLatitude = res[index].startLatitude;
        var endLongitude = res[index].endLongitude;
        var endLatitude = res[index].endLatitude;

        var lineColor;
        if (item.alarmState == "false") {
            if (item.networkType == '污水管网') {
                lineColor = '#ff0000';
            } else if (item.networkType == '雨水管网') {
                lineColor = '#09FC6B';
            } else {
                lineColor = '#00fffb';
            }
        } else {
            lineColor = 'gray';
        }
        var trackPoint = [];
        var newStartLongitude = parseFloat(startLongitude);
        var newEndLongitude = parseFloat(endLongitude);
        trackPoint.push(new BMapGL.Point(newStartLongitude, startLatitude));
        trackPoint.push(new BMapGL.Point(newEndLongitude, endLatitude));

        var polyline = new BMapGL.Polyline(trackPoint, {
            strokeColor: lineColor,
            strokeWeight: 3,
            setStrokeStyle: "dashed",
            strokeOpacity: 1
        });

        if (item.networkType == '污水管网') {
            sewagePipeLineArray.push(polyline);
        } else if (item.networkType == '雨水管网') {
            rainPipeLineArray.push(polyline);
        }
        map.addOverlay(polyline);
        var optsW = {
            title: '管线信息', // 信息窗口标题
            enableMessage: true, //设置允许信息窗发送短息
            message: "",

        }

        var text ="<div style='color: #F8F6F6;font-size: 15px'>";
        text = text + "管网管线编号：" + item.pipelineNo + "<br/>";
        text = text +"<br/>";
        text = text + "管网类型：" + item.networkType + "<br/>";
        text = text +"<br/>";
        text = text + "管网等级：" + item.networkLevel + "<br/>";
        text = text +"<br/>";
        text = text + "所属区域：" + item.addressName + "<br/>";
        text = text +"<br/>";

        if ( item.specs != "未知"){
            text = text + "管网规格（mm）：" +item.specs+ "<br/></div>";
            text = text +"<br/>";
        }else{
            text = text + "</div>";
        }
        var infoWindow = new BMapGL.InfoWindow(text, optsW);

        polyline.addEventListener('mouseover',function(event) {
            var tempInfoWindow = map.getInfoWindow();
            if (tempInfoWindow == null){
                map.openInfoWindow(infoWindow,event.latLng);
            }else if(tempInfoWindow.getTitle() == "管线信息"){
                map.openInfoWindow(infoWindow,event.latLng);
            }
        })

        polyline.addEventListener('mouseout',function(event) {
            var tempInfoWindow = map.getInfoWindow();
            if (tempInfoWindow == null){
                return;
            }
            var title = tempInfoWindow.getTitle();
            if ( title == "管线信息"){
                map.closeInfoWindow();
            }
        })
    })
}
// 显示污水管线
function showSewagePipeLine() {
    for (var i=0; i<sewagePipeLineArray.length; i++){
        map.addOverlay(sewagePipeLineArray[i]);
    }
}
// 隐藏污水管线
function hideSewagePipeLine() {
    for (var i=0; i<sewagePipeLineArray.length; i++){
        map.removeOverlay(sewagePipeLineArray[i]);
    }
}

// 显示雨水管线
function showRainPipeLine() {
    for (var i=0; i<rainPipeLineArray.length; i++){
        map.addOverlay(rainPipeLineArray[i]);
    }
}

// 隐藏雨水管线
function hideRainPipeLine() {
    for (var i=0; i<rainPipeLineArray.length; i++){
        map.removeOverlay(rainPipeLineArray[i]);
    }
}

// 显示污水点位
function showSewagePoint() {
    for (var i=0; i<sewagePointOverlayArray.length; i++){
        map.addOverlay(sewagePointOverlayArray[i]);
    }

}
// 隐藏污水点位
function hideSewagePoint() {
    for (var i=0; i<sewagePointOverlayArray.length; i++){
        map.removeOverlay(sewagePointOverlayArray[i]);
    }
}

// 显示雨水点位
function showRainPoint(){
    for (var i=0; i<rainPointOverlayArray.length; i++){
        map.addOverlay(rainPointOverlayArray[i]);
    }
}

// 隐藏雨水点位
function hideRainPoint() {
    for (var i=0; i<rainPointOverlayArray.length; i++){
        map.removeOverlay(rainPointOverlayArray[i]);
    }
}
//显示隔油池
function showOilSeparator() {
    for (var i=0; i<oilSeparatorArray.length;i++){
        map.addOverlay(oilSeparatorArray[i])
    }

}
//隐藏隔油池
function hideOilSeparator() {
    for (var i=0; i<oilSeparatorArray.length;i++){
        map.removeOverlay(oilSeparatorArray[i])
    }
}



// 管道查看easyui tree对象
var networkTreeObj = [
    {
        "id":"9",
        "checked":true,
        "text":"雨水管网",
        "state":"open",
        "children":[
            {
                "id":"0",
                "checked":true,
                "text":"管线",
                "state":"open",
                "children":null,
                "iconCls":"my-tree-icon-2",
                "attributes":"rain",
                "parentId":null,
                "pid":null,
                "offSet":null
            },
            {
                "page":null,
                "limit":null,
                "id":"1",
                "checked":false,
                "text":"点位",
                "state":"open",
                "children":[
                    {
                        "id":"7",
                        "checked":false,
                        "text":"雨水井",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    },
                    {
                        "page":null,
                        "limit":null,
                        "id":"8",
                        "checked":false,
                        "text":"雨水口",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    }
                ],
                "iconCls":"my-tree-icon-2",
                "attributes":"rain",
                "parentId":null,
                "pid":null,
                "offSet":null
            }
        ],
        "iconCls":"my-tree-icon-1",
        "attributes":null,
        "parentId":null,
        "pid":null,
        "offSet":null
    },
    {
        "page":null,
        "limit":null,
        "id":"10",
        "checked":true,
        "text":"污水管网",
        "state":"open",
        "children":[
            {
                "page":null,
                "limit":null,
                "id":"0",
                "checked":true,
                "text":"管线",
                "state":"open",
                "children":null,
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            },
            {
                "id":"1",
                "checked":false,
                "text":"点位",
                "state":"open",
                "children":[
                    {
                        "id":"2",
                        "checked":false,
                        "text":"污水三级管网汇集总口",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    },
                    {
                        "id":"3",
                        "checked":false,
                        "text":"污水二级管网汇集总口",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    },
                    {
                        "id":"4",
                        "checked":false,
                        "text":"污水一级管网出入口汇流井",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    },
                    {

                        "id":"5",
                        "checked":false,
                        "text":"泵站",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    },
                    {

                        "id":"6",
                        "checked":false,
                        "text":"污水井",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    }
                ],
                "iconCls":"my-tree-icon-2",
                "attributes":"sewage",
                "parentId":null,
                "pid":null,
                "offSet":null
            }
        ],
        "iconCls":"my-tree-icon-1",
        "attributes":"sewage",
        "parentId":null,
        "pid":null,
        "offSet":null
    },
    {
        "page":null,
        "limit":null,
        "id":"oil",
        "checked":true,
        "text":"隔油池",
        "state":null,
        "children":null,
        "iconCls":"my-tree-icon-1",
        "attributes":null,
        "parentId":null,
        "pid":null,
        "offSet":null
    },
    {
        "page":null,
        "limit":null,
        "id":"sampleArea",
        "checked":true,
        "text":"区域选择",
        "state":null,
        "children":null,
        "iconCls":"my-tree-icon-1",
        "attributes":null,
        "parentId":null,
        "pid":null,
        "offSet":null
    },

    {
        "page":null,
        "limit":null,
        "id":"alarmType",
        "checked":false,
        "text":"事件类型",
        "state":null,
        "children":[
            {
                "page":null,
                "limit":null,
                "id":null,
                "checked":false,
                "text":"设备故障",
                "state":null,
                "children":null,
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            },
            {
                "id":null,
                "checked":false,
                "text":"管网堵塞",
                "state":null,
                "children":null,
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            },
            {
                "id":null,
                "checked":false,
                "text":"管网破损",
                "state":null,
                "children":null,
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            },
            {
                "id":null,
                "checked":false,
                "text":"污水偷排",
                "state":null,
                "children":null,
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            },
            {
                "page":null,
                "limit":null,
                "id":null,
                "checked":false,
                "text":"管道错接",
                "state":null,
                "children":null,
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            }
        ],
        "iconCls":"my-tree-icon-1",
        "attributes":null,
        "parentId":null,
        "pid":null
    }
];
// 管道查看
$('#networkTree').tree({
    data: networkTreeObj,
    checkbox: true,
    onCheck: function (node) { //当用户点击复选框时触发
        var attributes = node.attributes;

        if (node.text == "雨水管网"){
            if (node.checked){
                showRainPipeLine();
                showRainPoint();
            }else{
                hideRainPipeLine();
                hideRainPoint();
            }
            return;
        }

        if (node.text == "污水管网"){
            if (node.checked){
                showSewagePipeLine();
                showSewagePoint();
            }else{
                hideSewagePipeLine();
                hideSewagePoint();
            }
            return;
        }

        if(node.text =="隔油池"){
            if(node.checked){
                showOilSeparator();
            }else{
                hideOilSeparator();
            }
            return;
        }
        if(node.text =="区域选择"){
            if(node.checked){
                showSampleArea();
            }else{
                removeSampleArea();
            }
            return;
        }
        if (node.text == "管线"){
            if (node.checked){
                if (attributes == "rain"){
                    showRainPipeLine();
                }else{
                    showSewagePipeLine();
                }
            }else{
                if (attributes == "rain"){
                    hideRainPipeLine();
                }else{
                    hideSewagePipeLine();
                }
            }
            return;
        }

        if (node.text == "点位"){
            if (node.checked){
                if (attributes == "rain"){
                    showRainPoint();
                }else{
                    showSewagePoint();
                }
            }else{
                if (attributes == "rain"){
                    hideRainPoint();
                }else{
                    hideSewagePoint();
                }
            }
        }
    }
});

$("#networkTree .my-tree-icon-3+.tree-checkbox").css('display', 'none');
$("#networkTree .my-tree-icon-4+.tree-checkbox").css('display', 'none');

// 2021112917171 Wangchong 雨水监测点显示控制
function rainMonitorDisplayControl(show) {
    if (show){
        for (var i=0; i<rainMonitorArray.length; i++){
            map.addOverlay(rainMonitorArray[i])
        }
    }else{
        for (var i=0; i<rainMonitorArray.length; i++){
            map.removeOverlay(rainMonitorArray[i])
        }
    }
}

// 污水监测点显示控制
function sewageMonitorDisplayControl(show) {
    if (show){
        for (var i=0; i<sewageMonitorArray.length; i++){
            map.addOverlay(sewageMonitorArray[i])
        }
    }else{
        for (var i=0; i<sewageMonitorArray.length; i++){
            map.removeOverlay(sewageMonitorArray[i])
        }
    }
}

// 泵站监测点显示控制
function pumpStationDisplayControl(show) {
    if (show){
        for (var i=0; i<pumpStationArray.length; i++){
            map.addOverlay(pumpStationArray[i])
        }
    }else{
        for (var i=0; i<pumpStationArray.length; i++){
            map.removeOverlay(pumpStationArray[i])
        }
    }
}

// 设施设备easyui tree
var devTreeObj = [
    {
        "id":"0",
        "checked":false,
        "text":"雨水管网",
        "state":"open",
        "children":[
            {
                "id":"2",
                "checked":false,
                "text":"雨水监测点",
                "state":"open",
                "children":[
                    {
                        "page":null,
                        "limit":null,
                        "id":null,
                        "checked":false,
                        "text":"液位计",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    },
                    {
                        "page":null,
                        "limit":null,
                        "id":null,
                        "checked":false,
                        "text":"雨量计",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    },
                    {
                        "page":null,
                        "limit":null,
                        "id":null,
                        "checked":false,
                        "text":"流量计",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    },
                    {
                        "page":null,
                        "limit":null,
                        "id":null,
                        "checked":false,
                        "text":"水质仪",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    }
                ],
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            }
        ],
        "iconCls":"my-tree-icon-1",
        "attributes":null,
        "parentId":null,
        "pid":null,
        "offSet":null
    },
    {
        "id":"1",
        "checked":false,
        "text":"污水管网",
        "state":"open",
        "children":[
            {
                "page":null,
                "limit":null,
                "id":"8",
                "checked":false,
                "text":"污水监测点",
                "state":"open",
                "children":[
                    {
                        "page":null,
                        "limit":null,
                        "id":null,
                        "checked":false,
                        "text":"液位计",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    },
                    {
                        "page":null,
                        "limit":null,
                        "id":null,
                        "checked":false,
                        "text":"流量计",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    },
                    {
                        "page":null,
                        "limit":null,
                        "id":null,
                        "checked":false,
                        "text":"水质仪",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    }
                ],
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            },
            {
                "id":"11",
                "checked":false,
                "text":"泵站",
                "state":"open",
                "children":[
                    {
                        "page":null,
                        "limit":null,
                        "id":null,
                        "checked":false,
                        "text":"抽水泵",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    },
                    {
                        "page":null,
                        "limit":null,
                        "id":null,
                        "checked":false,
                        "text":"阀门",
                        "state":"open",
                        "children":null,
                        "iconCls":"my-tree-icon-3",
                        "attributes":null,
                        "parentId":null,
                        "pid":null,
                        "offSet":null
                    }
                ],
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            }
        ],
        "iconCls":"my-tree-icon-1",
        "attributes":null,
        "parentId":null,
        "pid":null,
        "offSet":null
    },

    {
        "id":"3",
        "checked":false,
        "text":"油水分离器",
        "state":"open",
        "children":[
            {
                "page":null,
                "limit":null,
                "id":null,
                "checked":false,
                "text":"抽水泵",
                "state":"open",
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            },
            {
                "id":null,
                "checked":false,
                "text":"阀门",
                "state":"open",

                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            }
        ],
        "iconCls":"my-tree-icon-1",
        "attributes":null,
        "parentId":null,
        "pid":null,
        "offSet":null
    },

    {
        "id":"4",
        "checked":false,
        "text":"雨污分流器",
        "state":"open",
        "children":[
            {
                "page":null,
                "limit":null,
                "id":null,
                "checked":false,
                "text":"液位计",
                "state":"open",
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            },
            {
                "id":null,
                "checked":false,
                "text":"流量计",
                "state":"open",
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            },
            {
                "id":null,
                "checked":false,
                "text":"阀门",
                "state":"open",
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            },
            {
                "id":null,
                "checked":false,
                "text":"抽水泵",
                "state":"open",
                "iconCls":"my-tree-icon-2",
                "attributes":null,
                "parentId":null,
                "pid":null,
                "offSet":null
            },
        ],
        "iconCls":"my-tree-icon-1",
        "attributes":null,
        "parentId":null,
        "pid":null,
        "offSet":null
    },
]
// 设施设备查看
$('#devTree').tree({
    data: devTreeObj,
    checkbox: true,
    onCheck: function (node) { //当用户点击复选框时触发
        if (node.text == "雨水监测点"){
            if (node.checked){
                 rainMonitorDisplayControl(true)
            }else{
                rainMonitorDisplayControl(false)
            }
            return;
        }

        if (node.text == "污水监测点"){
            if (node.checked){
                sewageMonitorDisplayControl(true)
            }else{
                sewageMonitorDisplayControl(false)
            }
            return;
        }

        if (node.text == "泵站"){
            if (node.checked){
                pumpStationDisplayControl(true)
            }else{
                pumpStationDisplayControl(false)
            }
        }
    }
});
$("#devTree .my-tree-icon-3+.tree-checkbox").css('display', 'none');
$("#devTree .my-tree-icon-2+.tree-checkbox").css('display', 'none');


/*******************************A、B、C、D、E、F、G区域绘制  显示与隐藏  START*****************************/

//
var polygonA;
var ALabel;
var polygonB;
var BLabel;
var circleC;
var CLabel;
var polygonD;
var DLabel;
var polygonE;
var ELabel;
var polygonF;
var FLabel;
var circleG;
var GLabel;

initSampleArea();

/**
 * 
 * @param center 椭圆中心点
 * @param x 横向经度
 * @param y 纵向纬度
 * @returns {any[]}
 */
function add_oval(center,x,y)
{
    var assemble=new Array();
    var angle;
    var dot;
    var tangent=x/y;
    for(var i=0;i<36;i++)
    {
        angle = (2* Math.PI / 36) * i;
        dot = new BMapGL.Point(center.lng+Math.sin(angle)*y*tangent, center.lat+Math.cos(angle)*y);
        assemble.push(dot);
    }
    return assemble;
}

/**
 * 初始化区域
 */
function initSampleArea() {
    console.info("初始化区域");
    var polygonStyle = {
        fillColor: "rgba(0,247,255,0.1)", //填充颜色。当参数为空时，折线覆盖物没有填充效果。
        fillOpacity: 0, //填充透明度 0-1
        strokeColor: "rgb(0,247,255)", //边线颜色
        strokeStyle: "dashed", //边线样式,solid或dashed
        strokeWeight: 2, //边线宽度,以像素为单位
        strokeOpacity: 1 //边线透明度，取值范围0-1
    };
    var fontStyle = {
        color: 'rgb(0,247,255)',
        borderRadius: '5px',
        borderColor: 'rgba(255,255,255,0)',
        backgroundColor: '#00000000',
        padding: '10px',
        fontSize: '32px',
        height: '30px',
        lineHeight: '30px',
        fontFamily: '微软雅黑'
    };
    //A区域

    var centerPointA = new BMapGL.Point(120.18267081089619, 30.19693321716187);
    var APoints = add_oval(centerPointA,0.0024,0.0018) ;
    polygonA = new BMapGL.Polygon(APoints, polygonStyle);

    var AOpts = {
        position: getCenterPoint(APoints), // 指定文本标注所在的地理位置
        offset: new BMapGL.Size(-25, -25) // 设置文本偏移量
    };
    // 创建文本标注对象
    ALabel = new BMapGL.Label('A', AOpts);
    // 自定义文本标注样式
    ALabel.setStyle(fontStyle);


    // 区域B
    // 创建多边形
    var BPoints = [
        new BMapGL.Point(120.19035826904037, 30.201221652323508),
        new BMapGL.Point(120.1847578100836, 30.198314705958684),
        new BMapGL.Point(120.17966541019675, 30.20106067307962),
        new BMapGL.Point(120.18522495552271, 30.204457278736502)
    ];
    polygonB = new BMapGL.Polygon(BPoints,polygonStyle);

    var BOpts = {
        position: getCenterPoint(BPoints), // 指定文本标注所在的地理位置
        offset: new BMapGL.Size(-25, -25) // 设置文本偏移量
    };
    // 创建文本标注对象
    BLabel = new BMapGL.Label('B', BOpts);
    // 自定义文本标注样式
    BLabel.setStyle(fontStyle);


    //区域C
    // 创建圆
    var centerPointC = new BMapGL.Point(120.1978790591424, 30.207161217337818);
    circleC = new BMapGL.Circle(centerPointC, 480, polygonStyle);
    // 增加圆
    var COpts = {
        position: centerPointC, // 指定文本标注所在的地理位置
        offset: new BMapGL.Size(-25, -25) // 设置文本偏移量
    };
    // 创建文本标注对象
    CLabel = new BMapGL.Label('C', COpts);
    // 自定义文本标注样式
    CLabel.setStyle(fontStyle);


    // 区域D
    // 创建多边形
    var DPoints = [
        new BMapGL.Point(120.204849191414, 30.21471769968935),
        new BMapGL.Point(120.20134494403598, 30.21281543757225),
        new BMapGL.Point(120.20565224810478, 30.206875913459527),
        new BMapGL.Point(120.20818309343333, 30.20816530711734)
    ];
    polygonD = new BMapGL.Polygon(DPoints,polygonStyle);
    var DOpts = {
        position: getCenterPoint(DPoints), // 指定文本标注所在的地理位置
        offset: new BMapGL.Size(-25, -25) // 设置文本偏移量
    };
    // 创建文本标注对象
    DLabel = new BMapGL.Label('D', DOpts);
    // 自定义文本标注样式
    DLabel.setStyle(fontStyle);


    // 区域E
    // 创建多边形
    var EPoints = [
        new BMapGL.Point(120.21079519844999, 30.21282477572714),
        new BMapGL.Point(120.20806828490662, 30.211494378899242),
        new BMapGL.Point(120.20987543314003, 30.208956706561345),
        new BMapGL.Point(120.2125294682408, 30.210297783265432)
    ];
    polygonE = new BMapGL.Polygon(EPoints,polygonStyle);

    var EOpts = {
        position: getCenterPoint(EPoints), // 指定文本标注所在的地理位置
        offset: new BMapGL.Size(-25, -25) // 设置文本偏移量
    };
    // 创建文本标注对象
    ELabel = new BMapGL.Label('E', EOpts);
    // 自定义文本标注样式
    ELabel.setStyle(fontStyle);



    // 区域F
    // 创建多边形
    var FPoints = [
        new BMapGL.Point(120.21084091713726, 30.217979759840304),
        new BMapGL.Point(120.21118069681529, 30.214949984576005),
        new BMapGL.Point(120.20705803672172, 30.21174304185274),
        new BMapGL.Point(120.21192821210698, 30.213848224748705),
        new BMapGL.Point(120.21419340996059, 30.21243165808744),
        new BMapGL.Point(120.21380832632546, 30.21485161366954),
        new BMapGL.Point(120.21788568246197, 30.218589638270224),
        new BMapGL.Point(120.21310611499086, 30.215992710076446)
    ];
    polygonF = new BMapGL.Polygon(FPoints,polygonStyle);

    var FOpts = {
        position: getCenterPoint(FPoints), // 指定文本标注所在的地理位置
        offset: new BMapGL.Size(-25, -25) // 设置文本偏移量
    };
    // 创建文本标注对象
    FLabel = new BMapGL.Label('F', FOpts);
    // 自定义文本标注样式
    FLabel.setStyle(fontStyle);


    //区域G
    // 创建圆
    var centerPointG = new BMapGL.Point(120.21653177361509, 30.214825745655325);
    circleG = new BMapGL.Circle(centerPointG, 120, polygonStyle);
    // 增加圆
    var GOpts = {
        position: centerPointG, // 指定文本标注所在的地理位置
        offset: new BMapGL.Size(-25, -25) // 设置文本偏移量
    };
    // 创建文本标注对象
    GLabel = new BMapGL.Label('G', GOpts);
    // 自定义文本标注样式
    GLabel.setStyle(fontStyle);


    map.addOverlay(polygonA);
    map.addOverlay(ALabel);

    map.addOverlay(polygonB);
    map.addOverlay(BLabel);

    map.addOverlay(circleC);
    map.addOverlay(CLabel);

    map.addOverlay(polygonD);
    map.addOverlay(DLabel);

    map.addOverlay(polygonE);
    map.addOverlay(ELabel);

    map.addOverlay(polygonF);
    map.addOverlay(FLabel);

    map.addOverlay(circleG);
    map.addOverlay(GLabel);
}

/**
 * 展示区域
 */
function showSampleArea() {
    map.addOverlay(polygonA);
    map.addOverlay(ALabel);

    map.addOverlay(polygonB);
    map.addOverlay(BLabel);

    map.addOverlay(circleC);
    map.addOverlay(CLabel);

    map.addOverlay(polygonD);
    map.addOverlay(DLabel);

    map.addOverlay(polygonE);
    map.addOverlay(ELabel);

    map.addOverlay(polygonF);
    map.addOverlay(FLabel);

    map.addOverlay(circleG);
    map.addOverlay(GLabel);
}
/**
 * 移除区域范围
 */
function removeSampleArea() {
    map.removeOverlay(polygonA);
    map.removeOverlay(ALabel);

    map.removeOverlay(polygonB);
    map.removeOverlay(BLabel);

    map.removeOverlay(circleC);
    map.removeOverlay(CLabel);

    map.removeOverlay(polygonD);
    map.removeOverlay(DLabel);

    map.removeOverlay(polygonE);
    map.removeOverlay(ELabel);

    map.removeOverlay(polygonF);
    map.removeOverlay(FLabel);

    map.removeOverlay(circleG);
    map.removeOverlay(GLabel);
}

/**
 * 计算不规则多边形中心点
 * @param points
 * @returns {BMapGL.Point}
 */
function getCenterPoint(points) {
    var minLng;
    var maxLng;
    var minLat;
    var maxLat;
    $.each(points, function (index, item) {
        if (index == 0) {
            minLng = item.lng;
            maxLng = item.lng;
            minLat = item.lat;
            maxLat = item.lat;
        }
        if (minLng > item.lng) {
            minLng = item.lng;
        }
        if (maxLng < item.lng) {
            maxLng = item.lng;
        }
        if (minLat > item.lat) {
            minLat = item.lat;
        }
        if (maxLat < item.lat) {
            maxLat = item.lat;
        }
    })
    var centerLng = (minLng + maxLng) / 2;
    var centerLat = (minLat + maxLat) / 2;
    return new BMapGL.Point(centerLng, centerLat);
}
/*******************************A、B、C、D、E、F、G区域绘制  显示与隐藏  END*****************************/