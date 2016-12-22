package com.stripcode.core.dto.sf;

import com.stripcode.mybatis.sf.model.SFStorePhotoAttachment;

import java.util.List;

/**
 * Created by Metro on 2016/10/20.
 */
public class CreateStorePhotoDto {
    private List<SFStorePhotoAttachment>  StorePhotoList;

    public List<SFStorePhotoAttachment> getStorePhotoList() {
        return StorePhotoList;
    }

    public void setStorePhotoList(List<SFStorePhotoAttachment> storePhotoList) {
        StorePhotoList = storePhotoList;
    }
}
