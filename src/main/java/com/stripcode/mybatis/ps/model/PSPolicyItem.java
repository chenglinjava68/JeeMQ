package com.stripcode.mybatis.ps.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Metro on 2016/9/23.
 * 支持项实体
 */
public class PSPolicyItem extends BaseModel implements Serializable{
    private String rowId;//外键
    private String itemType;//项目类型
    private String itemCode;//支持项编号
    private String itemName;//支持项名称
    private String status;//状态
    private String creator;//创建者
    private Date createTime;//创建时间
    private String updater;//更新者
    private Date updateTime;//更新时间

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    @ExcelField(title="状态", align=1, sort=3)
    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public String getCreator() {
        return creator;
    }


    public void setCreator(String creator) {
        this.creator = creator;
    }





    public String getUpdater() {
        return updater;
    }


    public void setUpdater(String updater) {
        this.updater = updater;
    }




    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    @ExcelField(title="编号", align=1, sort=1)
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemcode) {
        this.itemCode = itemcode;
    }
    @ExcelField(title="名称", align=1, sort=2)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


}
