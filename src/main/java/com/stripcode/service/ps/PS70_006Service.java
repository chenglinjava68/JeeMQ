package com.stripcode.service.ps;

import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.ps.dao.PSPolicySupportApplyMapper;
import com.stripcode.mybatis.ps.dao.PSPolicySupportImplementationMapper;
import com.stripcode.mybatis.ps.model.PSPolicySupportApply;
import com.stripcode.mybatis.ps.model.PSPolicySupportImplementation;
import com.stripcode.mybatis.sf.model.SFPolicySupportAssessment;
import com.stripcode.mybatis.user.model.RscSysUser;
import com.stripcode.service.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/12/8.
 */
@Service
@CacheConfig(cacheNames = "PSPolicySupportApply")
public class PS70_006Service extends BaseService {
    @Autowired
    private PSPolicySupportApplyMapper psPolicySupportApplyMapper;
    @Autowired
    private PSPolicySupportImplementationMapper psPolicySupportImplementationMapper;

//查询政策支持执行里的执行信息
    /*public Integer selectCheckId(String CheckId){
        return psPolicySupportApplyMapper.selectCheckId(CheckId);
    }*/
    public PSPolicySupportImplementation selectCheckId(String CheckId){
        return psPolicySupportImplementationMapper.selectCheckId(CheckId);
    }
    public Integer selectRowId(String rowId){
        return psPolicySupportImplementationMapper.selectRowId(rowId);
    }
    //政策支持执行列表
    SFPolicySupportAssessment sfPolicySupportAssessment =null;
    public List<SFPolicySupportAssessment> selectList(String pids, String rowId) {
        sfPolicySupportAssessment= new SFPolicySupportAssessment();
        String[] pid = pids.split(",");
        sfPolicySupportAssessment.setPpIds(pid);
        sfPolicySupportAssessment.setRowId(rowId);
        return psPolicySupportImplementationMapper.selectList(sfPolicySupportAssessment);
    }

    //政策支持执行申请保存
    public Map update(PSPolicySupportImplementation psPolicySupportImplementation) {
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        int count = -1;
            List<SFPolicySupportAssessment> list=psPolicySupportImplementationMapper.selectList(sfPolicySupportAssessment);
            for(SFPolicySupportAssessment item:list){
                PSPolicySupportImplementation psPolicySupportImplementation1=new PSPolicySupportImplementation();
                psPolicySupportImplementation1.setRowId(item.getRowId());
                psPolicySupportImplementation1.setStoreId(item.getPpId());
                psPolicySupportImplementation1.setSupportItem(item.getSupportItem());
                psPolicySupportImplementation1.setSupportMode(item.getSupportMode());
                psPolicySupportImplementation1.setCheckId(psPolicySupportImplementation.getCheckId());
                psPolicySupportImplementation1.setSales(item.getSales());
                psPolicySupportImplementation1.setStartDate(item.getStartDate());
                psPolicySupportImplementation1.setEndDate2(item.getEndDate());
                psPolicySupportImplementation1.setAssessmentItem(item.getAssessmentItem());
                psPolicySupportImplementation1.setTarget(item.getTarget());
                psPolicySupportImplementation1.setReturnRatio(item.getReturnRatio());
                psPolicySupportImplementation1.setReturnSales(item.getReturnSales());
                count =psPolicySupportImplementationMapper.insertSupport(psPolicySupportImplementation1);
                /*Integer isExit= this.selectRowId(item.getRowId());
                if (isExit==0){
                    count =psPolicySupportImplementationMapper.insertSupport(psPolicySupportImplementation1);
                }else{
                    count =psPolicySupportImplementationMapper.updateSupport(psPolicySupportImplementation1);
                }*/


            }
        PSPolicySupportApply apply = new PSPolicySupportApply();
        apply.setCheckId(psPolicySupportImplementation.getCheckId());
        apply.setOriginator(WebUtil.getCurrentUser());
        if(StringUtils.isNotBlank(apply.getOriginator())){

            count =psPolicySupportApplyMapper.insertApply(apply.getOriginator());
        }else{
            count =psPolicySupportApplyMapper.updateApply(apply.getOriginator());
        }


        if (count != 1) {
            modelMap.put("result", false);
            modelMap.put("message", "保存失败!");
            return modelMap;
        }
        modelMap.put("ppId", sfPolicySupportAssessment.getPpId());
        modelMap.put("result", result);
        modelMap.put("message", "保存成功!");
        return modelMap;
    }

    public RscSysUser loadUser(String userId){
        return psPolicySupportApplyMapper.loadUser(userId);
    }
}
