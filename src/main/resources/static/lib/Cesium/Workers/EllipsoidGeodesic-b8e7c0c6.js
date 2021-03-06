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
define(["exports","./defined-b9ff0e39","./Check-e6691f86","./defaultValue-199f5aa8","./Math-92bd3539","./Cartesian2-8fa798b8","./defineProperties-ae15c9d5"],function(t,b,a,e,T,A,i){"use strict";function z(t,a,i,n,e,s,r){var h=function(t,a){return t*a*(4+t*(4-3*a))/16}(t,i);return(1-h)*t*a*(n+h*e*(r+h*s*(2*r*r-1)))}var s=new A.Cartesian3,r=new A.Cartesian3;function h(t,a,i,n){A.Cartesian3.normalize(n.cartographicToCartesian(a,r),s),A.Cartesian3.normalize(n.cartographicToCartesian(i,r),r);!function(t,a,i,n,e,s,r){var h,o,d,u,c,M=(a-i)/a,l=s-n,g=Math.atan((1-M)*Math.tan(e)),_=Math.atan((1-M)*Math.tan(r)),p=Math.cos(g),f=Math.sin(g),v=Math.cos(_),m=Math.sin(_),C=p*v,H=p*m,O=f*m,S=f*v,q=l,U=T.CesiumMath.TWO_PI,b=Math.cos(q),A=Math.sin(q);do{b=Math.cos(q),A=Math.sin(q);var w,R=H-S*b;d=Math.sqrt(v*v*A*A+R*R),o=O+C*b,h=Math.atan2(d,o),U=q,c=o-2*O/(u=0===d?(w=0,1):1-(w=C*A/d)*w),isNaN(c)&&(c=0),q=l+z(M,w,u,h,d,o,c)}while(Math.abs(q-U)>T.CesiumMath.EPSILON12);var P=u*(a*a-i*i)/(i*i),y=P*(256+P*(P*(74-47*P)-128))/1024,E=c*c,x=i*(1+P*(4096+P*(P*(320-175*P)-768))/16384)*(h-y*d*(c+y*(o*(2*E-1)-y*c*(4*d*d-3)*(4*E-3)/6)/4)),D=Math.atan2(v*A,H-S*b),N=Math.atan2(p*A,H*b-S);t._distance=x,t._startHeading=D,t._endHeading=N,t._uSquared=P}(t,n.maximumRadius,n.minimumRadius,a.longitude,a.latitude,i.longitude,i.latitude),t._start=A.Cartographic.clone(a,t._start),t._end=A.Cartographic.clone(i,t._end),t._start.height=0,t._end.height=0,function(t){var a=t._uSquared,i=t._ellipsoid.maximumRadius,n=t._ellipsoid.minimumRadius,e=(i-n)/i,s=Math.cos(t._startHeading),r=Math.sin(t._startHeading),h=(1-e)*Math.tan(t._start.latitude),o=1/Math.sqrt(1+h*h),d=o*h,u=Math.atan2(h,s),c=o*r,M=c*c,l=1-M,g=Math.sqrt(l),_=a/4,p=_*_,f=p*_,v=p*p,m=1+_-3*p/4+5*f/4-175*v/64,C=1-_+15*p/8-35*f/8,H=1-3*_+35*p/4,O=1-5*_,S=m*u-C*Math.sin(2*u)*_/2-H*Math.sin(4*u)*p/16-O*Math.sin(6*u)*f/48-5*Math.sin(8*u)*v/512,q=t._constants;q.a=i,q.b=n,q.f=e,q.cosineHeading=s,q.sineHeading=r,q.tanU=h,q.cosineU=o,q.sineU=d,q.sigma=u,q.sineAlpha=c,q.sineSquaredAlpha=M,q.cosineSquaredAlpha=l,q.cosineAlpha=g,q.u2Over4=_,q.u4Over16=p,q.u6Over64=f,q.u8Over256=v,q.a0=m,q.a1=C,q.a2=H,q.a3=O,q.distanceRatio=S}(t)}function n(t,a,i){var n=e.defaultValue(i,A.Ellipsoid.WGS84);this._ellipsoid=n,this._start=new A.Cartographic,this._end=new A.Cartographic,this._constants={},this._startHeading=void 0,this._endHeading=void 0,this._distance=void 0,this._uSquared=void 0,b.defined(t)&&b.defined(a)&&h(this,t,a,n)}i.defineProperties(n.prototype,{ellipsoid:{get:function(){return this._ellipsoid}},surfaceDistance:{get:function(){return this._distance}},start:{get:function(){return this._start}},end:{get:function(){return this._end}},startHeading:{get:function(){return this._startHeading}},endHeading:{get:function(){return this._endHeading}}}),n.prototype.setEndPoints=function(t,a){h(this,t,a,this._ellipsoid)},n.prototype.interpolateUsingFraction=function(t,a){return this.interpolateUsingSurfaceDistance(this._distance*t,a)},n.prototype.interpolateUsingSurfaceDistance=function(t,a){var i=this._constants,n=i.distanceRatio+t/i.b,e=Math.cos(2*n),s=Math.cos(4*n),r=Math.cos(6*n),h=Math.sin(2*n),o=Math.sin(4*n),d=Math.sin(6*n),u=Math.sin(8*n),c=n*n,M=n*c,l=i.u8Over256,g=i.u2Over4,_=i.u6Over64,p=i.u4Over16,f=2*M*l*e/3+n*(1-g+7*p/4-15*_/4+579*l/64-(p-15*_/4+187*l/16)*e-(5*_/4-115*l/16)*s-29*l*r/16)+(g/2-p+71*_/32-85*l/16)*h+(5*p/16-5*_/4+383*l/96)*o-c*((_-11*l/2)*h+5*l*o/2)+(29*_/96-29*l/16)*d+539*l*u/1536,v=Math.asin(Math.sin(f)*i.cosineAlpha),m=Math.atan(i.a/i.b*Math.tan(v));f-=i.sigma;var C=Math.cos(2*i.sigma+f),H=Math.sin(f),O=Math.cos(f),S=i.cosineU*O,q=i.sineU*H,U=Math.atan2(H*i.sineHeading,S-q*i.cosineHeading)-z(i.f,i.sineAlpha,i.cosineSquaredAlpha,f,H,O,C);return b.defined(a)?(a.longitude=this._start.longitude+U,a.latitude=m,a.height=0,a):new A.Cartographic(this._start.longitude+U,m,0)},t.EllipsoidGeodesic=n});
