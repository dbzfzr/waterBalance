package com.zy.gis.device.data;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.utils.NumberUtil;
import com.zy.gis.common.utils.SpringUtil;
import com.zy.gis.device.data.common.DeviceDataHandle;
import com.zy.gis.pojo.devAndFacility.DevControlPanelInfo;
import com.zy.gis.pojo.flexem.FlexState;
import com.zy.gis.service.DevControlPanelService;
import com.zy.gis.service.FlexStateService;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Wangchong
 * @date 2021/12/8 19:37
 * @description TODO netty接收数据处理
 */
public class NettyReceiveDataHandler extends ChannelHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(NettyReceiveDataHandler.class);

    private DevControlPanelService devControlPanelService = SpringUtil.getBean(DevControlPanelService.class);

    private FlexStateService flexStateService = SpringUtil.getBean(FlexStateService.class);

    private DeviceDataHandle deviceDataHandle = SpringUtil.getBean(DeviceDataHandle.class);

    /**
     * 这里我们覆盖了chanelRead()事件处理方法。 每当从客户端收到新的数据时， 这个方法会在收到消息时被调用，
     * 这个例子中，收到的消息的类型是ByteBuf
     *
     * @param ctx 通道处理的上下文信息
     * @param msg 接收的消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        try {
            ByteBuf in = (ByteBuf) msg;

            byte[] receiveBytes = new byte[in.readableBytes()];
            in.readBytes(receiveBytes);

            String receiveMessage = NumberUtil.bytes2HexString(receiveBytes);

            if (logger.isInfoEnabled()) {
                logger.info("tcp收到消息:{}", receiveMessage);
            }

            if (StringUtils.isEmpty(receiveMessage)) {
                return;
            }

            if (receiveMessage.length() == 72) {
                handleKaiMingDTUData(ctx, receiveMessage);
            }
        } finally {
            /**
             * ByteBuf是一个引用计数对象，这个对象必须显示地调用release()方法来释放。
             * 请记住处理器的职责是释放所有传递到处理器的引用计数对象。
             */
            // 抛弃收到的数据
            ReferenceCountUtil.release(msg);
        }
    }

    /***
     * 这个方法会在发生异常时触发
     *
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        /**
         * exceptionCaught() 事件处理方法是当出现 Throwable 对象才会被调用，即当 Netty 由于 IO
         * 错误或者处理器在处理事件时抛出的异常时。在大部分情况下，捕获的异常应该被记录下来 并且把关联的 channel
         * 给关闭掉。然而这个方法的处理方式会在遇到不同异常的情况下有不 同的实现，比如你可能想在关闭连接之前发送一个错误码的响应消息。
         */
        // 出现异常就关闭
        cause.printStackTrace();
        logger.error("tcp连接出现问题:{}", cause.getMessage());
        ctx.close();
    }

    /**
     * @param
     * @return
     * @author Wangchong
     * @date 2021/12/8 19:49
     * @description TODO tcp连接建立
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info("一个tcp连接建立,远程设备IP:{}", ctx.channel().remoteAddress().toString());
        }
    }

    /**
     * @param ctx
     * @param receiveMessage
     * @return
     * @author Wangchong
     * @date 2021/12/9 9:27
     * @description TODO 处理凯铭DTU上传来的数据，字符串长度为72
     */
    public void handleKaiMingDTUData(ChannelHandlerContext ctx, String receiveMessage) {

        // 设备编码
        String boxNo = receiveMessage.substring(0, 6);
        System.out.println("设备编码:" + boxNo);

        DevControlPanelInfo devControlPanelInfo = new DevControlPanelInfo();
        devControlPanelInfo.setBoxNo(boxNo);

        List<DevControlPanelInfo> devControlPanelInfoList = devControlPanelService.getAllDevControlPanelInfo(devControlPanelInfo);
        if (devControlPanelInfoList.size() == 0) {
            logger.error("{}设备信息不存在,请检查", boxNo);
            return;
        }

        devControlPanelInfo = devControlPanelInfoList.get(0);
        if (devControlPanelInfo == null) {
            logger.error("{}设备信息不存在,请检查", boxNo);
            return;
        }

        // 离线或者在线状态为空的话，更新状态
        if (!"true".equals(devControlPanelInfo.getBoxState())) {
            devControlPanelInfo.setBoxState("true");
            devControlPanelService.updateDevControlPanelByBoxNo(devControlPanelInfo);
            FlexState flexState = new FlexState();

            flexState.setBoxNo(boxNo);
            flexState.setFlexemOnlineSta(1);
            flexStateService.updateByBoxNoKeySelective(flexState);
        }

        // 设备系统类型
        String systemType = devControlPanelInfo.getSystemType();

        if (StringUtils.isEmpty(systemType)){
            logger.error("编号{}设备系统类型为空,请检查");
            return;
        }

        // 解析数据
        String year = receiveMessage.substring(12, 16);
        year = String.valueOf(Integer.parseInt(year, 16));

        String month = receiveMessage.substring(16, 18);
        month = String.valueOf(Integer.parseInt(month, 16));
        if (month.length() == 1) {
            month = "0" + month;
        }

        String day = receiveMessage.substring(18, 20);
        day = String.valueOf(Integer.parseInt(day, 16));
        if (day.length() == 1) {
            day = "0" + day;
        }

        String hour = receiveMessage.substring(20, 22);
        hour = String.valueOf(Integer.parseInt(hour, 16));
        if (hour.length() == 1) {
            hour = "0" + hour;
        }

        String minute = receiveMessage.substring(22, 24);
        minute = String.valueOf(Integer.parseInt(minute, 16));
        if (minute.length() == 1) {
            minute = "0" + minute;
        }

        String seconds = receiveMessage.substring(24, 26);
        seconds = String.valueOf(Integer.parseInt(seconds, 16));
        if (seconds.length() == 1) {
            seconds = "0" + seconds;
        }

        String time = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + seconds;
        //System.out.println("time:" + time);

        JSONObject msgJSONObject = new JSONObject();
        msgJSONObject.put("boxNo", boxNo);
        msgJSONObject.put("flexemTimeStamp", time);

        // COD
        String cod = receiveMessage.substring(28, 36);
        cod = String.valueOf(NumberUtil.BinaryStringToFloat(NumberUtil.HexString2binaryString(cod)));

        msgJSONObject.put("cod", cod);
        // 电导率
        String conductivity = receiveMessage.substring(36, 44);
        if (!"00000000".equals(conductivity)) {
            conductivity = String.valueOf(NumberUtil.BinaryStringToFloat(NumberUtil.HexString2binaryString(conductivity)));
            msgJSONObject.put("conductivity", conductivity);
        }

        // 当前流量
        String currentFlow = receiveMessage.substring(52, 60);
        if (!"00000000".equals(currentFlow)) {

            currentFlow = String.valueOf(NumberUtil.BinaryStringToFloat(NumberUtil.HexString2binaryString(currentFlow)));
            msgJSONObject.put("currentFlow", currentFlow);
        }

        // 累计流量
        String cumulativeFlow = receiveMessage.substring(60, 68);
        if (!"00000000".equals(cumulativeFlow)) {
            cumulativeFlow = String.valueOf(NumberUtil.BinaryStringToFloat(NumberUtil.HexString2binaryString(cumulativeFlow)));
            msgJSONObject.put("cumulativeFlow", cumulativeFlow);
        }

        if (logger.isInfoEnabled()){
            logger.info("设备数据:{}", msgJSONObject.toJSONString());
        }

        switch (systemType) {
            case "雨水监测点":
                deviceDataHandle.handleRainMonitorData(boxNo, msgJSONObject);
                break;
            case "污水监测点":
                deviceDataHandle.handleSewageMonitorFlexData(boxNo, msgJSONObject);
                break;
            case "泵站":
                deviceDataHandle.handlePumpStationFlexData(boxNo, msgJSONObject);
                break;
        }
    }
}