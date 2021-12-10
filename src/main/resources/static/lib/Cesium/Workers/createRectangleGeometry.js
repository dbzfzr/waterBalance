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
define(["./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5","./Transforms-f017fb11","./RuntimeError-d5522ee3","./WebGLConstants-554ddbe2","./ComponentDatatype-569c1e3e","./GeometryAttribute-78070f6e","./when-c208a7cf","./GeometryAttributes-c3465b51","./AttributeCompression-4cb3e905","./GeometryPipeline-63aa5551","./EncodedCartesian3-e4976669","./IndexDatatype-7119db15","./IntersectionTests-e02ea381","./Plane-f99813ce","./GeometryOffsetAttribute-0abfa3f6","./VertexFormat-b4c6d1c2","./GeometryInstance-c9988072","./EllipsoidRhumbLine-fb5cc30d","./PolygonPipeline-6a95891b","./RectangleGeometryLibrary-3e5c2fb8"],function(mt,t,e,p,dt,pt,a,H,r,n,gt,yt,i,o,s,ft,l,ht,u,c,vt,bt,_t,m,At,z){"use strict";var xt=new pt.Cartesian3,wt=new pt.Cartesian3,Ct=new pt.Cartesian3,Rt=new pt.Cartesian3,_=new pt.Rectangle,B=new pt.Cartesian2,A=new H.BoundingSphere,x=new H.BoundingSphere;function Et(t,e){var a=new yt.Geometry({attributes:new o.GeometryAttributes,primitiveType:yt.PrimitiveType.TRIANGLES});return a.attributes.position=new yt.GeometryAttribute({componentDatatype:gt.ComponentDatatype.DOUBLE,componentsPerAttribute:3,values:e.positions}),t.normal&&(a.attributes.normal=new yt.GeometryAttribute({componentDatatype:gt.ComponentDatatype.FLOAT,componentsPerAttribute:3,values:e.normals})),t.tangent&&(a.attributes.tangent=new yt.GeometryAttribute({componentDatatype:gt.ComponentDatatype.FLOAT,componentsPerAttribute:3,values:e.tangents})),t.bitangent&&(a.attributes.bitangent=new yt.GeometryAttribute({componentDatatype:gt.ComponentDatatype.FLOAT,componentsPerAttribute:3,values:e.bitangents})),a}var Ft=new pt.Cartesian3,Gt=new pt.Cartesian3;function Pt(t,e){var a=t._vertexFormat,r=t._ellipsoid,n=e.height,i=e.width,o=e.northCap,s=e.southCap,l=0,u=n,c=n,m=0;o&&(c-=l=1,m+=1),s&&(u-=1,c-=1,m+=1),m+=i*c;for(var d=a.position?new Float64Array(3*m):void 0,p=a.st?new Float32Array(2*m):void 0,g=0,y=0,f=xt,h=B,v=Number.MAX_VALUE,b=Number.MAX_VALUE,_=-Number.MAX_VALUE,A=-Number.MAX_VALUE,x=l;x<u;++x)for(var w=0;w<i;++w)z.RectangleGeometryLibrary.computePosition(e,r,a.st,x,w,f,h),d[g++]=f.x,d[g++]=f.y,d[g++]=f.z,a.st&&(p[y++]=h.x,p[y++]=h.y,v=Math.min(v,h.x),b=Math.min(b,h.y),_=Math.max(_,h.x),A=Math.max(A,h.y));if(o&&(z.RectangleGeometryLibrary.computePosition(e,r,a.st,0,0,f,h),d[g++]=f.x,d[g++]=f.y,d[g++]=f.z,a.st&&(p[y++]=h.x,p[y++]=h.y,v=h.x,b=h.y,_=h.x,A=h.y)),s&&(z.RectangleGeometryLibrary.computePosition(e,r,a.st,n-1,0,f,h),d[g++]=f.x,d[g++]=f.y,d[g]=f.z,a.st&&(p[y++]=h.x,p[y]=h.y,v=Math.min(v,h.x),b=Math.min(b,h.y),_=Math.max(_,h.x),A=Math.max(A,h.y))),a.st&&(v<0||b<0||1<_||1<A))for(var C=0;C<p.length;C+=2)p[C]=(p[C]-v)/(_-v),p[C+1]=(p[C+1]-b)/(A-b);var R=function(t,e,a,r){var n=t.length,i=e.normal?new Float32Array(n):void 0,o=e.tangent?new Float32Array(n):void 0,s=e.bitangent?new Float32Array(n):void 0,l=0,u=Rt,c=Ct,m=wt;if(e.normal||e.tangent||e.bitangent)for(var d=0;d<n;d+=3){var p=pt.Cartesian3.fromArray(t,d,xt),g=l+1,y=l+2;m=a.geodeticSurfaceNormal(p,m),(e.tangent||e.bitangent)&&(pt.Cartesian3.cross(pt.Cartesian3.UNIT_Z,m,c),H.Matrix3.multiplyByVector(r,c,c),pt.Cartesian3.normalize(c,c),e.bitangent&&pt.Cartesian3.normalize(pt.Cartesian3.cross(m,c,u),u)),e.normal&&(i[l]=m.x,i[g]=m.y,i[y]=m.z),e.tangent&&(o[l]=c.x,o[g]=c.y,o[y]=c.z),e.bitangent&&(s[l]=u.x,s[g]=u.y,s[y]=u.z),l+=3}return Et(e,{positions:t,normals:i,tangents:o,bitangents:s})}(d,a,r,e.tangentRotationMatrix),E=6*(i-1)*(c-1);o&&(E+=3*(i-1)),s&&(E+=3*(i-1));var F,G=ht.IndexDatatype.createTypedArray(m,E),P=0,V=0;for(F=0;F<c-1;++F){for(var L=0;L<i-1;++L){var D=P,M=D+i,T=M+1,O=D+1;G[V++]=D,G[V++]=M,G[V++]=O,G[V++]=O,G[V++]=M,G[V++]=T,++P}++P}if(o||s){var N,S,I=m-1,k=m-1;if(o&&s&&(I=m-2),P=0,o)for(F=0;F<i-1;F++)S=(N=P)+1,G[V++]=I,G[V++]=N,G[V++]=S,++P;if(s)for(P=(c-1)*i,F=0;F<i-1;F++)S=(N=P)+1,G[V++]=N,G[V++]=k,G[V++]=S,++P}return R.indices=G,a.st&&(R.attributes.st=new yt.GeometryAttribute({componentDatatype:gt.ComponentDatatype.FLOAT,componentsPerAttribute:2,values:p})),R}function Vt(t,e,a,r,n){return t[e++]=r[a],t[e++]=r[a+1],t[e++]=r[a+2],t[e++]=n[a],t[e++]=n[a+1],t[e]=n[a+2],t}function Lt(t,e,a,r){return t[e++]=r[a],t[e++]=r[a+1],t[e++]=r[a],t[e]=r[a+1],t}var Dt=new bt.VertexFormat;function w(t,e){var a,r=t._shadowVolume,n=t._offsetAttribute,i=t._vertexFormat,o=t._extrudedHeight,s=t._surfaceHeight,l=t._ellipsoid,u=e.height,c=e.width;if(r){var m=bt.VertexFormat.clone(i,Dt);m.normal=!0,t._vertexFormat=m}var d=Pt(t,e);r&&(t._vertexFormat=i);var p=At.PolygonPipeline.scaleToGeodeticHeight(d.attributes.position.values,s,l,!1),g=(p=new Float64Array(p)).length,y=2*g,f=new Float64Array(y);f.set(p);var h=At.PolygonPipeline.scaleToGeodeticHeight(d.attributes.position.values,o,l);f.set(h,g),d.attributes.position.values=f;var v,b,_,A=i.normal?new Float32Array(y):void 0,x=i.tangent?new Float32Array(y):void 0,w=i.bitangent?new Float32Array(y):void 0,C=i.st?new Float32Array(y/3*2):void 0;if(i.normal){for(b=d.attributes.normal.values,A.set(b),a=0;a<g;a++)b[a]=-b[a];A.set(b,g),d.attributes.normal.values=A}if(r){b=d.attributes.normal.values,i.normal||(d.attributes.normal=void 0);var R=new Float32Array(y);for(a=0;a<g;a++)b[a]=-b[a];R.set(b,g),d.attributes.extrudeDirection=new yt.GeometryAttribute({componentDatatype:gt.ComponentDatatype.FLOAT,componentsPerAttribute:3,values:R})}var E=mt.defined(n);if(E){var F=g/3*2,G=new Uint8Array(F);G=n===vt.GeometryOffsetAttribute.TOP?vt.arrayFill(G,1,0,F/2):(_=n===vt.GeometryOffsetAttribute.NONE?0:1,vt.arrayFill(G,_)),d.attributes.applyOffset=new yt.GeometryAttribute({componentDatatype:gt.ComponentDatatype.UNSIGNED_BYTE,componentsPerAttribute:1,values:G})}if(i.tangent){var P=d.attributes.tangent.values;for(x.set(P),a=0;a<g;a++)P[a]=-P[a];x.set(P,g),d.attributes.tangent.values=x}if(i.bitangent){var V=d.attributes.bitangent.values;w.set(V),w.set(V,g),d.attributes.bitangent.values=w}i.st&&(v=d.attributes.st.values,C.set(v),C.set(v,g/3*2),d.attributes.st.values=C);var L=d.indices,D=L.length,M=g/3,T=ht.IndexDatatype.createTypedArray(y/3,2*D);for(T.set(L),a=0;a<D;a+=3)T[a+D]=L[a+2]+M,T[a+1+D]=L[a+1]+M,T[a+2+D]=L[a]+M;d.indices=T;var O=e.northCap,N=e.southCap,S=u,I=2,k=0,H=4,z=4;O&&(I-=1,S-=1,k+=1,H-=2,z-=1),N&&(I-=1,S-=1,k+=1,H-=2,z-=1);var B=2*((k+=I*c+2*S-H)+z),U=new Float64Array(3*B),Y=r?new Float32Array(3*B):void 0,q=E?new Uint8Array(B):void 0,X=i.st?new Float32Array(2*B):void 0,Q=n===vt.GeometryOffsetAttribute.TOP;E&&!Q&&(_=n===vt.GeometryOffsetAttribute.ALL?1:0,q=vt.arrayFill(q,_));var W,J=0,j=0,Z=0,K=0,$=c*S;for(a=0;a<$;a+=c)U=Vt(U,J,W=3*a,p,h),J+=6,i.st&&(X=Lt(X,j,2*a,v),j+=4),r&&(Z+=3,Y[Z++]=b[W],Y[Z++]=b[W+1],Y[Z++]=b[W+2]),Q&&(q[K++]=1,K+=1);if(N){var tt=O?1+$:$;for(W=3*tt,a=0;a<2;a++)U=Vt(U,J,W,p,h),J+=6,i.st&&(X=Lt(X,j,2*tt,v),j+=4),r&&(Z+=3,Y[Z++]=b[W],Y[Z++]=b[W+1],Y[Z++]=b[W+2]),Q&&(q[K++]=1,K+=1)}else for(a=$-c;a<$;a++)U=Vt(U,J,W=3*a,p,h),J+=6,i.st&&(X=Lt(X,j,2*a,v),j+=4),r&&(Z+=3,Y[Z++]=b[W],Y[Z++]=b[W+1],Y[Z++]=b[W+2]),Q&&(q[K++]=1,K+=1);for(a=$-1;0<a;a-=c)U=Vt(U,J,W=3*a,p,h),J+=6,i.st&&(X=Lt(X,j,2*a,v),j+=4),r&&(Z+=3,Y[Z++]=b[W],Y[Z++]=b[W+1],Y[Z++]=b[W+2]),Q&&(q[K++]=1,K+=1);if(O){var et=$;for(W=3*et,a=0;a<2;a++)U=Vt(U,J,W,p,h),J+=6,i.st&&(X=Lt(X,j,2*et,v),j+=4),r&&(Z+=3,Y[Z++]=b[W],Y[Z++]=b[W+1],Y[Z++]=b[W+2]),Q&&(q[K++]=1,K+=1)}else for(a=c-1;0<=a;a--)U=Vt(U,J,W=3*a,p,h),J+=6,i.st&&(X=Lt(X,j,2*a,v),j+=4),r&&(Z+=3,Y[Z++]=b[W],Y[Z++]=b[W+1],Y[Z++]=b[W+2]),Q&&(q[K++]=1,K+=1);var at=function(t,e,a){var r=t.length,n=e.normal?new Float32Array(r):void 0,i=e.tangent?new Float32Array(r):void 0,o=e.bitangent?new Float32Array(r):void 0,s=0,l=0,u=0,c=!0,m=Rt,d=Ct,p=wt;if(e.normal||e.tangent||e.bitangent)for(var g=0;g<r;g+=6){var y=pt.Cartesian3.fromArray(t,g,xt),f=pt.Cartesian3.fromArray(t,(g+6)%r,Ft);if(c){var h=pt.Cartesian3.fromArray(t,(g+3)%r,Gt);pt.Cartesian3.subtract(f,y,f),pt.Cartesian3.subtract(h,y,h),p=pt.Cartesian3.normalize(pt.Cartesian3.cross(h,f,p),p),c=!1}pt.Cartesian3.equalsEpsilon(f,y,dt.CesiumMath.EPSILON10)&&(c=!0),(e.tangent||e.bitangent)&&(m=a.geodeticSurfaceNormal(y,m),e.tangent&&(d=pt.Cartesian3.normalize(pt.Cartesian3.cross(m,p,d),d))),e.normal&&(n[s++]=p.x,n[s++]=p.y,n[s++]=p.z,n[s++]=p.x,n[s++]=p.y,n[s++]=p.z),e.tangent&&(i[l++]=d.x,i[l++]=d.y,i[l++]=d.z,i[l++]=d.x,i[l++]=d.y,i[l++]=d.z),e.bitangent&&(o[u++]=m.x,o[u++]=m.y,o[u++]=m.z,o[u++]=m.x,o[u++]=m.y,o[u++]=m.z)}return Et(e,{positions:t,normals:n,tangents:i,bitangents:o})}(U,i,l);i.st&&(at.attributes.st=new yt.GeometryAttribute({componentDatatype:gt.ComponentDatatype.FLOAT,componentsPerAttribute:2,values:X})),r&&(at.attributes.extrudeDirection=new yt.GeometryAttribute({componentDatatype:gt.ComponentDatatype.FLOAT,componentsPerAttribute:3,values:Y})),E&&(at.attributes.applyOffset=new yt.GeometryAttribute({componentDatatype:gt.ComponentDatatype.UNSIGNED_BYTE,componentsPerAttribute:1,values:q}));var rt,nt,it,ot,st=ht.IndexDatatype.createTypedArray(B,6*k);g=U.length/3;var lt=0;for(a=0;a<g-1;a+=2){ot=((rt=a)+2)%g;var ut=pt.Cartesian3.fromArray(U,3*rt,Ft),ct=pt.Cartesian3.fromArray(U,3*ot,Gt);pt.Cartesian3.equalsEpsilon(ut,ct,dt.CesiumMath.EPSILON10)||(it=(2+(nt=(rt+1)%g))%g,st[lt++]=rt,st[lt++]=nt,st[lt++]=ot,st[lt++]=ot,st[lt++]=nt,st[lt++]=it)}return at.indices=st,(at=ft.GeometryPipeline.combineInstances([new _t.GeometryInstance({geometry:d}),new _t.GeometryInstance({geometry:at})]))[0]}var d=[new pt.Cartesian3,new pt.Cartesian3,new pt.Cartesian3,new pt.Cartesian3],C=new pt.Cartographic,R=new pt.Cartographic;function y(t,e,a,r,n){if(0===a)return pt.Rectangle.clone(t,n);var i=z.RectangleGeometryLibrary.computeOptions(t,e,a,0,_,C),o=i.height,s=i.width,l=d;return z.RectangleGeometryLibrary.computePosition(i,r,!1,0,0,l[0]),z.RectangleGeometryLibrary.computePosition(i,r,!1,0,s-1,l[1]),z.RectangleGeometryLibrary.computePosition(i,r,!1,o-1,0,l[2]),z.RectangleGeometryLibrary.computePosition(i,r,!1,o-1,s-1,l[3]),pt.Rectangle.fromCartesianArray(l,r,n)}function g(t){var e=(t=p.defaultValue(t,p.defaultValue.EMPTY_OBJECT)).rectangle,a=p.defaultValue(t.height,0),r=p.defaultValue(t.extrudedHeight,a);this._rectangle=pt.Rectangle.clone(e),this._granularity=p.defaultValue(t.granularity,dt.CesiumMath.RADIANS_PER_DEGREE),this._ellipsoid=pt.Ellipsoid.clone(p.defaultValue(t.ellipsoid,pt.Ellipsoid.WGS84)),this._surfaceHeight=Math.max(a,r),this._rotation=p.defaultValue(t.rotation,0),this._stRotation=p.defaultValue(t.stRotation,0),this._vertexFormat=bt.VertexFormat.clone(p.defaultValue(t.vertexFormat,bt.VertexFormat.DEFAULT)),this._extrudedHeight=Math.min(a,r),this._shadowVolume=p.defaultValue(t.shadowVolume,!1),this._workerName="createRectangleGeometry",this._offsetAttribute=t.offsetAttribute,this._rotatedRectangle=void 0,this._textureCoordinateRotationPoints=void 0}g.packedLength=pt.Rectangle.packedLength+pt.Ellipsoid.packedLength+bt.VertexFormat.packedLength+7,g.pack=function(t,e,a){return a=p.defaultValue(a,0),pt.Rectangle.pack(t._rectangle,e,a),a+=pt.Rectangle.packedLength,pt.Ellipsoid.pack(t._ellipsoid,e,a),a+=pt.Ellipsoid.packedLength,bt.VertexFormat.pack(t._vertexFormat,e,a),a+=bt.VertexFormat.packedLength,e[a++]=t._granularity,e[a++]=t._surfaceHeight,e[a++]=t._rotation,e[a++]=t._stRotation,e[a++]=t._extrudedHeight,e[a++]=t._shadowVolume?1:0,e[a]=p.defaultValue(t._offsetAttribute,-1),e};var f=new pt.Rectangle,h=pt.Ellipsoid.clone(pt.Ellipsoid.UNIT_SPHERE),v={rectangle:f,ellipsoid:h,vertexFormat:Dt,granularity:void 0,height:void 0,rotation:void 0,stRotation:void 0,extrudedHeight:void 0,shadowVolume:void 0,offsetAttribute:void 0};g.unpack=function(t,e,a){e=p.defaultValue(e,0);var r=pt.Rectangle.unpack(t,e,f);e+=pt.Rectangle.packedLength;var n=pt.Ellipsoid.unpack(t,e,h);e+=pt.Ellipsoid.packedLength;var i=bt.VertexFormat.unpack(t,e,Dt);e+=bt.VertexFormat.packedLength;var o=t[e++],s=t[e++],l=t[e++],u=t[e++],c=t[e++],m=1===t[e++],d=t[e];return mt.defined(a)?(a._rectangle=pt.Rectangle.clone(r,a._rectangle),a._ellipsoid=pt.Ellipsoid.clone(n,a._ellipsoid),a._vertexFormat=bt.VertexFormat.clone(i,a._vertexFormat),a._granularity=o,a._surfaceHeight=s,a._rotation=l,a._stRotation=u,a._extrudedHeight=c,a._shadowVolume=m,a._offsetAttribute=-1===d?void 0:d,a):(v.granularity=o,v.height=s,v.rotation=l,v.stRotation=u,v.extrudedHeight=c,v.shadowVolume=m,v.offsetAttribute=-1===d?void 0:d,new g(v))},g.computeRectangle=function(t,e){var a=(t=p.defaultValue(t,p.defaultValue.EMPTY_OBJECT)).rectangle,r=p.defaultValue(t.granularity,dt.CesiumMath.RADIANS_PER_DEGREE),n=p.defaultValue(t.ellipsoid,pt.Ellipsoid.WGS84);return y(a,r,p.defaultValue(t.rotation,0),n,e)};var E=new H.Matrix3,F=new H.Quaternion,G=new pt.Cartographic;g.createGeometry=function(t){if(!dt.CesiumMath.equalsEpsilon(t._rectangle.north,t._rectangle.south,dt.CesiumMath.EPSILON10)&&!dt.CesiumMath.equalsEpsilon(t._rectangle.east,t._rectangle.west,dt.CesiumMath.EPSILON10)){var e=t._rectangle,a=t._ellipsoid,r=t._rotation,n=t._stRotation,i=t._vertexFormat,o=z.RectangleGeometryLibrary.computeOptions(e,t._granularity,r,n,_,C,R),s=E;if(0!==n||0!==r){var l=pt.Rectangle.center(e,G),u=a.geodeticSurfaceNormalCartographic(l,Ft);H.Quaternion.fromAxisAngle(u,-n,F),H.Matrix3.fromQuaternion(F,s)}else H.Matrix3.clone(H.Matrix3.IDENTITY,s);var c,m,d=t._surfaceHeight,p=t._extrudedHeight,g=!dt.CesiumMath.equalsEpsilon(d,p,0,dt.CesiumMath.EPSILON2);if(o.lonScalar=1/t._rectangle.width,o.latScalar=1/t._rectangle.height,o.tangentRotationMatrix=s,e=t._rectangle,g){c=w(t,o);var y=H.BoundingSphere.fromRectangle3D(e,a,d,x),f=H.BoundingSphere.fromRectangle3D(e,a,p,A);m=H.BoundingSphere.union(y,f)}else{if((c=Pt(t,o)).attributes.position.values=At.PolygonPipeline.scaleToGeodeticHeight(c.attributes.position.values,d,a,!1),mt.defined(t._offsetAttribute)){var h=c.attributes.position.values.length,v=new Uint8Array(h/3),b=t._offsetAttribute===vt.GeometryOffsetAttribute.NONE?0:1;vt.arrayFill(v,b),c.attributes.applyOffset=new yt.GeometryAttribute({componentDatatype:gt.ComponentDatatype.UNSIGNED_BYTE,componentsPerAttribute:1,values:v})}m=H.BoundingSphere.fromRectangle3D(e,a,d)}return i.position||delete c.attributes.position,new yt.Geometry({attributes:c.attributes,indices:c.indices,primitiveType:c.primitiveType,boundingSphere:m,offsetAttribute:t._offsetAttribute})}},g.createShadowVolume=function(t,e,a){var r=t._granularity,n=t._ellipsoid,i=e(r,n),o=a(r,n);return new g({rectangle:t._rectangle,rotation:t._rotation,ellipsoid:n,stRotation:t._stRotation,granularity:r,extrudedHeight:o,height:i,vertexFormat:bt.VertexFormat.POSITION_ONLY,shadowVolume:!0})};var b=new pt.Rectangle,P=[new pt.Cartesian2,new pt.Cartesian2,new pt.Cartesian2],V=new yt.Matrix2,L=new pt.Cartographic;return a.defineProperties(g.prototype,{rectangle:{get:function(){return mt.defined(this._rotatedRectangle)||(this._rotatedRectangle=y(this._rectangle,this._granularity,this._rotation,this._ellipsoid)),this._rotatedRectangle}},textureCoordinateRotationPoints:{get:function(){return mt.defined(this._textureCoordinateRotationPoints)||(this._textureCoordinateRotationPoints=function(t){if(0===t._stRotation)return[0,0,0,1,1,0];var e=pt.Rectangle.clone(t._rectangle,b),a=t._granularity,r=t._ellipsoid,n=y(e,a,t._rotation-t._stRotation,r,b),i=P;i[0].x=n.west,i[0].y=n.south,i[1].x=n.west,i[1].y=n.north,i[2].x=n.east,i[2].y=n.south;for(var o=t.rectangle,s=yt.Matrix2.fromRotation(t._stRotation,V),l=pt.Rectangle.center(o,L),u=0;u<3;++u){var c=i[u];c.x-=l.longitude,c.y-=l.latitude,yt.Matrix2.multiplyByVector(s,c,c),c.x+=l.longitude,c.y+=l.latitude,c.x=(c.x-o.west)/o.width,c.y=(c.y-o.south)/o.height}var m=i[0],d=i[1],p=i[2],g=new Array(6);return pt.Cartesian2.pack(m,g),pt.Cartesian2.pack(d,g,2),pt.Cartesian2.pack(p,g,4),g}(this)),this._textureCoordinateRotationPoints}}}),function(t,e){return mt.defined(e)&&(t=g.unpack(t,e)),t._ellipsoid=pt.Ellipsoid.clone(t._ellipsoid),t._rectangle=pt.Rectangle.clone(t._rectangle),g.createGeometry(t)}});
