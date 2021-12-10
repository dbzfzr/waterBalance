function add_arr_point(viewer,point,arrPoint){
    viewer.entities.add({
        name: "根据视距缩放点",
        position: Cesium.Cartesian3.fromDegrees(arrPoint.x, arrPoint.y, arrPoint.z),
        point:point
    });
}

function add_arr_text(viewer,label,arrPoint){
    viewer.entities.add({
        name: "贴地文字",
        position: Cesium.Cartesian3.fromDegrees(arrPoint.x, arrPoint.y,arrPoint.z),
        label: label
    });
} 
//线
function draw_line(viewer, polyline) {
    var glowingLine = viewer.entities.add({
        name: 'Glowing blue line on the surface',
        polyline: polyline
    });
    viewer.zoomTo(viewer.entities);
}

/**
 * 
 * @param {*} viewer 
 * @param {*} polylineVolume  管道线的属性
 */
//虚线
function polylineDash(viewer, polyline) {
    var dashLine = viewer.entities.add({
        name: 'Red dashed line',
        // polyline: {
        //     positions: Cesium.Cartesian3.fromDegreesArrayHeights([100, 28, 250000, 130, 28, 250000]),
        //     width: 5,
        //     material: new Cesium.PolylineDashMaterialProperty({
        //         color: Cesium.Color.RED
        //     })
        //}
        polyline: polyline
    });
    viewer.zoomTo(viewer.entities);
}




//管道线
function polylineVolume1(viewer, polylineVolume) {
    var redTube = viewer.entities.add({
        name: 'Red tube with rounded corners',
        polylineVolume: polylineVolume
        // {
        //     positions: Cesium.Cartesian3.fromDegreesArray([100.0, 22.0, 100.0, 26.0, 105, 27.0]),
        //     shape: computeCircle(60000.0),
        //     material: Cesium.Color.RED
        // }
    });
    var polylinevolumeinstance = new Cesium.GeometryInstance({
        geometry: new Cesium.PolylineVolumeGeometry({
            polylinePositions: Cesium.Cartesian3.fromDegreesArrayHeights([
                90, 35, 50000,
                110, 35, 50000
            ]),
            shapePositions: computeStar(7, 70000, 50000),
            cornerType: Cesium.CornerType.MITERED
        }),
        vertexFormat: Cesium.PolylineMaterialAppearance.VERTEX_FORMAT,
        id: "polylinevolumeinstance"
    });

    viewer.zoomTo(viewer.entities);
}
function computeCircle(radius) {
    var positions = [];
    for (var i = 0; i < 360; i++) {
        var radians = Cesium.Math.toRadians(i);
        positions.push(new Cesium.Cartesian2(radius * Math.cos(radians), radius * Math.sin(radians)));
    }
    return positions;
}
function computeStar(arms, rOuter, rInner) {
    var angle = Math.PI / arms;
    var length = 2 * arms;
    var positions = new Array(length);
    
    
    for (var i = 0; i < length; i++) {
        var r = (i % 2) === 0 ? rOuter : rInner;
        positions[i] = new Cesium.Cartesian2(Math.cos(i * angle) * r, Math.sin(i * angle) * r);
    }
    return positions;
}

/**
 * 点标注
 
 * @param {*} viewer 
 * @param {*} point 
 */
var primitive;
var primitives = [];

var drawControl;//绘制对象
function add_marker_point(viewer, position, color, j) {
    var pointPrimitives = viewer.scene.primitives.add(new Cesium.PointPrimitiveCollection());
    primitive = pointPrimitives.add({
        pixelSize: 3,
        color: color,
        position: position
    });
    primitive.tooltip = '第' + j + '个点';
    primitives.push(primitive);
}
//添加点
function add_point(viewer, style, type) {
 
    drawControl = new gsp3d.Draw(viewer, {});
    drawControl.startDraw({
        type: type,
        style: style
    });
}
function text_label(viewer, pointInfo, j) {
    var labels = viewer.scene.primitives.add(new Cesium.LabelCollection());
    var primitive = labels.add(pointInfo);
 
    primitive.tooltip = '第' + j + '个文字';
}
//添加图标点+文字
function icon_point(item, label, inthtml, viewer, billboard) {
    var dataSource = new Cesium.CustomDataSource();
    //添加实体
    var entitie = dataSource.entities.add({
        id: item.id,
        name: item.name,
        position: Cesium.Cartesian3.fromDegrees(+item.x, +item.y, item.z || 0),
        billboard: billboard,
        label: label,
        data: item,
        popup: {
            html: inthtml,
            anchor: [0, 10],

        },
        click: function (entity) {//单击
            if (viewer.camera.positionCartographic.height > 90000) {
                viewer.gsp.popup.close();//关闭popup
                var position = entity.position._value;
                viewer.gsp.centerPoint(position, {
                    radius: 5000,   //距离目标点的距离
                    pitch: -50,     //相机方向
                    duration: 4,
                    complete: function (e) {//飞行完成回调方法
                        viewer.gsp.popup.show(entity);//显示popup
                    }
                });
            }
        }
    });
    viewer.dataSources.add(dataSource);

}
//添加图标点
function make_icon_point(viewer, item, billboard) {
    viewer.entities.add({
        name: "贴地图标",
        position: Cesium.Cartesian3.fromDegrees(item.x, item.y, item.z),
        billboard: billboard
    });
}

