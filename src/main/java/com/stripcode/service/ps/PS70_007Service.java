package com.stripcode.service.ps;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.ps.dao.PSPolicySupportImplementationMapper;
import com.stripcode.mybatis.ps.model.PSPolicySupportImplementation;
import com.stripcode.mybatis.ps.model.PSPolicySupportImplementationModel;
import com.stripcode.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/12/9.
 */
@Service
@CacheConfig(cacheNames = "PSPolicySupportImplementation")
public class PS70_007Service extends BaseService{
    @Autowired
    private PSPolicySupportImplementationMapper psPolicySupportImplementationMapper;
    //列表带分页的查询数据
    public PageInfo<PSPolicySupportImplementation> queryForPage(Map<String,Object> params){
        //合并orderBy Sord
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        List<PSPolicySupportImplementation> psPolicySupportImplementationList =psPolicySupportImplementationMapper.queryForPage(params);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        for (PSPolicySupportImplementation model : psPolicySupportImplementationList){
            try {
                if(model.getCreaterTime()!=null){
                    date = format.parse(model.getCreaterTime());
                    model.setCreaterTime(format.format(date));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return new PageInfo<PSPolicySupportImplementation>(psPolicySupportImplementationMapper.queryForPage(params));
    }
    /**
     * 导出列表数据
     * * @param params
     * @param request
     * @param response
     */
    public void exportUser( Map<String,Object> params, HttpServletRequest request, HttpServletResponse response) {
        try {
            String fileName = "政策支持执行审核"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<PSPolicySupportImplementation> page =  psPolicySupportImplementationMapper.queryForPage(params);
            List<PSPolicySupportImplementation> data = page.getResult();
            new ExportExcel("政策支持执行审核", PSPolicySupportImplementation.class).setDataList(data).write(response, fileName).dispose();
        } catch (Exception e) {

        }
    }
    //政策支持执行审核详细信息导出
    public void exportUser1( Map<String,Object> params, HttpServletRequest request, HttpServletResponse response) {
        try {
            String fileName = "政策支持执行审核详细信息"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<PSPolicySupportImplementationModel> page =  psPolicySupportImplementationMapper.queryForPage1(params);
            List<PSPolicySupportImplementationModel> data = page.getResult();
            new ExportExcel("政策支持执行审核详细信息", PSPolicySupportImplementationModel.class).setDataList(data).write(response, fileName).dispose();
        } catch (Exception e) {

        }
    }
    //根据rowId查询详细内容
    public List<PSPolicySupportImplementation> queryAll(String checkId){
        return psPolicySupportImplementationMapper.queryAll(checkId);
    }

    public Map update(PSPolicySupportImplementationModel psPolicySupportImplementation) throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        String message = "保存成功";
        boolean result = true;
        Integer IsExist = 0;
        int count = -1;
            for (PSPolicySupportImplementation item:psPolicySupportImplementation.getPsPolicySupportImplementationList()){
                IsExist=psPolicySupportImplementationMapper.selectImplementation(item.getRowId(), item.getCheckId());
                if(IsExist ==0){
                    count=psPolicySupportImplementationMapper.insertImplementation(item);
                }else{
                    count=psPolicySupportImplementationMapper.updateImplementation(item);
                }
            }
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        map.put("result", result);
        map.put("message", message);
        return map;
    }


    @Transactional
    public void insertPSPolicySupportImplementationModel(Map<String, Object> map) {
        List<PSPolicySupportImplementationModel> list = (List) map.get("list");
        if (list != null && list.size() > 0) {
            for (PSPolicySupportImplementationModel psPolicySupportImplementationModel : list) {
                //执行新增操作
                psPolicySupportImplementationMapper.insertPSPolicySupportImplementationModel(psPolicySupportImplementationModel);
            }
        }
    }
}
