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
define(["./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5","./Transforms-f017fb11","./RuntimeError-d5522ee3","./WebGLConstants-554ddbe2","./when-c208a7cf","./AttributeCompression-4cb3e905","./IndexDatatype-7119db15","./IntersectionTests-e02ea381","./Plane-f99813ce","./createTaskProcessorWorker","./EllipsoidTangentPlane-16a5fc6d","./OrientedBoundingBox-1bbba5b8","./Color-e48ace34"],function(Te,e,a,r,ke,Be,n,t,i,o,s,Le,Oe,f,d,c,u,Pe,Ue){"use strict";var Fe=new Be.Cartesian3,Se=new Be.Ellipsoid,Re=new Be.Rectangle,De={min:void 0,max:void 0,indexBytesPerElement:void 0};function Me(e,a,r){var n=a.length,t=2+n*Pe.OrientedBoundingBox.packedLength+1+function(e){for(var a=e.length,r=0,n=0;n<a;++n)r+=Ue.Color.packedLength+3+e[n].batchIds.length;return r}(r),i=new Float64Array(t),o=0;i[o++]=e,i[o++]=n;for(var s=0;s<n;++s)Pe.OrientedBoundingBox.pack(a[s],i,o),o+=Pe.OrientedBoundingBox.packedLength;var f=r.length;i[o++]=f;for(var d=0;d<f;++d){var c=r[d];Ue.Color.pack(c.color,i,o),o+=Ue.Color.packedLength,i[o++]=c.offset,i[o++]=c.count;var u=c.batchIds,h=u.length;i[o++]=h;for(var l=0;l<h;++l)i[o++]=u[l]}return i}var _e=new Be.Cartesian3,Ge=new Be.Cartesian3,Ve=new Be.Cartesian3,Ye=new Be.Cartesian3,He=new Be.Cartesian3,ze=new Be.Cartographic,We=new Be.Rectangle;return c(function(e,a){var r;!function(e){var a=new Float64Array(e),r=0;De.indexBytesPerElement=a[r++],De.min=a[r++],De.max=a[r++],Be.Cartesian3.unpack(a,r,Fe),r+=Be.Cartesian3.packedLength,Be.Ellipsoid.unpack(a,r,Se),r+=Be.Ellipsoid.packedLength,Be.Rectangle.unpack(a,r,Re)}(e.packedBuffer),r=2===De.indexBytesPerElement?new Uint16Array(e.indices):new Uint32Array(e.indices);var n,t,i,o=new Uint16Array(e.positions),s=new Uint32Array(e.counts),f=new Uint32Array(e.indexCounts),d=new Uint32Array(e.batchIds),c=new Uint32Array(e.batchTableColors),u=new Array(s.length),h=Fe,l=Se,g=Re,p=De.min,b=De.max,C=e.minimumHeights,v=e.maximumHeights;Te.defined(C)&&Te.defined(v)&&(C=new Float32Array(C),v=new Float32Array(v));var y=o.length/2,I=o.subarray(0,y),m=o.subarray(y,2*y);Le.AttributeCompression.zigZagDeltaDecode(I,m);var w=new Float32Array(3*y);for(n=0;n<y;++n){var x=I[n],A=m[n],E=ke.CesiumMath.lerp(g.west,g.east,x/32767),N=ke.CesiumMath.lerp(g.south,g.north,A/32767),T=Be.Cartographic.fromRadians(E,N,0,ze),k=l.cartographicToCartesian(T,_e);Be.Cartesian3.pack(k,w,3*n)}var B=s.length,L=new Array(B),O=new Array(B),P=0,U=0;for(n=0;n<B;++n)L[n]=P,O[n]=U,P+=s[n],U+=f[n];var F,S=new Float32Array(3*y*2),R=new Uint16Array(2*y),D=new Uint32Array(O.length),M=new Uint32Array(f.length),_=[],G={};for(n=0;n<B;++n)i=c[n],Te.defined(G[i])?(G[i].positionLength+=s[n],G[i].indexLength+=f[n],G[i].batchIds.push(n)):G[i]={positionLength:s[n],indexLength:f[n],offset:0,indexOffset:0,batchIds:[n]};var V=0,Y=0;for(i in G)if(G.hasOwnProperty(i)){(F=G[i]).offset=V,F.indexOffset=Y;var H=2*F.positionLength,z=2*F.indexLength+6*F.positionLength;V+=H,Y+=z,F.indexLength=z}var W=[];for(i in G)G.hasOwnProperty(i)&&(F=G[i],W.push({color:Ue.Color.fromRgba(parseInt(i)),offset:F.indexOffset,count:F.indexLength,batchIds:F.batchIds}));for(n=0;n<B;++n){var j=(F=G[i=c[n]]).offset,Z=3*j,q=j,J=L[n],K=s[n],Q=d[n],X=p,$=b;Te.defined(C)&&Te.defined(v)&&(X=C[n],$=v[n]);var ee=Number.POSITIVE_INFINITY,ae=Number.NEGATIVE_INFINITY,re=Number.POSITIVE_INFINITY,ne=Number.NEGATIVE_INFINITY;for(t=0;t<K;++t){var te=Be.Cartesian3.unpack(w,3*J+3*t,_e);l.scaleToGeodeticSurface(te,te);var ie=l.cartesianToCartographic(te,ze),oe=ie.latitude,se=ie.longitude;ee=Math.min(oe,ee),ae=Math.max(oe,ae),re=Math.min(se,re),ne=Math.max(se,ne);var fe=l.geodeticSurfaceNormal(te,Ge),de=Be.Cartesian3.multiplyByScalar(fe,X,Ve),ce=Be.Cartesian3.add(te,de,Ye);de=Be.Cartesian3.multiplyByScalar(fe,$,de);var ue=Be.Cartesian3.add(te,de,He);Be.Cartesian3.subtract(ue,h,ue),Be.Cartesian3.subtract(ce,h,ce),Be.Cartesian3.pack(ue,S,Z),Be.Cartesian3.pack(ce,S,Z+3),R[q]=Q,R[q+1]=Q,Z+=6,q+=2}(g=We).west=re,g.east=ne,g.south=ee,g.north=ae,u[n]=Pe.OrientedBoundingBox.fromRectangle(g,p,b,l);var he=F.indexOffset,le=O[n],ge=f[n];for(D[n]=he,t=0;t<ge;t+=3){var pe=r[le+t]-J,be=r[le+t+1]-J,Ce=r[le+t+2]-J;_[he++]=2*pe+j,_[he++]=2*be+j,_[he++]=2*Ce+j,_[he++]=2*Ce+1+j,_[he++]=2*be+1+j,_[he++]=2*pe+1+j}for(t=0;t<K;++t){var ve=t,ye=(t+1)%K;_[he++]=2*ve+1+j,_[he++]=2*ye+j,_[he++]=2*ve+j,_[he++]=2*ve+1+j,_[he++]=2*ye+1+j,_[he++]=2*ye+j}F.offset+=2*K,F.indexOffset=he,M[n]=he-D[n]}_=Oe.IndexDatatype.createTypedArray(S.length/3,_);for(var Ie=W.length,me=0;me<Ie;++me){for(var we=W[me].batchIds,xe=0,Ae=we.length,Ee=0;Ee<Ae;++Ee)xe+=M[we[Ee]];W[me].count=xe}var Ne=Me(2===_.BYTES_PER_ELEMENT?Oe.IndexDatatype.UNSIGNED_SHORT:Oe.IndexDatatype.UNSIGNED_INT,u,W);return a.push(S.buffer,_.buffer,D.buffer,M.buffer,R.buffer,Ne.buffer),{positions:S.buffer,indices:_.buffer,indexOffsets:D.buffer,indexCounts:M.buffer,batchIds:R.buffer,packedBuffer:Ne.buffer}})});
