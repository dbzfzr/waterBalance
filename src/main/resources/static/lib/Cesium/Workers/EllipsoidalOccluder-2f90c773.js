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
define(["exports","./defined-b9ff0e39","./Check-e6691f86","./defaultValue-199f5aa8","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5","./Transforms-f017fb11"],function(e,u,a,p,f,i,r){"use strict";function t(e,a){this._ellipsoid=e,this._cameraPosition=new f.Cartesian3,this._cameraPositionInScaledSpace=new f.Cartesian3,this._distanceToLimbInScaledSpaceSquared=0,u.defined(a)&&(this.cameraPosition=a)}i.defineProperties(t.prototype,{ellipsoid:{get:function(){return this._ellipsoid}},cameraPosition:{get:function(){return this._cameraPosition},set:function(e){var a=this._ellipsoid.transformPositionToScaledSpace(e,this._cameraPositionInScaledSpace),i=f.Cartesian3.magnitudeSquared(a)-1;f.Cartesian3.clone(e,this._cameraPosition),this._cameraPositionInScaledSpace=a,this._distanceToLimbInScaledSpaceSquared=i}}});var o=new f.Cartesian3;t.prototype.isPointVisible=function(e){var a=this._ellipsoid.transformPositionToScaledSpace(e,o);return this.isScaledSpacePointVisible(a)},t.prototype.isScaledSpacePointVisible=function(e){var a=this._cameraPositionInScaledSpace,i=this._distanceToLimbInScaledSpaceSquared,t=f.Cartesian3.subtract(e,a,o),n=-f.Cartesian3.dot(t,a);return!(i<0?0<n:i<n&&n*n/f.Cartesian3.magnitudeSquared(t)>i)},t.prototype.computeHorizonCullingPoint=function(e,a,i){u.defined(i)||(i=new f.Cartesian3);for(var t=this._ellipsoid,n=h(t,e),r=0,o=0,s=a.length;o<s;++o){var c=S(t,a[o],n);r=Math.max(r,c)}return C(n,r,i)};var m=new f.Cartesian3;t.prototype.computeHorizonCullingPointFromVertices=function(e,a,i,t,n){u.defined(n)||(n=new f.Cartesian3),t=p.defaultValue(t,f.Cartesian3.ZERO);for(var r=this._ellipsoid,o=h(r,e),s=0,c=0,l=a.length;c<l;c+=i){m.x=a[c]+t.x,m.y=a[c+1]+t.y,m.z=a[c+2]+t.z;var d=S(r,m,o);s=Math.max(s,d)}return C(o,s,n)};var s=[];t.prototype.computeHorizonCullingPointFromRectangle=function(e,a,i){var t=f.Rectangle.subsample(e,a,0,s),n=r.BoundingSphere.fromPoints(t);if(!(f.Cartesian3.magnitude(n.center)<.1*a.minimumRadius))return this.computeHorizonCullingPoint(n.center,t,i)};var c=new f.Cartesian3,l=new f.Cartesian3;function S(e,a,i){var t=e.transformPositionToScaledSpace(a,c),n=f.Cartesian3.magnitudeSquared(t),r=Math.sqrt(n),o=f.Cartesian3.divideByScalar(t,r,l);n=Math.max(1,n);var s=1/(r=Math.max(1,r));return 1/(f.Cartesian3.dot(o,i)*s-f.Cartesian3.magnitude(f.Cartesian3.cross(o,i,o))*(Math.sqrt(n-1)*s))}function C(e,a,i){if(!(a<=0||a===1/0||a!=a))return f.Cartesian3.multiplyByScalar(e,a,i)}var n=new f.Cartesian3;function h(e,a){return f.Cartesian3.equals(a,f.Cartesian3.ZERO)?a:(e.transformPositionToScaledSpace(a,n),f.Cartesian3.normalize(n,n))}e.EllipsoidalOccluder=t});
