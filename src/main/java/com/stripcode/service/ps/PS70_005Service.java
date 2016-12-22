package com.stripcode.service.ps;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.ps.dao.PSPolicyImplementMapper;
import com.stripcode.mybatis.sf.model.SFPolicySupportAssessment;
import com.stripcode.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/12/6.
 */
@Service
@CacheConfig(cacheNames = "psPolicyImplement")
public class PS70_005Service extends BaseService {
    @Autowired
    private PSPolicyImplementMapper psPolicyImplementMapper;

    //列表带分页的查询数据
    public PageInfo<SFPolicySupportAssessment> queryForPage(Map<String,Object> params){
        //合并orderBy Sord
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        return new PageInfo<SFPolicySupportAssessment>(psPolicyImplementMapper.queryForPage(params));
    }
    /**
     * 导出列表数据
     * * @param params
     * @param request
     * @param response
     */
    public void exportUser( Map<String,Object> params, HttpServletRequest request, HttpServletResponse response) {
        try {
            String fileName = "政策支持执行"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<SFPolicySupportAssessment> page =  psPolicyImplementMapper.queryForPage(params);
            List<SFPolicySupportAssessment> data = page.getResult();
            new ExportExcel("政策支持执行", SFPolicySupportAssessment.class).setDataList(data).write(response, fileName).dispose();
        } catch (Exception e) {

        }
    }
}
