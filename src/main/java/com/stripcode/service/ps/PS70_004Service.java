package com.stripcode.service.ps;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.ps.dao.PSPolicyItemMapper;
import com.stripcode.mybatis.ps.dao.PSPolicySupportDetailMapper;
import com.stripcode.mybatis.ps.dao.PSPolicySupportMapper;
import com.stripcode.mybatis.ps.model.PSPolicyItem;
import com.stripcode.mybatis.ps.model.PSPolicySupport;
import com.stripcode.mybatis.ps.model.PSPolicySupportDetail;
import com.stripcode.service.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/26.
 */
@Service
@CacheConfig(cacheNames = "psPolicySupport")
public class PS70_004Service extends BaseService {
    @Autowired
    private PSPolicySupportMapper psPolicySupportMapper;
    @Autowired
    private PSPolicySupportDetailMapper psPolicySupportDetailMapper;

    @Autowired
    private PSPolicyItemMapper psPolicyItemMapper;
    /*
    * 列表带分页的查询条件
    * */
    public PageInfo<PSPolicySupport> queryForPage(Map<String ,Object> params){
        //合并orderBy Sord
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        return new PageInfo<PSPolicySupport>(psPolicySupportMapper.queryForPage(params));
    }

    /*
    * 查询rowId
    * */
    public PSPolicySupport queryById(String rowId){
        PSPolicySupport psPolicySupport =psPolicySupportMapper.selectLoad(rowId);
        if(psPolicySupport!=null) {
            psPolicySupport.setPolicySupportDetailList(this.queryByIdTable(rowId));
        }
        return psPolicySupport;
    }
    /*
    * 查询表格policyId
    *
    * */
    public List<PSPolicySupportDetail> queryByIdTable(String policyId){
        return psPolicySupportDetailMapper.selectLoadTable(policyId);
    }
    @Transactional
    public Map update(Map<String,Object> map,PSPolicySupport model)throws Exception{
        Map modelMap = new HashMap();
        int count = -1;
        //保存或修改是否成功
        boolean result = true;
        Integer isRowNull =0;
        //返回到前台的提示信息
        String message = "保存成功!";
        String rowId = model.getRowId();
        /*if(model.getPolicySupportDetailList()!=null && model.getPolicySupportDetailList().size()>0) {
            count = this.savePolicySupportDetail(model.getPolicySupportDetailList());
        }*/
        // 保存政策支持基本信息
        if(StringUtils.isBlank(rowId)){
            rowId = UUIDUtils.generateKey();
            model.setRowId(rowId);
            count = psPolicySupportMapper.insert(model);
        }else{
            count = psPolicySupportMapper.update(model);
        }
        // 保存政策支持内容
        /*String []  rowIds = null;*/
        String []  amountLimits = null;
        String []  remarks = null;
        /*String []  itemCodes = null;
        String []  conditionCodes = null;
        String []  modeCodes = null;*/
        try{
            /*rowIds =  (String []) map.get("rowIds");*/
            amountLimits =  (String []) map.get("amountLimits");
            remarks =  (String []) map.get("remarks");
            /*itemCodes =  (String []) map.get("itemCodes");
            conditionCodes =  (String []) map.get("conditionCodes");
            modeCodes =  (String []) map.get("modeCodes");*/
        }catch(Exception e){
            /*rowIds = new String[1];
            rowIds[0] = (String)map.get("rowIds");*/
            amountLimits = new String[1];
            amountLimits[0] = (String)map.get("amountLimits");
            remarks = new String[1];
            remarks[0] = (String)map.get("remarks");
            /*itemCodes = new String[1];
            itemCodes[0] = (String)map.get("itemCodes");
            conditionCodes = new String[1];
            conditionCodes[0] = (String)map.get("conditionCodes");
            modeCodes = new String[1];
            modeCodes[0] = (String)map.get("modeCodes");*/
        }
        String []  rowIds = model.getRowIds();
        String [] itemCodes = model.getItemCodes();
        String [] conditionCodes = model.getConditionCodes();
        /*String [] amountLimits = model.getAmountLimits();*/
        String [] modeCodes = model.getModeCodes();
        /*String [] remarks = model.getRemarks();*/
        if(rowIds==null||rowIds.length==0){

            amountLimits = new String[0];
            remarks = new String[0];
        }
        if(model.getRowIds()!=null) {
            for(int i = 0;i<rowIds.length;i++){
                PSPolicySupportDetail ps = new PSPolicySupportDetail();
                ps.setRowId(rowIds[i]);
                ps.setItemCode(itemCodes[i]);
                ps.setPolicyId(rowId);
                ps.setModeCode(modeCodes[i]);
                ps.setRemark(remarks[i]);
                ps.setAmountLimit(amountLimits[i]);
                ps.setConditionCode(conditionCodes[i]);
                if (StringUtils.isBlank(ps.getRowId())) {
                    ps.setRowId(UUIDUtils.generateKey());
                    rowIds[i] = ps.getRowId();
                    count =  psPolicySupportDetailMapper.insertPolicySupportDetail(ps);
                } else {
                    count =  psPolicySupportDetailMapper.updatepolicySupportDetail(ps);
                }
            }
        }

/*        else {
            List<PSPolicySupportDetail> list = new ArrayList<PSPolicySupportDetail>();
            for (PSPolicySupportDetail item : list) {
                if (item.getRowId() == null || item.getRowId() == "") {
                    item.setRowId(UUIDUtils.generateKey());
                    count = psPolicySupportDetailMapper.insertPolicySupportDetail(item);
                } else {
                    count = psPolicySupportDetailMapper.updatepolicySupportDetail(item);
                }
            }
        }*/
        // 删除列表中多余的数据
        if(rowIds!=null&&rowIds.length!=0){
            isRowNull=1;
        }
        psPolicySupportDetailMapper.deletByPolicyDetail(rowIds,rowId,isRowNull);
        if (count!=1){
            result = false;
            message = "保存失败!";
        }
        modelMap.put("rowId",model.getRowId());
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }
    @Transactional
    public Integer savePolicySupportDetail(List<PSPolicySupportDetail> list) throws Exception{
        Integer count = -1;
        //返回到前台的提示信息
            for (PSPolicySupportDetail item : list) {
                if (StringUtils.isBlank(item.getRowId())) {
                    item.setRowId(UUIDUtils.generateKey());
                    count = psPolicySupportDetailMapper.insertPolicySupportDetail(item);
                } else {
                    count = psPolicySupportDetailMapper.updatepolicySupportDetail(item);
                }
            }
        return count;
    }
    /*
    * 查询支持项
    * */
    public Map selectSupportDetailList(String policyId){
        Map modelMap = new HashMap();
        String [] policyIds = policyId.split(",");
        List<PSPolicyItem> list = new ArrayList<PSPolicyItem>();
        for (String item:policyIds){
            PSPolicyItem psPolicyItem = psPolicyItemMapper.editLoad(item);
            list.add(psPolicyItem);
        }
        List<PSPolicyItem> iList = psPolicyItemMapper.selectAllByItemType("M0101");
        List<PSPolicyItem> contentList = psPolicyItemMapper.selectAllByItemType("M0102");
        List<PSPolicyItem> conditionList = psPolicyItemMapper.selectAllByItemType("M0103");
        modelMap.put("itemList",list);
        //支持编号
        modelMap.put("iList",iList);
        //支持内容
        modelMap.put("contentList",contentList);
        //支持条件
        modelMap.put("conditionList",conditionList);
        return modelMap;
    }

