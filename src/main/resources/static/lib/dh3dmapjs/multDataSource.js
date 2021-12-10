var flyLine;
/**
 * 加载模型
 * @param {*} layermanager 
 * @param {*} viewer 
 * @param {*} serverURL 
 */
 function loadModel(layermanager, viewer, serverURL) {
    var layerModel;

    layerModel = gsp3d.layer.createLayer(layermanager, viewer, serverURL);

    return layerModel;
}
/**
 * 数据单体化
 * @param {*} viewer 
 */
 function show_picked_featureinfo(viewer) {
    var nameOverlay = document.createElement('div');
    viewer.container.appendChild(nameOverlay);
    nameOverlay.className = 'backdrop';
    nameOverlay.style.display = 'none';
    nameOverlay.style.position = 'absolute';
    nameOverlay.style.bottom = '0';
    nameOverlay.style.left = '0';

    nameOverlay.style['pointer-events'] = 'none';
    nameOverlay.style.padding = '4px';
    nameOverlay.style.backgroundColor = 'black';
    var highlighted = {
        feature: undefined,
        originalColor: new Cesium.Color()
    };
    viewer.screenSpaceEventHandler.setInputAction(function onMouseMove(movement) {
        if (Cesium.defined(highlighted.feature)) {
            highlighted.feature.color = highlighted.originalColor;
            highlighted.feature = undefined;
        }
        var pickedFeature = viewer.scene.pick(movement.position);
        if (!Cesium.defined(pickedFeature) || !pickedFeature.getProperty) {
            nameOverlay.style.display = 'none';
            return;
        }
        var name = pickedFeature.getProperty('name');
        // console.log(pickedFeature.getProperty('name'));
        console.log(pickedFeature.getProperty('name'));

        if (!Cesium.defined(name)) {
            name = pickedFeature.getProperty('id');
        }
        if (!Cesium.defined(name)) return;
        if (name != "") {
            nameOverlay.style.display = 'block';
            nameOverlay.style.color = "#ffffff";
            nameOverlay.style.bottom = viewer.canvas.clientHeight - movement.position.y + 'px';
            nameOverlay.style.left = movement.position.x + 'px';
            nameOverlay.textContent = name;
        }
        highlighted.feature = pickedFeature;
        Cesium.Color.clone(pickedFeature.color, highlighted.originalColor);
        pickedFeature.color = Cesium.Color.BLUEVIO;
    }, Cesium.ScreenSpaceEventType.LEFT_CLICK);

}
/**
 * 世界地形
 */
function add_world_terrain(viewer) {

    viewer.terrainProvider = new Cesium.CesiumTerrainProvider({
        url: Cesium.IonResource.fromAssetId(1)


    })
}

/**
 * 中囯地形
 */
function add_china_terrain(viewer) {
    viewer.terrainProvider = new Cesium.CesiumTerrainProvider({
        url: "http://data.marsgis.cn/terrain",
        requestWaterMask: true,
        requestVertexNormals: true
    });

}
/**
 * 无地形
 */
function add_null_terrain(viewer) {
    viewer.terrainProvider = new Cesium.EllipsoidTerrainProvider({
        ellipsoid: Cesium.Ellipsoid.WGS84
    });
}



/**
 * 加載人工模型
 */
 function removeAllTerrainEffect(viewer) {
    viewer.scene.moon.show = false;
    viewer.scene.skyBox.show = false;
    viewer.scene.sun.show = false;
    viewer.scene.globe.show = false;
    viewer.scene.fog.enabled = false;
    viewer.scene.skyAtmosphere.show = false;
}
function addAllTerrainEffect(viewer) {
    viewer.scene.moon.show = true;
    viewer.scene.skyBox.show = true;
    viewer.scene.sun.show = true;
    viewer.scene.globe.show = true;
    viewer.scene.fog.enabled = true;
    viewer.scene.skyAtmosphere.show = true;
}
var myterrainlayer;

