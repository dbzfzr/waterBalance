package com.zy.gis.device.data;

/**
@author Wangchong
@date 2021/12/8 19:29
@description TODO 凯铭DTU的设备传上来的数据处理 使用netty框架进行TCP监听
*/
public class DTUDeviceDataHandler {

    private static DTUDeviceDataHandler dtuDeviceDataHandler = null;

    /**
     * netty TCP监听端口
     */
    private static final int TCP_LISTEN_PORT = 14002;

    private OneNettyTcpServer oneNettyTcpServer = new OneNettyTcpServer(TCP_LISTEN_PORT);


    private DTUDeviceDataHandler(){

    }

    // 单例
    public static DTUDeviceDataHandler getInstance(){
        synchronized (DTUDeviceDataHandler.class){
            if (null == dtuDeviceDataHandler){
                dtuDeviceDataHandler = new DTUDeviceDataHandler();
            }
        }
        return dtuDeviceDataHandler;
    }

    /**
    @author Wangchong
    @date 2021/12/8 20:03
    @description TODO 开启 netty tcp 监听
    */
    public void startNettyTcpListen(){
        oneNettyTcpServer.startRun();
    }
}
