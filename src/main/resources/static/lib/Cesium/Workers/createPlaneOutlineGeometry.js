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
define(["./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5","./Transforms-f017fb11","./RuntimeError-d5522ee3","./WebGLConstants-554ddbe2","./ComponentDatatype-569c1e3e","./GeometryAttribute-78070f6e","./when-c208a7cf","./GeometryAttributes-c3465b51"],function(r,e,t,n,a,i,o,u,c,f,s,d,y,p){"use strict";function m(){this._workerName="createPlaneOutlineGeometry"}m.packedLength=0,m.pack=function(e,t){return t},m.unpack=function(e,t,n){return r.defined(n)?n:new m};var b=new i.Cartesian3(-.5,-.5,0),w=new i.Cartesian3(.5,.5,0);return m.createGeometry=function(){var e=new p.GeometryAttributes,t=new Uint16Array(8),n=new Float64Array(12);return n[0]=b.x,n[1]=b.y,n[2]=b.z,n[3]=w.x,n[4]=b.y,n[5]=b.z,n[6]=w.x,n[7]=w.y,n[8]=b.z,n[9]=b.x,n[10]=w.y,n[11]=b.z,e.position=new d.GeometryAttribute({componentDatatype:s.ComponentDatatype.DOUBLE,componentsPerAttribute:3,values:n}),t[0]=0,t[1]=1,t[2]=1,t[3]=2,t[4]=2,t[5]=3,t[6]=3,t[7]=0,new d.Geometry({attributes:e,indices:t,primitiveType:d.PrimitiveType.LINES,boundingSphere:new u.BoundingSphere(i.Cartesian3.ZERO,Math.sqrt(2))})},function(e,t){return r.defined(t)&&(e=m.unpack(e,t)),m.createGeometry(e)}});
