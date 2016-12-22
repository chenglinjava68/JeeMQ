package com.stripcode.service.cs;


import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.cs.dao.CSNegotiationMapper;
import com.stripcode.mybatis.cs.model.CSNegotiation;
import com.stripcode.service.user.RscSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "CS20_022Service")
public class CS20_022Service {
    @Autowired
    private CSNegotiationMapper csNegotiationMapper;

    @Autowired
    private RscSysUserService rscSysUserService;

    public List<CSNegotiation> query(String customerId){
        return csNegotiationMapper.selectAll(customerId);
    }

    public CSNegotiation detailsByRecordId(String recordId){
        return csNegotiationMapper.detailsByRecordId(recordId);
    }

    @Transactional
    public Map updateNegotiation(CSNegotiation model){
        Map modelMap = new HashMap();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1; 

        if(model.getRecordId()==null){
            count = csNegotiationMapper.insertNegotiation(model);
        }else {
            count = csNegotiationMapper.updateNegotiation(model);
        }
        if(count!=1){
            result = false;
            message = "保存失败!";
        }
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }

    public void exportNegotiation(HttpServletRequest request, HttpServletResponse response,String customerId){
//        List<ExcelHeader<CSNegotiation>> headers = new ArrayList<ExcelHeader<CSNegotiation>>();
//        headers.add(new ExcelHeader<CSNegotiation>("谈判主题","topic"));
//        headers.add(new ExcelHeader<CSNegotiation>("谈判时间","dateTime"));
//        headers.add(new ExcelHeader<CSNegotiation>("业主方参与人","landlord"));
//        headers.add(new ExcelHeader<CSNegotiation>("本公司参与人","mbParticipant"));
//        headers.add(new ExcelHeader<CSNegotiation>("谈判方式","commType"));
//        headers.add(new ExcelHeader<CSNegotiation>("谈判地点","location"));
//        headers.add(new ExcelHeader<CSNegotiation>("谈判内容","content"));
//        RscSysUser creator = rscSysUserService.queryById(WebUtil.getCurrentUser());
//        List<CSNegotiation> data = this.query(customerId);
//        new ExcelExporter(request,response).export(new ExcelDocument<CSNegotiation>(5000,"全部客户信息",creator == null ? "" : creator.getUserName(),headers,data));

        try {
            List<CSNegotiation> data = csNegotiationMapper.selectAll(customerId);
            String fileName = "客户谈判记录"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            new ExportExcel("客户谈判记录", CSNegotiation.class).setDataList(data).write(response, fileName).dispose();
        } catch (Exception e) {

        }
    }
}
