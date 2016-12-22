package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.tree.TreeModel;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFSiteInfoMapper;
import com.stripcode.mybatis.sf.model.SFFloorInfo;
import com.stripcode.mybatis.sf.model.SFRentInfo;
import com.stripcode.mybatis.sf.model.SFSiteInfo;
import com.stripcode.mybatis.sf.model.SFStyleAreaPerInfo;
import com.stripcode.mybatis.user.model.TCodeMacroDefine;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "SF30_052Service")
public class SF30_052Service {
    @Autowired
   private SFSiteInfoMapper sfSiteInfoMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    //保存
    @Transactional
    public Map update(SFSiteInfo model, TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        Map<String,Object> floorMap = new HashMap<String,Object>();
        Map<String,Object> rentMap = new HashMap<String,Object>();
        Boolean result = true;
        String message = "保存成功!";
        //从map取值
        Integer count = -1;
        Double totalSize = 0.0;
        ArrayList floorRowId = new ArrayList();
        ArrayList rentRowId = new ArrayList();
        if(model.getFloorInfoList()!=null){
            model.setFloor(model.getFloorInfoList().size());
            //           循环新增或修改楼层信息
            for (SFFloorInfo item : model.getFloorInfoList()){
                item.setPpId(model.getPpId());
                //判断是否存在楼层信息
                Integer isExistFloorInfo = sfSiteInfoMapper.isExistFloorInfo(model.getPpId(),item.getRowId());
                //执行新增或修改操作
                if(isExistFloorInfo==0){
                    item.setRowId(UUIDUtils.generateKey());
                    count = sfSiteInfoMapper.insertFloorInfo(item);
                }else {
                    count = sfSiteInfoMapper.updateFloorInfo(item);
                }
                floorRowId.add(item.getRowId());
                if(item.getSize() == null){
                    continue;
                }
                totalSize += item.getSize();
            }
        }

        model.setArea(totalSize);
        if(model.getRentInfoList()!=null){
            for(SFRentInfo rent : model.getRentInfoList()){
                rent.setPpId(model.getPpId());
                //判读是否存在周边租金信息
                Integer isExistRentInfo = sfSiteInfoMapper.isExistRentInfo(model.getPpId(),rent.getRowId());
                //新增或修改周边租金信息
                if(isExistRentInfo==0){
                    rent.setRowId(UUIDUtils.generateKey());
                    count = sfSiteInfoMapper.insertRentInfo(rent);
                }else {
                    count = sfSiteInfoMapper.updateRentInfo(rent);
                }
                rentRowId.add(rent.getRowId());
            }
        }
        //判断是否存在场地信息
        Integer isExistSiteInfo = sfSiteInfoMapper.isExistSiteInfo(model.getPpId());
        //新增或修改场地信息
        if(isExistSiteInfo==0){
            model.setRowId(UUIDUtils.generateKey());
            count = sfSiteInfoMapper.insertSiteInfo(model);
        }else{
            count = sfSiteInfoMapper.updateSiteInfo(model);
        }
        if(floorRowId.size()==0){
            floorMap.put("isFloorNull",0);
        }
        if(rentRowId.size()==0){
            rentMap.put("isRentNull",0);
        }
        //删除楼层信息
        floorMap.put("rowId",floorRowId);
        floorMap.put("ppId",model.getPpId());
        sfSiteInfoMapper.delFloor(floorMap);
        // 删除周边租金信息
        rentMap.put("rowId",rentRowId);
        rentMap.put("ppId",model.getPpId());
        sfSiteInfoMapper.delRent(rentMap);

        if(count!=1){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(model.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),csTaskCompletion.getOptimauthId());
        modelMap.put("rowId",model.getRowId());
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }

    /**
     * 查询场地信息
     * @param ppId
     * @return SFSiteInfo
     */
    public SFSiteInfo querySiteInfo(String ppId){
        SFSiteInfo model = sfSiteInfoMapper.querySiteInfo(ppId);
        if(model!=null){
            model.setFloorInfoList(this.queryFloorInfo(ppId));
            model.setRentInfoList(this.queryRentInfo(ppId));
            return model;
        }

        SFSiteInfo siteInfo = new SFSiteInfo();
        siteInfo.setFloorInfoList(this.queryFloorInfo(ppId));
        siteInfo.setRentInfoList(this.queryRentInfo(ppId));
        return siteInfo;
    }

    /**
     * 查询周边租金信息
     * @param ppId
     * @return list
     */
    public List<SFRentInfo> queryRentInfo(String ppId){
        return sfSiteInfoMapper.queryRentInfo(ppId);
    }

    /**
     * 查询楼层信息
     * @param ppId
     * @return list
     */
    public List<SFFloorInfo> queryFloorInfo(String ppId){
        return sfSiteInfoMapper.queryFloorInfo(ppId);
    }


    public List<TreeModel> queryStyleAreaPerInfo(String ppId){
        return sfSiteInfoMapper.queryStyleAreaPerInfo(ppId);
    }

    public List<TCodeMacroDefine> loadTableHead(String storeImages) {
        List<TCodeMacroDefine> list = new ArrayList<TCodeMacroDefine>();
        String[] storeImage = storeImages.split(",");
        for (int i = 0;i<storeImage.length;i++){
            TCodeMacroDefine model = sfSiteInfoMapper.loadTableHead(storeImage[i]);
            list.add(model);
        }
        return list;
    }

    public List<SFStyleAreaPerInfo> queryStyleInfo(String ppId,String seriesSex){
        return sfSiteInfoMapper.queryStyleInfo(ppId,seriesSex);
    }
}
