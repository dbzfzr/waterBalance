/**
 * 20211013 Wangchong 3维地下管网水流向控制
 */
var waterLineCorridorPrimitiveArray = [];

var waterLineGraphicLayer = null;
/**
 * 添加水流向 图层
 * @param graphicLayer
 */
// 短
var smallLengthRepeat = new Cesium.Cartesian2(2.0, 1.0);
var smallLengthRepeat0 =new Cesium.Cartesian2(4.0, 1.0);
var smallLengthRepeat1 = new Cesium.Cartesian2(6.0, 1.0);
var smallLengthRepeat2 = new Cesium.Cartesian2(8.0,1.0);
var smallLengthRepeat3 = new Cesium.Cartesian2(7.0,1.0);
var smallLengthRepeat4 =  new Cesium.Cartesian2(9.0,1.0);
var smallLengthRepeat5 =  new Cesium.Cartesian2(10.0,1.0);
var smallLengthRepeat6  =   new Cesium.Cartesian2(5.0,1.0);
//长
var bigLengthRepeat = new Cesium.Cartesian2(11.0, 1.0);
var bigLengthRepeat1 = new Cesium.Cartesian2(12.0, 1.0);
var bigLengthRepeat2 = new Cesium.Cartesian2(13.0, 1.0);
var bigLengthRepeat3 = new Cesium.Cartesian2(14.0, 1.0);
var bigLengthRepeat4 = new Cesium.Cartesian2(16.0, 1.0);
var bigLengthRepeat5 = new Cesium.Cartesian2(17.0, 1.0);
var bigLengthRepeat6 = new Cesium.Cartesian2(18.0, 1.0);
function addWaterLine(graphicLayer){

    var primitive1 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172319, 30.200748, 9.3],
            [120.172139, 30.200675, 9.0]
        ],
        style: {
            height: 9.3,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });

    primitive1.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive1');
    })
    graphicLayer.addGraphic(primitive1); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive1);


    var primitive2 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.171958, 30.200602, 8.7],
            [120.172112, 30.200663,  9.0]
        ],
        style: {
            height: 9.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });

    primitive2.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive2');
    })
    graphicLayer.addGraphic(primitive2); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive2);


    var primitive3 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.17197, 30.200579, 6.9],
            [120.172007, 30.200594, 7.1]
        ],
        style: {
            height: 7.1,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });

    primitive3.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive3');
    })
    graphicLayer.addGraphic(primitive3); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive3);


    var primitive4 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172331, 30.200725, 7.6],
            [120.172024,30.2006, 7.0]
        ],
        style: {
            height: 7.6,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });

    primitive4.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive4');
    })
    graphicLayer.addGraphic(primitive4); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive4);



    var primitive5 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.171972, 30.200574, 5.5],
            [120.17215, 30.200647, 5.9]
        ],
        style: {
            height: 5.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });

    primitive5.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive5');
    })
    graphicLayer.addGraphic(primitive5); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive5);



    var primitive6 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172335,30.200722, 6.2],
            [120.172177, 30.200656, 5.9]
        ],
        style: {
            height: 6.2,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });

    primitive6.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive6');
    })
    graphicLayer.addGraphic(primitive6); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive6);



    var primitive7 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.17202, 30.200589, 7],
            [120.172698, 30.199319, 6.2]
        ],
        style: {
            height: 7,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: new Cesium.Cartesian2(40.0, 1.0),
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive7.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive7');
    })
    graphicLayer.addGraphic(primitive7); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive7);






    var primitive8 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172131, 30.200656, 9.0],
            [120.172289, 30.200362, 8.8]
        ],
        style: {
            height: 9.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive8.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive8');
    })
    graphicLayer.addGraphic(primitive8); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive8);


    var primitive9 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172169, 30.200643, 5.9],
            [120.172256, 30.20048, 5.8]
        ],
        style: {
            height: 5.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive9.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive9');
    })
    graphicLayer.addGraphic(primitive9); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive9);


    var primitive10 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172268, 30.200458, 5.9],
            [120.172286, 30.200423, 5.8]
        ],
        style: {
            height: 5.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive10.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive10');
    })
    graphicLayer.addGraphic(primitive10); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive10);


    var primitive11 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.1723, 30.200397, 6.0],
            [120.172418, 30.200174, 5.6]
        ],
        style: {
            height: 6.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat3,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive11.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive11');
    })
    graphicLayer.addGraphic(primitive11); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive11);


    var primitive12 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172597, 30.200481, 9.3],
            [120.172309, 30.200354, 8.8]
        ],
        style: {
            height: 9.3,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive12.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive12');
    })
    graphicLayer.addGraphic(primitive12); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive12);


    var primitive13 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.17213,30.200281, 8.4],
            [120.172285, 30.200342, 8.8]
        ],
        style: {
            height: 8.8,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive13.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive13');
    })
    graphicLayer.addGraphic(primitive13); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive13);

    var primitive14 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172302,30.200337, 8.8],
            [120.17245, 30.20006, 8.6]
        ],
        style: {
            height: 8.8,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive14.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive14');
    })
    graphicLayer.addGraphic(primitive14); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive14);

    var primitive15 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172226,30.200082, 5.2],
            [120.172413, 30.200155, 5.6]
        ],
        style: {
            height: 5.6,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive15.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive15');
    })
    graphicLayer.addGraphic(primitive15); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive15);

    var primitive16 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172597,30.20023, 5.9],
            [120.172441, 30.200167, 5.6]
        ],
        style: {
            height: 5.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive16.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive16');
    })
    graphicLayer.addGraphic(primitive16); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive16);

    var primitive17 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172432,30.20015, 5.6],
            [120.172594,30.199846, 5.4]
        ],
        style: {
            height: 5.6,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive17.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive17');
    })
    graphicLayer.addGraphic(primitive17); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive17);

    var primitive18 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172475,30.200013, 8.6],
            [120.172632,30.199714, 8.4]
        ],
        style: {
            height: 8.6,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive18.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive18');
    })
    graphicLayer.addGraphic(primitive18); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive18);

    var primitive19 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172646,30.19969, 8.4],
            [120.172806,30.199391, 8.1]
        ],
        style: {
            height: 8.4,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive19.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive19');
    })
    graphicLayer.addGraphic(primitive19); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive19);

    var primitive20 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172607,30.199822, 5.4],
            [120.172769,30.199517, 5.1]
        ],
        style: {
            height: 5.4,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive20.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive20');
    })
    graphicLayer.addGraphic(primitive20); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive20);

    var primitive21 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172584,30.199428, 4.8],
            [120.172762,30.199499, 5.2]
        ],
        style: {
            height: 5.2,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive21.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive21');
    })
    graphicLayer.addGraphic(primitive21); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive21);

    var primitive22 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172947,30.199573, 5.5],
            [120.172789,30.199511, 5.3]
        ],
        style: {
            height: 5.5,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive22.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive22');
    })
    graphicLayer.addGraphic(primitive22); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive22);

    var primitive23 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172645,30.199310, 7.8],
            [120.172801,30.199373, 8.2]
        ],
        style: {
            height: 8.2,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive23.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive23');
    })
    graphicLayer.addGraphic(primitive23); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive23);


    var primitive24 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173008,30.199458, 8.5],
            [120.172825,30.199382, 8.2]
        ],
        style: {
            height: 8.5,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive24.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive24');
    })
    graphicLayer.addGraphic(primitive24); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive24);

    var primitive25 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173021,30.199434, 6.8],
            [120.172715,30.199311, 6.2]
        ],
        style: {
            height: 6.8,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive25.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive25');
    })
    graphicLayer.addGraphic(primitive25); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive25);

    var primitive26 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172658,30.199288, 6.1],
            [120.172697,30.199304, 6.2]
        ],
        style: {
            height: 6.2,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive26.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive26');
    })
    graphicLayer.addGraphic(primitive26); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive26);


    var primitive27 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172782,30.199493, 5.2],
            [120.17287,30.199328, 5.1]
        ],
        style: {
            height: 5.2,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat0,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive27.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive27');
    })
    graphicLayer.addGraphic(primitive27); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive27);

    var primitive28 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172709,30.199299, 6.2],
            [120.172802,30.199126, 6.1]
        ],
        style: {
            height: 6.2,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive28.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive28');
    })
    graphicLayer.addGraphic(primitive28); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive28);



    var primitive29 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172819,30.199368, 8.2],
            [120.173007,30.199015, 7.9]
        ],
        style: {
            height: 8.2,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat3,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive29.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive29');
    })
    graphicLayer.addGraphic(primitive29); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive29);

    var primitive30 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172882,30.199304, 5.1],
            [120.172976,30.199129, 4.9]
        ],
        style: {
            height: 5.1,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive30.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive30');
    })
    graphicLayer.addGraphic(primitive30); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive30);

    var primitive31 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173299,30.199269, 5.6],
            [120.172995,30.199122, 5]
        ],
        style: {
            height: 5.6,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive31.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive31');
    })
    graphicLayer.addGraphic(primitive31); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive31);

    var primitive32 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172637,30.198944, 4.3],
            [120.172969,30.199109, 4.9]
        ],
        style: {
            height: 4.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat3,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive32.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive32');
    })
    graphicLayer.addGraphic(primitive32); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive32);

    var primitive33 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172815,30.199102, 6.1],
            [120.172909,30.198924, 5.9]
        ],
        style: {
            height: 6.1,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat2,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive33.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive33');
    })
    graphicLayer.addGraphic(primitive33); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive33);

    var primitive34 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173352,30.199168, 8.6],
            [120.173026,30.199009, 7.9]
        ],
        style: {
            height: 8.6,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive34.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive34');
    })
    graphicLayer.addGraphic(primitive34); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive34);

    var primitive35 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172702,30.198848, 7.3],
            [120.173001,30.198997, 7.9]
        ],
        style: {
            height: 7.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive35.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive35');
    })
    graphicLayer.addGraphic(primitive35); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive35);

    var primitive36 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173374,30.19914, 6.4],
            [120.172922,30.198919, 5.9]
        ],
        style: {
            height: 6.4,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive36.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive36');
    })
    graphicLayer.addGraphic(primitive36); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive36);

    var primitive37 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172722,30.198817, 5.6],
            [120.172905,30.198909, 6]
        ],
        style: {
            height: 6.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive37.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive37');
    })
    graphicLayer.addGraphic(primitive37); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive37);

    var primitive38 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172988,30.199104, 5.0],
            [120.173142,30.19882, 4.7]
        ],
        style: {
            height: 5.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive38.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive38');
    })
    graphicLayer.addGraphic(primitive38); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive38);

    var primitive39 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172919,30.198906, 6.0],
            [120.172983,30.198788, 5.9]
        ],
        style: {
            height: 6.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat0,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive39.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive39');
    })
    graphicLayer.addGraphic(primitive39); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive39);

    var primitive40 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.17302,30.198992, 7.9],
            [120.173149,30.198748, 7.8]
        ],
        style: {
            height: 7.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat2,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive40.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive40');
    })
    graphicLayer.addGraphic(primitive40); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive40);

    var primitive41 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.172995,30.198764, 5.9],
            [120.173365,30.198068, 5.4]
        ],
        style: {
            height: 5.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: new Cesium.Cartesian2(25.0, 1.0),
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive41.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive41');
    })
    graphicLayer.addGraphic(primitive41); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive41);

    var primitive42 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173163,30.198723, 7.8],
            [120.173459,30.198166, 7.5]
        ],
        style: {
            height: 7.8,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: new Cesium.Cartesian2(18.0, 1.0),
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive42.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive42');
    })
    graphicLayer.addGraphic(primitive42); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive42);

    var primitive43 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173154,30.198797, 4.8],
            [120.173448,30.198245, 4.4]
        ],
        style: {
            height: 4.8,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: new Cesium.Cartesian2(22.0, 1.0),
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive43.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive43');
    })
    graphicLayer.addGraphic(primitive43); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive43);

    var primitive44 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173624,30.198302, 4.7],
            [120.173467,30.198239, 4.4]
        ],
        style: {
            height: 4.7,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive44.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive44');
    })
    graphicLayer.addGraphic(primitive44); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive44);

    var primitive45 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173254,30.198153, 4.0],
            [120.17344,30.198228, 4.4]
        ],
        style: {
            height: 4.4,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive45.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive45');
    })
    graphicLayer.addGraphic(primitive45); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive45);

    var primitive46 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.17346,30.198222, 4.4],
            [120.173577,30.198001, 4.2]
        ],
        style: {
            height: 4.4,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive46.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive46');
    })
    graphicLayer.addGraphic(primitive46); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive46);

    var primitive47 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173311,30.198063, 7.2],
            [120.173466,30.198124, 7.5]
        ],
        style: {
            height: 7.5,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive47.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive47');
    })
    graphicLayer.addGraphic(primitive47); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive47);

    var primitive48 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173674,30.198209, 7.8],
            [120.173493,30.198136, 7.5]
        ],
        style: {
            height: 7.8,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive48.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive48');
    })
    graphicLayer.addGraphic(primitive48); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive48);

    var primitive49 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173323,30.198039, 5.3],
            [120.173361,30.198054, 5.4]
        ],
        style: {
            height: 5.4,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive49.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive49');
    })
    graphicLayer.addGraphic(primitive49); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive49);

    var primitive50 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173688,30.198185, 6.0],
            [120.17338,30.198061, 5.4]
        ],
        style: {
            height: 6.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive50.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive50');
    })
    graphicLayer.addGraphic(primitive50); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive50);

    var primitive51 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173486,30.198118, 7.5],
            [120.173667,30.197779, 7.2]
        ],
        style: {
            height: 7.5,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive51.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive51');
    })
    graphicLayer.addGraphic(primitive51); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive51);

    var primitive52 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.17359,30.197977, 4.3],
            [120.173709,30.197755, 4.1]
        ],
        style: {
            height: 4.3,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive52.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive52');
    })
    graphicLayer.addGraphic(primitive52); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive52);

    var primitive53 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173375,30.198049, 5.4],
            [120.173785,30.197281, 4.9]
        ],
        style: {
            height: 5.4,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: new Cesium.Cartesian2(25.0, 1.0),
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive53.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive53');
    })
    graphicLayer.addGraphic(primitive53); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive53);

    var primitive54 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.17372,30.197732, 4.1],
            [120.17385,30.197489, 3.9]
        ],
        style: {
            height: 4.1,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive54.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive54');
    })
    graphicLayer.addGraphic(primitive54); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive54);

    var primitive55 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173679,30.197756, 7.3],
            [120.173867,30.197403, 7.0]
        ],
        style: {
            height: 7.3,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive55.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive55');
    })
    graphicLayer.addGraphic(primitive55); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive55);

    var primitive56 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.17386,30.197469, 3.9],
            [120.174029,30.197156, 3.7]
        ],
        style: {
            height: 3.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive56.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive56');
    })
    graphicLayer.addGraphic(primitive56); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive56);

    var primitive57 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173879,30.197379, 7.0],
            [120.174039,30.19708, 6.8]
        ],
        style: {
            height: 7.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive57.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive57');
    })
    graphicLayer.addGraphic(primitive57); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive57);


    var primitive58 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174387,30.197311, 4.4],
            [120.174048,30.197152, 3.7]
        ],
        style: {
            height: 4.4,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive58.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive58');
    })
    graphicLayer.addGraphic(primitive58); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive58);

    var primitive59 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173628,30.196979, 3.0],
            [120.174023,30.19714, 3.7]
        ],
        style: {
            height: 3.7,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive59.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive59');
    })
    graphicLayer.addGraphic(primitive59); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive59);

    var primitive60 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173672,30.196916, 6.1],
            [120.174031,30.197062, 6.8]
        ],
        style: {
            height: 6.8,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive60.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive60');
    })
    graphicLayer.addGraphic(primitive60); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive60);

    var primitive61 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174449,30.197256, 7.6],
            [120.174086,30.197086, 6.9]
        ],
        style: {
            height: 7.6,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive61.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive61');
    })
    graphicLayer.addGraphic(primitive61); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive61);

    var primitive62 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173797,30.197258, 4.9],
            [120.173957,30.196956, 4.7]
        ],
        style: {
            height: 4.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive62.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive62');
    })
    graphicLayer.addGraphic(primitive62); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive62);

    var primitive63 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173711,30.196844, 4.2],
            [120.173952,30.196943, 4.7]
        ],
        style: {
            height: 4.7,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive63.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive63');
    })
    graphicLayer.addGraphic(primitive63); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive63);

    var primitive64 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174494,30.197187, 5.7],
            [120.174102,30.197002, 4.9]
        ],
        style: {
            height: 5.7,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive64.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive64');
    })
    graphicLayer.addGraphic(primitive64); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive64);

    var primitive65 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.1741,30.197002, 5.0],
            [120.173971,30.196951, 4.7]
        ],
        style: {
            height: 5.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat0,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive65.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive65');
    })
    graphicLayer.addGraphic(primitive65); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive65);

    var primitive66 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174041,30.197133, 3.7],
            [120.1742,30.196827, 3.5]
        ],
        style: {
            height: 3.7,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive66.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive66');
    })
    graphicLayer.addGraphic(primitive66); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive66);

    var primitive67 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174051,30.197056, 6.8],
            [120.174209,30.196754, 6.6]
        ],
        style: {
            height: 6.8,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive67.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive67');
    })
    graphicLayer.addGraphic(primitive67); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive67);

    var primitive68 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.173966,30.196939, 4.7],
            [120.174237,30.196414, 4.3]
        ],
        style: {
            height: 4.7,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: new Cesium.Cartesian2(20.0, 1.0),
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive68.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive68');
    })
    graphicLayer.addGraphic(primitive68); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive68);

    var primitive69 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174211,30.196803, 3.5],
            [120.174337,30.19656, 3.3]
        ],
        style: {
            height: 3.5,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat2,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive69.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive69');
    })
    graphicLayer.addGraphic(primitive69); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive69);

    var primitive70 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174219,30.19673, 6.6],
            [120.174347,30.196485, 6.4]
        ],
        style: {
            height: 6.6,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive70.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive70');
    })
    graphicLayer.addGraphic(primitive70); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive70);

    var primitive71 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174144,30.19647, 3.0],
            [120.174329,30.196543, 3.3]
        ],
        style: {
            height: 3.3,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive71.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive71');
    })
    graphicLayer.addGraphic(primitive71); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive71);

    var primitive72 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174514,30.196615, 3.7],
            [120.174356,30.196554, 3.3]
        ],
        style: {
            height: 3.7,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive72.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive72');
    })
    graphicLayer.addGraphic(primitive72); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive72);

    var primitive73 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174184,30.196409, 6.1],
            [120.174341,30.19647, 6.4]
        ],
        style: {
            height: 6.4,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat0,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive73.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive73');
    })
    graphicLayer.addGraphic(primitive73); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive73);

    var primitive74 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174547,30.196551, 6.8],
            [120.174368,30.19648, 6.4]
        ],
        style: {
            height: 6.8,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive74.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive74');
    })
    graphicLayer.addGraphic(primitive74); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive74);

    var primitive75 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.17435,30.196537, 3.4],
            [120.174528,30.196191, 3.1]
        ],
        style: {
            height: 3.4,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive75.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive75');
    })
    graphicLayer.addGraphic(primitive75); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive75);

    var primitive76 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174196,30.196385, 4.2],
            [120.174233,30.196399, 4.4]
        ],
        style: {
            height: 4.4,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive76.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive76');
    })
    graphicLayer.addGraphic(primitive76); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive76);

    var primitive77 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174561,30.196528, 4.9],
            [120.174253,30.196407, 4.3]
        ],
        style: {
            height: 4.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive77.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive77');
    })
    graphicLayer.addGraphic(primitive77); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive77);

    var primitive78 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174359,30.196462, 6.5],
            [120.174473,30.196244, 6.3]
        ],
        style: {
            height: 6.5,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive78.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive78');
    })
    graphicLayer.addGraphic(primitive78); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive78);

    var primitive79 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174247,30.196395, 4.4],
            [120.174271,30.196347, 4.3]
        ],
        style: {
            height: 4.4,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive79.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive79');
    })
    graphicLayer.addGraphic(primitive79); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive79);

    var primitive80 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174274,30.196344, 4.3],
            [120.174353,30.196136, 4.1]
        ],
        style: {
            height: 4.3,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat3,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive80.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive80');
    })
    graphicLayer.addGraphic(primitive80); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive80);

    var primitive81 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174355,30.196133, 4.2],
            [120.17448,30.195893, 4.0]
        ],
        style: {
            height: 4.2,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat3,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive81.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive81');
    })
    graphicLayer.addGraphic(primitive81); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive81);

    var primitive82 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174482,30.195888, 4.0],
            [120.174611,30.195681, 3.9]
        ],
        style: {
            height: 4.2,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive82.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive82');
    })
    graphicLayer.addGraphic(primitive82); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive82);

    var primitive83 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174488,30.19622, 6.3],
            [120.1746,30.196001, 6.1]
        ],
        style: {
            height: 6.3,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat2,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive83.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive83');
    })
    graphicLayer.addGraphic(primitive83); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive83);

    var primitive84 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174541,30.196166, 3.1],
            [120.174722,30.19582, 2.8]
        ],
        style: {
            height: 3.1,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat3,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive84.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive84');
    })
    graphicLayer.addGraphic(primitive84); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive84);

    var primitive85 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174613,30.195976, 6.1],
            [120.174724,30.195758, 5.9]
        ],
        style: {
            height: 6.1,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive85.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive85');
    })
    graphicLayer.addGraphic(primitive85); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive85);

    var primitive86 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174527,30.195729, 2.6],
            [120.174714,30.195800, 2.9]
        ],
        style: {
            height: 2.8,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive86.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive86');
    })
    graphicLayer.addGraphic(primitive86); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive86);

    var primitive87 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174896,30.195874, 3.2],
            [120.174741,30.195813, 2.9]
        ],
        style: {
            height: 3.2,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive87.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive87');
    })
    graphicLayer.addGraphic(primitive87); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive87);

    var primitive88 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174734,30.195794, 2.9],
            [120.174955,30.195366, 2.6]
        ],
        style: {
            height: 2.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive88.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive88');
    })
    graphicLayer.addGraphic(primitive88); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive88);

    var primitive89 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174561,30.195679, 5.6],
            [120.174716,30.19574, 6.0]
        ],
        style: {
            height: 6.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive89.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive89');
    })
    graphicLayer.addGraphic(primitive89); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive89);

    var primitive90 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174925,30.195822, 6.3],
            [120.174744,30.195751, 6.0]
        ],
        style: {
            height: 6.3,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat2,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive90.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive90');
    })
    graphicLayer.addGraphic(primitive90); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive90);

    var primitive91 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174575,30.195656, 3.8],
            [120.174607,30.195669, 3.9]
        ],
        style: {
            height: 3.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive91.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive91');
    })
    graphicLayer.addGraphic(primitive91); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive91);

    var primitive92 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174939,30.195799, 4.5],
            [120.174628,30.195676, 3.9]
        ],
        style: {
            height: 4.5,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive92.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive92');
    })
    graphicLayer.addGraphic(primitive92); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive92);

    var primitive93 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174738,30.195732, 6.0],
            [120.174862,30.195491, 5.8]
        ],
        style: {
            height: 6.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive93.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive93');
    })
    graphicLayer.addGraphic(primitive93); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive93);

    var primitive94 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174875,30.195466, 5.8],
            [120.175008,30.195209, 6.0]
        ],
        style: {
            height: 6.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive94.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive94');
    })
    graphicLayer.addGraphic(primitive94); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive94);

    var primitive95 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174622,30.195665, 3.9],
            [120.174644,30.195631, 3.8]
        ],
        style: {
            height: 3.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive95.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive95');
    })
    graphicLayer.addGraphic(primitive95); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive95);


    var primitive96 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174645,30.195628, 3.9],
            [120.175054,30.194836, 3.4]
        ],
        style: {
            height: 3.9,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: new Cesium.Cartesian2(32.0, 1.0),
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive96.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive96');
    })
    graphicLayer.addGraphic(primitive96); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive96);

    var primitive97 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174969,30.195341, 2.6],
            [120.175165,30.194962, 2.3]
        ],
        style: {
            height: 2.6,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive97.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive97');
    })
    graphicLayer.addGraphic(primitive97); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive97);

    var primitive98 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175022,30.195184, 6.0],
            [120.175164,30.194906, 5.8]
        ],
        style: {
            height: 6.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat5,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive98.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive98');
    })
    graphicLayer.addGraphic(primitive98); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive98);

    var primitive99 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174978,30.194875, 2.0],
            [120.175156,30.194945, 2.3]
        ],
        style: {
            height: 2.3,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive99.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive99');
    })
    graphicLayer.addGraphic(primitive99); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive99);

    var primitive100 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175344,30.195019, 2.6],
            [120.175185,30.194956, 2.3]
        ],
        style: {
            height: 2.6,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive100.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive100');
    })
    graphicLayer.addGraphic(primitive100); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive100);

    var primitive101 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175002,30.194828, 5.5],
            [120.175155,30.194888, 5.8]
        ],
        style: {
            height: 5.8,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat6,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive101.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive101');
    })
    graphicLayer.addGraphic(primitive101); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive101);

    var primitive102 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175365,30.194971, 6.2],
            [120.175184,30.1949, 5.8]
        ],
        style: {
            height: 6.2,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive102.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive102');
    })
    graphicLayer.addGraphic(primitive102); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive102);

    var primitive103 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175014,30.194805, 3.3],
            [120.175049,30.194819, 3.5]
        ],
        style: {
            height: 3.5,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive103.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive103');
    })
    graphicLayer.addGraphic(primitive103); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive103);

    var primitive104 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175378,30.194947, 4.0],
            [120.175072,30.194828, 3.4]
        ],
        style: {
            height: 4.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat:smallLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive104.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive104');
    })
    graphicLayer.addGraphic(primitive104); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive104);

    var primitive105 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175177,30.194937, 2.3],
            [120.175324,30.194657, 2.1]
        ],
        style: {
            height: 2.3,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive105.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive105');
    })
    graphicLayer.addGraphic(primitive105); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive105);

    var primitive106 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175065,30.194814, 3.5],
            [120.175208,30.19454, 3.2]
        ],
        style: {
            height: 3.5,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive106.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive106');
    })
    graphicLayer.addGraphic(primitive106); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive106);

    var primitive107 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175177,30.194882, 5.8],
            [120.175316,30.194609, 5.6]
        ],
        style: {
            height: 5.8,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive107.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive107');
    })
    graphicLayer.addGraphic(primitive107); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive107);

    var primitive108 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175605,30.194765, 2.6],
            [120.175341,30.194651, 2.1]
        ],
        style: {
            height: 2.6,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive108.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive108');
    })
    graphicLayer.addGraphic(primitive108); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive108);

    var primitive109 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.17497,30.194496, 1.5],
            [120.175314,30.19464, 2.1]
        ],
        style: {
            height: 2.1,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat1,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive109.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive109');
    })
    graphicLayer.addGraphic(primitive109); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive109);

    var primitive110 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.174994,30.194476, 5.0],
            [120.175306,30.194591, 5.6]
        ],
        style: {
            height: 5.6,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive110.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive110');
    })
    graphicLayer.addGraphic(primitive110); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive110);

    var primitive111 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175621,30.194734, 6.2],
            [120.175334,30.194602, 5.6]
        ],
        style: {
            height: 6.2,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat4,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive111.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive111');
    })
    graphicLayer.addGraphic(primitive111); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive111);

    var primitive112 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175012,30.194445, 2.9],
            [120.175201,30.194524, 3.3]
        ],
        style: {
            height: 3.3,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: smallLengthRepeat0,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive112.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive112');
    })
    graphicLayer.addGraphic(primitive112); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive112);

    var primitive113 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175635,30.194709, 4.0],
            [120.175224,30.194534, 3.2]
        ],
        style: {
            height: 4.0,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: bigLengthRepeat3,
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive113.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive113');
    })
    graphicLayer.addGraphic(primitive113); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive113);

    var primitive114 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175334,30.194632, 2.1],
            [120.175563,30.194191, 1.8]
        ],
        style: {
            height: 2.1,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: new Cesium.Cartesian2(16.0, 1.0),
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive114.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive114');
    })
    graphicLayer.addGraphic(primitive114); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive114);


    var primitive115 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175329,30.194584, 5.6],
            [120.175541,30.194179, 5.3]
        ],
        style: {
            height: 5.6,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: new Cesium.Cartesian2(15.0, 1.0),
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive115.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive115');
    })
    graphicLayer.addGraphic(primitive115); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive115);

    var primitive116 = new mars3d.graphic.CorridorPrimitive({
        positions: [
            [120.175217,30.194519, 3.3],
            [120.175421,30.19413, 3.0]
        ],
        style: {
            height: 3.3,
            width: 1.0,
            cornerType: Cesium.CornerType.MITERED,
            material: mars3d.MaterialUtil.createMaterial(mars3d.MaterialType.LineFlow, {
                image: "image/arrow.png",
                axisY: false,
                repeat: new Cesium.Cartesian2(14.0, 1.0),
                color: "#ffffff",
                speed: 20,
            }),
        },
    });
    primitive116.on(mars3d.EventType.click, function(event) {
        console.log('单击了管道水流向primitive116');
    })
    graphicLayer.addGraphic(primitive116); //primitive.addTo(graphicLayer)  //另外一种写法
    waterLineCorridorPrimitiveArray.push(primitive116);


}




function showWaterLine() {
    for (var i=0; i<waterLineCorridorPrimitiveArray.length; i++){
           waterLineGraphicLayer.addGraphic(waterLineCorridorPrimitiveArray[i]);
    }
}

function hideWaterLine() {
    for (var i=0; i<waterLineCorridorPrimitiveArray.length; i++){
        waterLineCorridorPrimitiveArray[i].remove(false);
    }
}
