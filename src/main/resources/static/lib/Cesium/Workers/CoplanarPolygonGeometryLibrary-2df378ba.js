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
define(["exports","./Check-e6691f86","./Cartesian2-8fa798b8","./Transforms-cb918156","./OrientedBoundingBox-b0beae54"],function(n,e,l,x,B){"use strict";var t={},s=new l.Cartesian3,P=new l.Cartesian3,M=new l.Cartesian3,b=new l.Cartesian3,h=new B.OrientedBoundingBox;function o(n,e,t,r,a){var i=l.Cartesian3.subtract(n,e,s),o=l.Cartesian3.dot(t,i),u=l.Cartesian3.dot(r,i);return l.Cartesian2.fromElements(o,u,a)}t.validOutline=function(n){var e=B.OrientedBoundingBox.fromPoints(n,h).halfAxes,t=x.Matrix3.getColumn(e,0,P),r=x.Matrix3.getColumn(e,1,M),a=x.Matrix3.getColumn(e,2,b),i=l.Cartesian3.magnitude(t),o=l.Cartesian3.magnitude(r),u=l.Cartesian3.magnitude(a);return!(0===i&&(0===o||0===u)||0===o&&0===u)},t.computeProjectTo2DArguments=function(n,e,t,r){var a,i,o=B.OrientedBoundingBox.fromPoints(n,h),u=o.halfAxes,s=x.Matrix3.getColumn(u,0,P),C=x.Matrix3.getColumn(u,1,M),m=x.Matrix3.getColumn(u,2,b),c=l.Cartesian3.magnitude(s),g=l.Cartesian3.magnitude(C),d=l.Cartesian3.magnitude(m),f=Math.min(c,g,d);return(0!==c||0!==g&&0!==d)&&(0!==g||0!==d)&&(f!==g&&f!==d||(a=s),f===c?a=C:f===d&&(i=C),f!==c&&f!==g||(i=m),l.Cartesian3.normalize(a,t),l.Cartesian3.normalize(i,r),l.Cartesian3.clone(o.center,e),!0)},t.createProjectPointsTo2DFunction=function(r,a,i){return function(n){for(var e=new Array(n.length),t=0;t<n.length;t++)e[t]=o(n[t],r,a,i);return e}},t.createProjectPointTo2DFunction=function(t,r,a){return function(n,e){return o(n,t,r,a,e)}},n.CoplanarPolygonGeometryLibrary=t});
