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
define(["./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5","./Transforms-f017fb11","./RuntimeError-d5522ee3","./WebGLConstants-554ddbe2","./ComponentDatatype-569c1e3e","./GeometryAttribute-78070f6e","./when-c208a7cf","./GeometryAttributes-c3465b51","./IndexDatatype-7119db15","./GeometryOffsetAttribute-0abfa3f6","./VertexFormat-b4c6d1c2","./EllipsoidGeometry-5feceec0"],function(a,e,t,i,r,o,n,s,d,c,l,m,f,u,p,y,G,b){"use strict";function k(e){var t=i.defaultValue(e.radius,1),r={radii:new o.Cartesian3(t,t,t),stackPartitions:e.stackPartitions,slicePartitions:e.slicePartitions,vertexFormat:e.vertexFormat};this._ellipsoidGeometry=new b.EllipsoidGeometry(r),this._workerName="createSphereGeometry"}k.packedLength=b.EllipsoidGeometry.packedLength,k.pack=function(e,t,r){return b.EllipsoidGeometry.pack(e._ellipsoidGeometry,t,r)};var v=new b.EllipsoidGeometry,x={radius:void 0,radii:new o.Cartesian3,vertexFormat:new G.VertexFormat,stackPartitions:void 0,slicePartitions:void 0};return k.unpack=function(e,t,r){var i=b.EllipsoidGeometry.unpack(e,t,v);return x.vertexFormat=G.VertexFormat.clone(i._vertexFormat,x.vertexFormat),x.stackPartitions=i._stackPartitions,x.slicePartitions=i._slicePartitions,a.defined(r)?(o.Cartesian3.clone(i._radii,x.radii),r._ellipsoidGeometry=new b.EllipsoidGeometry(x),r):(x.radius=i._radii.x,new k(x))},k.createGeometry=function(e){return b.EllipsoidGeometry.createGeometry(e._ellipsoidGeometry)},function(e,t){return a.defined(t)&&(e=k.unpack(e,t)),k.createGeometry(e)}});
