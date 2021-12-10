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
define(["./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5","./Transforms-f017fb11","./RuntimeError-d5522ee3","./WebGLConstants-554ddbe2","./ComponentDatatype-569c1e3e","./GeometryAttribute-78070f6e","./when-c208a7cf","./GeometryAttributes-c3465b51","./IndexDatatype-7119db15","./GeometryOffsetAttribute-0abfa3f6","./EllipsoidOutlineGeometry-05dfc7e0"],function(n,e,i,r,t,s,a,o,d,l,u,c,f,p,m,y,G){"use strict";function b(e){var i=r.defaultValue(e.radius,1),t={radii:new s.Cartesian3(i,i,i),stackPartitions:e.stackPartitions,slicePartitions:e.slicePartitions,subdivisions:e.subdivisions};this._ellipsoidGeometry=new G.EllipsoidOutlineGeometry(t),this._workerName="createSphereOutlineGeometry"}b.packedLength=G.EllipsoidOutlineGeometry.packedLength,b.pack=function(e,i,t){return G.EllipsoidOutlineGeometry.pack(e._ellipsoidGeometry,i,t)};var k=new G.EllipsoidOutlineGeometry,v={radius:void 0,radii:new s.Cartesian3,stackPartitions:void 0,slicePartitions:void 0,subdivisions:void 0};return b.unpack=function(e,i,t){var r=G.EllipsoidOutlineGeometry.unpack(e,i,k);return v.stackPartitions=r._stackPartitions,v.slicePartitions=r._slicePartitions,v.subdivisions=r._subdivisions,n.defined(t)?(s.Cartesian3.clone(r._radii,v.radii),t._ellipsoidGeometry=new G.EllipsoidOutlineGeometry(v),t):(v.radius=r._radii.x,new b(v))},b.createGeometry=function(e){return G.EllipsoidOutlineGeometry.createGeometry(e._ellipsoidGeometry)},function(e,i){return n.defined(i)&&(e=b.unpack(e,i)),b.createGeometry(e)}});
