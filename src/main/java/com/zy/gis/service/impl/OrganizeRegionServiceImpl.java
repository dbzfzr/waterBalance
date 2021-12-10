package com.zy.gis.service.impl;

import com.zy.gis.mapper.OrganizeInfoMapper;
import com.zy.gis.mapper.OrganizeRegionInfoMapper;
import com.zy.gis.pojo.OrganizeRegionInfo;
import com.zy.gis.service.OrganizeRegionService;

import com.zy.gis.util.MyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/28 14:09
 */
@Service
public class OrganizeRegionServiceImpl implements OrganizeRegionService {
    Logger logger = LoggerFactory.getLogger(OrganizeRegionServiceImpl.class);

    @Autowired
    OrganizeRegionInfoMapper organizeRegionInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return organizeRegionInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertOrganizeRegionList(List<OrganizeRegionInfo> organizeRegionInfoList) {
        boolean isInsertFail = false;
        int sort = 0;
        //如果存在旧区域范围点位，先删除全部旧点位，再添加新点位
        List<OrganizeRegionInfo> oldRegionList = organizeRegionInfoMapper.selectRegionInfo(organizeRegionInfoList.get(0));
        if(oldRegionList.size() > 0){
            int iDel = organizeRegionInfoMapper.deleteByOrganizeId(organizeRegionInfoList.get(0).getOrganizeId());
            logger.info("该区域存在旧点位数据数量为"+oldRegionList.size()+"条，删除旧区域点数"+ iDel+ "条数据");
        }
        //添加新区域范围点位
        for(OrganizeRegionInfo organizeRegionInfo : organizeRegionInfoList){
            sort++;
            organizeRegionInfo.setSort(sort);
            organizeRegionInfo.setCreateTime(MyUtil.getNowDateTime());
            organizeRegionInfo.setUpdateTime(MyUtil.getNowDateTime());
             int iRet = organizeRegionInfoMapper.insertSelective(organizeRegionInfo);
             if(iRet < 1){
                 isInsertFail = true;
                 List<OrganizeRegionInfo> list = organizeRegionInfoMapper.selectRegionInfo(organizeRegionInfo);
                 int iDel = organizeRegionInfoMapper.deleteByOrganizeId(organizeRegionInfo.getOrganizeId());
                 logger.info("新增失败，该区域存在点位数据数量为"+list.size()+"条，删除已新增的区域点数"+ iDel+ "条数据");
                 break;
             }
        }

        if(isInsertFail){//新增失败
            return -1;
        }
        return organizeRegionInfoList.size();
    }

    @Override
    public int updateByPrimaryKeySelective(OrganizeRegionInfo record) {
        return organizeRegionInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<OrganizeRegionInfo> selectRegionInfo(OrganizeRegionInfo record) {
        return organizeRegionInfoMapper.selectRegionInfo(record);
    }

    @Override
    public int deleteByOrganizeId(Integer organizeId) {
        return organizeRegionInfoMapper.deleteByOrganizeId(organizeId);
    }
}
