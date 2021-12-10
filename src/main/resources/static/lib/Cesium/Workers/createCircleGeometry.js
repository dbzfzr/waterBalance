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
define(["./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5","./Transforms-f017fb11","./RuntimeError-d5522ee3","./WebGLConstants-554ddbe2","./ComponentDatatype-569c1e3e","./GeometryAttribute-78070f6e","./when-c208a7cf","./GeometryAttributes-c3465b51","./AttributeCompression-4cb3e905","./GeometryPipeline-63aa5551","./EncodedCartesian3-e4976669","./IndexDatatype-7119db15","./IntersectionTests-e02ea381","./Plane-f99813ce","./GeometryOffsetAttribute-0abfa3f6","./VertexFormat-b4c6d1c2","./EllipseGeometryLibrary-596447b4","./GeometryInstance-c9988072","./EllipseGeometry-c44bacf1"],function(o,e,t,r,i,a,n,l,s,d,m,c,u,p,y,_,f,h,G,x,g,b,v,E,w){"use strict";function A(e){var t=(e=r.defaultValue(e,r.defaultValue.EMPTY_OBJECT)).radius,i={center:e.center,semiMajorAxis:t,semiMinorAxis:t,ellipsoid:e.ellipsoid,height:e.height,extrudedHeight:e.extrudedHeight,granularity:e.granularity,vertexFormat:e.vertexFormat,stRotation:e.stRotation,shadowVolume:e.shadowVolume};this._ellipseGeometry=new w.EllipseGeometry(i),this._workerName="createCircleGeometry"}A.packedLength=w.EllipseGeometry.packedLength,A.pack=function(e,t,i){return w.EllipseGeometry.pack(e._ellipseGeometry,t,i)};var C=new w.EllipseGeometry({center:new a.Cartesian3,semiMajorAxis:1,semiMinorAxis:1}),M={center:new a.Cartesian3,radius:void 0,ellipsoid:a.Ellipsoid.clone(a.Ellipsoid.UNIT_SPHERE),height:void 0,extrudedHeight:void 0,granularity:void 0,vertexFormat:new b.VertexFormat,stRotation:void 0,semiMajorAxis:void 0,semiMinorAxis:void 0,shadowVolume:void 0};return A.unpack=function(e,t,i){var r=w.EllipseGeometry.unpack(e,t,C);return M.center=a.Cartesian3.clone(r._center,M.center),M.ellipsoid=a.Ellipsoid.clone(r._ellipsoid,M.ellipsoid),M.height=r._height,M.extrudedHeight=r._extrudedHeight,M.granularity=r._granularity,M.vertexFormat=b.VertexFormat.clone(r._vertexFormat,M.vertexFormat),M.stRotation=r._stRotation,M.shadowVolume=r._shadowVolume,o.defined(i)?(M.semiMajorAxis=r._semiMajorAxis,M.semiMinorAxis=r._semiMinorAxis,i._ellipseGeometry=new w.EllipseGeometry(M),i):(M.radius=r._semiMajorAxis,new A(M))},A.createGeometry=function(e){return w.EllipseGeometry.createGeometry(e._ellipseGeometry)},A.createShadowVolume=function(e,t,i){var r=e._ellipseGeometry._granularity,o=e._ellipseGeometry._ellipsoid,a=t(r,o),n=i(r,o);return new A({center:e._ellipseGeometry._center,radius:e._ellipseGeometry._semiMajorAxis,ellipsoid:o,stRotation:e._ellipseGeometry._stRotation,granularity:r,extrudedHeight:a,height:n,vertexFormat:b.VertexFormat.POSITION_ONLY,shadowVolume:!0})},n.defineProperties(A.prototype,{rectangle:{get:function(){return this._ellipseGeometry.rectangle}},textureCoordinateRotationPoints:{get:function(){return this._ellipseGeometry.textureCoordinateRotationPoints}}}),function(e,t){return o.defined(t)&&(e=A.unpack(e,t)),e._ellipseGeometry._center=a.Cartesian3.clone(e._ellipseGeometry._center),e._ellipseGeometry._ellipsoid=a.Ellipsoid.clone(e._ellipseGeometry._ellipsoid),A.createGeometry(e)}});
