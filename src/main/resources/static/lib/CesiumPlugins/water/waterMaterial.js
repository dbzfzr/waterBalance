/** 
 * 用于生成动态水效果
 **/
mars3d.waterMaterial = {
    waters: [],
    normalMapUrl: '../lib/CesiumPlugins/water/img/waterNormals.jpg', //水正常扰动的法线图 
    //自定义区域的动态水效果,使用方法： geometryInstance 用于限定动态水域的范围 
    apply: function (viewer, geometryInstance, normalMapUrl) {
        var water = viewer.scene.primitives.add(new Cesium.Primitive({
            geometryInstances: geometryInstance,
            appearance: new Cesium.EllipsoidSurfaceAppearance({
                aboveGround: false,
                material: new Cesium.Material({
                    fabric: {
                        type: 'Water',
                        uniforms: {
                            normalMap: normalMapUrl || this.normalMapUrl,//水正常扰动的法线图。
                            frequency: 8000.0,     //控制波数的数字。
                            animationSpeed: 0.02,   //控制水的动画速度的数字。
                            amplitude: 5.0,         //控制水波振幅的数字。
                            specularIntensity: 0.8,  //控制镜面反射强度的数字。  
                            baseWaterColor: new Cesium.Color.fromCssColorString("#006ab4"), //rgba颜色对象基础颜色的水。#00ffff,#00baff,#006ab4
                            blendColor: new Cesium.Color.fromCssColorString("#00baff")      //从水中混合到非水域时使用的rgba颜色对象。  
                        }
                    }
                }),
                fragmentShaderSource: this.getShader()
            }),
            show: true
        }));
        this.waters.push(water);

        return water;
    },
    //移除动态水效果, 使用方法： 
    remove: function (water) {
        viewer.scene.primitives.remove(water);
    },
    removeAll: function (viewer) {
        for (var i = 0; i < this.waters.length; i++) {
            viewer.scene.primitives.remove(this.waters[i]);
        }
        this.waters = [];
    },
    //重写shader，修改水面的透明度
    getShader: function () {
        return 'varying vec3 v_positionMC;\n\
                varying vec3 v_positionEC;\n\
                varying vec2 v_st;\n\
                \n\
                void main()\n\
                {\n\
                    czm_materialInput materialInput;\n\
                    vec3 normalEC = normalize(czm_normal3D * czm_geodeticSurfaceNormal(v_positionMC, vec3(0.0), vec3(1.0)));\n\
                #ifdef FACE_FORWARD\n\
                    normalEC = faceforward(normalEC, vec3(0.0, 0.0, 1.0), -normalEC);\n\
                #endif\n\
                    materialInput.s = v_st.s;\n\
                    materialInput.st = v_st;\n\
                    materialInput.str = vec3(v_st, 0.0);\n\
                    materialInput.normalEC = normalEC;\n\
                    materialInput.tangentToEyeMatrix = czm_eastNorthUpToEyeCoordinates(v_positionMC, materialInput.normalEC);\n\
                    vec3 positionToEyeEC = -v_positionEC;\n\
                    materialInput.positionToEyeEC = positionToEyeEC;\n\
                    czm_material material = czm_getMaterial(materialInput);\n\
                #ifdef FLAT\n\
                    gl_FragColor = vec4(material.diffuse + material.emission, material.alpha);\n\
                #else\n\
                    gl_FragColor = czm_phong(normalize(positionToEyeEC), material);\n\
                    gl_FragColor.a = 0.5;\n\
                #endif\n\
                }';
    },


};


