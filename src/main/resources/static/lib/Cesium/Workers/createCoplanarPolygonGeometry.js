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
define(["./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5","./Transforms-f017fb11","./RuntimeError-d5522ee3","./WebGLConstants-554ddbe2","./ComponentDatatype-569c1e3e","./GeometryAttribute-78070f6e","./when-c208a7cf","./GeometryAttributes-c3465b51","./AttributeCompression-4cb3e905","./GeometryPipeline-63aa5551","./EncodedCartesian3-e4976669","./IndexDatatype-7119db15","./IntersectionTests-e02ea381","./Plane-f99813ce","./VertexFormat-b4c6d1c2","./GeometryInstance-c9988072","./arrayRemoveDuplicates-1efed288","./BoundingRectangle-f894321c","./EllipsoidTangentPlane-16a5fc6d","./OrientedBoundingBox-1bbba5b8","./CoplanarPolygonGeometryLibrary-0956a841","./ArcType-c72d871a","./EllipsoidRhumbLine-fb5cc30d","./PolygonPipeline-6a95891b","./PolygonGeometryLibrary-ee8a60d0"],function(s,e,t,p,k,R,a,I,n,r,M,H,o,B,i,w,l,O,c,y,u,A,F,m,d,g,G,b,f,z,L){"use strict";var S=new R.Cartesian3,E=new m.BoundingRectangle,N=new R.Cartesian2,Q=new R.Cartesian2,T=new R.Cartesian3,D=new R.Cartesian3,V=new R.Cartesian3,_=new R.Cartesian3,j=new R.Cartesian3,U=new R.Cartesian3,Y=new I.Quaternion,q=new I.Matrix3,J=new I.Matrix3,W=new R.Cartesian3;function Z(e,t,a,n,r,o,i,l){var s=e.positions,p=z.PolygonPipeline.triangulate(e.positions2D,e.holes);p.length<3&&(p=[0,1,2]);var c=O.IndexDatatype.createTypedArray(s.length,p.length);c.set(p);var y=q;if(0!==n){var u=I.Quaternion.fromAxisAngle(o,n,Y);if(y=I.Matrix3.fromQuaternion(u,y),t.tangent||t.bitangent){u=I.Quaternion.fromAxisAngle(o,-n,Y);var m=I.Matrix3.fromQuaternion(u,J);i=R.Cartesian3.normalize(I.Matrix3.multiplyByVector(m,i,i),i),t.bitangent&&(l=R.Cartesian3.normalize(R.Cartesian3.cross(o,i,l),l))}}else y=I.Matrix3.clone(I.Matrix3.IDENTITY,y);var d=Q;t.st&&(d.x=a.x,d.y=a.y);for(var g=s.length,b=3*g,f=new Float64Array(b),v=t.normal?new Float32Array(b):void 0,h=t.tangent?new Float32Array(b):void 0,C=t.bitangent?new Float32Array(b):void 0,x=t.st?new Float32Array(2*g):void 0,P=0,w=0,A=0,F=0,G=0,L=0;L<g;L++){var E=s[L];if(f[P++]=E.x,f[P++]=E.y,f[P++]=E.z,t.st){var T=r(I.Matrix3.multiplyByVector(y,E,S),N);R.Cartesian2.subtract(T,d,T);var D=k.CesiumMath.clamp(T.x/a.width,0,1),V=k.CesiumMath.clamp(T.y/a.height,0,1);x[G++]=D,x[G++]=V}t.normal&&(v[w++]=o.x,v[w++]=o.y,v[w++]=o.z),t.tangent&&(h[F++]=i.x,h[F++]=i.y,h[F++]=i.z),t.bitangent&&(C[A++]=l.x,C[A++]=l.y,C[A++]=l.z)}var _=new B.GeometryAttributes;return t.position&&(_.position=new H.GeometryAttribute({componentDatatype:M.ComponentDatatype.DOUBLE,componentsPerAttribute:3,values:f})),t.normal&&(_.normal=new H.GeometryAttribute({componentDatatype:M.ComponentDatatype.FLOAT,componentsPerAttribute:3,values:v})),t.tangent&&(_.tangent=new H.GeometryAttribute({componentDatatype:M.ComponentDatatype.FLOAT,componentsPerAttribute:3,values:h})),t.bitangent&&(_.bitangent=new H.GeometryAttribute({componentDatatype:M.ComponentDatatype.FLOAT,componentsPerAttribute:3,values:C})),t.st&&(_.st=new H.GeometryAttribute({componentDatatype:M.ComponentDatatype.FLOAT,componentsPerAttribute:2,values:x})),new H.Geometry({attributes:_,indices:c,primitiveType:H.PrimitiveType.TRIANGLES})}function v(e){var t=(e=p.defaultValue(e,p.defaultValue.EMPTY_OBJECT)).polygonHierarchy,a=p.defaultValue(e.vertexFormat,u.VertexFormat.DEFAULT);this._vertexFormat=u.VertexFormat.clone(a),this._polygonHierarchy=t,this._stRotation=p.defaultValue(e.stRotation,0),this._ellipsoid=R.Ellipsoid.clone(p.defaultValue(e.ellipsoid,R.Ellipsoid.WGS84)),this._workerName="createCoplanarPolygonGeometry",this.packedLength=L.PolygonGeometryLibrary.computeHierarchyPackedLength(t)+u.VertexFormat.packedLength+R.Ellipsoid.packedLength+2}v.fromPositions=function(e){return new v({polygonHierarchy:{positions:(e=p.defaultValue(e,p.defaultValue.EMPTY_OBJECT)).positions},vertexFormat:e.vertexFormat,stRotation:e.stRotation,ellipsoid:e.ellipsoid})},v.pack=function(e,t,a){return a=p.defaultValue(a,0),a=L.PolygonGeometryLibrary.packPolygonHierarchy(e._polygonHierarchy,t,a),R.Ellipsoid.pack(e._ellipsoid,t,a),a+=R.Ellipsoid.packedLength,u.VertexFormat.pack(e._vertexFormat,t,a),a+=u.VertexFormat.packedLength,t[a++]=e._stRotation,t[a]=e.packedLength,t};var h=R.Ellipsoid.clone(R.Ellipsoid.UNIT_SPHERE),C=new u.VertexFormat,x={polygonHierarchy:{}};return v.unpack=function(e,t,a){t=p.defaultValue(t,0);var n=L.PolygonGeometryLibrary.unpackPolygonHierarchy(e,t);t=n.startingIndex,delete n.startingIndex;var r=R.Ellipsoid.unpack(e,t,h);t+=R.Ellipsoid.packedLength;var o=u.VertexFormat.unpack(e,t,C);t+=u.VertexFormat.packedLength;var i=e[t++],l=e[t];return s.defined(a)||(a=new v(x)),a._polygonHierarchy=n,a._ellipsoid=R.Ellipsoid.clone(r,a._ellipsoid),a._vertexFormat=u.VertexFormat.clone(o,a._vertexFormat),a._stRotation=i,a.packedLength=l,a},v.createGeometry=function(e){var t=e._vertexFormat,a=e._polygonHierarchy,n=e._stRotation,r=a.positions;if(!((r=F.arrayRemoveDuplicates(r,R.Cartesian3.equalsEpsilon,!0)).length<3)){var o=T,i=D,l=V,s=j,p=U;if(G.CoplanarPolygonGeometryLibrary.computeProjectTo2DArguments(r,_,s,p)){if(o=R.Cartesian3.cross(s,p,o),o=R.Cartesian3.normalize(o,o),!R.Cartesian3.equalsEpsilon(_,R.Cartesian3.ZERO,k.CesiumMath.EPSILON6)){var c=e._ellipsoid.geodeticSurfaceNormal(_,W);R.Cartesian3.dot(o,c)<0&&(o=R.Cartesian3.negate(o,o),s=R.Cartesian3.negate(s,s))}var y=G.CoplanarPolygonGeometryLibrary.createProjectPointsTo2DFunction(_,s,p),u=G.CoplanarPolygonGeometryLibrary.createProjectPointTo2DFunction(_,s,p);t.tangent&&(i=R.Cartesian3.clone(s,i)),t.bitangent&&(l=R.Cartesian3.clone(p,l));var m=L.PolygonGeometryLibrary.polygonsFromHierarchy(a,y,!1),d=m.hierarchy,g=m.polygons;if(0!==d.length){r=d[0].outerRing;for(var b=I.BoundingSphere.fromPoints(r),f=L.PolygonGeometryLibrary.computeBoundingRectangle(o,u,r,n,E),v=[],h=0;h<g.length;h++){var C=new A.GeometryInstance({geometry:Z(g[h],t,f,n,u,o,i,l)});v.push(C)}var x=w.GeometryPipeline.combineInstances(v)[0];x.attributes.position.values=new Float64Array(x.attributes.position.values),x.indices=O.IndexDatatype.createTypedArray(x.attributes.position.values.length/3,x.indices);var P=x.attributes;return t.position||delete P.position,new H.Geometry({attributes:P,indices:x.indices,primitiveType:x.primitiveType,boundingSphere:b})}}}},function(e,t){return s.defined(t)&&(e=v.unpack(e,t)),v.createGeometry(e)}});
