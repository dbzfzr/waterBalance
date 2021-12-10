package com.zy.gis.pojo;
/**
@author Wangchong
@date 2021/12/3 15:31
@description TODO 设备维修记录
*/
public class DeviceRepairRecordWithBLOBs extends DeviceRepairRecord {
    /**
     * 故障情况描述
     */
    private String breakdownDescription;

    /**
     * 维修/处理情况
     */
    private String repairDescription;

    /**
     * 遗留问题或其他需说明的情况
     */
    private String remark;

    /**
     * 故障情况描述
     * @return breakdown_description 故障情况描述
     */
    public String getBreakdownDescription() {
        return breakdownDescription;
    }

    /**
     * 故障情况描述
     * @param breakdownDescription 故障情况描述
     */
    public void setBreakdownDescription(String breakdownDescription) {
        this.breakdownDescription = breakdownDescription == null ? null : breakdownDescription.trim();
    }

    /**
     * 维修/处理情况
     * @return repair_description 维修/处理情况
     */
    public String getRepairDescription() {
        return repairDescription;
    }

    /**
     * 维修/处理情况
     * @param repairDescription 维修/处理情况
     */
    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription == null ? null : repairDescription.trim();
    }

    /**
     * 遗留问题或其他需说明的情况
     * @return remark 遗留问题或其他需说明的情况
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 遗留问题或其他需说明的情况
     * @param remark 遗留问题或其他需说明的情况
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}