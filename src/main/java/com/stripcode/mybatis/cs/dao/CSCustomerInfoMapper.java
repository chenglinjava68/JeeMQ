package com.stripcode.mybatis.cs.dao;

import com.github.pagehelper.Page;
import com.stripcode.mybatis.cs.model.CSCSustomerOfficeMap;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.sys.model.SYSBranchOfficeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/8/19.
 */
public interface CSCustomerInfoMapper {
    Page<CSCustomerInfo> selectForPage(Map<String,Object> param);
    CSCustomerInfo selectById(String customerId);

    CSCustomerInfo selectCustomerByIdNumer(String idNumber);
    CSCustomerInfo details(@Param("customerId") String customerId);
    Integer insert(CSCustomerInfo model);
    Integer update(CSCustomerInfo model);
    Integer isExistsByIdNumber(@Param("idNumber") String idNumber,@Param("customerId") String customerId);

    Integer isExistsByCompanyName(@Param("companyName") String companyName,@Param("customerId") String customerId);

    Integer isExistsByBusinessLicense(@Param("businessLicense") String businessLicense,@Param("customerId") String customerId);
    Integer insertSuperiorCompany(CSCSustomerOfficeMap model);
    Integer deleteSuperiorCompany(String customerId);
    List<CSCustomerInfo> selectForExport(Map<String,Object> param);
    List<Map<String,Object>> selectByOfficeId(CSCSustomerOfficeMap record);

    List<SYSBranchOfficeInfo> queryAllOffice();
}