    public Map selectAll(String rowId){
        Map modelMap = new HashMap();
        List<PSPolicyItem> AllList =psPolicyItemMapper.selectALL(rowId);
        modelMap.put("AllList",AllList);
        return modelMap;
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @Transactional
    public Map delete(String id) {
        Map modelMap = new HashMap();
        int count = psPolicySupportMapper.deleteByPrimaryKey(id);
        if (count == 1) {
            modelMap.put("result", true);
            modelMap.put("message", "删除成功！");
            return modelMap;
        }
        modelMap.put("result", false);
        modelMap.put("message", "删除失败！");
        return modelMap;
    }
    /**
     * 禁用
     */
    @Transactional
    public Map updatePolicy(String rowId,String status)throws Exception{
        Map modelMap = new HashMap();
        int count = -1;
        //保存或修改是否成功
        boolean result = true;
        //返回到前台的提示信息
        String message = "禁用成功!";
        PSPolicySupport psPolicySupport =null;
        if(status.equals("reStore")) {
            psPolicySupport= new PSPolicySupport();
            psPolicySupport.setRowId(rowId);
            count = psPolicySupportMapper.updatePolicy(psPolicySupport);
        }
        if (count!=1){
            result = false;
            message = "禁用失败!";
        }
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }
    /**
     * 恢复
     */
    @Transactional
    public Map recoveryPolicy(String rowId,String status)throws Exception{
        Map modelMap = new HashMap();
        int count = -1;
        //保存或修改是否成功
        boolean result = true;
        //返回到前台的提示信息
        String message = "恢复成功!";
        PSPolicySupport psPolicySupport =null;
        if(status.equals("recoveryPolicy")) {
            psPolicySupport= new PSPolicySupport();
            psPolicySupport.setRowId(rowId);
            count = psPolicySupportMapper.recoveryPolicy(psPolicySupport);
        }
        if (count!=1){
            result = false;
            message = "恢复失败!";
        }
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }
    /**
     * 导出列表数据
     * * @param params
     * @param request
     * @param response
     */
    public void exportUser( Map<String,Object> params, HttpServletRequest request, HttpServletResponse response) {
        try {
            String fileName = "新增政策支持"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<PSPolicySupport> page =  psPolicySupportMapper.queryForPage(params);
            // List<PSPolicySupport> data = psPolicySupportMapper.selectForExport(params);
            List<PSPolicySupport> data = page.getResult();
            new ExportExcel("新增政策支持", PSPolicySupport.class).setDataList(data).write(response, fileName).dispose();
        } catch (Exception e) {

        }
    }
}
