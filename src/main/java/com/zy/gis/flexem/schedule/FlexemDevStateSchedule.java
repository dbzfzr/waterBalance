package com.zy.gis.flexem.schedule;

import com.zy.gis.common.utils.ConfigUtil;
import com.zy.gis.common.utils.DateUtil;
import com.zy.gis.common.utils.MyXMLUtil;
import com.zy.gis.pojo.AlarmRecord;
import com.zy.gis.pojo.devAndFacility.DevControlPanelInfo;
import com.zy.gis.pojo.flexem.FlexState;
import com.zy.gis.service.AlarmRecordService;
import com.zy.gis.service.DevControlPanelService;
import com.zy.gis.service.FlexStateService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

/**
@author Wangchong
@date 2021/10/30 14:54
@description TODO 繁易屏设备状态检测定时任务
*/
@Component
@EnableScheduling
public class FlexemDevStateSchedule {

    private static Logger log = LoggerFactory.getLogger(FlexemDevStateSchedule.class);

    @Autowired
    private FlexStateService flexStateService;

    @Autowired
    private DevControlPanelService devControlPanelService;

    @Autowired
    private AlarmRecordService alarmRecordService;

    /**
     * 20211207 Wangchong 多长时间未收到在线消息 繁易屏设备设置为离线状态 默认6分钟
     */
    private static Long howLongNoReceiveOnlineMessageSetFlexemOffline;

    static {
       String str = MyXMLUtil.getConfigXMLValue(ConfigUtil.getConfigXmlPath(), "howLongNoReceiveOnlineMessageSetFlexemOffline");
       if (StringUtils.isNotEmpty(str)){
           howLongNoReceiveOnlineMessageSetFlexemOffline = Long.valueOf(str);
       }else{
           howLongNoReceiveOnlineMessageSetFlexemOffline = 360000L;
       }
    }

    private static DevControlPanelInfo devControlPanelInfo = new DevControlPanelInfo();

    /**
    @author Wangchong
    @date 2021/11/5 19:30
    @description TODO 定时器5分钟检测一次繁易屏状态
    */
    @Scheduled(cron = "0 */5 * * * *")  //定时器5分钟触发一次
    public void flexStateInspect(){

        log.info("定时监测繁易屏状态执行");
        FlexState flexState = new FlexState();

        List<FlexState> flexStateList = flexStateService.selectFlexStateList(flexState);

        Long nowTimeMillseconds = System.currentTimeMillis();

        String nowTimeStr = DateUtil.getNowTime();
        Long flexemTimeStampMillseconds;

        for (FlexState flexemState : flexStateList){
            if (flexemState.getFlexemOnlineSta() == 0){// 已经是离线状态，不再进行判断
                continue;
            }
            try {
                flexemTimeStampMillseconds = DateUtil.parse(flexemState.getFlexemTimeStamp()).getTime();

            }catch (ParseException e){
                log.error("解析时间字符串出现问题:{}", e.getMessage());
                continue;
            }

            if (nowTimeMillseconds - flexemTimeStampMillseconds < howLongNoReceiveOnlineMessageSetFlexemOffline){
                continue;
            }

            flexState.setBoxNo(flexemState.getBoxNo());
            flexState.setFlexemOnlineSta(0);
            flexState.setFlexemWireless(0);
            flexState.setUpdateTime(nowTimeStr);
            // 更新设备状态
            flexStateService.updateByBoxNoKeySelective(flexState);

            devControlPanelInfo.setBoxNo(flexemState.getBoxNo());
            devControlPanelInfo.setBoxState("false");
            devControlPanelInfo.setUpdateTime(nowTimeStr);
            devControlPanelService.updateDevControlPanelByBoxNo(devControlPanelInfo);

            // 离线报警事件
           // DevControlPanelInfo tempDevControlPanelInfo = devControlPanelService.getAllDevControlPanelInfo(devControlPanelInfo).get(0);

            AlarmRecord alarmRecord = new AlarmRecord();
            alarmRecord.setAlarmDevCode(flexemState.getBoxNo());
            //alarmRecord.setDevFacilityNo(tempDevControlPanelInfo.getFacilityNo());
            alarmRecord.setAlarmLevel("橙色");
            alarmRecord.setHandleState("未处理");
            alarmRecord.setAlarmType("设备故障");
            //alarmRecord.setAlarmStation(tempDevControlPanelInfo.getBoxAlias());
            alarmRecord.setAlarmDescription("繁易屏设备离线");
            alarmRecord.setAlarmTime(nowTimeStr);

//            Integer count = alarmRecordService.insertSelective(alarmRecord);
//            if (count > 0) {
//                log.info("{}离线报警事件插入成功", flexemState.getBoxNo());
//            }else{
//                log.info("{}离线报警事件插入失败", flexemState.getBoxNo());
//                return;
//            }
        }
    }
}
