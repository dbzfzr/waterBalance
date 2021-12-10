package com.zy.gis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.utils.DateUtil;
import com.zy.gis.mapper.AlarmDispatchMapper;
import com.zy.gis.mapper.AlarmRecordMapper;
import com.zy.gis.mapper.UserInfoMapper;
import com.zy.gis.mapper.devAndFacility.NetworkPointInfoMapper;
import com.zy.gis.orm.qo.AlarmRecordQueryParameter;
import com.zy.gis.pojo.AlarmDispatchRule;
import com.zy.gis.pojo.AlarmRecord;
import com.zy.gis.pojo.UserInfo;
import com.zy.gis.pojo.devAndFacility.NetworkPointInfo;
import com.zy.gis.pojo.flexem.AlarmDispatch;
import com.zy.gis.service.AlarmDispatchRuleService;
import com.zy.gis.service.AlarmDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wangchong
 * @date 2021/11/8 16:10
 */
@Service
public class AlarmDispatchServiceImpl implements AlarmDispatchService {

    @Autowired
    private AlarmDispatchMapper alarmDispatchMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private NetworkPointInfoMapper networkPointInfoMapper;

    @Autowired
    private AlarmDispatchRuleService alarmDispatchRuleService;

    @Autowired
    private AlarmRecordMapper alarmRecordMapper;

    @Override
    public List<AlarmDispatch> selectAlarmDispatchList(AlarmDispatch alarmDispatch) {
        return alarmDispatchMapper.selectAlarmDispatchList(alarmDispatch);
    }

    @Override
    public Integer insertSelective(AlarmDispatch record) {
        return alarmDispatchMapper.insertSelective(record);
    }

    public Integer selectAlarmDispatchCount(AlarmDispatch alarmDispatch) {
        return alarmDispatchMapper.selectAlarmDispatchCount(alarmDispatch);
    }

    public Integer updateSelective(AlarmDispatch record) {
      if (record.getHandleState().equals("已处理")) {
          AlarmRecordQueryParameter alarmRecordQueryParameter = new AlarmRecordQueryParameter();
          alarmRecordQueryParameter.setLinkAlarmId(record.getAlarmRecordId());

          List<AlarmRecord> alarmRecordList = alarmRecordMapper.getAlarmRecordList(alarmRecordQueryParameter);

          AlarmDispatch alarmDispatch = new AlarmDispatch();

          for (AlarmRecord alarmRecord : alarmRecordList) {
              if (!"已处理".equals(alarmRecord.getHandleState())) {
                  alarmDispatch.setAlarmRecordId(alarmRecord.getId());
                  alarmDispatch.setHandleResult("自动解除");
                  alarmDispatch.setWaitHandleTime(DateUtil.getNowTime());
                  alarmDispatch.setHandleState("已处理");
                  alarmDispatchMapper.updateSelective(alarmDispatch);
              }
          }
      }
        return alarmDispatchMapper.updateSelective(record);
    }

    /**
     * @param record
     * @return
     * @author Wangchong
     * @date 2021/11/23 15:04
     * @description TODO 根据报警记录自动派单
     */
    @Override
    public Integer insertAlarmDispatch(AlarmRecord record) {
        NetworkPointInfo tempNetworkPointInfo = new NetworkPointInfo();
        tempNetworkPointInfo.setPointNo(record.getDevFacilityNo());
        tempNetworkPointInfo = networkPointInfoMapper.getAllNetworkPoint(tempNetworkPointInfo).get(0);

        if (tempNetworkPointInfo == null) {
            return 0;
        }

        JSONObject paramJSONObject = new JSONObject();
        paramJSONObject.put("organizationCode", tempNetworkPointInfo.getAddressId());
        paramJSONObject.put("alarmType", record.getAlarmType());

        List<AlarmDispatchRule> alarmDispatchRuleList = alarmDispatchRuleService.selectAlarmDispatchRuleList(paramJSONObject);

        AlarmDispatch alarmDispatch = new AlarmDispatch();
        alarmDispatch.setAlarmRecordId(record.getId());

        alarmDispatch.setDispatchTime(record.getAlarmTime());
        alarmDispatch.setAlarmTime(record.getAlarmTime());
        alarmDispatch.setDispatchToUserOrgCode(tempNetworkPointInfo.getAddressId());
        alarmDispatch.setHandleState("未处理");
        alarmDispatch.setDispatchType("自动派单");

        if (alarmDispatchRuleList.size() > 0){
            for (AlarmDispatchRule alarmDispatchRule: alarmDispatchRuleList){
                alarmDispatch.setDispatchToUserId(alarmDispatchRule.getDispatchToUserId());
                alarmDispatchMapper.insertSelective(alarmDispatch);
            }
            return 1;
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setRoleName("运维操作人员");
        userInfo.setOrganizationCode(tempNetworkPointInfo.getAddressId());

        List<UserInfo> tempUserInfoList = userInfoMapper.getUserInfoList(userInfo);

        if ( tempUserInfoList != null && tempUserInfoList.size() == 0){
            return 0;
        }

        // 查询运维人员
        userInfo = tempUserInfoList.get(0);

        if (userInfo == null) {
            return 0;
        }

        alarmDispatch.setDispatchToUserId(userInfo.getUserId());
        alarmDispatchMapper.insertSelective(alarmDispatch);
        return 1;
    }
}
