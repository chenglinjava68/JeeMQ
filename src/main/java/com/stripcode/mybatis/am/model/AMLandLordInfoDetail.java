package com.stripcode.mybatis.am.model;

import com.stripcode.mybatis.common.BaseModel;

/**店铺业主详细信息表
 * Created by Metro on 2016/12/14.
 */
public class AMLandLordInfoDetail extends BaseModel {
    private String storeId;//店铺ID
    private String landLord;//业主名称
    private String contacter;//联系人名称
    private String position;//职位
    private String tel;//电话
    private String rentType;//租赁方式
    private String owner;//产权人
    private String address;//地址

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getLandLord() {
        return landLord;
    }

    public void setLandLord(String landLord) {
        this.landLord = landLord;
    }

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
