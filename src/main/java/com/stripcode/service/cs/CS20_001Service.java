package com.stripcode.service.cs;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.Page;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.cs.dao.CSCustomerInfoMapper;
import com.stripcode.mybatis.cs.model.CSCSustomerOfficeMap;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.sys.model.SYSBranchOfficeInfo;
import com.stripcode.service.user.RscSysUserService;
import org.apache.commons.lang3.StringUtils;
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
@CacheConfig(cacheNames = "CS20_001")
public class CS20_001Service {
    @Autowired
    private CSCustomerInfoMapper csCustomerInfoMapper;
    @Autowired
    private RscSysUserService rscSysUserService;

    public PageInfo<CSCustomerInfo> query(Map<String,Object> param){
        PageSortUtil.unoinSortBySord(param);
        PageHelper.startPage(param);
        return new PageInfo<CSCustomerInfo>(csCustomerInfoMapper.selectForPage(param));
    }

    public CSCustomerInfo queryById(String id){
        CSCustomerInfo csCustomerInfo = csCustomerInfoMapper.details(id);
        return csCustomerInfo;
    }


    @Transactional
    public Map update(CSCustomerInfo csCustomerInfo)throws Exception{
        Map modelMap = new HashMap();
        Integer count = -1;
        //保存或修改是否成功
        boolean result = true;
        //返回到前台的提示信息
        String message = "保存成功!";
        Date date = new Date();
        csCustomerInfo.setCreateTime(date);
        csCustomerInfo.setUpdateTime(date);
        String customerId = csCustomerInfo.getCustomerId();
        String random = UUIDUtils.generateKey();
        if(StringUtils.isBlank(customerId)){
            csCustomerInfo.setCustomerId(random);
            count = csCustomerInfoMapper.insert(csCustomerInfo);
            modelMap.put("customerId",csCustomerInfo.getCustomerId());
        }else{
            count = csCustomerInfoMapper.update(csCustomerInfo);
        }
        if(StringUtils.isNotBlank(csCustomerInfo.getDef1())){
            count = this.saveSuperiorCompany(csCustomerInfo.getDef1(),csCustomerInfo.getCustomerId());
        }
        if (count!=1){
            result = false;
            message = "保存失败!";
        }
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }

    @Transactional
    public Integer saveSuperiorCompany(String superiorCompanys,String customerId){
        Integer count = -1;
        String[] superiorCompany = superiorCompanys.split(",");
        csCustomerInfoMapper.deleteSuperiorCompany(customerId);
        for (int i = 0;i<superiorCompany.length;i++){
            CSCSustomerOfficeMap model = new CSCSustomerOfficeMap();
            model.setCustomerId(customerId);
            model.setOfficeId(superiorCompany[i]);
            model.setRowId(UUIDUtils.generateKey());
            count = csCustomerInfoMapper.insertSuperiorCompany(model);
        }
        return count;
    }

    public Map<String,Object> isExistsByIdNumber(String idNumber,String customerId){
        Map<String,Object> map = new HashMap<String, Object>();
        Boolean valid =true ;
        //查询所有相同IdNumber数量
        Integer isExistsByNoCustomerId = csCustomerInfoMapper.isExistsByIdNumber(idNumber,null);
        //屏蔽自身用
        Integer isExists = csCustomerInfoMapper.isExistsByIdNumber(idNumber,customerId);

        //用于屏蔽自身
        if(StringUtils.isNotBlank(customerId)){
            if(isExists==1&&isExistsByNoCustomerId==1){
                valid = true;
            }
        }

        if (isExistsByNoCustomerId > 0) {
            CSCustomerInfo customer = csCustomerInfoMapper.selectCustomerByIdNumer(idNumber);
            map.put("message","<i class='glyphicon glyphicon-remove'></i><strong style='margin-left: 3px;'>系统存在相同身份证号,客户名 : "+customer.getCorporation()+" , 客户性质 : "+customer.getCustomerProperty()+"</strong>!");
            valid = false;
        }
        map.put("valid",valid);
        return map;
    }

    public boolean isExistsByCompanyName(String companyName,String customerId){
        //查询所有相同IdNumber数量
        Integer isExistsByNoCustomerId = csCustomerInfoMapper.isExistsByCompanyName(companyName,null);
        //屏蔽自身用
        Integer isExists = csCustomerInfoMapper.isExistsByCompanyName(companyName,customerId);

        //用于屏蔽自身
        if(StringUtils.isNotBlank(customerId)){
            if(isExists==1&&isExistsByNoCustomerId==1){
                return true;
            }
        }

        if (isExistsByNoCustomerId > 0) {
            return false;
        }
        return true;
    }

    public boolean isExistsByBusinessLicense(String businessLicense,String customerId){
        //查询所有相同IdNumber数量
        Integer isExistsByNoCustomerId = csCustomerInfoMapper.isExistsByBusinessLicense(businessLicense,null);
        //屏蔽自身用
        Integer isExists = csCustomerInfoMapper.isExistsByBusinessLicense(businessLicense,customerId);

        //用于屏蔽自身
        if(StringUtils.isNotBlank(customerId)){
            if(isExists==1&&isExistsByNoCustomerId==1){
                return true;
            }
        }

        if (isExistsByNoCustomerId > 0) {
            return false;
        }
        return true;
    }

    public void exportCustomer(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
        /*List<ExcelHeader<CSCustomerInfo>> header = new ArrayList<ExcelHeader<CSCustomerInfo>>();
        header.add(new ExcelHeader<CSCustomerInfo>("个体/法人代表","corporation"));
        header.add(new ExcelHeader<CSCustomerInfo>("客户性质","customerProperty"));
        header.add(new ExcelHeader<CSCustomerInfo>("客户类型","customerType"));
        header.add(new ExcelHeader<CSCustomerInfo>("客户公司名称","companyName"));
        header.add(new ExcelHeader<CSCustomerInfo>("上级公司","superiorCompany"));
        header.add(new ExcelHeader<CSCustomerInfo>("市场授权","erpNumber"));
        header.add(new ExcelHeader<CSCustomerInfo>("已到期","startDateNumber"));
        header.add(new ExcelHeader<CSCustomerInfo>("未到期","endDateNumber"));
        header.add(new ExcelHeader<CSCustomerInfo>("店铺","storeNumber"));
        header.add(new ExcelHeader<CSCustomerInfo>("客户状态","userStatus"));
        RscSysUser creator = rscSysUserService.queryById(WebUtil.getCurrentUser());
        List<CSCustomerInfo> data = csCustomerInfoMapper.selectForExport(params);
        new ExcelExporter(request,response).export(new ExcelDocument<CSCustomerInfo>(5000,"全部客户信息",creator == null ? "" : creator.getUserName(),header,data));*/

        try {
            Page<CSCustomerInfo> page = csCustomerInfoMapper.selectForPage(params);
            List<CSCustomerInfo> data = page.getResult();
            String fileName = "客户管理"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            new ExportExcel("客户管理", CSCustomerInfo.class).setDataList(data).write(response, fileName).dispose();
        } catch (Exception e) {

        }
    }

    public List<SYSBranchOfficeInfo> queryAllOffice(){
        return csCustomerInfoMapper.queryAllOffice();
    }
}