function delete_all() {
    drawControl.clearDraw();
}
/**
 * 
 * @param {*} arr  点的集合
 * @param {*} point  点的属性
 * @param {*} label   文本属性
 * @param {*} viewer   
 * @param {*} billboard  气泡框属性
 */
function add_point_text(item, inthtml, label, viewer, point) {
    var dataSource = new Cesium.CustomDataSource();
    //添加实体
    var entitie = dataSource.entities.add({
        
        name: item.name,
        position: Cesium.Cartesian3.fromDegrees(item.x, item.y,item.z),
        point: point,
        label: label,
        data: item,
        tooltip: {
            html: inthtml,
            anchor: [0, -12],
        }, 
        click: function (entity) {//单击
            viewer.gsp.popup.show(entity);//显示popup
        }
    });

      

    viewer.dataSources.add(dataSource);
}
// 3.29 
function add_text(viewer,style,type){
    drawControl = new gsp3d.Draw(viewer, {});
    drawControl.startDraw({
        type: type,
        style: style,
    });
}
/**
 * 绘制点位 
 * @param {*} arr 
 */

function add_point_feature(arr) {
    var billboard = {
        image: 'http://69.234.224.124:7003/Esvsample/img/test_icon.png',
        scale: 0.7,  //原始大小的缩放比例
        horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
        verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
        // heightReference: Cesium.HeightReference.CLAMP_TO_GROUND, //贴地
        scaleByDistance: new Cesium.NearFarScalar(1.5e2, 1.0, 8.0e6, 0.2)
    }
    for (var i = 0;i < arr.length; i++) {
        var item = arr[i];
        var inthtml =
            '<table style="width: auto;"><tr>' +
            '<th scope="col" colspan="4"  style="text-align:center;font-size:15px;">' +
            '广告牌' +
            '</table>';
        var label = {
            text: item.text,
            font: "normal small-caps normal 19px 楷体",
            style: Cesium.LabelStyle.FILL_AND_OUTLINE,
            fillColor: Cesium.Color.AZURE,
            outlineColor: Cesium.Color.BLACK,
            outlineWidth: 2,
            horizontalOrigin: Cesium.HorizontalOrigin.LEFT,
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            pixelOffset: new Cesium.Cartesian2(10, 0), //偏移量
            distanceDisplayCondition: new Cesium.DistanceDisplayCondition(0.0, 80000)
        }
        icon_point(item, label, inthtml, viewer, billboard);
    }
}
/**
* 几何绘制标注
* @param {*} viewer 
* @param {*} polygon 面
* 
*/
function draw_polygon(viewer, polygon) {
    var redPolygon = viewer.entities.add({
        name: 'Red polygon on surface',
        polygon: polygon
    });
    var positions = Cesium.Cartesian3.fromDegreesArray([
        125.0, 27.0,
        125.0, 22.0,
        117.0, 23.0,
        112.0, 21.0,
        112.0, 25.0
    ]);
    var redPolygonInstance = new Cesium.GeometryInstance({
        geometry: Cesium.PolygonGeometry.fromPositions({
            positions: positions,
            vertexFormat: Cesium.PerInstanceColorAppearance.VERTEX_FORMAT
        }),
        attributes: {
            color: Cesium.ColorGeometryInstanceAttribute.fromColor(Cesium.Color.RED)
        }
    });
    viewer.gsp.centerAt({ "y": 29.877073, "x": 121.539334, "z": 57.23, "heading": 195.7, "pitch": -20.2, "roll": 360 });
}
/**
 * 绘制二维空间平面
 * @param {*} viewer 
 */
function make_polygon(viewer) {
    var drawControl = new gsp3d.Draw(viewer, {});
    drawControl.startDraw({
        type: "polygon",
        style: {
            color: "#29cf34",
            opacity: 0.5,
            clampToGround: false
        }
    });
}
/**
 * 绘制几何盒子
 * @param {*} viewer 
 * @param {*} position 
 * @param {*} box 
 */
