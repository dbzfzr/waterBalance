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
define(["exports","./defined-b9ff0e39","./Check-e6691f86","./freezeObject-2d5b18ce","./defaultValue-199f5aa8","./Math-92bd3539","./Transforms-f017fb11"],function(e,u,r,o,g,F,t){"use strict";function a(e,r,o){return o<0&&(o+=1),1<o&&(o-=1),6*o<1?e+6*(r-e)*o:2*o<1?r:3*o<2?e+(r-e)*(2/3-o)*6:e}function S(e,r,o,t){this.red=g.defaultValue(e,1),this.green=g.defaultValue(r,1),this.blue=g.defaultValue(o,1),this.alpha=g.defaultValue(t,1)}var f,s,n;S.fromCartesian4=function(e,r){return u.defined(r)?(r.red=e.x,r.green=e.y,r.blue=e.z,r.alpha=e.w,r):new S(e.x,e.y,e.z,e.w)},S.fromBytes=function(e,r,o,t,f){return e=S.byteToFloat(g.defaultValue(e,255)),r=S.byteToFloat(g.defaultValue(r,255)),o=S.byteToFloat(g.defaultValue(o,255)),t=S.byteToFloat(g.defaultValue(t,255)),u.defined(f)?(f.red=e,f.green=r,f.blue=o,f.alpha=t,f):new S(e,r,o,t)},S.fromAlpha=function(e,r,o){return u.defined(o)?(o.red=e.red,o.green=e.green,o.blue=e.blue,o.alpha=r,o):new S(e.red,e.green,e.blue,r)},t.FeatureDetection.supportsTypedArrays()&&(f=new ArrayBuffer(4),s=new Uint32Array(f),n=new Uint8Array(f)),S.fromRgba=function(e,r){return s[0]=e,S.fromBytes(n[0],n[1],n[2],n[3],r)},S.fromHsl=function(e,r,o,t,f){e=g.defaultValue(e,0)%1,r=g.defaultValue(r,0),o=g.defaultValue(o,0),t=g.defaultValue(t,1);var s=o,n=o,C=o;if(0!==r){var l,i=2*o-(l=o<.5?o*(1+r):o+r-o*r);s=a(i,l,e+1/3),n=a(i,l,e),C=a(i,l,e-1/3)}return u.defined(f)?(f.red=s,f.green=n,f.blue=C,f.alpha=t,f):new S(s,n,C,t)},S.fromRandom=function(e,r){var o=(e=g.defaultValue(e,g.defaultValue.EMPTY_OBJECT)).red;if(!u.defined(o)){var t=g.defaultValue(e.minimumRed,0),f=g.defaultValue(e.maximumRed,1);o=t+F.CesiumMath.nextRandomNumber()*(f-t)}var s=e.green;if(!u.defined(s)){var n=g.defaultValue(e.minimumGreen,0),C=g.defaultValue(e.maximumGreen,1);s=n+F.CesiumMath.nextRandomNumber()*(C-n)}var l=e.blue;if(!u.defined(l)){var i=g.defaultValue(e.minimumBlue,0),a=g.defaultValue(e.maximumBlue,1);l=i+F.CesiumMath.nextRandomNumber()*(a-i)}var E=e.alpha;if(!u.defined(E)){var b=g.defaultValue(e.minimumAlpha,0),O=g.defaultValue(e.maximumAlpha,1);E=b+F.CesiumMath.nextRandomNumber()*(O-b)}return u.defined(r)?(r.red=o,r.green=s,r.blue=l,r.alpha=E,r):new S(o,s,l,E)};var C=/^#([0-9a-f])([0-9a-f])([0-9a-f])$/i,l=/^#([0-9a-f]{2})([0-9a-f]{2})([0-9a-f]{2})$/i,i=/^rgba?\(\s*([0-9.]+%?)\s*,\s*([0-9.]+%?)\s*,\s*([0-9.]+%?)(?:\s*,\s*([0-9.]+))?\s*\)$/i,E=/^hsla?\(\s*([0-9.]+)\s*,\s*([0-9.]+%)\s*,\s*([0-9.]+%)(?:\s*,\s*([0-9.]+))?\s*\)$/i;S.fromCssColorString=function(e,r){u.defined(r)||(r=new S);var o=S[e.toUpperCase()];if(u.defined(o))return S.clone(o,r),r;var t=C.exec(e);return null!==t?(r.red=parseInt(t[1],16)/15,r.green=parseInt(t[2],16)/15,r.blue=parseInt(t[3],16)/15,r.alpha=1,r):null!==(t=l.exec(e))?(r.red=parseInt(t[1],16)/255,r.green=parseInt(t[2],16)/255,r.blue=parseInt(t[3],16)/255,r.alpha=1,r):null!==(t=i.exec(e))?(r.red=parseFloat(t[1])/("%"===t[1].substr(-1)?100:255),r.green=parseFloat(t[2])/("%"===t[2].substr(-1)?100:255),r.blue=parseFloat(t[3])/("%"===t[3].substr(-1)?100:255),r.alpha=parseFloat(g.defaultValue(t[4],"1.0")),r):null!==(t=E.exec(e))?S.fromHsl(parseFloat(t[1])/360,parseFloat(t[2])/100,parseFloat(t[3])/100,parseFloat(g.defaultValue(t[4],"1.0")),r):r=void 0},S.packedLength=4,S.pack=function(e,r,o){return o=g.defaultValue(o,0),r[o++]=e.red,r[o++]=e.green,r[o++]=e.blue,r[o]=e.alpha,r},S.unpack=function(e,r,o){return r=g.defaultValue(r,0),u.defined(o)||(o=new S),o.red=e[r++],o.green=e[r++],o.blue=e[r++],o.alpha=e[r],o},S.byteToFloat=function(e){return e/255},S.floatToByte=function(e){return 1===e?255:256*e|0},S.clone=function(e,r){if(u.defined(e))return u.defined(r)?(r.red=e.red,r.green=e.green,r.blue=e.blue,r.alpha=e.alpha,r):new S(e.red,e.green,e.blue,e.alpha)},S.equals=function(e,r){return e===r||u.defined(e)&&u.defined(r)&&e.red===r.red&&e.green===r.green&&e.blue===r.blue&&e.alpha===r.alpha},S.equalsArray=function(e,r,o){return e.red===r[o]&&e.green===r[o+1]&&e.blue===r[o+2]&&e.alpha===r[o+3]},S.prototype.clone=function(e){return S.clone(this,e)},S.prototype.equals=function(e){return S.equals(this,e)},S.prototype.equalsEpsilon=function(e,r){return this===e||u.defined(e)&&Math.abs(this.red-e.red)<=r&&Math.abs(this.green-e.green)<=r&&Math.abs(this.blue-e.blue)<=r&&Math.abs(this.alpha-e.alpha)<=r},S.prototype.toString=function(){return"("+this.red+", "+this.green+", "+this.blue+", "+this.alpha+")"},S.prototype.toCssColorString=function(){var e=S.floatToByte(this.red),r=S.floatToByte(this.green),o=S.floatToByte(this.blue);return 1===this.alpha?"rgb("+e+","+r+","+o+")":"rgba("+e+","+r+","+o+","+this.alpha+")"},S.prototype.toBytes=function(e){var r=S.floatToByte(this.red),o=S.floatToByte(this.green),t=S.floatToByte(this.blue),f=S.floatToByte(this.alpha);return u.defined(e)?(e[0]=r,e[1]=o,e[2]=t,e[3]=f,e):[r,o,t,f]},S.prototype.toRgba=function(){return n[0]=S.floatToByte(this.red),n[1]=S.floatToByte(this.green),n[2]=S.floatToByte(this.blue),n[3]=S.floatToByte(this.alpha),s[0]},S.prototype.brighten=function(e,r){return e=1-e,r.red=1-(1-this.red)*e,r.green=1-(1-this.green)*e,r.blue=1-(1-this.blue)*e,r.alpha=this.alpha,r},S.prototype.darken=function(e,r){return e=1-e,r.red=this.red*e,r.green=this.green*e,r.blue=this.blue*e,r.alpha=this.alpha,r},S.prototype.withAlpha=function(e,r){return S.fromAlpha(this,e,r)},S.add=function(e,r,o){return o.red=e.red+r.red,o.green=e.green+r.green,o.blue=e.blue+r.blue,o.alpha=e.alpha+r.alpha,o},S.subtract=function(e,r,o){return o.red=e.red-r.red,o.green=e.green-r.green,o.blue=e.blue-r.blue,o.alpha=e.alpha-r.alpha,o},S.multiply=function(e,r,o){return o.red=e.red*r.red,o.green=e.green*r.green,o.blue=e.blue*r.blue,o.alpha=e.alpha*r.alpha,o},S.divide=function(e,r,o){return o.red=e.red/r.red,o.green=e.green/r.green,o.blue=e.blue/r.blue,o.alpha=e.alpha/r.alpha,o},S.mod=function(e,r,o){return o.red=e.red%r.red,o.green=e.green%r.green,o.blue=e.blue%r.blue,o.alpha=e.alpha%r.alpha,o},S.multiplyByScalar=function(e,r,o){return o.red=e.red*r,o.green=e.green*r,o.blue=e.blue*r,o.alpha=e.alpha*r,o},S.divideByScalar=function(e,r,o){return o.red=e.red/r,o.green=e.green/r,o.blue=e.blue/r,o.alpha=e.alpha/r,o},S.ALICEBLUE=o.freezeObject(S.fromCssColorString("#F0F8FF")),S.ANTIQUEWHITE=o.freezeObject(S.fromCssColorString("#FAEBD7")),S.AQUA=o.freezeObject(S.fromCssColorString("#00FFFF")),S.AQUAMARINE=o.freezeObject(S.fromCssColorString("#7FFFD4")),S.AZURE=o.freezeObject(S.fromCssColorString("#F0FFFF")),S.BEIGE=o.freezeObject(S.fromCssColorString("#F5F5DC")),S.BISQUE=o.freezeObject(S.fromCssColorString("#FFE4C4")),S.BLACK=o.freezeObject(S.fromCssColorString("#000000")),S.BLANCHEDALMOND=o.freezeObject(S.fromCssColorString("#FFEBCD")),S.BLUE=o.freezeObject(S.fromCssColorString("#0000FF")),S.BLUEVIOLET=o.freezeObject(S.fromCssColorString("#8A2BE2")),S.BROWN=o.freezeObject(S.fromCssColorString("#A52A2A")),S.BURLYWOOD=o.freezeObject(S.fromCssColorString("#DEB887")),S.CADETBLUE=o.freezeObject(S.fromCssColorString("#5F9EA0")),S.CHARTREUSE=o.freezeObject(S.fromCssColorString("#7FFF00")),S.CHOCOLATE=o.freezeObject(S.fromCssColorString("#D2691E")),S.CORAL=o.freezeObject(S.fromCssColorString("#FF7F50")),S.CORNFLOWERBLUE=o.freezeObject(S.fromCssColorString("#6495ED")),S.CORNSILK=o.freezeObject(S.fromCssColorString("#FFF8DC")),S.CRIMSON=o.freezeObject(S.fromCssColorString("#DC143C")),S.CYAN=o.freezeObject(S.fromCssColorString("#00FFFF")),S.DARKBLUE=o.freezeObject(S.fromCssColorString("#00008B")),S.DARKCYAN=o.freezeObject(S.fromCssColorString("#008B8B")),S.DARKGOLDENROD=o.freezeObject(S.fromCssColorString("#B8860B")),S.DARKGRAY=o.freezeObject(S.fromCssColorString("#A9A9A9")),S.DARKGREEN=o.freezeObject(S.fromCssColorString("#006400")),S.DARKGREY=S.DARKGRAY,S.DARKKHAKI=o.freezeObject(S.fromCssColorString("#BDB76B")),S.DARKMAGENTA=o.freezeObject(S.fromCssColorString("#8B008B")),S.DARKOLIVEGREEN=o.freezeObject(S.fromCssColorString("#556B2F")),S.DARKORANGE=o.freezeObject(S.fromCssColorString("#FF8C00")),S.DARKORCHID=o.freezeObject(S.fromCssColorString("#9932CC")),S.DARKRED=o.freezeObject(S.fromCssColorString("#8B0000")),S.DARKSALMON=o.freezeObject(S.fromCssColorString("#E9967A")),S.DARKSEAGREEN=o.freezeObject(S.fromCssColorString("#8FBC8F")),S.DARKSLATEBLUE=o.freezeObject(S.fromCssColorString("#483D8B")),S.DARKSLATEGRAY=o.freezeObject(S.fromCssColorString("#2F4F4F")),S.DARKSLATEGREY=S.DARKSLATEGRAY,S.DARKTURQUOISE=o.freezeObject(S.fromCssColorString("#00CED1")),S.DARKVIOLET=o.freezeObject(S.fromCssColorString("#9400D3")),S.DEEPPINK=o.freezeObject(S.fromCssColorString("#FF1493")),S.DEEPSKYBLUE=o.freezeObject(S.fromCssColorString("#00BFFF")),S.DIMGRAY=o.freezeObject(S.fromCssColorString("#696969")),S.DIMGREY=S.DIMGRAY,S.DODGERBLUE=o.freezeObject(S.fromCssColorString("#1E90FF")),S.FIREBRICK=o.freezeObject(S.fromCssColorString("#B22222")),S.FLORALWHITE=o.freezeObject(S.fromCssColorString("#FFFAF0")),S.FORESTGREEN=o.freezeObject(S.fromCssColorString("#228B22")),S.FUCHSIA=o.freezeObject(S.fromCssColorString("#FF00FF")),S.GAINSBORO=o.freezeObject(S.fromCssColorString("#DCDCDC")),S.GHOSTWHITE=o.freezeObject(S.fromCssColorString("#F8F8FF")),S.GOLD=o.freezeObject(S.fromCssColorString("#FFD700")),S.GOLDENROD=o.freezeObject(S.fromCssColorString("#DAA520")),S.GRAY=o.freezeObject(S.fromCssColorString("#808080")),S.GREEN=o.freezeObject(S.fromCssColorString("#008000")),S.GREENYELLOW=o.freezeObject(S.fromCssColorString("#ADFF2F")),S.GREY=S.GRAY,S.HONEYDEW=o.freezeObject(S.fromCssColorString("#F0FFF0")),S.HOTPINK=o.freezeObject(S.fromCssColorString("#FF69B4")),S.INDIANRED=o.freezeObject(S.fromCssColorString("#CD5C5C")),S.INDIGO=o.freezeObject(S.fromCssColorString("#4B0082")),S.IVORY=o.freezeObject(S.fromCssColorString("#FFFFF0")),S.KHAKI=o.freezeObject(S.fromCssColorString("#F0E68C")),S.LAVENDER=o.freezeObject(S.fromCssColorString("#E6E6FA")),S.LAVENDAR_BLUSH=o.freezeObject(S.fromCssColorString("#FFF0F5")),S.LAWNGREEN=o.freezeObject(S.fromCssColorString("#7CFC00")),S.LEMONCHIFFON=o.freezeObject(S.fromCssColorString("#FFFACD")),S.LIGHTBLUE=o.freezeObject(S.fromCssColorString("#ADD8E6")),S.LIGHTCORAL=o.freezeObject(S.fromCssColorString("#F08080")),S.LIGHTCYAN=o.freezeObject(S.fromCssColorString("#E0FFFF")),S.LIGHTGOLDENRODYELLOW=o.freezeObject(S.fromCssColorString("#FAFAD2")),S.LIGHTGRAY=o.freezeObject(S.fromCssColorString("#D3D3D3")),S.LIGHTGREEN=o.freezeObject(S.fromCssColorString("#90EE90")),S.LIGHTGREY=S.LIGHTGRAY,S.LIGHTPINK=o.freezeObject(S.fromCssColorString("#FFB6C1")),S.LIGHTSEAGREEN=o.freezeObject(S.fromCssColorString("#20B2AA")),S.LIGHTSKYBLUE=o.freezeObject(S.fromCssColorString("#87CEFA")),S.LIGHTSLATEGRAY=o.freezeObject(S.fromCssColorString("#778899")),S.LIGHTSLATEGREY=S.LIGHTSLATEGRAY,S.LIGHTSTEELBLUE=o.freezeObject(S.fromCssColorString("#B0C4DE")),S.LIGHTYELLOW=o.freezeObject(S.fromCssColorString("#FFFFE0")),S.LIME=o.freezeObject(S.fromCssColorString("#00FF00")),S.LIMEGREEN=o.freezeObject(S.fromCssColorString("#32CD32")),S.LINEN=o.freezeObject(S.fromCssColorString("#FAF0E6")),S.MAGENTA=o.freezeObject(S.fromCssColorString("#FF00FF")),S.MAROON=o.freezeObject(S.fromCssColorString("#800000")),S.MEDIUMAQUAMARINE=o.freezeObject(S.fromCssColorString("#66CDAA")),S.MEDIUMBLUE=o.freezeObject(S.fromCssColorString("#0000CD")),S.MEDIUMORCHID=o.freezeObject(S.fromCssColorString("#BA55D3")),S.MEDIUMPURPLE=o.freezeObject(S.fromCssColorString("#9370DB")),S.MEDIUMSEAGREEN=o.freezeObject(S.fromCssColorString("#3CB371")),S.MEDIUMSLATEBLUE=o.freezeObject(S.fromCssColorString("#7B68EE")),S.MEDIUMSPRINGGREEN=o.freezeObject(S.fromCssColorString("#00FA9A")),S.MEDIUMTURQUOISE=o.freezeObject(S.fromCssColorString("#48D1CC")),S.MEDIUMVIOLETRED=o.freezeObject(S.fromCssColorString("#C71585")),S.MIDNIGHTBLUE=o.freezeObject(S.fromCssColorString("#191970")),S.MINTCREAM=o.freezeObject(S.fromCssColorString("#F5FFFA")),S.MISTYROSE=o.freezeObject(S.fromCssColorString("#FFE4E1")),S.MOCCASIN=o.freezeObject(S.fromCssColorString("#FFE4B5")),S.NAVAJOWHITE=o.freezeObject(S.fromCssColorString("#FFDEAD")),S.NAVY=o.freezeObject(S.fromCssColorString("#000080")),S.OLDLACE=o.freezeObject(S.fromCssColorString("#FDF5E6")),S.OLIVE=o.freezeObject(S.fromCssColorString("#808000")),S.OLIVEDRAB=o.freezeObject(S.fromCssColorString("#6B8E23")),S.ORANGE=o.freezeObject(S.fromCssColorString("#FFA500")),S.ORANGERED=o.freezeObject(S.fromCssColorString("#FF4500")),S.ORCHID=o.freezeObject(S.fromCssColorString("#DA70D6")),S.PALEGOLDENROD=o.freezeObject(S.fromCssColorString("#EEE8AA")),S.PALEGREEN=o.freezeObject(S.fromCssColorString("#98FB98")),S.PALETURQUOISE=o.freezeObject(S.fromCssColorString("#AFEEEE")),S.PALEVIOLETRED=o.freezeObject(S.fromCssColorString("#DB7093")),S.PAPAYAWHIP=o.freezeObject(S.fromCssColorString("#FFEFD5")),S.PEACHPUFF=o.freezeObject(S.fromCssColorString("#FFDAB9")),S.PERU=o.freezeObject(S.fromCssColorString("#CD853F")),S.PINK=o.freezeObject(S.fromCssColorString("#FFC0CB")),S.PLUM=o.freezeObject(S.fromCssColorString("#DDA0DD")),S.POWDERBLUE=o.freezeObject(S.fromCssColorString("#B0E0E6")),S.PURPLE=o.freezeObject(S.fromCssColorString("#800080")),S.RED=o.freezeObject(S.fromCssColorString("#FF0000")),S.ROSYBROWN=o.freezeObject(S.fromCssColorString("#BC8F8F")),S.ROYALBLUE=o.freezeObject(S.fromCssColorString("#4169E1")),S.SADDLEBROWN=o.freezeObject(S.fromCssColorString("#8B4513")),S.SALMON=o.freezeObject(S.fromCssColorString("#FA8072")),S.SANDYBROWN=o.freezeObject(S.fromCssColorString("#F4A460")),S.SEAGREEN=o.freezeObject(S.fromCssColorString("#2E8B57")),S.SEASHELL=o.freezeObject(S.fromCssColorString("#FFF5EE")),S.SIENNA=o.freezeObject(S.fromCssColorString("#A0522D")),S.SILVER=o.freezeObject(S.fromCssColorString("#C0C0C0")),S.SKYBLUE=o.freezeObject(S.fromCssColorString("#87CEEB")),S.SLATEBLUE=o.freezeObject(S.fromCssColorString("#6A5ACD")),S.SLATEGRAY=o.freezeObject(S.fromCssColorString("#708090")),S.SLATEGREY=S.SLATEGRAY,S.SNOW=o.freezeObject(S.fromCssColorString("#FFFAFA")),S.SPRINGGREEN=o.freezeObject(S.fromCssColorString("#00FF7F")),S.STEELBLUE=o.freezeObject(S.fromCssColorString("#4682B4")),S.TAN=o.freezeObject(S.fromCssColorString("#D2B48C")),S.TEAL=o.freezeObject(S.fromCssColorString("#008080")),S.THISTLE=o.freezeObject(S.fromCssColorString("#D8BFD8")),S.TOMATO=o.freezeObject(S.fromCssColorString("#FF6347")),S.TURQUOISE=o.freezeObject(S.fromCssColorString("#40E0D0")),S.VIOLET=o.freezeObject(S.fromCssColorString("#EE82EE")),S.WHEAT=o.freezeObject(S.fromCssColorString("#F5DEB3")),S.WHITE=o.freezeObject(S.fromCssColorString("#FFFFFF")),S.WHITESMOKE=o.freezeObject(S.fromCssColorString("#F5F5F5")),S.YELLOW=o.freezeObject(S.fromCssColorString("#FFFF00")),S.YELLOWGREEN=o.freezeObject(S.fromCssColorString("#9ACD32")),S.TRANSPARENT=o.freezeObject(new S(0,0,0,0)),e.Color=S});