//加载离线影像
function showTerrain_off(viewer, Terrain) {
    addAllTerrainEffect(viewer)
    // viewer.imageryLayers.remove(myterrainlayer);
    var imageryProvider = gsp3d.layer.createImageryProvider({
        type: "xyz",
        url: Terrain,
    });
    myterrainlayer = viewer.imageryLayers.addImageryProvider(imageryProvider);
}
//加载在线影像
function showTerrain(viewer) {
    addAllTerrainEffect(viewer)
    viewer.imageryLayers.remove(myterrainlayer);
    var imageryProvider = gsp3d.layer.createImageryProvider({
        type: "www_tdt",
        layer: "img_d",
        key: [
            "17d172351bb1cce531033fd01c8e9746",
            "37ea2b71a26dc5de0ddb68426a7ae27e",
            "c47e23a4774e9b808842a7db5dcdb139",
            "c47e23a4774e9b808842a7db5dcdb139",
            "c47e23a4774e9b808842a7db5dcdb139"
        ],
        // //proxy: "/proxy/proxy.jsp?"
    });
    myterrainlayer = viewer.imageryLayers.addImageryProvider(imageryProvider);
}

var layerWorks = [];
function load_model(layermanager, urls, viewer) {
    // removeModel();
    //判断时间授权半年
    var curDate = new Date().getTime();
    var authorizationS = new Date().getTime();
    if (curDate > authorizationS) {
        return;
    } else {
        for (var i = 0; i < urls.length; i++) {
            layermanager.url = urls[i]
            console.log("dada", layermanager)
            var layerWork = gsp3d.layer.createLayer(layermanager, viewer);
            layerWorks.push(layerWork)
        }
    }
    return layerWork;
}
//建筑模型
function Demo_model(layermanager, viewer) {
    // removeModel();
    //判断时间授权半年
    var layerWork;
    var curDate = new Date().getTime();
    var authorizationS = new Date().getTime();
    if (curDate > authorizationS) {
        return;
    } else {
        layerWork = gsp3d.layer.createLayer(layermanager, viewer);
        layerWorks.push(layerWork)
    }
    return layerWork;
}
//地下材质沙石
function caizhi1_model(layermanager, viewer) {
    // removeModel();
    //判断时间授权半年
    var layerWork;
    var curDate = new Date().getTime();
    var authorizationS = new Date().getTime();
    if (curDate > authorizationS) {
        return;
    } else {
        layerWork = gsp3d.layer.createLayer(layermanager, viewer);
        layerWorks.push(layerWork)
    }
    return layerWork;
}
//地下材质土壤
function caizhi2_model(layermanager, viewer) {
    // removeModel();
    //判断时间授权半年
    var layerWork;
    var curDate = new Date().getTime();
    var authorizationS = new Date().getTime();
    if (curDate > authorizationS) {
        return;
    } else {
        layerWork = gsp3d.layer.createLayer(layermanager, viewer);
        layerWorks.push(layerWork)
    }
    return layerWork;
}
//地下管线
function guanxian1_model(layermanager, viewer) {
    // removeModel();
    //判断时间授权半年
    var layerWork;
    var curDate = new Date().getTime();
    var authorizationS = new Date().getTime();
    if (curDate > authorizationS) {
        return;
    } else {
        layerWork = gsp3d.layer.createLayer(layermanager, viewer);
        layerWorks.push(layerWork)
    }
    return layerWork;
}
function guanxian2_model(layermanager, viewer) {
    // removeModel();
    //判断时间授权半年
    var layerWork;
    var curDate = new Date().getTime();
    var authorizationS = new Date().getTime();
    if (curDate > authorizationS) {
        return;
    } else {
        layerWork = gsp3d.layer.createLayer(layermanager, viewer);
        layerWorks.push(layerWork)
    }
    return layerWork;
}

//管线单体化模型
function pipeline_model(layermanager, viewer) {
    // removeModel();
    show_picked_featureinfo(viewer);
    //判断时间授权半年
    var layerWork;
    var curDate = new Date().getTime();
    var authorizationS = new Date().getTime();
    if (curDate > authorizationS) {
        return;
    } else {
         var layerWork = gsp3d.layer.createLayer(layermanager, viewer);
        layerWorks.push(layerWork)
    }
    return layerWork;
}

