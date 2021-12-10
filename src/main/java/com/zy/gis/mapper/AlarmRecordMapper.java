package com.zy.gis.mapper;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.orm.qo.AlarmRecordQueryParameter;
import com.zy.gis.pojo.AlarmRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.zip.ZipInputStream;

@Repository
public interface AlarmRecordMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insertSelective(AlarmRecord record);

    AlarmRecord selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(AlarmRecord record);

   /**
   @author Wangchong
   @date 2021/10/22 19:26
   @description 查询报警记录列表
   @param
   @return
   */
    List<AlarmRecord> getAlarmRecordList(AlarmRecordQueryParameter alarmRecordQueryParameter);

    Integer getAlarmRecordCount(AlarmRecordQueryParameter alarmRecordQueryParameter);

    /**
    @author Wangchong
    @date 2021/10/23 14:26
    @description TODO 统计报警记录处理状态的数量
    @return {"handleState": ,"recordCount": }
    */
    List<JSONObject> statisticAlarmHandleStateCount();

    /**
    @author Wangchong
    @date 2021/11/12 10:05
    @description TODO 根据报警id查找报警记录
    @param  alarmIdList 报警id
    @return {@link AlarmRecord}
    */
    List<AlarmRecord> selectAlarmRecordListByIdList(@Param("alarmIdList")List<Integer> alarmIdList);
}