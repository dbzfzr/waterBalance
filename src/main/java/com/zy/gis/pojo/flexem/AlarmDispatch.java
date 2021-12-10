package com.zy.gis.pojo.flexem;

import com.zy.gis.pojo.BaseQueryEntity;
/**
@author Wangchong
@date 2021/11/8 15:51
@description TODO 报警下派实体类
*/
public class AlarmDispatch extends BaseQueryEntity {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 报警事件id
     */
    private Integer alarmRecordId;

    /**
     * 事件发生时间
     */
    private String alarmTime;

    /**
     * 派单人用户id
     */
    private Integer dispatchUserId;

    /**
     * 派单人的所属区域代码
     */
    private String dispatchUserOrgCode;

    /**
     * 派单到运维操作人员的id
     */
    private Integer dispatchToUserId;

    /**
     * 运维操作人员的所属区域代码
     */
    private String dispatchToUserOrgCode;

    /**
     * 派单时间
     */
    private String dispatchTime;

    /**
     * 处理状态
     */
    private String handleState;

    /**
     * 等待处理时长
     */
    private String waitHandleTime;

    /**
     * 下派说明
     */
    private String dispatchDescription;

    /**
     * 处理结果
     */
    private String handleResult;

    /**
     * 派单类型
     */
    private String dispatchType;

    /**
     * 记录id
     * @return id 记录id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 记录id
     * @param id 记录id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 报警事件id
     * @return alarm_record_id 报警事件id
     */
    public Integer getAlarmRecordId() {
        return alarmRecordId;
    }

    /**
     * 报警事件id
     * @param alarmRecordId 报警事件id
     */
    public void setAlarmRecordId(Integer alarmRecordId) {
        this.alarmRecordId = alarmRecordId;
    }

    /**
     * 事件发生时间
     * @return alarm_time 事件发生时间
     */
    public String getAlarmTime() {
        return alarmTime;
    }

    /**
     * 事件发生时间
     * @param alarmTime 事件发生时间
     */
    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime == null ? null : alarmTime.trim();
    }

    /**
     * 派单人用户id
     * @return dispatch_user_id 派单人用户id
     */
    public Integer getDispatchUserId() {
        return dispatchUserId;
    }

    /**
     * 派单人用户id
     * @param dispatchUserId 派单人用户id
     */
    public void setDispatchUserId(Integer dispatchUserId) {
        this.dispatchUserId = dispatchUserId;
    }

    /**
     * 派单人的所属区域代码
     * @return dispatch_user_org_code 派单人的所属区域代码
     */
    public String getDispatchUserOrgCode() {
        return dispatchUserOrgCode;
    }

    /**
     * 派单人的所属区域代码
     * @param dispatchUserOrgCode 派单人的所属区域代码
     */
    public void setDispatchUserOrgCode(String dispatchUserOrgCode) {
        this.dispatchUserOrgCode = dispatchUserOrgCode == null ? null : dispatchUserOrgCode.trim();
    }

    /**
     * 派单到运维操作人员的id
     * @return dispatch_to_user_id 派单到运维操作人员的id
     */
    public Integer getDispatchToUserId() {
        return dispatchToUserId;
    }

    /**
     * 派单到运维操作人员的id
     * @param dispatchToUserId 派单到运维操作人员的id
     */
    public void setDispatchToUserId(Integer dispatchToUserId) {
        this.dispatchToUserId = dispatchToUserId;
    }

    /**
     * 运维操作人员的所属区域代码
     * @return dispatch_to_user_org_code 运维操作人员的所属区域代码
     */
    public String getDispatchToUserOrgCode() {
        return dispatchToUserOrgCode;
    }

    /**
     * 运维操作人员的所属区域代码
     * @param dispatchToUserOrgCode 运维操作人员的所属区域代码
     */
    public void setDispatchToUserOrgCode(String dispatchToUserOrgCode) {
        this.dispatchToUserOrgCode = dispatchToUserOrgCode == null ? null : dispatchToUserOrgCode.trim();
    }

    /**
     * 派单时间
     * @return dispatch_time 派单时间
     */
    public String getDispatchTime() {
        return dispatchTime;
    }

    /**
     * 派单时间
     * @param dispatchTime 派单时间
     */
    public void setDispatchTime(String dispatchTime) {
        this.dispatchTime = dispatchTime == null ? null : dispatchTime.trim();
    }

    /**
     * 处理状态
     * @return handle_state 处理状态
     */
    public String getHandleState() {
        return handleState;
    }

    /**
     * 处理状态
     * @param handleState 处理状态
     */
    public void setHandleState(String handleState) {
        this.handleState = handleState == null ? null : handleState.trim();
    }

    /**
     * 等待处理时长
     * @return wait_handle_time 等待处理时长
     */
    public String getWaitHandleTime() {
        return waitHandleTime;
    }

    /**
     * 等待处理时长
     * @param waitHandleTime 等待处理时长
     */
    public void setWaitHandleTime(String waitHandleTime) {
        this.waitHandleTime = waitHandleTime == null ? null : waitHandleTime.trim();
    }

    /**
     * 下派说明
     * @return dispatch_description 下派说明
     */
    public String getDispatchDescription() {
        return dispatchDescription;
    }

    /**
     * 下派说明
     * @param dispatchDescription 下派说明
     */
    public void setDispatchDescription(String dispatchDescription) {
        this.dispatchDescription = dispatchDescription == null ? null : dispatchDescription.trim();
    }

    /**
     * 处理结果
     * @return handle_result 处理结果
     */
    public String getHandleResult() {
        return handleResult;
    }

    /**
     * 处理结果
     * @param handleResult 处理结果
     */
    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult == null ? null : handleResult.trim();
    }

    public String getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(String dispatchType) {
        this.dispatchType = dispatchType;
    }
}