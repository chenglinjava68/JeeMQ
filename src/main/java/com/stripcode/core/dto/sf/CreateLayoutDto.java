package com.stripcode.core.dto.sf;

import com.stripcode.mybatis.sf.model.SFLandlordLayout;

import java.util.List;

/**
 * Created by Metro on 2016/9/28.
 */
public class CreateLayoutDto {
    private List<SFLandlordLayout> sfLandLord;

    public List<SFLandlordLayout> getSfLandLord() {
        return sfLandLord;
    }

    public void setSfLandLord(List<SFLandlordLayout> sfLandLord) {
        this.sfLandLord = sfLandLord;
    }
}
