
var MyUtil = {
    msg : function (msg) {
        layer.msg(msg,{time:500});
    }
    ,msg : function (msg,time) {
        layer.msg(msg,{time:time});
    }
    ,tip : function () {

    }
    ,getHexUpperString :function(value) {
        value = value.toString(16).toLocaleUpperCase();
        if(value.length < 2){
            value = '0'+ value;
        }
        return value;
    }
    ,getUUid : function () {
        var d = new Date().getTime();
        if (window.performance && typeof window.performance.now === "function") {
            d += performance.now(); //use high-precision timer if available
        }
        var uuid = 'xxxxxxxxxxxx4xxxyxxxxxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
            var r = (d + Math.random() * 16) % 16 | 0;
            d = Math.floor(d / 16);
            return (c == 'x' ? r : (r & 0x3 | 0x8)).toString(16);
        });
        return uuid;
    }
    //自定义长度补0
    ,repairZero : function(value,len) {
        if(value.length < len){
            for(var i=value.length;i<len;i++){
                value = '0'+value;
            }
        }
        return value;
    }
    //默认长度2补0
    ,repairZero : function(value) {
        var len = 2;
        if(value.length < len){
            value = '0'+value;
        }
        return value;
    }
    //空字符串校验
    ,isEmptyString : function (str) {
        return str == null || str.length < 1;
    }
    //是否空对象
    ,isEmptyObj : function(obj){
        var bRet = true;
        if(obj == null){
            return bRet;
        }
        for(var key in obj){
            bRet = false ;
            return bRet;
        }
        return bRet;
    },
    headItemThis : function(str) {
        var itemS = $('.layui-header').find('.layui-nav-item');
        for(var i=0;i<itemS.length;i++){
            var item = itemS[i];
            if($(item).find('a').text() == str){
                $(item).addClass('layui-this');
            }else {
                $(item).removeClass('layui-this');
            }
        }
    }
};

var DateUtil = {
    dateformat : function(time, format){
        var t = new Date(time);
        var tf = function(i){return (i < 10 ? '0' : '') + i};
        return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
            switch(a){
                case 'yyyy':
                    return tf(t.getFullYear());
                    break;
                case 'MM':
                    return tf(t.getMonth() + 1);
                    break;
                case 'mm':
                    return tf(t.getMinutes());
                    break;
                case 'dd':
                    return tf(t.getDate());
                    break;
                case 'HH':
                    return tf(t.getHours());
                    break;
                case 'ss':
                    return tf(t.getSeconds());
                    break;
            }
        })
    }

};

var MyTreeUtil = {
    getSelectedNode : function(){
        return $('#tt').tree('getSelected');
    }
    ,findTree : function (id) {
        return $('#tt').tree('find',id);
    }
};


var MyLayUIUtil = {
    loading : function () {
        return layer.load(1, {shade: [0.1,'#fff']});
    }
    ,closeLoading : function (loading) {
        layer.close(loading);
    }
};



