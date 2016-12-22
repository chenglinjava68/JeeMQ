package com.stripcode.mybatis.sf.dao;

import com.github.pagehelper.Page;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.ps.model.PSPolicySupport;
import com.stripcode.mybatis.ps.model.PSPolicySupportDetail;
import com.stripcode.mybatis.sf.model.SFPolicySupport;
import com.stripcode.mybatis.sf.model.SFPolicySupportAgreeAttachment;
import com.stripcode.mybatis.sf.model.SFProgressEst;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * Created by Metro on 2016/9/28.
 */
public interface SFPolicySupportMapper {
    CSCustomerInfo selectById(String customerId);
    Page<PSPolicySupport> psPolicyQueryForPage(Map<String,Object> object);
    //查询政策选择
    List<PSPolicySupport> selectPolicy(String policy);
    //政策支持里面保存后查询政策
    List<SFPolicySupport> queryPolicy(String ppId);
    SFPolicySupport selectPolicyOne(String ppId);
    //查询政策支持的rowId
    PSPolicySupport selectLoad(String rowId);
    //根据政策支持内容表rowId查询详细内容
    List<PSPolicySupportDetail> selectAllDate(String id);

    //保存政策
    Integer insertPolicy(SFPolicySupport model);
    Integer updatePolicy(SFPolicySupport model);
    int update(SFPolicySupport model);
    int insert(SFPolicySupport model);
    /**
     * 添加模板附件
     * @param sfPolicySupportAgreeAttachment
     * @return
     */
    Integer insertAttachment(SFPolicySupportAgreeAttachment sfPolicySupportAgreeAttachment);

    Integer deleteInser(@Param("templateId")String templateId,@Param("ppId")String ppId);
    /**
     * 修改附件模板
     * @param sfPolicySupportAgreeAttachment
     * @return
     */
    Integer updateAttachment(SFPolicySupportAgreeAttachment sfPolicySupportAgreeAttachment);
    Integer insertAttachment2(SFPolicySupportAgreeAttachment sfPolicySupportAgreeAttachment);
    Integer updateAttachment2(SFPolicySupportAgreeAttachment sfPolicySupportAgreeAttachment);
    Integer insertAttachment3(SFPolicySupportAgreeAttachment sfPolicySupportAgreeAttachment);
    Integer updateAttachment3(SFPolicySupportAgreeAttachment sfPolicySupportAgreeAttachment);
    Integer isExistsSFPolicySupport(@Param("rowId") String rowId, @Param("ppId") String ppId);
    Integer isExistsSFPolicySupport2(@Param("rowId") String rowId, @Param("ppId") String ppId);
    Integer isExistsSFPolicySupport3(@Param("rowId") String rowId, @Param("ppId") String ppId);
    //政策支持协议签字上传查询签约日期
    List<SFProgressEst> selectProgressAll(String ppId);
}
