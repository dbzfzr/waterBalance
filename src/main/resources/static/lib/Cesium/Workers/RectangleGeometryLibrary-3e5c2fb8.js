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
define(["exports","./defined-b9ff0e39","./Check-e6691f86","./Math-92bd3539","./Cartesian2-8fa798b8","./Transforms-f017fb11","./GeometryAttribute-78070f6e"],function(t,m,n,y,O,a,G){"use strict";var p=Math.cos,v=Math.sin,x=Math.sqrt,r={computePosition:function(t,n,a,r,e,o,s){var i=n.radiiSquared,g=t.nwCorner,h=t.boundingRectangle,u=g.latitude-t.granYCos*r+e*t.granXSin,C=p(u),c=v(u),l=i.z*c,S=g.longitude+r*t.granYSin+e*t.granXCos,d=C*p(S),f=C*v(S),w=i.x*d,M=i.y*f,X=x(w*d+M*f+l*c);if(o.x=w/X,o.y=M/X,o.z=l/X,a){var Y=t.stNwCorner;m.defined(Y)?(u=Y.latitude-t.stGranYCos*r+e*t.stGranXSin,S=Y.longitude+r*t.stGranYSin+e*t.stGranXCos,s.x=(S-t.stWest)*t.lonScalar,s.y=(u-t.stSouth)*t.latScalar):(s.x=(S-h.west)*t.lonScalar,s.y=(u-h.south)*t.latScalar)}}},R=new G.Matrix2,b=new O.Cartesian3,P=new O.Cartographic,W=new O.Cartesian3,_=new a.GeographicProjection;function T(t,n,a,r,e,o,s){var i=Math.cos(n),g=r*i,h=a*i,u=Math.sin(n),C=r*u,c=a*u;b=_.project(t,b),b=O.Cartesian3.subtract(b,W,b);var l=G.Matrix2.fromRotation(n,R);b=G.Matrix2.multiplyByVector(l,b,b),b=O.Cartesian3.add(b,W,b),o-=1,s-=1;var S=(t=_.unproject(b,t)).latitude,d=S+o*c,f=S-g*s,w=S-g*s+o*c,M=Math.max(S,d,f,w),X=Math.min(S,d,f,w),Y=t.longitude,m=Y+o*h,p=Y+s*C,v=Y+s*C+o*h;return{north:M,south:X,east:Math.max(Y,m,p,v),west:Math.min(Y,m,p,v),granYCos:g,granYSin:C,granXCos:h,granXSin:c,nwCorner:t}}r.computeOptions=function(t,n,a,r,e,o,s){var i,g,h,u,C,c=t.east,l=t.west,S=t.north,d=t.south,f=!1,w=!1;S===y.CesiumMath.PI_OVER_TWO&&(f=!0),d===-y.CesiumMath.PI_OVER_TWO&&(w=!0);var M=S-d;h=(C=c<l?y.CesiumMath.TWO_PI-l+c:c-l)/((i=Math.ceil(C/n)+1)-1),u=M/((g=Math.ceil(M/n)+1)-1);var X=O.Rectangle.northwest(t,o),Y=O.Rectangle.center(t,P);0===a&&0===r||(Y.longitude<X.longitude&&(Y.longitude+=y.CesiumMath.TWO_PI),W=_.project(Y,W));var m=u,p=h,v=O.Rectangle.clone(t,e),G={granYCos:m,granYSin:0,granXCos:p,granXSin:0,nwCorner:X,boundingRectangle:v,width:i,height:g,northCap:f,southCap:w};if(0!==a){var x=T(X,a,h,u,0,i,g);S=x.north,d=x.south,c=x.east,l=x.west,G.granYCos=x.granYCos,G.granYSin=x.granYSin,G.granXCos=x.granXCos,G.granXSin=x.granXSin,v.north=S,v.south=d,v.east=c,v.west=l}if(0!==r){a-=r;var R=O.Rectangle.northwest(v,s),b=T(R,a,h,u,0,i,g);G.stGranYCos=b.granYCos,G.stGranXCos=b.granXCos,G.stGranYSin=b.granYSin,G.stGranXSin=b.granXSin,G.stNwCorner=R,G.stWest=b.west,G.stSouth=b.south}return G},t.RectangleGeometryLibrary=r});
