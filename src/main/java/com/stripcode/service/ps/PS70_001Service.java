package com.stripcode.service.ps;
import com.github.pagehelper.Page;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.stripcode.core.util.excelUtil.ExportExcel;

import com.stripcode.mybatis.ps.dao.PSPolicyItemMapper;
import com.stripcode.mybatis.ps.model.PSPolicyItem;

import com.stripcode.service.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/23.
 */
@Service
@CacheConfig(cacheNames = "psPolicyItem")
public class PS70_001Service extends BaseService {
    @Autowired
    private PSPolicyItemMapper psPolicyItemMapper;

    /**
     * 列表带分页的查询数据
     * @param params
     * @return
     */
    public PageInfo<PSPolicyItem> queryForPage(Map<String,Object> params){
        //合并orderBy Sord
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        return new PageInfo<PSPolicyItem>(psPolicyItemMapper.queryForPage(params));
    }
    /*
    * 查询rowId
    * */
    public PSPolicyItem queryById(String id){
        PSPolicyItem psPolicyItem =psPolicyItemMapper.editLoad(id);
        return psPolicyItem;
    }
    /**
     * 保存
     * @param psPolicyItem
     * @return
     * @throws Exception
     */
    @Transactional
    public Map update(PSPolicyItem psPolicyItem,String itemType)throws Exception{
        Map modelMap = new HashMap();
        int count = -1;
        //保存或修改是否成功
        boolean result = true;
        //返回到前台的提示信息
        String message = "保存成功!";
        String rowId = psPolicyItem.getRowId();;
        String random = UUIDUtils.generateKey();

        if(StringUtils.isBlank(rowId)){
            psPolicyItem.setRowId(random);
            count = psPolicyItemMapper.insert(psPolicyItem);
            modelMap.put("rowId",random);
        }else {
            count = psPolicyItemMapper.update(psPolicyItem);
        }
        if (count!=1){
            result = false;
            message = "保存失败!";
        }
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }
    /**
     * 禁用
     */
    @Transactional
    public Map updatRestore(String rowId,String itemType)throws Exception{
        Map modelMap = new HashMap();
        int count = -1;
        //保存或修改是否成功
        boolean result = true;
        //返回到前台的提示信息
        String message = "保存成功!";
        PSPolicyItem psPolicyItem = null;
        if(itemType.equals("reStore")) {
            psPolicyItem= new PSPolicyItem();
            psPolicyItem.setRowId(rowId);
            count = psPolicyItemMapper.updateStatus(psPolicyItem);
        }
        if (count!=1){
            result = false;
            message = "保存失败!";
        }
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }
    public boolean isExistsNumber(String itemCode,String rowId,String itemType){
        //查询所有相同itemCode的数量
        int isExistsByNoRowId = psPolicyItemMapper.isExistsNumber(itemCode,null,itemType);
        //屏蔽自身
        int isExists =psPolicyItemMapper.isExistsNumber(itemCode,rowId,itemType);
        if(StringUtils.isNotBlank(rowId)){
            if(isExists==1&&isExistsByNoRowId==1){
                return true;
            }
        }
        if (isExistsByNoRowId > 0) {
            return false;
        }
        return true;
    }

    /**
     * 导出列表数据
     * @param params
     * @param request
     * @param response
     */
    public void exportUser(String itemType,Map<String,Object> params, HttpServletRequest request, HttpServletResponse response) {
            try {
                Page<PSPolicyItem> page = psPolicyItemMapper.queryForPage(params);
                List<PSPolicyItem> data = page.getResult();
                String title;
                String fileName;
                if(itemType.equals("M0101")){
                    title = "支持项维护";
                }else if(itemType.equals("M0102")){
                    title = "支持方式维护";
                }else {
                    title = "支持条件维护";
                }
                fileName = title + DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
                new ExportExcel(title, PSPolicyItem.class).setDataList(data).write(response, fileName).dispose();

            } catch (Exception e) {
                e.printStackTrace();
            }


    }
}