function draw_box(viewer, position, box) {
    var redBox = viewer.entities.add({
        name: 'Red box with black outline',
       
        position: position,
        box: box
    });
}
/**
 * 绘制几何平面
 * @param {*} viewer 
 * @param {*} position 
 * @param {*} plane 
 
 */
/**
 *  绘制平面
 * @param {*} viewer 
 * @param {*} position 
 * @param {*} plane 
 */
function draw_plane(viewer, position, plane) {
    var redBox = viewer.entities.add({
        name: 'Red box with black outline',
        position: position,
        plane: plane
    });
}


//绘制墙
function draw_wall(viewer, wall) {
    var greenWall = viewer.entities.add({
        name: 'Green wall from surface with outline',
        wall: wall,
    });
}
/**
 * 几何绘制标注
 * @param {*} viewer 
 * @param {*} sphere 球
 * 
 */
function draw_sphere(viewer, ellipsoid, position) {
    var blueEllipsoid = viewer.entities.add({
        name: 'Blue ellipsoid',
        position: position,
        ellipsoid: ellipsoid,
    });
    /*
     * 新加载模式-几何图元，这适用于复杂的定制化场景，核心由三部分组成，几何实例与模型矩阵以及样式
     */
    var ellipsoidinstance = new Cesium.GeometryInstance({
        geometry: new Cesium.EllipsoidGeometry({
            vertexFormat: Cesium.VertexFormat.POSITION_ONLY,
            radii: new Cesium.Cartesian3(500000.0, 500000.0, 500000.0)
        }),
        modelMatrix: Cesium.Matrix4.multiplyByTranslation(Cesium.Transforms.eastNorthUpToFixedFrame(
            Cesium.Cartesian3.fromDegrees(108.59777, 40.03883)), //几何的空间位置
            new Cesium.Cartesian3(0.0, 0.0, 300000.0), //几何的x,y,z空间偏移
            new Cesium.Matrix4()), //这个可以选择默认
        attributes: {
            color: new Cesium.ColorGeometryInstanceAttribute(0.0, 1.0, 1.0, 1.0)
        },
        id: "ellipsoidinstance"
    });
}
/**
 * 几何绘制标注
 * @param {*} viewer 
 * @param {*} circle 圆
 * 
 */
function draw_circle(viewer, ellipse, position) {
    var greenCircle = viewer.entities.add({
        position: position,
        // position: Cesium.Cartesian3.fromDegrees(121.538530, 29.874921, 1.02),
        name: 'Green circle',
        ellipse: ellipse
    });
    var cylinderinstance = new Cesium.GeometryInstance({
        geometry: new Cesium.CylinderGeometry({
            length: 200000,
            topRadius: 80000,
            bottomRadius: 200000,
        }),
        modelMatrix: Cesium.Matrix4.multiplyByTranslation(Cesium.Transforms.eastNorthUpToFixedFrame(
            Cesium.Cartesian3.fromDegrees(113.59777, 30.03883)), //几何的空间位置
            new Cesium.Cartesian3(0.0, 0.0, 300000.0), //几何的x,y,z空间偏移
            new Cesium.Matrix4()), //这个可以选择默认
        attributes: {
            color: new Cesium.ColorGeometryInstanceAttribute(0.0, 1.0, 1.0, 1.0)
        },
        id: "cylinderinstance"
    });
}
/**
 * 几何绘制标注
 * @param {*} viewer 
 * @param {*} cylinder 圆锥体
 * 
 */
function draw_cylinder(viewer, cylinder, position) {
    var redCone = viewer.entities.add({
        name: 'Red cone',
        position: position,
        cylinder: cylinder
    });
}

/**
 * 几何绘制标注
 * @param {*} viewer 
 * @param {*} rectangle 长方形
 * 
 */
function draw_rectangle(viewer, rectangle) {
    var redRectangle = viewer.entities.add({
        name: 'Red translucent rectangle',
        rectangle: rectangle,
    });
    /*
     * 新加载模式-几何图元，这适用于复杂的定制化场景，核心由三部分组成，几何实例与模型矩阵以及样式
     */
    var rectangleinstance = new Cesium.GeometryInstance({
        geometry: new Cesium.RectangleGeometry({
            ellipsoid: Cesium.Ellipsoid.WGS84,
            rectangle: Cesium.Rectangle.fromDegrees(10.0, 3.0, 16.0, 2.0),
            height: 1.0,
            extrudedHeight: 3
        }),
        vertexFormat: Cesium.PolylineMaterialAppearance.VERTEX_FORMAT,
        id: "rectangleinstance"
    });
}