//删除模型
function removeModel() {
    if (layerWorks.length !== 0) {
        for (var k = 0; k < layerWorks.length; k++) {
            layerWorks[k].remove();
            layerWorks.splice(k, 1);

        }
        console.log("清除模型成功", layerWorks)
    } else {
        return
    }
}
// function showScope(viewer, url) {
//     var that = this;
//     that.layerScope = new gsp3d.layer.GeoJsonLayer(
//         {
//             name: "管线",
//             url: url,
//             symbol: {
//                 styleOptions: {
//                     fill: true,
//                     opacity: 0.3,
//                     outlineColor: "#FED976",
//                     outlineWidth: 30,
//                     outlineOpacity: 0.5,
//                     width: 12,
//                     extrudedHeight: 5,//立体高
//                     height: 5,//高度
//                     cornerType: Cesium.CornerType.BEVELED,//
//                     outline: true,//外边线
//                     radius: 25,
//                     material: {
//                         solidColor: {
//                             color: {
//                                 rgba: [0, 0, 255, 255],
//                             },
//                         },
//                     },
//                     label: {
//                         //面中心点，显示文字的配置
//                         field: "name", //对应的属性名称
//                         font_size: 25,
//                         color: "#071c94",
//                         border: true,
//                         border_color: "#dcd8d8",
//                     },
//                 },
//             },
//             // popup: "{ORGNAME}",
//             "tooltip": "{name}",
//             click: function (entity) {
//
//             },
//             mouseover: function (entity) {
//
//
//                 //   that.highlightedEntity(entity);
//             },
//             mouseout: function (entity) {
//
//                 //   that.clearLastHighlightedEntity();
//             },
//             visible: true,
//             flyTo: false,
//         },
//         viewer
//     );
//
// }

// function removeScope() {
//     if (this.layerScope != null) {
//         this.layerScope.remove();
//     } else {
//         return
//     }
// }

/**
 * 
 * @param {*} viewer 
 * @param {*} flydata   
 * 
 */

var lineEntity;
//修改 20210323
function line_roam(viewer, lineInfo) {
    viewer.entities.removeAll();

    flyLine = new gsp3d.FlyLine(viewer, lineInfo);
    flyLine.start();
}
// 显示路线 20210323
function show_line(viewer, lineInfo) {
     var flyLonlat = [];
    var flyLine;
    flyLine = new gsp3d.FlyLine(viewer, lineInfo);
    flyLine.start();
    for ( var item in flyLine.arrLinePoint) {

        if (typeof flyLine.arrLinePoint[item] !== "function") {
            for ( var itemChild in flyLine.arrLinePoint[item].lonlat) {
                if (typeof flyLine.arrLinePoint[item].lonlat[itemChild] !== "function") {
                    flyLonlat.push(flyLine.arrLinePoint[item].lonlat[itemChild])
                }
            }
        }
    }
    // 添加路线
    this.lineEntity = viewer.entities.add({
        // name: 'Orange line with black outline at height and following the surface',
        polyline: {
            positions: Cesium.Cartesian3.fromDegreesArrayHeights(flyLonlat),
            // width: 5,
            material: new Cesium.PolylineOutlineMaterialProperty({
                // color: Cesium.Color.ORANGE,
                // outlineWidth: 2,
                // outlineColor: Cesium.Color.BLACK
            })
        }
    });
    return flyLine;
}

//暂停巡更  20210323
function pause_roam(viewer, isStart) {
    if (flyLine) {
        viewer.clock.shouldAnimate = isStart;
    }
}
/**
 * 人行漫游
 * @param {*} flydata 
 
 * @param {*} viewer 
 */

function line_roam_man(flydata, viewer) {
    flyLine = new gsp3d.FlyLine(viewer, flydata);
    flyLine.start();
}

function line_roam_fly(flydata, viewer) {
    flyLine = new gsp3d.FlyLine(viewer, flydata);
    flyLine.start();
}
// 停止巡更
function stop_roam() {
    if (flyLine) {
        flyLine.destroy();
    }
}
