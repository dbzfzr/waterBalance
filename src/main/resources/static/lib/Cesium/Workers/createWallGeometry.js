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
define(["./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5","./Transforms-f017fb11","./RuntimeError-d5522ee3","./WebGLConstants-554ddbe2","./ComponentDatatype-569c1e3e","./GeometryAttribute-78070f6e","./when-c208a7cf","./GeometryAttributes-c3465b51","./IndexDatatype-7119db15","./IntersectionTests-e02ea381","./Plane-f99813ce","./VertexFormat-b4c6d1c2","./EllipsoidTangentPlane-16a5fc6d","./EllipsoidRhumbLine-fb5cc30d","./PolygonPipeline-6a95891b","./EllipsoidGeodesic-b8e7c0c6","./PolylinePipeline-60358d3d","./WallGeometryLibrary-a4c4cd8d"],function(j,e,t,p,Z,K,a,Q,i,n,X,$,r,ee,te,o,s,u,m,l,d,c,f,ae){"use strict";var ie=new K.Cartesian3,ne=new K.Cartesian3,re=new K.Cartesian3,oe=new K.Cartesian3,se=new K.Cartesian3,me=new K.Cartesian3,le=new K.Cartesian3,de=new K.Cartesian3;function y(e){var t=(e=p.defaultValue(e,p.defaultValue.EMPTY_OBJECT)).positions,a=e.maximumHeights,i=e.minimumHeights,n=p.defaultValue(e.vertexFormat,u.VertexFormat.DEFAULT),r=p.defaultValue(e.granularity,Z.CesiumMath.RADIANS_PER_DEGREE),o=p.defaultValue(e.ellipsoid,K.Ellipsoid.WGS84);this._positions=t,this._minimumHeights=i,this._maximumHeights=a,this._vertexFormat=u.VertexFormat.clone(n),this._granularity=r,this._ellipsoid=K.Ellipsoid.clone(o),this._workerName="createWallGeometry";var s=1+t.length*K.Cartesian3.packedLength+2;j.defined(i)&&(s+=i.length),j.defined(a)&&(s+=a.length),this.packedLength=s+K.Ellipsoid.packedLength+u.VertexFormat.packedLength+1}y.pack=function(e,t,a){var i;a=p.defaultValue(a,0);var n=e._positions,r=n.length;for(t[a++]=r,i=0;i<r;++i,a+=K.Cartesian3.packedLength)K.Cartesian3.pack(n[i],t,a);var o=e._minimumHeights;if(r=j.defined(o)?o.length:0,t[a++]=r,j.defined(o))for(i=0;i<r;++i)t[a++]=o[i];var s=e._maximumHeights;if(r=j.defined(s)?s.length:0,t[a++]=r,j.defined(s))for(i=0;i<r;++i)t[a++]=s[i];return K.Ellipsoid.pack(e._ellipsoid,t,a),a+=K.Ellipsoid.packedLength,u.VertexFormat.pack(e._vertexFormat,t,a),t[a+=u.VertexFormat.packedLength]=e._granularity,t};var g=K.Ellipsoid.clone(K.Ellipsoid.UNIT_SPHERE),h=new u.VertexFormat,v={positions:void 0,minimumHeights:void 0,maximumHeights:void 0,ellipsoid:g,vertexFormat:h,granularity:void 0};return y.unpack=function(e,t,a){var i;t=p.defaultValue(t,0);var n,r,o=e[t++],s=new Array(o);for(i=0;i<o;++i,t+=K.Cartesian3.packedLength)s[i]=K.Cartesian3.unpack(e,t);if(0<(o=e[t++]))for(n=new Array(o),i=0;i<o;++i)n[i]=e[t++];if(0<(o=e[t++]))for(r=new Array(o),i=0;i<o;++i)r[i]=e[t++];var m=K.Ellipsoid.unpack(e,t,g);t+=K.Ellipsoid.packedLength;var l=u.VertexFormat.unpack(e,t,h),d=e[t+=u.VertexFormat.packedLength];return j.defined(a)?(a._positions=s,a._minimumHeights=n,a._maximumHeights=r,a._ellipsoid=K.Ellipsoid.clone(m,a._ellipsoid),a._vertexFormat=u.VertexFormat.clone(l,a._vertexFormat),a._granularity=d,a):(v.positions=s,v.minimumHeights=n,v.maximumHeights=r,v.granularity=d,new y(v))},y.fromConstantHeights=function(e){var t,a,i=(e=p.defaultValue(e,p.defaultValue.EMPTY_OBJECT)).positions,n=e.minimumHeight,r=e.maximumHeight,o=j.defined(n),s=j.defined(r);if(o||s){var m=i.length;t=o?new Array(m):void 0,a=s?new Array(m):void 0;for(var l=0;l<m;++l)o&&(t[l]=n),s&&(a[l]=r)}return new y({positions:i,maximumHeights:a,minimumHeights:t,ellipsoid:e.ellipsoid,vertexFormat:e.vertexFormat})},y.createGeometry=function(e){var t=e._positions,a=e._minimumHeights,i=e._maximumHeights,n=e._vertexFormat,r=e._granularity,o=e._ellipsoid,s=ae.WallGeometryLibrary.computePositions(o,t,i,a,r,!0);if(j.defined(s)){var m,l=s.bottomPositions,d=s.topPositions,p=s.numCorners,u=d.length,c=2*u,f=n.position?new Float64Array(c):void 0,y=n.normal?new Float32Array(c):void 0,g=n.tangent?new Float32Array(c):void 0,h=n.bitangent?new Float32Array(c):void 0,v=n.st?new Float32Array(c/3*2):void 0,C=0,b=0,A=0,x=0,_=0,E=de,w=le,F=me,L=!0,P=0,k=1/((u/=3)-t.length+1);for(m=0;m<u;++m){var G=3*m,V=K.Cartesian3.fromArray(d,G,ie),H=K.Cartesian3.fromArray(l,G,ne);if(n.position&&(f[C++]=H.x,f[C++]=H.y,f[C++]=H.z,f[C++]=V.x,f[C++]=V.y,f[C++]=V.z),n.st&&(v[_++]=P,v[_++]=0,v[_++]=P,v[_++]=1),n.normal||n.tangent||n.bitangent){var T,D=K.Cartesian3.clone(K.Cartesian3.ZERO,se),z=o.scaleToGeodeticSurface(K.Cartesian3.fromArray(d,G,ne),ne);if(m+1<u&&(T=o.scaleToGeodeticSurface(K.Cartesian3.fromArray(d,3+G,re),re),D=K.Cartesian3.fromArray(d,3+G,se)),L){var O=K.Cartesian3.subtract(D,V,oe),S=K.Cartesian3.subtract(z,V,ie);E=K.Cartesian3.normalize(K.Cartesian3.cross(S,O,E),E),L=!1}K.Cartesian3.equalsEpsilon(T,z,Z.CesiumMath.EPSILON10)?L=!0:(P+=k,n.tangent&&(w=K.Cartesian3.normalize(K.Cartesian3.subtract(T,z,w),w)),n.bitangent&&(F=K.Cartesian3.normalize(K.Cartesian3.cross(E,w,F),F))),n.normal&&(y[b++]=E.x,y[b++]=E.y,y[b++]=E.z,y[b++]=E.x,y[b++]=E.y,y[b++]=E.z),n.tangent&&(g[x++]=w.x,g[x++]=w.y,g[x++]=w.z,g[x++]=w.x,g[x++]=w.y,g[x++]=w.z),n.bitangent&&(h[A++]=F.x,h[A++]=F.y,h[A++]=F.z,h[A++]=F.x,h[A++]=F.y,h[A++]=F.z)}}var I=new ee.GeometryAttributes;n.position&&(I.position=new $.GeometryAttribute({componentDatatype:X.ComponentDatatype.DOUBLE,componentsPerAttribute:3,values:f})),n.normal&&(I.normal=new $.GeometryAttribute({componentDatatype:X.ComponentDatatype.FLOAT,componentsPerAttribute:3,values:y})),n.tangent&&(I.tangent=new $.GeometryAttribute({componentDatatype:X.ComponentDatatype.FLOAT,componentsPerAttribute:3,values:g})),n.bitangent&&(I.bitangent=new $.GeometryAttribute({componentDatatype:X.ComponentDatatype.FLOAT,componentsPerAttribute:3,values:h})),n.st&&(I.st=new $.GeometryAttribute({componentDatatype:X.ComponentDatatype.FLOAT,componentsPerAttribute:2,values:v}));var R=c/3;c-=6*(p+1);var M=te.IndexDatatype.createTypedArray(R,c),N=0;for(m=0;m<R-2;m+=2){var W=m,B=m+2,U=K.Cartesian3.fromArray(f,3*W,ie),q=K.Cartesian3.fromArray(f,3*B,ne);if(!K.Cartesian3.equalsEpsilon(U,q,Z.CesiumMath.EPSILON10)){var J=m+1,Y=m+3;M[N++]=J,M[N++]=W,M[N++]=Y,M[N++]=Y,M[N++]=W,M[N++]=B}}return new $.Geometry({attributes:I,indices:M,primitiveType:$.PrimitiveType.TRIANGLES,boundingSphere:new Q.BoundingSphere.fromVertices(f)})}},function(e,t){return j.defined(t)&&(e=y.unpack(e,t)),e._ellipsoid=K.Ellipsoid.clone(e._ellipsoid),y.createGeometry(e)}});