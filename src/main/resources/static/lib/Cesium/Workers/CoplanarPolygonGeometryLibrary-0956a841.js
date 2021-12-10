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
define(["exports","./Check-e6691f86","./Cartesian2-8fa798b8","./Transforms-f017fb11","./OrientedBoundingBox-1bbba5b8"],function(n,t,l,x,b){"use strict";var e={},s=new l.Cartesian3,B=new l.Cartesian3,P=new l.Cartesian3,M=new l.Cartesian3,h=new b.OrientedBoundingBox;function o(n,t,e,r,a){var i=l.Cartesian3.subtract(n,t,s),o=l.Cartesian3.dot(e,i),u=l.Cartesian3.dot(r,i);return l.Cartesian2.fromElements(o,u,a)}e.validOutline=function(n){var t=b.OrientedBoundingBox.fromPoints(n,h).halfAxes,e=x.Matrix3.getColumn(t,0,B),r=x.Matrix3.getColumn(t,1,P),a=x.Matrix3.getColumn(t,2,M),i=l.Cartesian3.magnitude(e),o=l.Cartesian3.magnitude(r),u=l.Cartesian3.magnitude(a);return!(0===i&&(0===o||0===u)||0===o&&0===u)},e.computeProjectTo2DArguments=function(n,t,e,r){var a,i,o=b.OrientedBoundingBox.fromPoints(n,h),u=o.halfAxes,s=x.Matrix3.getColumn(u,0,B),C=x.Matrix3.getColumn(u,1,P),m=x.Matrix3.getColumn(u,2,M),c=l.Cartesian3.magnitude(s),f=l.Cartesian3.magnitude(C),g=l.Cartesian3.magnitude(m),d=Math.min(c,f,g);return(0!==c||0!==f&&0!==g)&&(0!==f||0!==g)&&(d!==f&&d!==g||(a=s),d===c?a=C:d===g&&(i=C),d!==c&&d!==f||(i=m),l.Cartesian3.normalize(a,e),l.Cartesian3.normalize(i,r),l.Cartesian3.clone(o.center,t),!0)},e.createProjectPointsTo2DFunction=function(r,a,i){return function(n){for(var t=new Array(n.length),e=0;e<n.length;e++)t[e]=o(n[e],r,a,i);return t}},e.createProjectPointTo2DFunction=function(e,r,a){return function(n,t){return o(n,e,r,a,t)}},n.CoplanarPolygonGeometryLibrary=e});
