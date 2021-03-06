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
define(["exports","./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./Math-92bd3539","./WebGLConstants-554ddbe2"],function(e,r,t,n,N,E){"use strict";var a={UNSIGNED_BYTE:E.WebGLConstants.UNSIGNED_BYTE,UNSIGNED_SHORT:E.WebGLConstants.UNSIGNED_SHORT,UNSIGNED_INT:E.WebGLConstants.UNSIGNED_INT,getSizeInBytes:function(e){switch(e){case a.UNSIGNED_BYTE:return Uint8Array.BYTES_PER_ELEMENT;case a.UNSIGNED_SHORT:return Uint16Array.BYTES_PER_ELEMENT;case a.UNSIGNED_INT:return Uint32Array.BYTES_PER_ELEMENT}},fromSizeInBytes:function(e){switch(e){case 2:return a.UNSIGNED_SHORT;case 4:return a.UNSIGNED_INT;case 1:return a.UNSIGNED_BYTE}},validate:function(e){return r.defined(e)&&(e===a.UNSIGNED_BYTE||e===a.UNSIGNED_SHORT||e===a.UNSIGNED_INT)},createTypedArray:function(e,r){return e>=N.CesiumMath.SIXTY_FOUR_KILOBYTES?new Uint32Array(r):new Uint16Array(r)},createTypedArrayFromArrayBuffer:function(e,r,t,n){return e>=N.CesiumMath.SIXTY_FOUR_KILOBYTES?new Uint32Array(r,t,n):new Uint16Array(r,t,n)}},S=n.freezeObject(a);e.IndexDatatype=S});
