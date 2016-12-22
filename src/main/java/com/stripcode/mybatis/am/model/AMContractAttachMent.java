package com.stripcode.mybatis.am.model;

import com.stripcode.mybatis.common.BaseModel;

/**合同附件实体类
 * Created by Metro on 2016/10/20.
 */
public class AMContractAttachMent extends BaseModel {
    private String StoreId;
    private String signDate;
    private String contractName;
    private String optimizedType;
    private String templateId;
    private String attachId;


    private String fileName;
    private String  fieldId;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getStoreId() {
        return StoreId;
    }

    public void setStoreId(String storeId) {
        StoreId = storeId;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getOptimizedType() {
        return optimizedType;
    }

    public void setOptimizedType(String optimizedType) {
        this.optimizedType = optimizedType;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }
}
