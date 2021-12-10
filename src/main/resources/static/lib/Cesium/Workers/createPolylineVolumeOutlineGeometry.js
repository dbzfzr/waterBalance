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
define(["./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5","./Transforms-f017fb11","./RuntimeError-d5522ee3","./WebGLConstants-554ddbe2","./ComponentDatatype-569c1e3e","./GeometryAttribute-78070f6e","./when-c208a7cf","./GeometryAttributes-c3465b51","./IndexDatatype-7119db15","./IntersectionTests-e02ea381","./Plane-f99813ce","./arrayRemoveDuplicates-1efed288","./BoundingRectangle-f894321c","./EllipsoidTangentPlane-16a5fc6d","./EllipsoidRhumbLine-fb5cc30d","./PolygonPipeline-6a95891b","./PolylineVolumeGeometryLibrary-c134c401","./EllipsoidGeodesic-b8e7c0c6","./PolylinePipeline-60358d3d"],function(d,e,i,c,a,u,n,y,t,r,f,h,o,g,m,l,s,p,v,E,P,_,b,k,C){"use strict";function L(e){var i=(e=c.defaultValue(e,c.defaultValue.EMPTY_OBJECT)).polylinePositions,n=e.shapePositions;this._positions=i,this._shape=n,this._ellipsoid=u.Ellipsoid.clone(c.defaultValue(e.ellipsoid,u.Ellipsoid.WGS84)),this._cornerType=c.defaultValue(e.cornerType,b.CornerType.ROUNDED),this._granularity=c.defaultValue(e.granularity,a.CesiumMath.RADIANS_PER_DEGREE),this._workerName="createPolylineVolumeOutlineGeometry";var t=1+i.length*u.Cartesian3.packedLength;t+=1+n.length*u.Cartesian2.packedLength,this.packedLength=t+u.Ellipsoid.packedLength+2}L.pack=function(e,i,n){var t;n=c.defaultValue(n,0);var a=e._positions,r=a.length;for(i[n++]=r,t=0;t<r;++t,n+=u.Cartesian3.packedLength)u.Cartesian3.pack(a[t],i,n);var o=e._shape;for(r=o.length,i[n++]=r,t=0;t<r;++t,n+=u.Cartesian2.packedLength)u.Cartesian2.pack(o[t],i,n);return u.Ellipsoid.pack(e._ellipsoid,i,n),n+=u.Ellipsoid.packedLength,i[n++]=e._cornerType,i[n]=e._granularity,i};var T=u.Ellipsoid.clone(u.Ellipsoid.UNIT_SPHERE),D={polylinePositions:void 0,shapePositions:void 0,ellipsoid:T,height:void 0,cornerType:void 0,granularity:void 0};L.unpack=function(e,i,n){var t;i=c.defaultValue(i,0);var a=e[i++],r=new Array(a);for(t=0;t<a;++t,i+=u.Cartesian3.packedLength)r[t]=u.Cartesian3.unpack(e,i);a=e[i++];var o=new Array(a);for(t=0;t<a;++t,i+=u.Cartesian2.packedLength)o[t]=u.Cartesian2.unpack(e,i);var l=u.Ellipsoid.unpack(e,i,T);i+=u.Ellipsoid.packedLength;var s=e[i++],p=e[i];return d.defined(n)?(n._positions=r,n._shape=o,n._ellipsoid=u.Ellipsoid.clone(l,n._ellipsoid),n._cornerType=s,n._granularity=p,n):(D.polylinePositions=r,D.shapePositions=o,D.cornerType=s,D.granularity=p,new L(D))};var G=new v.BoundingRectangle;return L.createGeometry=function(e){var i=e._positions,n=p.arrayRemoveDuplicates(i,u.Cartesian3.equalsEpsilon),t=e._shape;if(t=b.PolylineVolumeGeometryLibrary.removeDuplicatesFromShape(t),!(n.length<2||t.length<3)){_.PolygonPipeline.computeWindingOrder2D(t)===_.WindingOrder.CLOCKWISE&&t.reverse();var a=v.BoundingRectangle.fromPoints(t,G);return function(e,i){var n=new g.GeometryAttributes;n.position=new h.GeometryAttribute({componentDatatype:f.ComponentDatatype.DOUBLE,componentsPerAttribute:3,values:e});var t,a,r=i.length,o=n.position.values.length/3,l=e.length/3/r,s=m.IndexDatatype.createTypedArray(o,2*r*(1+l)),p=0,d=(t=0)*r;for(a=0;a<r-1;a++)s[p++]=a+d,s[p++]=a+d+1;for(s[p++]=r-1+d,s[p++]=d,d=(t=l-1)*r,a=0;a<r-1;a++)s[p++]=a+d,s[p++]=a+d+1;for(s[p++]=r-1+d,s[p++]=d,t=0;t<l-1;t++){var c=r*t,u=c+r;for(a=0;a<r;a++)s[p++]=a+c,s[p++]=a+u}return new h.Geometry({attributes:n,indices:m.IndexDatatype.createTypedArray(o,s),boundingSphere:y.BoundingSphere.fromVertices(e),primitiveType:h.PrimitiveType.LINES})}(b.PolylineVolumeGeometryLibrary.computePositions(n,t,a,e,!1),t)}},function(e,i){return d.defined(i)&&(e=L.unpack(e,i)),e._ellipsoid=u.Ellipsoid.clone(e._ellipsoid),L.createGeometry(e)}});
