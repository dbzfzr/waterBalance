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
define(["./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5","./when-c208a7cf","./AttributeCompression-4cb3e905","./createTaskProcessorWorker"],function(e,a,r,t,v,y,n,i,A,s){"use strict";var M=32767,R=new y.Cartographic,x=new y.Cartesian3,z=new y.Rectangle,D=new y.Ellipsoid,E={min:void 0,max:void 0};return s(function(e,a){var r=new Uint16Array(e.positions);!function(e){e=new Float64Array(e);var a=0;E.min=e[a++],E.max=e[a++],y.Rectangle.unpack(e,a,z),a+=y.Rectangle.packedLength,y.Ellipsoid.unpack(e,a,D)}(e.packedBuffer);var t=z,n=D,i=E.min,s=E.max,o=r.length/3,c=r.subarray(0,o),u=r.subarray(o,2*o),f=r.subarray(2*o,3*o);A.AttributeCompression.zigZagDeltaDecode(c,u,f);for(var p=new Float64Array(r.length),l=0;l<o;++l){var d=c[l],h=u[l],b=f[l],m=v.CesiumMath.lerp(t.west,t.east,d/M),C=v.CesiumMath.lerp(t.south,t.north,h/M),g=v.CesiumMath.lerp(i,s,b/M),w=y.Cartographic.fromRadians(m,C,g,R),k=n.cartographicToCartesian(w,x);y.Cartesian3.pack(k,p,3*l)}return a.push(p.buffer),{positions:p.buffer}})});
