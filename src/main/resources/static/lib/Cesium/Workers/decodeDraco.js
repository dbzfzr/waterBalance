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
define(["./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./RuntimeError-d5522ee3","./WebGLConstants-554ddbe2","./ComponentDatatype-569c1e3e","./when-c208a7cf","./IndexDatatype-7119db15","./createTaskProcessorWorker"],function(y,e,r,t,n,b,a,A,o,m,i){"use strict";var l;function w(e,r,t){var n,a=e.num_points(),o=t.num_components(),i=new l.AttributeQuantizationTransform;if(i.InitFromAttribute(t)){for(var u=new Array(o),s=0;s<o;++s)u[s]=i.min_value(s);n={quantizationBits:i.quantization_bits(),minValues:u,range:i.range(),octEncoded:!1}}l.destroy(i),(i=new l.AttributeOctahedronTransform).InitFromAttribute(t)&&(n={quantizationBits:i.quantization_bits(),octEncoded:!0}),l.destroy(i);var d,c=a*o;d=y.defined(n)?function(e,r,t,n,a){var o,i;n.quantizationBits<=8?(i=new l.DracoUInt8Array,o=new Uint8Array(a),r.GetAttributeUInt8ForAllPoints(e,t,i)):(i=new l.DracoUInt16Array,o=new Uint16Array(a),r.GetAttributeUInt16ForAllPoints(e,t,i));for(var u=0;u<a;++u)o[u]=i.GetValue(u);return l.destroy(i),o}(e,r,t,n,c):function(e,r,t,n){var a,o;switch(t.data_type()){case 1:case 11:o=new l.DracoInt8Array,a=new Int8Array(n),r.GetAttributeInt8ForAllPoints(e,t,o);break;case 2:o=new l.DracoUInt8Array,a=new Uint8Array(n),r.GetAttributeUInt8ForAllPoints(e,t,o);break;case 3:o=new l.DracoInt16Array,a=new Int16Array(n),r.GetAttributeInt16ForAllPoints(e,t,o);break;case 4:o=new l.DracoUInt16Array,a=new Uint16Array(n),r.GetAttributeUInt16ForAllPoints(e,t,o);break;case 5:case 7:o=new l.DracoInt32Array,a=new Int32Array(n),r.GetAttributeInt32ForAllPoints(e,t,o);break;case 6:case 8:o=new l.DracoUInt32Array,a=new Uint32Array(n),r.GetAttributeUInt32ForAllPoints(e,t,o);break;case 9:case 10:o=new l.DracoFloat32Array,a=new Float32Array(n),r.GetAttributeFloatForAllPoints(e,t,o)}for(var i=0;i<n;++i)a[i]=o.GetValue(i);return l.destroy(o),a}(e,r,t,c);var f=A.ComponentDatatype.fromTypedArray(d);return{array:d,data:{componentsPerAttribute:o,componentDatatype:f,byteOffset:t.byte_offset(),byteStride:A.ComponentDatatype.getSizeInBytes(f)*o,normalized:t.normalized(),quantization:n}}}function u(e){var r=new l.Decoder,t=["POSITION","NORMAL","COLOR","TEX_COORD"];if(e.dequantizeInShader)for(var n=0;n<t.length;++n)r.SkipAttributeTransform(l[t[n]]);var a=e.bufferView,o=new l.DecoderBuffer;if(o.Init(e.array,a.byteLength),r.GetEncodedGeometryType(o)!==l.TRIANGULAR_MESH)throw new b.RuntimeError("Unsupported draco mesh geometry type.");var i=new l.Mesh,u=r.DecodeBufferToMesh(o,i);if(!u.ok()||0===i.ptr)throw new b.RuntimeError("Error decoding draco mesh geometry: "+u.error_msg());l.destroy(o);var s={},d=e.compressedAttributes;for(var c in d)if(d.hasOwnProperty(c)){var f=d[c],y=r.GetAttributeByUniqueId(i,f);s[c]=w(i,r,y)}var A={indexArray:function(e,r){for(var t=e.num_points(),n=e.num_faces(),a=new l.DracoInt32Array,o=3*n,i=m.IndexDatatype.createTypedArray(t,o),u=0,s=0;s<n;++s)r.GetFaceFromMesh(e,s,a),i[u+0]=a.GetValue(0),i[u+1]=a.GetValue(1),i[u+2]=a.GetValue(2),u+=3;return l.destroy(a),{typedArray:i,numberOfIndices:o}}(i,r),attributeData:s};return l.destroy(i),l.destroy(r),A}function s(e){return y.defined(e.primitive)?u(e):function(e){var r=new l.Decoder;e.dequantizeInShader&&(r.SkipAttributeTransform(l.POSITION),r.SkipAttributeTransform(l.NORMAL));var t=new l.DecoderBuffer;if(t.Init(e.buffer,e.buffer.length),r.GetEncodedGeometryType(t)!==l.POINT_CLOUD)throw new b.RuntimeError("Draco geometry type must be POINT_CLOUD.");var n=new l.PointCloud,a=r.DecodeBufferToPointCloud(t,n);if(!a.ok()||0===n.ptr)throw new b.RuntimeError("Error decoding draco point cloud: "+a.error_msg());l.destroy(t);var o={},i=e.properties;for(var u in i)if(i.hasOwnProperty(u)){var s=i[u],d=r.GetAttributeByUniqueId(n,s);o[u]=w(n,r,d)}return l.destroy(n),l.destroy(r),o}(e)}function d(e){l=e,self.onmessage=i(s),self.postMessage(!0)}return function(e){var r=e.data.webAssemblyConfig;if(y.defined(r))return require([r.modulePath],function(e){y.defined(r.wasmBinaryFile)?(y.defined(e)||(e=self.DracoDecoderModule),e(r).then(function(e){d(e)})):d(e())})}});
