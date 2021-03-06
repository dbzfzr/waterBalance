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
define(["./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5","./Transforms-f017fb11","./RuntimeError-d5522ee3","./WebGLConstants-554ddbe2","./ComponentDatatype-569c1e3e","./GeometryAttribute-78070f6e","./when-c208a7cf","./GeometryAttributes-c3465b51","./IndexDatatype-7119db15","./IntersectionTests-e02ea381","./Plane-f99813ce","./EllipsoidTangentPlane-16a5fc6d","./EllipsoidRhumbLine-fb5cc30d","./PolygonPipeline-6a95891b","./EllipsoidGeodesic-b8e7c0c6","./PolylinePipeline-60358d3d","./WallGeometryLibrary-a4c4cd8d"],function(w,e,i,m,G,L,t,x,a,n,T,V,r,D,I,o,s,l,d,u,p,f,S){"use strict";var O=new L.Cartesian3,R=new L.Cartesian3;function c(e){var i=(e=m.defaultValue(e,m.defaultValue.EMPTY_OBJECT)).positions,t=e.maximumHeights,a=e.minimumHeights,n=m.defaultValue(e.granularity,G.CesiumMath.RADIANS_PER_DEGREE),r=m.defaultValue(e.ellipsoid,L.Ellipsoid.WGS84);this._positions=i,this._minimumHeights=a,this._maximumHeights=t,this._granularity=n,this._ellipsoid=L.Ellipsoid.clone(r),this._workerName="createWallOutlineGeometry";var o=1+i.length*L.Cartesian3.packedLength+2;w.defined(a)&&(o+=a.length),w.defined(t)&&(o+=t.length),this.packedLength=o+L.Ellipsoid.packedLength+1}c.pack=function(e,i,t){var a;t=m.defaultValue(t,0);var n=e._positions,r=n.length;for(i[t++]=r,a=0;a<r;++a,t+=L.Cartesian3.packedLength)L.Cartesian3.pack(n[a],i,t);var o=e._minimumHeights;if(r=w.defined(o)?o.length:0,i[t++]=r,w.defined(o))for(a=0;a<r;++a)i[t++]=o[a];var s=e._maximumHeights;if(r=w.defined(s)?s.length:0,i[t++]=r,w.defined(s))for(a=0;a<r;++a)i[t++]=s[a];return L.Ellipsoid.pack(e._ellipsoid,i,t),i[t+=L.Ellipsoid.packedLength]=e._granularity,i};var h=L.Ellipsoid.clone(L.Ellipsoid.UNIT_SPHERE),g={positions:void 0,minimumHeights:void 0,maximumHeights:void 0,ellipsoid:h,granularity:void 0};return c.unpack=function(e,i,t){var a;i=m.defaultValue(i,0);var n,r,o=e[i++],s=new Array(o);for(a=0;a<o;++a,i+=L.Cartesian3.packedLength)s[a]=L.Cartesian3.unpack(e,i);if(0<(o=e[i++]))for(n=new Array(o),a=0;a<o;++a)n[a]=e[i++];if(0<(o=e[i++]))for(r=new Array(o),a=0;a<o;++a)r[a]=e[i++];var l=L.Ellipsoid.unpack(e,i,h),d=e[i+=L.Ellipsoid.packedLength];return w.defined(t)?(t._positions=s,t._minimumHeights=n,t._maximumHeights=r,t._ellipsoid=L.Ellipsoid.clone(l,t._ellipsoid),t._granularity=d,t):(g.positions=s,g.minimumHeights=n,g.maximumHeights=r,g.granularity=d,new c(g))},c.fromConstantHeights=function(e){var i,t,a=(e=m.defaultValue(e,m.defaultValue.EMPTY_OBJECT)).positions,n=e.minimumHeight,r=e.maximumHeight,o=w.defined(n),s=w.defined(r);if(o||s){var l=a.length;i=o?new Array(l):void 0,t=s?new Array(l):void 0;for(var d=0;d<l;++d)o&&(i[d]=n),s&&(t[d]=r)}return new c({positions:a,maximumHeights:t,minimumHeights:i,ellipsoid:e.ellipsoid})},c.createGeometry=function(e){var i=e._positions,t=e._minimumHeights,a=e._maximumHeights,n=e._granularity,r=e._ellipsoid,o=S.WallGeometryLibrary.computePositions(r,i,a,t,n,!1);if(w.defined(o)){var s,l=o.bottomPositions,d=o.topPositions,m=d.length,u=2*m,p=new Float64Array(u),f=0;for(m/=3,s=0;s<m;++s){var c=3*s,h=L.Cartesian3.fromArray(d,c,O),g=L.Cartesian3.fromArray(l,c,R);p[f++]=g.x,p[f++]=g.y,p[f++]=g.z,p[f++]=h.x,p[f++]=h.y,p[f++]=h.z}var y=new D.GeometryAttributes({position:new V.GeometryAttribute({componentDatatype:T.ComponentDatatype.DOUBLE,componentsPerAttribute:3,values:p})}),v=u/3;u=2*v-4+v;var E=I.IndexDatatype.createTypedArray(v,u),_=0;for(s=0;s<v-2;s+=2){var b=s,C=s+2,H=L.Cartesian3.fromArray(p,3*b,O),A=L.Cartesian3.fromArray(p,3*C,R);if(!L.Cartesian3.equalsEpsilon(H,A,G.CesiumMath.EPSILON10)){var P=s+1,k=s+3;E[_++]=P,E[_++]=b,E[_++]=P,E[_++]=k,E[_++]=b,E[_++]=C}}return E[_++]=v-2,E[_++]=v-1,new V.Geometry({attributes:y,indices:E,primitiveType:V.PrimitiveType.LINES,boundingSphere:new x.BoundingSphere.fromVertices(p)})}},function(e,i){return w.defined(i)&&(e=c.unpack(e,i)),e._ellipsoid=L.Ellipsoid.clone(e._ellipsoid),c.createGeometry(e)}});
