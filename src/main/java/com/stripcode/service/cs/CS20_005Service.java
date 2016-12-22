package com.stripcode.service.cs;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.cs.dao.CSMarketOptimauthMapper;
import com.stripcode.mybatis.cs.model.*;
import com.stripcode.service.user.RscSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames="CS20_005")
public class CS20_005Service {
    @Autowired
    private CSMarketOptimauthMapper csMarketOptimauthMapper;
    @Autowired
    private RscSysUserService rscSysUserService;

    public PageInfo<CSMarketOptimauth> query(Map<String,Object> map){
        PageSortUtil.unoinSortBySord(map);
        PageHelper.startPage(map);
        return new PageInfo<CSMarketOptimauth>(csMarketOptimauthMapper.selectForPage(map));
    }

    public CSMarketOptimauth queryOptimauth(String optimauthId){
        return csMarketOptimauthMapper.queryOptimauth(optimauthId);
    }

    public void selectForExport(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
        /*List<ExcelHeader<CSMarketOptimauth>> header = new ArrayList<ExcelHeader<CSMarketOptimauth>>();
        header.add(new ExcelHeader<CSMarketOptimauth>("客户名称","corporation"));
        header.add(new ExcelHeader<CSMarketOptimauth>("客户性质","customerProperty"));
        header.add(new ExcelHeader<CSMarketOptimauth>("上级公司","superiorCompany"));
        header.add(new ExcelHeader<CSMarketOptimauth>("状态","currentNode"));
        header.add(new ExcelHeader<CSMarketOptimauth>("负责人","director"));
        RscSysUser creator = rscSysUserService.queryById(WebUtil.getCurrentUser());
        List<CSMarketOptimauth> data = csMarketOptimauthMapper.selectForExport(params);
        new ExcelExporter(request,response).export(new ExcelDocument<CSMarketOptimauth>(5000,"全部市场授权优化信息[新增]",creator == null ? "" : creator.getUserName(),header,data));*/

        try {
            Page<CSMarketOptimauth> page = csMarketOptimauthMapper.selectForPage(params);
            List<CSMarketOptimauth> data = page.getResult();
            String fileName = "市场授权优化新增"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            new ExportExcel("市场授权优化新增", CSMarketOptimauth.class).setDataList(data).write(response, fileName).dispose();
        } catch (Exception e) {

        }
    }
}
