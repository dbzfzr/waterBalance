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
define(["exports","./defined-b9ff0e39","./Check-e6691f86","./Math-92bd3539","./Cartesian2-8fa798b8"],function(t,u,o,r,c){"use strict";var s={octEncodeInRange:function(t,o,e){if(e.x=t.x/(Math.abs(t.x)+Math.abs(t.y)+Math.abs(t.z)),e.y=t.y/(Math.abs(t.x)+Math.abs(t.y)+Math.abs(t.z)),t.z<0){var n=e.x,a=e.y;e.x=(1-Math.abs(a))*r.CesiumMath.signNotZero(n),e.y=(1-Math.abs(n))*r.CesiumMath.signNotZero(a)}return e.x=r.CesiumMath.toSNorm(e.x,o),e.y=r.CesiumMath.toSNorm(e.y,o),e},octEncode:function(t,o){return s.octEncodeInRange(t,255,o)}},e=new c.Cartesian2,n=new Uint8Array(1);function a(t){return n[0]=t,n[0]}s.octEncodeToCartesian4=function(t,o){return s.octEncodeInRange(t,65535,e),o.x=a(e.x*(1/256)),o.y=a(e.x),o.z=a(e.y*(1/256)),o.w=a(e.y),o},s.octDecodeInRange=function(t,o,e,n){if(n.x=r.CesiumMath.fromSNorm(t,e),n.y=r.CesiumMath.fromSNorm(o,e),n.z=1-(Math.abs(n.x)+Math.abs(n.y)),n.z<0){var a=n.x;n.x=(1-Math.abs(n.y))*r.CesiumMath.signNotZero(a),n.y=(1-Math.abs(a))*r.CesiumMath.signNotZero(n.y)}return c.Cartesian3.normalize(n,n)},s.octDecode=function(t,o,e){return s.octDecodeInRange(t,o,255,e)},s.octDecodeFromCartesian4=function(t,o){var e=256*t.x+t.y,n=256*t.z+t.w;return s.octDecodeInRange(e,n,65535,o)},s.octPackFloat=function(t){return 256*t.x+t.y};var i=new c.Cartesian2;function f(t){return t>>1^-(1&t)}s.octEncodeFloat=function(t){return s.octEncode(t,i),s.octPackFloat(i)},s.octDecodeFloat=function(t,o){var e=t/256,n=Math.floor(e),a=256*(e-n);return s.octDecode(n,a,o)},s.octPack=function(t,o,e,n){var a=s.octEncodeFloat(t),r=s.octEncodeFloat(o),c=s.octEncode(e,i);return n.x=65536*c.x+a,n.y=65536*c.y+r,n},s.octUnpack=function(t,o,e,n){var a=t.x/65536,r=Math.floor(a),c=65536*(a-r);a=t.y/65536;var i=Math.floor(a),u=65536*(a-i);s.octDecodeFloat(c,o),s.octDecodeFloat(u,e),s.octDecode(r,i,n)},s.compressTextureCoordinates=function(t){return 4096*(4095*t.x|0)+(4095*t.y|0)},s.decompressTextureCoordinates=function(t,o){var e=t/4096,n=Math.floor(e);return o.x=n/4095,o.y=(t-4096*n)/4095,o},s.zigZagDeltaDecode=function(t,o,e){for(var n=t.length,a=0,r=0,c=0,i=0;i<n;++i)a+=f(t[i]),r+=f(o[i]),t[i]=a,o[i]=r,u.defined(e)&&(c+=f(e[i]),e[i]=c)},t.AttributeCompression=s});
