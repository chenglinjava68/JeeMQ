package com.stripcode.service.cs;

import com.github.pagehelper.PageHelper;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.WebUtil;
import com.stripcode.core.util.excel.ExcelDocument;
import com.stripcode.core.util.excel.ExcelExporter;
import com.stripcode.core.util.excel.ExcelHeader;
import com.stripcode.mybatis.cs.dao.CSCustomerErpInfoMapper;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.mybatis.user.model.RscSysUser;
import com.stripcode.service.BaseService;
import com.github.pagehelper.PageInfo;
import com.stripcode.service.user.RscSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/8/19.
 */
@Service
@CacheConfig(cacheNames = "csCustomerErpInfo")
public class CS20_003Service extends BaseService{
            @Autowired
            private CSCustomerErpInfoMapper CSCustomerErpInfoMapper;
            @Autowired
            private RscSysUserService rscSysUserService;
            /*
            带分页的查询列表
             */
            public PageInfo<CSCustomerErpInfo> queryForPage(Map<String ,Object> params){
                PageSortUtil.unoinSortBySord(params);
                PageHelper.startPage(params);
                return new PageInfo<CSCustomerErpInfo>(CSCustomerErpInfoMapper.queryForPage(params));
            };
            /*
            查询客户授权信息列表
             */
            public PageInfo<CSCustomerErpInfo> queryForMarket(Map<String ,Object> params){
                PageSortUtil.unoinSortBySord(params);
                String type = params.get("type").toString();
                if(type.equals("startDate")){
                    PageHelper.startPage(params);
                    return  new PageInfo<CSCustomerErpInfo>(CSCustomerErpInfoMapper.queryForMarket(params));
                }else if(type.equals("endDate")){
                    PageHelper.startPage(params);
                    return  new PageInfo<CSCustomerErpInfo>(CSCustomerErpInfoMapper.queryForMarketend(params));
                }else{
                    PageHelper.startPage(params);
                    return  new PageInfo<CSCustomerErpInfo>(CSCustomerErpInfoMapper.queryForMarketCustomer(params));
                }
            }
        /**
         * 授权导出
         */
        public void exportErpInfo(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response) {
            List<ExcelHeader<CSCustomerErpInfo>> headers = new ArrayList<ExcelHeader<CSCustomerErpInfo>>();
            headers.add(new ExcelHeader<CSCustomerErpInfo>("客户名称", "corporation"));
            headers.add(new ExcelHeader<CSCustomerErpInfo>("品牌", "brand"));
            headers.add(new ExcelHeader<CSCustomerErpInfo>("ERP市场ID", "erpCode"));
            headers.add(new ExcelHeader<CSCustomerErpInfo>("ERP市场名称", "erpName"));
            headers.add(new ExcelHeader<CSCustomerErpInfo>("授权结束日期", "accreditEndDate"));
            headers.add(new ExcelHeader<CSCustomerErpInfo>("折率方式", "discountRateMode"));
            headers.add(new ExcelHeader<CSCustomerErpInfo>("合作模式", "cooperationMode"));
            RscSysUser creator  = rscSysUserService.queryById(WebUtil.getCurrentUser());
            List<CSCustomerErpInfo> data = CSCustomerErpInfoMapper.selectForExportErpInfo(params);
            new ExcelExporter(request,response).export(new ExcelDocument<CSCustomerErpInfo>(5000,"客户市场授权信息",creator == null ? "" : creator.getUserName(),headers,data));
        }

        /*
        判断是否为新老客户
         */
        public Map isExistErpCode(Map<String ,Object> params){
            Map modelMap = new HashMap();
            List<CSCustomerErpInfo> list = CSCustomerErpInfoMapper.queryForMarketCustomer(params);
            if (list.isEmpty()){
                modelMap.put("result",false);
                return modelMap;
            }else {
                modelMap.put("result",list);
                return modelMap;
            }
        }
}
