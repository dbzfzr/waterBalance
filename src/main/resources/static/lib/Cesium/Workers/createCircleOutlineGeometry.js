/**
 * Cesium - https://github.com/AnalyticalGraphicsInc/cesium
 *
 * Copyright 2011-2017 Cesium Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 
 *  该版本修改了部分代码，主要是汉化、优化功能、添加接口 等 by  http://marsgis.cn
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Columbus View (Pat. Pend.)
 *
 * Portions licensed separately.
 * See https://github.com/AnalyticalGraphicsInc/cesium/blob/master/LICENSE.md for full licensing details.
 */
define(["./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5","./Transforms-f017fb11","./RuntimeError-d5522ee3","./WebGLConstants-554ddbe2","./ComponentDatatype-569c1e3e","./GeometryAttribute-78070f6e","./when-c208a7cf","./GeometryAttributes-c3465b51","./IndexDatatype-7119db15","./GeometryOffsetAttribute-0abfa3f6","./EllipseGeometryLibrary-596447b4","./EllipseOutlineGeometry-93e12950"],function(l,e,i,r,t,n,s,o,a,d,u,c,m,p,f,y,G,_){"use strict";function h(e){var i=(e=r.defaultValue(e,r.defaultValue.EMPTY_OBJECT)).radius,t={center:e.center,semiMajorAxis:i,semiMinorAxis:i,ellipsoid:e.ellipsoid,height:e.height,extrudedHeight:e.extrudedHeight,granularity:e.granularity,numberOfVerticalLines:e.numberOfVerticalLines};this._ellipseGeometry=new _.EllipseOutlineGeometry(t),this._workerName="createCircleOutlineGeometry"}h.packedLength=_.EllipseOutlineGeometry.packedLength,h.pack=function(e,i,t){return _.EllipseOutlineGeometry.pack(e._ellipseGeometry,i,t)};var b=new _.EllipseOutlineGeometry({center:new n.Cartesian3,semiMajorAxis:1,semiMinorAxis:1}),E={center:new n.Cartesian3,radius:void 0,ellipsoid:n.Ellipsoid.clone(n.Ellipsoid.UNIT_SPHERE),height:void 0,extrudedHeight:void 0,granularity:void 0,numberOfVerticalLines:void 0,semiMajorAxis:void 0,semiMinorAxis:void 0};return h.unpack=function(e,i,t){var r=_.EllipseOutlineGeometry.unpack(e,i,b);return E.center=n.Cartesian3.clone(r._center,E.center),E.ellipsoid=n.Ellipsoid.clone(r._ellipsoid,E.ellipsoid),E.height=r._height,E.extrudedHeight=r._extrudedHeight,E.granularity=r._granularity,E.numberOfVerticalLines=r._numberOfVerticalLines,l.defined(t)?(E.semiMajorAxis=r._semiMajorAxis,E.semiMinorAxis=r._semiMinorAxis,t._ellipseGeometry=new _.EllipseOutlineGeometry(E),t):(E.radius=r._semiMajorAxis,new h(E))},h.createGeometry=function(e){return _.EllipseOutlineGeometry.createGeometry(e._ellipseGeometry)},function(e,i){return l.defined(i)&&(e=h.unpack(e,i)),e._ellipseGeometry._center=n.Cartesian3.clone(e._ellipseGeometry._center),e._ellipseGeometry._ellipsoid=n.Ellipsoid.clone(e._ellipseGeometry._ellipsoid),h.createGeometry(e)}});
